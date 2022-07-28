package com.activity.model;
import java.sql.Date;

import com.activity_category.model.ActivityCategoryService;
import com.activity_category.model.ActivityCategoryVO;

public class ActivityVO implements java.io.Serializable{
	private Integer activity_ID;	// ACTIVITY_ID
	private Integer activity_category_ID;	// ACTIVITY_CATEGORY_ID
	private String activity_name;	// ACTIVITY_NAME
	private Integer activity_price; // ACTIVITY_PRICE
	private Date activity_start; // ACTIVITY_START
	private Date activity_end; // ACTIVITY_END
	private String activity_description; // ACTIVITY_DESCRIPTION
	private String activity_content; // ACTIVITY_CONTENT
	private String activity_info; // ACTIVITY_INFO
	private Integer activity_state; // ACTIVITY_STATE
	
	public ActivityVO () {
		
	}

	public ActivityVO(Integer activity_ID, Integer activity_category_ID, String activity_name, Integer activity_price,
			Date activity_start, Date activity_end, String activity_description, String activity_content,
			String activity_info, Integer activity_state) {
		super();
		this.activity_ID = activity_ID;
		this.activity_category_ID = activity_category_ID;
		this.activity_name = activity_name;
		this.activity_price = activity_price;
		this.activity_start = activity_start;
		this.activity_end = activity_end;
		this.activity_description = activity_description;
		this.activity_content = activity_content;
		this.activity_info = activity_info;
		this.activity_state = activity_state;
	}

	public Integer getActivity_ID() {
		return activity_ID;
	}

	public void setActivity_ID(Integer activity_ID) {
		this.activity_ID = activity_ID;
	}

	public Integer getActivity_category_ID() {
		return activity_category_ID;
	}

	public void setActivity_category_ID(Integer activity_category_ID) {
		this.activity_category_ID = activity_category_ID;
	}

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	public Integer getActivity_price() {
		return activity_price;
	}

	public void setActivity_price(Integer activity_price) {
		this.activity_price = activity_price;
	}

	public Date getActivity_start() {
		return activity_start;
	}

	public void setActivity_start(Date activity_start) {
		this.activity_start = activity_start;
	}

	public Date getActivity_end() {
		return activity_end;
	}

	public void setActivity_end(Date activity_end) {
		this.activity_end = activity_end;
	}

	public String getActivity_description() {
		return activity_description;
	}

	public void setActivity_description(String activity_description) {
		this.activity_description = activity_description;
	}

	public String getActivity_content() {
		return activity_content;
	}

	public void setActivity_content(String activity_content) {
		this.activity_content = activity_content;
	}

	public String getActivity_info() {
		return activity_info;
	}

	public void setActivity_info(String activity_info) {
		this.activity_info = activity_info;
	}

	public Integer getActivity_state() {
		return activity_state;
	}

	public void setActivity_state(Integer activity_state) {
		this.activity_state = activity_state;
	}
	
	// for join activity_category_ID from activity_category
	public ActivityCategoryVO getActivityCategoryVO() {
		ActivityCategoryService activityCategoryService = new ActivityCategoryService();
		ActivityCategoryVO activityCategoryVO = activityCategoryService.getOneActivityCategory(activity_category_ID);
		return activityCategoryVO;		
	}
			
}
