package com.xm.bean;

public class DormRecord {
	private Integer sid;
	private String dorm_id;
	private Integer dorm_capacity;
	private String in_date;
	private String out_date;
	public DormRecord(Integer sid, String dorm_id, Integer dorm_capacity, String in_date, String out_date) {
		super();
		this.sid = sid;
		this.dorm_id = dorm_id;
		this.dorm_capacity = dorm_capacity;
		this.in_date = in_date;
		this.out_date = out_date;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
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
	public String getIn_date() {
		return in_date;
	}
	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}
	public String getOut_date() {
		return out_date;
	}
	public void setOut_date(String out_date) {
		this.out_date = out_date;
	}
	
}
