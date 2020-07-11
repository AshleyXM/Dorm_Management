package com.xm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xm.bean.Dorm;

@Service
public interface DormService {
	
	public int updateOldDorm(String oldDormId);

	public int updateNewDorm(String newDormId);

	public List<Integer> getDormIds();

	public Dorm getDormById(String newDormId);

	public void addNewDorm(String newDormId);

	public int updateDormCapacity(String dorm_id);

}
