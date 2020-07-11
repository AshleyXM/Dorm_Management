package com.xm.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xm.bean.Dorm;
import com.xm.dao.DormDao;
import com.xm.service.DormService;

@Service
@Transactional
public class DormServiceImp implements DormService{
	
	@Autowired
	private DormDao dormDao;

	@Override
	public int updateOldDorm(String oldDormId) {
		return dormDao.updateOldDorm(oldDormId);
	}

	@Override
	public int updateNewDorm(String newDormId) {
		return dormDao.updateNewDorm(newDormId);
	}

	@Override
	public List<Integer> getDormIds() {
		return dormDao.getDormIds();
	}

	@Override
	public Dorm getDormById(String newDormId) {
		return dormDao.getDormById(newDormId);
	}

	@Override
	public void addNewDorm(String newDormId) {
		dormDao.addNewDorm(newDormId);
	}

	@Override
	public int updateDormCapacity(String dorm_id) {
		return dormDao.updateDormCapacity(dorm_id);
	}

}
