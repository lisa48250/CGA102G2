package com.activity_session.model;

import java.sql.Date;
import java.sql.Timestamp;

import com.activity.model.ActivityService;
import com.activity.model.ActivityVO;

public class ActivitySessionVO implements java.io.Serializable{
	private Integer activity_session_ID;	// ACTIVITY_SESSION_ID
	private Integer activity_ID;	// ACTIVITY_ID
	private Timestamp activity_session_start;	// ACTIVITY_SESSION_START
	private Timestamp activity_session_end; // ACTIVITY_SESSION_END
	private Integer activity_enroll_state; // ACTIVITY_ENROLL_STATE
	private String status_note; // STATUS_NOTE
	private Integer activity_max_part; // ACTIVITY_MAX_PART
	private Integer activity_min_part; // ACTIVITY_MIN_PART
	private Integer enroll_total; // ENROLL_TOTAL
	private Date enroll_start; // ENROLL_START
	private Date enroll_end; // ENROLL_END
	private Integer activity_session_state; // ACTIVITY_SESSION_STATE
	
	public ActivitySessionVO () {
		
	}

	public ActivitySessionVO(Integer activity_session_ID, Integer activity_ID, Timestamp activity_session_start,
			Timestamp activity_session_end, Integer activity_enroll_state, String status_note,
			Integer activity_max_part, Integer activity_min_part, Integer enroll_total, Date enroll_start,
			Date enroll_end, Integer activity_session_state) {
		super();
		this.activity_session_ID = activity_session_ID;
		this.activity_ID = activity_ID;
		this.activity_session_start = activity_session_start;
		this.activity_session_end = activity_session_end;
		this.activity_enroll_state = activity_enroll_state;
		this.status_note = status_note;
		this.activity_max_part = activity_max_part;
		this.activity_min_part = activity_min_part;
		this.enroll_total = enroll_total;
		this.enroll_start = enroll_start;
		this.enroll_end = enroll_end;
		this.activity_session_state = activity_session_state;
	}

	public Integer getActivity_session_ID() {
		return activity_session_ID;
	}

	public void setActivity_session_ID(Integer activity_session_ID) {
		this.activity_session_ID = activity_session_ID;
	}

	public Integer getActivity_ID() {
		return activity_ID;
	}

	public void setActivity_ID(Integer activity_ID) {
		this.activity_ID = activity_ID;
	}

	public Timestamp getActivity_session_start() {
		return activity_session_start;
	}

	public void setActivity_session_start(Timestamp activity_session_start) {
		this.activity_session_start = activity_session_start;
	}

	public Timestamp getActivity_session_end() {
		return activity_session_end;
	}

	public void setActivity_session_end(Timestamp activity_session_end) {
		this.activity_session_end = activity_session_end;
	}

	public Integer getActivity_enroll_state() {
		return activity_enroll_state;
	}

	public void setActivity_enroll_state(Integer activity_enroll_state) {
		this.activity_enroll_state = activity_enroll_state;
	}

	public String getStatus_note() {
		return status_note;
	}

	public void setStatus_note(String status_note) {
		this.status_note = status_note;
	}

	public Integer getActivity_max_part() {
		return activity_max_part;
	}

	public void setActivity_max_part(Integer activity_max_part) {
		this.activity_max_part = activity_max_part;
	}

	public Integer getActivity_min_part() {
		return activity_min_part;
	}

	public void setActivity_min_part(Integer activity_min_part) {
		this.activity_min_part = activity_min_part;
	}

	public Integer getEnroll_total() {
		return enroll_total;
	}

	public void setEnroll_total(Integer enroll_total) {
		this.enroll_total = enroll_total;
	}

	public Date getEnroll_start() {
		return enroll_start;
	}

	public void setEnroll_start(Date enroll_start) {
		this.enroll_start = enroll_start;
	}

	public Date getEnroll_end() {
		return enroll_end;
	}

	public void setEnroll_end(Date enroll_end) {
		this.enroll_end = enroll_end;
	}

	public Integer getActivity_session_state() {
		return activity_session_state;
	}

	public void setActivity_session_state(Integer activity_session_state) {
		this.activity_session_state = activity_session_state;
	}
	
	// for join activity_ID from activity
	public ActivityVO getActivityVO() {
		ActivityService activityService = new ActivityService();
		ActivityVO activityVO = activityService.getOneActivity(activity_ID);
		return activityVO;		
	}
	
}
