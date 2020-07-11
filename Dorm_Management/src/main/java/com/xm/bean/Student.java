package com.xm.bean;

public class Student {
	private Integer sid;
	private String sname;
	private String gender;
	private String institute;
	private String inschool_date;
	private String dorm_id;
	private Integer dorm_capacity;
	public Student(Integer sid, String sname, String gender, String institute, String inschool_date, String dorm_id,
			Integer dorm_capacity) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.institute = institute;
		this.inschool_date = inschool_date;
		this.dorm_id = dorm_id;
		this.dorm_capacity = dorm_capacity;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getInschool_date() {
		return inschool_date;
	}
	public void setInschool_date(String inschool_date) {
		this.inschool_date = inschool_date;
	}
	public String getDorm_id() {
		return dorm_id;
	}
	public void setDorm_id(String dorm_id) {
		this.dorm_id = dorm_id;
	}
	public Integer getDorm_capacity() {
		return dorm_capacity;
	}
	public void setDorm_capacity(Integer dorm_capacity) {
		this.dorm_capacity = dorm_capacity;
	}
	
}
