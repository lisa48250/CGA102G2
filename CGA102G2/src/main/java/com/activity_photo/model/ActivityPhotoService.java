package com.activity_photo.model;

import java.util.List;

public class ActivityPhotoService {

	private ActivityPhotoDAO_interface dao;
	
	public ActivityPhotoService () {
		dao = new ActivityPhotoDAO();
	}
	
	public ActivityPhotoVO addActivityPhoto(Integer activity_ID, byte[] activity_photo) {
		
		ActivityPhotoVO activityPhotoVO = new ActivityPhotoVO();
		
		activityPhotoVO.setActivity_ID(activity_ID);
		activityPhotoVO.setActivity_photo(activity_photo);		
		dao.insert(activityPhotoVO);
		
		return activityPhotoVO;		
	}
	
	public ActivityPhotoVO updateActivityPhoto(Integer activity_photo_ID, Integer activity_ID, byte[] activity_photo) {
		
		ActivityPhotoVO activityPhotoVO = new ActivityPhotoVO();
		
		activityPhotoVO.setActivity_photo_ID(activity_photo_ID);
		activityPhotoVO.setActivity_ID(activity_ID);
		activityPhotoVO.setActivity_photo(activity_photo);
		dao.update(activityPhotoVO);
		
		return activityPhotoVO;		
	}
	
	public void deleteActivityPhoto(Integer activity_photo_ID) {
	
		dao.delete(activity_photo_ID);
		
	}
	
	public ActivityPhotoVO getOneActivityPhoto(Integer activity_photo_ID) {
		
		return dao.findByPrimaryKey(activity_photo_ID);
		
	}
	
	public List<ActivityPhotoVO> getAll() {
		
		return dao.getAll();
		
	}
	
}
