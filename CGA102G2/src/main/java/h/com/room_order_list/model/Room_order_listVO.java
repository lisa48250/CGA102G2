package h.com.room_order_list.model;



public class Room_order_listVO implements java.io.Serializable {
	private Integer room_order_list_id;
	private Integer room_type_id;
	private Integer room_id;
	private Integer room_order_id;
	private Integer number_of_people;
	private String special_req;
	private Integer room_price;
	private Integer room_type;
	private Integer room;

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

	public Integer getroom_type() {
		return room_type;
	}

	public void setroom_type(Integer room_type) {
		this.room_type = room_type;
	}
	
	public Integer getRoom_price() {
		return room_price;
	}

	public void setRoom_price(Integer room_price) {
		this.room_price = room_price;
	}
	
	public Integer getroom() {
		return room_price;
	}

	public void setroom(Integer room) {
		this.room = room;
	}
	
	//現在是訂單明細
	
	//房型
	public h.com.room_type.model.Room_TypeVO getroom_TypeVO(){
		h.com.room_type.model.Room_TypeService rts = new h.com.room_type.model.Room_TypeService();
		h.com.room_type.model.Room_TypeVO rtvo = rts.getOneRoom_Type(room_type_id);
		return rtvo;
	}
	//房間
	public h.com.room.model.RoomVO getroomVO(){
		h.com.room.model.Room_Service rs = new h.com.room.model.Room_Service();
		h.com.room.model.RoomVO rvo = rs.getOneRoom(room_id);
		return rvo;
	}
}
