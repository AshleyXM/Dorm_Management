package com.xm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xm.bean.Dorm;

public interface DormDao {
	
	public int updateOldDorm(String oldDormId);

	public int updateNewDorm(String newDormId);

	public List<Integer> getDormIds();

	public Dorm getDormById(String newDormId);

	public void addNewDorm(String newDormId);

	public int updateDormCapacity(String dorm_id);
}
