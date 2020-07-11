package com.xm.bean;

public class Dorm {
	private String dorm_id;
	private Integer dorm_capacity;
	
	public Dorm(String dorm_id, Integer dorm_capacity) {
		super();
		this.dorm_id = dorm_id;
		this.dorm_capacity = dorm_capacity;
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
