package com.xm.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xm.bean.DormRecord;
import com.xm.dao.DormRecordDao;
import com.xm.service.DormRecordService;

@Service
@Transactional
public class DormRecordServiceImp implements DormRecordService{

	@Autowired
	private DormRecordDao dormRecordDao;
	
	
	@Override
	public int updateDormRecord(String sid, String currentDate) {
		return dormRecordDao.updateDormRecord(sid,currentDate);
	}
	
	@Override
	public List<DormRecord> getDormRecord(Integer sid) {
		return dormRecordDao.getDormRecord(sid);
	}

	@Override
	public int insertDormRecord(int nextSid, String dorm_id, String currentDate) {
		return dormRecordDao.insertDormRecord(nextSid,dorm_id,currentDate);
	}

}
