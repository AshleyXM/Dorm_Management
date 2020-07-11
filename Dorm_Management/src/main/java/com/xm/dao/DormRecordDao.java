package com.xm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xm.bean.DormRecord;

public interface DormRecordDao {

	public int updateDormRecord(@Param("sid")String sid, @Param("currentDate")String currentDate);

	List<DormRecord> getDormRecord(Integer sid);

	int insertDormRecord(@Param("nextSid")int nextSid, @Param("dorm_id")String dorm_id, @Param("currentDate")String currentDate);
	
}
