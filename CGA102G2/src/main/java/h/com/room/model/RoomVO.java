package h.com.room.model;

import java.sql.Date;

public class RoomVO implements java.io.Serializable{
	private Integer room_id;
	private Integer room_type_id;
	private String room_guest_name;
	private Integer room_sale_status;
	private Integer room_status;
	private Integer room_type;
	private Date check_in_date;
	private Date check_out_date;

	
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

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}
	public Integer getRoom_type_id() {
		return room_type_id;
	}
	public void setRoom_type_id(Integer room_type_id) {
		this.room_type_id = room_type_id;
	}
	public String getRoom_guest_name() {
		return room_guest_name;
	}
	public void setRoom_guest_name(String room_guest_name) {
		this.room_guest_name = room_guest_name;
	}
	public Integer getRoom_sale_status() {
		return room_sale_status;
	}
	public void setRoom_sale_status(Integer room_sale_status) {
		this.room_sale_status = room_sale_status;
	}
	public Integer getRoom_type() {
		return room_type;
	}

	public void setRoom_type(Integer room_type) {
		this.room_type = room_type;
	}

	public Integer getRoom_status() {
		return room_status;
	}
	public void setRoom_status(Integer room_status) {
		this.room_status = room_status;
	}
	
	
	
	public String toString() {
		return "RoomVO =[room_id=" + room_id + " room_type_id=" + room_type_id + "room_guest_name="
				+ room_guest_name + "room_sale_status=" + room_sale_status + "room_status="
				+ room_status + "room_type=" + room_type + "]";
	}
	
	public h.com.room_type.model.Room_TypeVO getroom_type() {
		 h.com.room_type.model.Room_TypeService rt = new h.com.room_type.model.Room_TypeService();
		h.com.room_type.model.Room_TypeVO rtv = rt.getOneRoom_Type(room_type_id);
		return rtv;
	}
	
	

}
