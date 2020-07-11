package com.xm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xm.bean.Dorm;
import com.xm.bean.DormRecord;
import com.xm.bean.Student;
import com.xm.service.DormRecordService;
import com.xm.service.DormService;
import com.xm.service.StudentService;

@Controller
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DormService dormService;
	
	@Autowired
	private DormRecordService dormRecordService;
	
	@RequestMapping("getAllStudent")
	public String getAllStudent(Model model)
	{
		List<Student> studentList=studentService.getAllStudents();
		model.addAttribute("studentList",studentList);
		return "index";
	}
	
	@RequestMapping("keywordSearch")
	public ModelAndView keywordSearch(String keyword) {  //参数名必须和jsp页面传递的key值相对应
		ModelAndView mv=new ModelAndView();
		List<Student> keywordStudentList=studentService.getKeywordStudents(keyword);
		mv.addObject("studentList",keywordStudentList);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("getStudentBySid")
	@ResponseBody
	public Map<String, String> getStudentBySid(Integer sid)
	{
		Map<String, String> result=new HashMap<String, String>();
		Student student=studentService.getStudentBySid(sid);
		result.put("student_sid",student.getSid().toString());
		result.put("student_name", student.getSname());
		result.put("student_gender", student.getGender());
		result.put("student_institute", student.getInstitute());
		result.put("student_dorm_id", student.getDorm_id());
		return result;
	}
	
	@RequestMapping("changeDorm")
	public ModelAndView changeDorm(Integer student_sid,String student_name,String student_gender,String student_institute,String student_dorm_id)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("student_sid",student_sid);
		mv.addObject("student_name",student_name);
		mv.addObject("student_gender",student_gender);
		mv.addObject("student_institute",student_institute);
		mv.addObject("student_dorm_id",student_dorm_id);
		List<Integer> dormids=dormService.getDormIds();
		mv.addObject("dormids",dormids);
		mv.setViewName("changeDorm");
		return mv;
	}
	
	@RequestMapping("updateDormInfo")
	@ResponseBody
	public void updateDormInfo(String sid,String oldDormId,String newDormId)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate=dateFormat.format(new Date());
		studentService.updateOneStudentInfo(sid,newDormId);
		dormService.updateOldDorm(oldDormId);
		dormService.updateNewDorm(newDormId);
		dormRecordService.updateDormRecord(sid,currentDate);
		dormRecordService.insertDormRecord(Integer.parseInt(sid),newDormId,currentDate);
	}
	
	@RequestMapping("checkChangeRecord")
	@ResponseBody
	public ModelAndView checkChangeRecord(Integer sid)
	{
		ModelAndView mv=new ModelAndView();
		List<DormRecord> dorm_records=dormRecordService.getDormRecord(sid);
		mv.addObject("student",studentService.getStudentBySid(sid));
		mv.addObject("dorm_records", dorm_records);
		mv.setViewName("checkChangeRecord");
		return mv;
	}
	
	@RequestMapping("addNewDorm")
	@ResponseBody
	public String addNewDorm(String newDormId)
	{
		Dorm dorm=dormService.getDormById(newDormId);
		if(dorm==null) {
			dormService.addNewDorm(newDormId);
			return "y";
		}
		else {  
			return "n";
		}
	}
	
	@RequestMapping("addStudent")
	public String addStudent(Model model) 
	{
		List<Integer> dorm_ids=dormService.getDormIds();
		model.addAttribute("dorm_ids",dorm_ids);
		return "addStudent";
	}
	
	@RequestMapping("insertStudent")
	@ResponseBody
	public String insertStudent(String name,String gender,String institute,String inschool_date,String dorm_id)
	{
		int nextSid=studentService.getNextSid();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate=dateFormat.format(new Date());
		int rt1=studentService.insertStudent(name,gender,institute,inschool_date,dorm_id);
		int rt2=dormService.updateDormCapacity(dorm_id);
		int rt3=dormRecordService.insertDormRecord(nextSid,dorm_id,currentDate);
		if(rt1*rt2*rt3!=0) {
			return "y";
		}else {
			return "n";
		}
	}
}
