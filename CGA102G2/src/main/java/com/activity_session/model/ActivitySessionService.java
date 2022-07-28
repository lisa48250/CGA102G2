package com.activity_session.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.activity.model.ActivityVO;

public class ActivitySessionService {

	private ActivitySessionDAO_interface dao;
	
	public ActivitySessionService () {
		dao = new ActivitySessionDAO();
	}
	
	public ActivitySessionVO addActivitySession(ActivitySessionVO activitySessionVO) {
	
		dao.insert(activitySessionVO);
		
		return activitySessionVO;		
	}
	
	public ActivitySessionVO updateActivitySession(ActivitySessionVO activitySessionVO) {
		
		dao.update(activitySessionVO);
		
		return activitySessionVO;		
	}
	
	public void deleteActivitySession(Integer activity_session_ID) {
	
		dao.delete(activity_session_ID);
		
	}
	
	public ActivitySessionVO getOneActivitySession(Integer activity_session_ID) {
		
		return dao.findByPrimaryKey(activity_session_ID);
		
	}
	
	public List<ActivitySessionVO> getAll() {
		
		return dao.getAll();
		
	}
	
	public List<ActivitySessionVO> getAll(Map<String, String[]> map) {
		
		return dao.getAll(map);
		
	}

	public List<ActivitySessionVO> getActivitySessionsWhereStateIsOne() {
		
		return dao.getActivitySessionsWhereStateIsOne();
		
	}
}
