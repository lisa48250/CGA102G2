package h.com.room_schedule.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Room_scheduleVO implements java.io.Serializable {
	
	private Integer room_schedule_id;
	private Integer room_type_id;
	private Integer room_id;
	private Date check_in_date;
	private Date check_out_date;
	
	
	public Integer getRoom_schedule_id() {
		return room_schedule_id;
	}
	public void setRoom_schedule_id(Integer room_schedule_id) {
		this.room_schedule_id = room_schedule_id;
	}
	public Integer getRoom_type_id() {
		return room_type_id;
	}
	public void setRoom_type_id(Integer room_type_id) {
		this.room_type_id = room_type_id;
	}
	public Integer getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
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
