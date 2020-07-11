package com.xm.serviceImp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xm.bean.Student;
import com.xm.dao.DormDao;
import com.xm.dao.StudentDao;
import com.xm.service.StudentService;

@Service
@Transactional
public class StudentServiceImp implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public List<Student> getKeywordStudents(String keyword) {
		return studentDao.getKeywordStudents(keyword);
	}

	@Override
	public Student getStudentBySid(Integer sid) {
		return studentDao.getStudentBySid(sid);
	}

	@Override
	public int updateOneStudentInfo(@Param("sid")String sid, @Param("newDormId")String newDormId) {
		return studentDao.updateOneStudentInfo(sid, newDormId);
	}
	
	@Override
	public int getNextSid() {
		return studentDao.getNextSid();
	}

	@Override
	public int insertStudent(String name, String gender, String institute, String inschool_date, String dorm_id) {
		return studentDao.insertStudent(name,gender,institute,inschool_date,dorm_id);
	}

}
