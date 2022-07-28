package h.com.room_order_list.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class Room_Order_ListService {

	private Room_order_listDAO_interface dao;

	public Room_Order_ListService() {
		dao = new Room_order_listJDBCDAO();
	}

	public void insertRoomOrderList(Integer room_type_id, Integer room_id, Integer room_order_id,
			Integer number_of_people, String special_req, Integer room_price) {
		Room_order_listVO rol = new Room_order_listVO();

		rol.setRoom_type_id(room_type_id);
		rol.setRoom_id(room_id);
		rol.setRoom_order_id(room_order_id);
		rol.setNumber_of_people(number_of_people);
		rol.setSpecial_req(special_req);
		rol.setRoom_price(room_price);
	}

	public void updateRoomOrderList(Integer room_type_id, Integer room_id, Integer room_order_id,
			Integer number_of_people, String special_req, Integer room_price, Integer room_order_list_id) {
		Room_order_listVO rol = new Room_order_listVO();

		rol.setRoom_type_id(room_type_id);
		rol.setRoom_id(room_id);
		rol.setRoom_order_id(room_order_id);
		rol.setNumber_of_people(number_of_people);
		rol.setSpecial_req(special_req);
		rol.setRoom_price(room_price);
		rol.setRoom_price(room_order_list_id);
	}

	public void deleteRoomOrderList(Integer room_order_list_id) {
		dao.delete(room_order_list_id);
	}

	public Room_order_listVO findByPrimaryKeyRoomOrderList(Integer room_order_list_id) {
		return dao.findByPrimaryKey(room_order_list_id);
	}

	public List<Room_order_listVO> getAllRoomOrderList() {
		return dao.getAll();
	}
	public  List<Room_order_listVO> getAllDetail(Integer room_order_id){
		return dao.getAllDetail(room_order_id);
	}
	
}
