package m.com.room_order_list.model;

import m.com.room_type.model.Room_TypeService;
import m.com.room_type.model.Room_TypeVO;

public class Room_order_listVO implements java.io.Serializable {
	private Integer room_order_list_id;
	private Integer room_type_id;
	private Integer room_id;
	private Integer room_order_id;
	private Integer number_of_people;
	private String special_req;
	private Integer room_price;

	public Integer getRoom_order_list_id() {
		return room_order_list_id;
	}

	public void setRoom_order_list_id(Integer room_order_list_id) {
		this.room_order_list_id = room_order_list_id;
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

	public Integer getRoom_order_id() {
		return room_order_id;
	}

	public void setRoom_order_id(Integer room_order_id) {
		this.room_order_id = room_order_id;
	}

	public Integer getNumber_of_people() {
		return number_of_people;
	}

	public void setNumber_of_people(Integer number_of_people) {
		this.number_of_people = number_of_people;
	}

	public String getSpecial_req() {
		return special_req;
	}

	public void setSpecial_req(String special_req) {
		this.special_req = special_req;
	}

	public Integer getRoom_price() {
		return room_price;
	}

	public void setRoom_price(Integer room_price) {
		this.room_price = room_price;
	}
	
	// Join房型
	public Room_TypeVO getRoomTypeVO() {
		Room_TypeService room_typeSvc = new Room_TypeService();
		Room_TypeVO room_typeVO = room_typeSvc.getOneRoom_Type(room_type_id);
		return room_typeVO;
	}
}
