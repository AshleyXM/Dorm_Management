package com.xm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xm.bean.Student;

@Service
public interface StudentService{
	
	public List<Student> getAllStudents();

	public List<Student> getKeywordStudents(String keyword);

	public Student getStudentBySid(Integer sid);

	public int updateOneStudentInfo(String sid, String newDormId);

	public int insertStudent(String name, String gender, String institute, String inschool_date, String dorm_id);

	public int getNextSid();
	
}
