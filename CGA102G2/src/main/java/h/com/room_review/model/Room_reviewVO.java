package h.com.room_review.model;

import java.sql.Timestamp;

public class Room_reviewVO implements java.io.Serializable{
	private Integer room_review_id;
	private Integer room_order_id;
	private Integer room_type_id;
	private String room_review;
	private Timestamp room_review_date;
	
	
	public Integer getRoom_review_id() {
		return room_review_id;
	}
	public void setRoom_review_id(Integer room_review_id) {
		this.room_review_id = room_review_id;
	}
	public Integer getRoom_order_id() {
		return room_order_id;
	}
	public void setRoom_order_id(Integer room_order_id) {
		this.room_order_id = room_order_id;
	}
	public Integer getRoom_type_id() {
		return room_type_id;
	}
	public void setRoom_type_id(Integer room_type_id) {
		this.room_type_id = room_type_id;
	}
	public String getRoom_review() {
		return room_review;
	}
	public void setRoom_review(String room_review) {
		this.room_review = room_review;
	}
	public java.sql.Timestamp getRoom_review_date() {
		return room_review_date;
	}
	public void setRoom_review_date(java.sql.Timestamp room_review_date) {
		this.room_review_date = room_review_date;
	}
	

}
