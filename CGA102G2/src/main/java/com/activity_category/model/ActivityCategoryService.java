package com.activity_category.model;

import java.util.List;
import java.util.Set;

import com.activity.model.ActivityVO;

public class ActivityCategoryService {

	private ActivityCategoryDAO_interface dao;
	
	public ActivityCategoryService () {
		dao = new ActivityCategoryDAO();
	}
	
	public ActivityCategoryVO addActivityCategory(String activity_category_name, String activity_category_info) {
		
		ActivityCategoryVO activityCategoryVO = new ActivityCategoryVO();
		
		activityCategoryVO.setActivity_category_name(activity_category_name);
		activityCategoryVO.setActivity_category_info(activity_category_info);
		dao.insert(activityCategoryVO);
		
		return activityCategoryVO;		
	}
	
	public ActivityCategoryVO updateActivityCategory(Integer activity_category_ID, String activity_category_name, String activity_category_info) {
		
		ActivityCategoryVO activityCategoryVO = new ActivityCategoryVO();
		
		activityCategoryVO.setActivity_category_ID(activity_category_ID);
		activityCategoryVO.setActivity_category_name(activity_category_name);
		activityCategoryVO.setActivity_category_info(activity_category_info);
		dao.update(activityCategoryVO);
		
		return activityCategoryVO;		
	}
	
	public void deleteActivityCategory(Integer activity_category_ID) {
	
		dao.delete(activity_category_ID);
		
	}
	
	public ActivityCategoryVO getOneActivityCategory(Integer activity_category_ID) {
		
		return dao.findByPrimaryKey(activity_category_ID);
		
	}
	
	public List<ActivityCategoryVO> getAll() {
		
		return dao.getAll();
		
	}
	
	public Set<ActivityVO> getActivitiesByActivity_category_ID(Integer activity_category_ID) {
		
		return dao.getActivitiesByActivity_category_ID(activity_category_ID);
		
	}
	
}
