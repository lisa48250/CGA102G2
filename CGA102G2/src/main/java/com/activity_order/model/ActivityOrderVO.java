package com.activity_order.model;
import java.sql.Date;
import java.sql.Timestamp;

public class ActivityOrderVO implements java.io.Serializable{
	private Integer activityOrderId;  //ACTIVITY_ORDER_ID 	活動訂單編號 join
	private Integer memberId; //MEMBER_ID  					會員編號	  join
	private Integer activitySessionId; //ACTIVITY_SESSION_ID 活動場次編號 join
	private Timestamp orderTime; //ORDER_TIME				訂單日期
	private Integer enrollNumber;  //ENROLL_NUMBER			報名人數
	private Integer orderAmount;  //ORDER_AMOUNT			訂單金額
	private Integer orderState;  //ORDER_STATE				訂單狀態
	private Integer refundState;  //REFUND_STATE			退款狀態
	private String orderMemo;  //ORDER_MEMO					訂單備註
	public Integer getActivityOrderId() {
		return activityOrderId;
	}
	public void setActivityOrderId(Integer activityOrderId) {
		this.activityOrderId = activityOrderId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getActivitySessionId() {
		return activitySessionId;
	}
	public void setActivitySessionId(Integer activitySessionId) {
		this.activitySessionId = activitySessionId;
	}
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
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
	

    // for join activitySessionStart 、activitySessionEnd from ActivitySessionId MemberId
	
    // for join activityName from  MemberId	activityID
}
