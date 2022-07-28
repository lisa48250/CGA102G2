package com.activity_join.model;

import java.sql.Timestamp;

public class ActivityJoinVO {
	private Integer activityOrderId; // ao.ACTIVITY_ORDER_ID,
	private Integer activityID; // a.ACTIVITY_ID,
	private String activityName; // a.ACTIVITY_NAME
	private String member_name; // m.MEMBER_NAME,
	private Integer member_id; // m.MEMBER_ID,
	private Integer activitySessionID; // ase.ACTIVITY_SESSION_ID
	private Timestamp activitySessionStart; // ase.ACTIVITY_ENROLL_STATE
	private Timestamp activitySessionEnd; // ase.ACTIVITY_SESSION_END
	private Timestamp orderTime; // ao.ORDER_TIME 訂單日期
	private Integer enrollNumber; // ao.ENROLL_NUMBER 報名人數
	private Integer orderAmount; // ao.ORDER_AMOUNT 訂單金額
	private Integer orderState; // ao.ORDER_STATE 訂單狀態
	private Integer refundState; // ao.REFUND_STATE 退款狀態
	private String orderMemo; // ao.ORDER_MEMO 活動備註
	private Boolean canCancel;

	public Boolean getCanCancel() {
		return canCancel;
	}

	public void setCanCancel(Boolean canCancel) {
		this.canCancel = canCancel;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getActivityOrderId() {
		return activityOrderId;
	}

	public void setActivityOrderId(Integer activityOrderId) {
		this.activityOrderId = activityOrderId;
	}

	public Integer getActivityID() {
		return activityID;
	}

	public void setActivityID(Integer activityID) {
		this.activityID = activityID;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	public Integer getActivitySessionID() {
		return activitySessionID;
	}

	public void setActivitySessionID(Integer activitySessionID) {
		this.activitySessionID = activitySessionID;
	}

	public Timestamp getActivitySessionStart() {
		return activitySessionStart;
	}

	public void setActivitySessionStart(Timestamp activitySessionStart) {
		this.activitySessionStart = activitySessionStart;
	}

	public Timestamp getActivitySessionEnd() {
		return activitySessionEnd;
	}

	public void setActivitySessionEnd(Timestamp activitySessionEnd) {
		this.activitySessionEnd = activitySessionEnd;
	}

	public Integer getEnrollNumber() {
		return enrollNumber;
	}

	public void setEnrollNumber(Integer enrollNumber) {
		this.enrollNumber = enrollNumber;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public Integer getRefundState() {
		return refundState;
	}

	public void setRefundState(Integer refundState) {
		this.refundState = refundState;
	}

	public String getOrderMemo() {
		return orderMemo;
	}

	public void setOrderMemo(String orderMemo) {
		this.orderMemo = orderMemo;
	}

}