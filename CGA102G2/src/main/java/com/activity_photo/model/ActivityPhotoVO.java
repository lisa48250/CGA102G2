package com.activity_photo.model;

import com.activity.model.ActivityService;
import com.activity.model.ActivityVO;

public class ActivityPhotoVO implements java.io.Serializable{
	private Integer activity_photo_ID;	// ACTIVITY_PHOTO_ID
	private Integer activity_ID;	// ACTIVITY_ID
	private byte[] activity_photo;	// ACTIVITY_PHOTO
	
	public ActivityPhotoVO( ) {
		
	}

	public ActivityPhotoVO(Integer activity_photo_ID, Integer activity_ID, byte[] activity_photo) {
		super();
		this.activity_photo_ID = activity_photo_ID;
		this.activity_ID = activity_ID;
		this.activity_photo = activity_photo;
	}

	public Integer getActivity_photo_ID() {
		return activity_photo_ID;
	}

	public void setActivity_photo_ID(Integer activity_photo_ID) {
		this.activity_photo_ID = activity_photo_ID;
	}

	public Integer getActivity_ID() {
		return activity_ID;
	}

	public void setActivity_ID(Integer activity_ID) {
		this.activity_ID = activity_ID;
	}

	public byte[] getActivity_photo() {
		return activity_photo;
	}

	public void setActivity_photo(byte[] activity_photo) {
		this.activity_photo = activity_photo;
	}

	// for join activity_ID from activity
	public ActivityVO getActivityVO() {
		ActivityService activityService = new ActivityService();
		ActivityVO activityVO = activityService.getOneActivity(activity_ID);
		return activityVO;		
	}
	
}
