package m.com.room_order.model;

import java.sql.Date;

public class Room_OrderVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer room_order_id;
	private Integer member_id;
	private java.sql.Timestamp order_date;
	private Integer room_order_status;
	private Integer room_charge;
	private Date check_in_date;
	private Date check_out_date;
	
	public Integer getRoom_order_id() {
		return room_order_id;
	}
	public void setRoom_order_id(Integer room_order_id) {
		this.room_order_id = room_order_id;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public java.sql.Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(java.sql.Timestamp order_date) {
		this.order_date = order_date;
	}
	public int getRoom_order_status() {
		return room_order_status;
	}
	public void setRoom_order_status(int room_order_status) {
		this.room_order_status = room_order_status;
	}
	public int getRoom_charge() {
		return room_charge;
	}
	public void setRoom_charge(int room_charge) {
		this.room_charge = room_charge;
	}
	public Date getCheck_in_date() {
		return check_in_date;
	}
	public void setCheck_in_date(Date check_in_date) {
		this.check_in_date = check_in_date;
	}
	public Date getCheck_out_date() {
		return check_out_date;
	}
	public void setCheck_out_date(Date check_out_date) {
		this.check_out_date = check_out_date;
	}

}
