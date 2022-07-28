package m.com.room.model;

import m.com.room_type.model.Room_TypeService;
import m.com.room_type.model.Room_TypeVO;

public class RoomVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer room_id;
	private Integer room_type_id;
	private String room_guest_name;
	private Integer room_sale_status;
	private Integer room_status;
//	private Room_TypeVO Room_typevo;
	
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
	public Integer getRoom_status() {
		return room_status;
	}
	public void setRoom_status(Integer room_status) {
		this.room_status = room_status;
	}
//	public Room_TypeVO getRoom_typevo() {
//		return Room_typevo;
//	}
	public Room_TypeVO getroomtype(Integer room_type_id) {
        Room_TypeService roomtypeSvc = new Room_TypeService();
        return roomtypeSvc.getOneRoom_Type(room_type_id);
    }

}
