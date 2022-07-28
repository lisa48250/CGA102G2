package m.com.room_order.model;

import java.sql.Date;
import java.util.List;

import m.com.room.model.RoomService;
import m.com.room.model.RoomVO;
import m.com.room_order_list.model.Room_Order_ListService;
import m.com.room_order_list.model.Room_order_listVO;

public class Room_OrderService {

	private Room_OrderDAO_interface dao;

	public Room_OrderService() {
		dao = new Room_OrderJDBCDAO();
	}

	public Room_OrderVO addRoom_Order(Integer member_id, java.sql.Timestamp order_date, Integer room_order_status,
			Integer room_charge, Date check_in_date, Date check_out_date) {

		Room_OrderVO room_orderVO = new Room_OrderVO();

		room_orderVO.setMember_id(member_id);
		room_orderVO.setRoom_order_status(room_order_status);
		room_orderVO.setRoom_charge(room_charge);
		room_orderVO.setCheck_in_date(check_in_date);
		room_orderVO.setCheck_out_date(check_out_date);
		dao.insert(room_orderVO);

		return room_orderVO;
	}

	public Room_OrderVO updateRoom_Order(Integer room_order_id, Integer member_id, java.sql.Timestamp order_date,
			Integer room_order_status, Integer room_charge, Date check_in_date, Date check_out_date) {

		Room_OrderVO room_orderVO = new Room_OrderVO();

		room_orderVO.setRoom_order_id(room_order_id);
		room_orderVO.setMember_id(member_id);
		room_orderVO.setOrder_date(order_date);
		room_orderVO.setRoom_order_status(room_order_status);
		room_orderVO.setRoom_charge(room_charge);
		room_orderVO.setCheck_in_date(check_in_date);
		room_orderVO.setCheck_out_date(check_out_date);
		dao.update(room_orderVO);

		return room_orderVO;
	}

	public void deleteRoom_Order(Integer room_order_id) {
		dao.delete(room_order_id);
	}

	public Room_OrderVO getOneRoom_Order(Integer room_order_id) {
		return dao.findByPrimaryKey(room_order_id);
	}

	public List<Room_OrderVO> getAll() {
		return dao.getAll();
	}
	
	public List<Room_OrderVO> getAllTime() {
		return dao.getAllTime();
	}

	public Room_OrderVO updateStatus(Room_OrderVO room_orderVO) {

		room_orderVO.setRoom_order_status(1);
		dao.updateStatus(room_orderVO);
		Integer room_order_id = room_orderVO.getRoom_order_id();
		Room_Order_ListService roomlistSvc = new Room_Order_ListService();
		List<Room_order_listVO> list = roomlistSvc.getAllOrder(room_order_id);
		RoomService roomSvc = new RoomService();
		for(Room_order_listVO list1 : list) {
			Integer id = list1.getRoom_id();
			RoomVO room = roomSvc.getOneRoom(id);
			System.out.println("房間編號"+id);
			room.setRoom_status(1);
			Integer room_id = room.getRoom_id();
			Integer room_sale_status = room.getRoom_sale_status();
			Integer room_status = room.getRoom_status();
			Integer room_type_id = room.getRoom_type_id();
			String room_guest_name = room.getRoom_guest_name();
			roomSvc.updateRoom(room_id, room_type_id, room_guest_name, room_sale_status, room_status);
		}
		return room_orderVO;
	}
	
	public Room_OrderVO updateStatusout(Room_OrderVO room_orderVO) {

		room_orderVO.setRoom_order_status(0);
		dao.updateStatus(room_orderVO);
		Integer room_order_id = room_orderVO.getRoom_order_id();
		Room_Order_ListService roomlistSvc = new Room_Order_ListService();
		List<Room_order_listVO> list = roomlistSvc.getAllOrder(room_order_id);
		RoomService roomSvc = new RoomService();
		for(Room_order_listVO list1 : list) {
			Integer id = list1.getRoom_id();
			RoomVO room = roomSvc.getOneRoom(id);
			room.setRoom_status(2);
			Integer room_id = room.getRoom_id();
			Integer room_sale_status = room.getRoom_sale_status();
			Integer room_status = room.getRoom_status();
			Integer room_type_id = room.getRoom_type_id();
			String room_guest_name = room.getRoom_guest_name();
			roomSvc.updateRoom(room_id, room_type_id, room_guest_name, room_sale_status, room_status);
		}
		return room_orderVO;
	}
	
	public List<Room_OrderVO> getCheckin(Date check_in_date) {
		return (List<Room_OrderVO>) dao.findByCheckin(check_in_date);
	}
	
	public List<Room_OrderVO> findtodayorder() {
		return (List<Room_OrderVO>) dao.findtodayorder();
	}
	
	public List<Room_order_listVO> getList(Integer room_order_id ) {

		Room_Order_ListService roomlistSvc = new Room_Order_ListService();
		List<Room_order_listVO> list = roomlistSvc.getAllOrder(room_order_id);
		return list;
	}
}
