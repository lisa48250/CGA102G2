package com.activity.model;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.activity_photo.model.ActivityPhotoVO;
import com.activity_session.model.ActivitySessionVO;


public class ActivityService {

	private ActivityDAO_interface dao;
	
	public ActivityService () {
		dao = new ActivityDAO();
	}
	
	public ActivityVO addActivity(Integer activity_category_ID, String activity_name, Integer activity_price,
			Date activity_start, Date activity_end, String activity_description, String activity_content,
			String activity_info, Integer activity_state) {
		
		ActivityVO activityVO = new ActivityVO();
		
		activityVO.setActivity_category_ID(activity_category_ID);
		activityVO.setActivity_name(activity_name);
		activityVO.setActivity_price(activity_price);
		activityVO.setActivity_start(activity_start);
		activityVO.setActivity_end(activity_end);
		activityVO.setActivity_description(activity_description);
		activityVO.setActivity_content(activity_content);
		activityVO.setActivity_info(activity_info);
		activityVO.setActivity_state(activity_state);		
		dao.insert(activityVO);
		
		return activityVO;		
	}
	
	public ActivityVO updateActivity(Integer activity_ID, Integer activity_category_ID, String activity_name, Integer activity_price,
			Date activity_start, Date activity_end, String activity_description, String activity_content,
			String activity_info, Integer activity_state) {
		
		ActivityVO activityVO = new ActivityVO();
		
		activityVO.setActivity_ID(activity_ID);
		activityVO.setActivity_category_ID(activity_category_ID);
		activityVO.setActivity_name(activity_name);
		activityVO.setActivity_price(activity_price);
		activityVO.setActivity_start(activity_start);
		activityVO.setActivity_end(activity_end);
		activityVO.setActivity_description(activity_description);
		activityVO.setActivity_content(activity_content);
		activityVO.setActivity_info(activity_info);
		activityVO.setActivity_state(activity_state);		
		dao.update(activityVO);
		
		return activityVO;		
	}
	
	public void deleteActivity(Integer activity_ID) {
	
		dao.delete(activity_ID);
		
	}
	
	public ActivityVO getOneActivity(Integer activity_ID) {
		
		return dao.findByPrimaryKey(activity_ID);
		
	}
	
	public List<ActivityVO> getAll() {
		
		return dao.getAll();
		
	}
	
	public List<ActivityVO> getAll(Map<String, String[]> map) {
		
		return dao.getAll(map);
		
	}
	
	public Set<ActivitySessionVO> getActivitySessionsByActivity_ID(Integer activity_ID) {
		
		return dao.getActivitySessionsByActivity_ID(activity_ID);
		
	}
	
	public Set<ActivityPhotoVO> getActivityPhotosByActivity_ID(Integer activity_ID) {
		
		return dao.getActivityPhotosByActivity_ID(activity_ID);
		
	}
	
	public List<ActivityVO> getActivitiesWhereStateIsOne() {
		
		return dao.getActivitiesWhereStateIsOne();
		
	}

}
