package h.com.room_order.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import h.com.room_order_list.model.Room_order_listVO;





public class Room_OrderService {
	
	private Room_orderDAO_interface dao;

	public Room_OrderService() {
		dao = new Room_orderJDBCDAO();
	}

	public void insertRoomOrder(Integer member_id, Timestamp order_date, Integer room_order_status, Integer room_charge, Date check_in_date, Date check_out_date) {
		Room_orderVO rol = new Room_orderVO();

		rol.setMember_id(member_id);
		rol.setOrder_date(order_date);
		rol.setRoom_order_status(room_order_status);
		rol.setRoom_charge(room_charge);
		rol.setCheck_in_date(check_in_date);
		rol.setCheck_out_date(check_out_date);
	}

	public void updateRoomOrder(Integer member_id, Timestamp order_date, Integer room_order_status, Integer room_charge, Date check_in_date, Date check_out_date , Integer room_order_id) {
		

		Room_orderVO rol = new Room_orderVO();

		rol.setMember_id(member_id);
		rol.setOrder_date(order_date);
		rol.setRoom_order_status(room_order_status);
		rol.setRoom_charge(room_charge);
		rol.setCheck_in_date(check_in_date);
		rol.setCheck_out_date(check_out_date);
		rol.setRoom_order_id(room_order_id);
	}

	public void deleteRoomOrder(Integer room_order_id) {
		dao.delete(room_order_id);
	}

	public Room_orderVO findByPrimaryKeyRoomOrder(Integer room_order_id) {
		return dao.findByPrimaryKey(room_order_id);
	}

	public List<Room_orderVO> getAllRoomOrder() {
		return dao.getAll();
	}
	public Set<Room_order_listVO> getRoom_order_listByRoom_order(Integer room_order_id){
		return dao.getRoom_order_listByRoom_order(room_order_id);
	}
	public void insertWithRoom_order_list(Room_orderVO room_orderVO , List<Room_order_listVO> list) {
	 dao.insertWithRoom_order_list(room_orderVO , list);
		
	}
	public List<Room_orderVO> getAll0(Integer room_order_status , Integer member_id){
		return dao.getAll0(room_order_status , member_id);
	}
    public List<Room_orderVO> getAll1(Integer room_order_status , Integer member_id){
    	return dao.getAll1(room_order_status , member_id);
    }
    public List<Room_orderVO> getAll2(Integer room_order_status , Integer member_id){
    	return dao.getAll2(room_order_status , member_id);
    }
    public List<Room_orderVO> getAllID( Integer member_id){
    	return dao.getAllID( member_id);
    }
    }
	

