package com.xm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xm.bean.Student;

public interface StudentDao {

	public List<Student> getAllStudents();

	public List<Student> getKeywordStudents(String keyword);

	public Student getStudentBySid(Integer sid);

	public int updateOneStudentInfo(@Param("sid")String sid, @Param("newDormId")String newDormId);

	public int insertStudent(@Param("name")String name, @Param("gender")String gender, @Param("institute")String institute, @Param("inschool_date")String inschool_date, @Param("dorm_id")String dorm_id);

	public int getNextSid();

}
