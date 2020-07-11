package com.xm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xm.bean.DormRecord;

@Service
public interface DormRecordService {

	int updateDormRecord(String sid, String currentDate);

	List<DormRecord> getDormRecord(Integer sid);

	int insertDormRecord(int nextSid, String dorm_id, String currentDate);

}
