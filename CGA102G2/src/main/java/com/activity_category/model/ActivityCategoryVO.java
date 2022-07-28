package com.activity_category.model;

public class ActivityCategoryVO implements java.io.Serializable{
	private Integer activity_category_ID;	// ACTIVITY_CATEGORY_ID
	private String activity_category_name;	// ACTIVITY_CATEGORY_NAME
	private String activity_category_info;	// ACTIVITY_CATEGORY_INFO
	
	public ActivityCategoryVO() {
		
	}
	
	public ActivityCategoryVO(Integer activity_category_ID, String activity_category_name,
			String activity_category_info) {
		super();
		this.activity_category_ID = activity_category_ID;
		this.activity_category_name = activity_category_name;
		this.activity_category_info = activity_category_info;
	}

	public Integer getActivity_category_ID() {
		return activity_category_ID;
	}

	public void setActivity_category_ID(Integer activity_category_ID) {
		this.activity_category_ID = activity_category_ID;
	}

	public String getActivity_category_name() {
		return activity_category_name;
	}

	public void setActivity_category_name(String activity_category_name) {
		this.activity_category_name = activity_category_name;
	}

	public String getActivity_category_info() {
		return activity_category_info;
	}

	public void setActivity_category_info(String activity_category_info) {
		this.activity_category_info = activity_category_info;
	}
	
}
