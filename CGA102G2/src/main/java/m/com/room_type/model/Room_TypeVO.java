package m.com.room_type.model;

import java.sql.Blob;

public class Room_TypeVO  implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer room_type_id;
	private String room_type_name;
	private Integer room_type_amount;
	private String room_type_content;
	private Integer room_type_sale_status;
	private String room_total_review;
	private Blob room_type_pic;
	private Integer room_type_price;
	
	public Integer getRoom_type_id() {
		return room_type_id;
	}
	public void setRoom_type_id(Integer room_type_id) {
		this.room_type_id = room_type_id;
	}
	public String getRoom_type_name() {
		return room_type_name;
	}
	public void setRoom_type_name(String room_type_name) {
		this.room_type_name = room_type_name;
	}
	public Integer getRoom_type_amount() {
		return room_type_amount;
	}
	public void setRoom_type_amount(Integer room_type_amount) {
		this.room_type_amount = room_type_amount;
	}
	public String getRoom_type_content() {
		return room_type_content;
	}
	public void setRoom_type_content(String room_type_content) {
		this.room_type_content = room_type_content;
	}
	public Integer getRoom_type_sale_status() {
		return room_type_sale_status;
	}
	public void setRoom_type_sale_status(Integer room_sale_status) {
		this.room_type_sale_status = room_sale_status;
	}
	public String getRoom_total_review() {
		return room_total_review;
	}
	public void setRoom_total_review(String room_total_review) {
		this.room_total_review = room_total_review;
	}
	public Blob getRoom_type_pic() {
		return room_type_pic;
	}
	public void setRoom_type_pic(Blob room_type_pic) {
		this.room_type_pic = room_type_pic;
	}
	public Integer getRoom_type_price() {
		return room_type_price;
	}
	public void setRoom_type_price(Integer room_type_price) {
		this.room_type_price = room_type_price;
	}	
}
