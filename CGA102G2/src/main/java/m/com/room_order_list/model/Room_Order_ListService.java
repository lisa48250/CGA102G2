package m.com.room_order_list.model;

import java.util.List;

public class Room_Order_ListService {
	
	private Room_order_listDAO_interface dao;
	
	public Room_Order_ListService() {
		dao = new Room_order_listJDBCDAO();
	}
	
	public Room_order_listVO addRoom_Order_List(Integer room_type_id , Integer room_id , Integer room_order_id , Integer number_of_people , String special_req , Integer room_price) {
		
		Room_order_listVO room_order_listVO = new Room_order_listVO();
		room_order_listVO.setRoom_type_id(room_type_id);
		room_order_listVO.setRoom_id(room_id);
		room_order_listVO.setRoom_order_id(room_order_id);
		room_order_listVO.setNumber_of_people(number_of_people);
		room_order_listVO.setSpecial_req(special_req);
		room_order_listVO.setRoom_price(room_price);
		dao.insert(room_order_listVO);
		
		return room_order_listVO;
	}
	
	public Room_order_listVO updateRoom_Order_List(Integer room_order_list_id, Integer room_type_id , Integer room_id , Integer room_order_id , Integer number_of_people , String special_req , Integer room_price) {

		Room_order_listVO room_order_listVO = new Room_order_listVO();
		room_order_listVO.setRoom_order_list_id(room_order_list_id);
		room_order_listVO.setRoom_type_id(room_type_id);
		room_order_listVO.setRoom_id(room_id);
		room_order_listVO.setRoom_order_id(room_order_id);
		room_order_listVO.setNumber_of_people(number_of_people);
		room_order_listVO.setSpecial_req(special_req);
		room_order_listVO.setRoom_price(room_price);
		dao.update(room_order_listVO);
		
		return room_order_listVO;
	}
	
	public void deleteRoom_Order_List(Integer room_order_list_id) {
		dao.delete(room_order_list_id);
	}
	
	public Room_order_listVO getOneRoom_Order_List(Integer room_order_list_id) {
		return dao.findByPrimaryKey(room_order_list_id);
	}
	
	public List<Room_order_listVO>getAll(){
		return dao.getAll();
	}
	
	public List<Room_order_listVO>getAllOrder(Integer room_order_id){
		return dao.getAllOrder(room_order_id);
	}
}
