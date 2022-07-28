package m.com.room_type_schedule.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Room_type_scheduleVO implements java.io.Serializable {
	private Integer room_type_schedule_id;
	private Integer room_type_id;
	private Integer room_amount;
	private Integer room_rsv_booked;
	private Timestamp room_order_date;
	public Integer getRoom_type_schedule_id() {
		return room_type_schedule_id;
	}
	public void setRoom_type_schedule_id(Integer room_type_schedule_id) {
		this.room_type_schedule_id = room_type_schedule_id;
	}
	public Integer getRoom_type_id() {
		return room_type_id;
	}
	public void setRoom_type_id(Integer room_type_id) {
		this.room_type_id = room_type_id;
	}
	public Integer getRoom_amount() {
		return room_amount;
	}
	public void setRoom_amount(Integer room_amount) {
		this.room_amount = room_amount;
	}
	public Integer getRoom_rsv_booked() {
		return room_rsv_booked;
	}
	public void setRoom_rsv_booked(Integer room_rsv_booked) {
		this.room_rsv_booked = room_rsv_booked;
	}
	public Timestamp getRoom_order_date() {
		return room_order_date;
	}
	public void setRoom_order_date(Timestamp room_order_date) {
		this.room_order_date = room_order_date;
	}
	
}
