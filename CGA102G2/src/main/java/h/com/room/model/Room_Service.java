package h.com.room.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import h.com.room_order_list.model.Room_order_listVO;

public class Room_Service {

	private RoomDAO_interface dao;

	public Room_Service() {
		dao = new RoomJDBCDAO();
	}

	public RoomVO addRoom(Integer room_type_id, Integer room_sale_status, Integer room_status ,Date check_in_date , Date check_out_date) {

		RoomVO roomVO = new RoomVO();

		roomVO.setRoom_type_id(room_type_id);
		roomVO.setRoom_sale_status(room_sale_status);
		roomVO.setRoom_status(room_status);
		roomVO.setCheck_in_date(check_in_date);
		roomVO.setCheck_out_date(check_out_date);
		dao.insert(roomVO);
		return roomVO;
	}

	public RoomVO updateRoom(Integer room_id, Integer room_type_id, String room_guest_name, Integer room_sale_status,
			Integer room_status ,Date check_in_date , Date check_out_date) {

		RoomVO roomVO = new RoomVO();

		roomVO.setRoom_id(room_id);
		roomVO.setRoom_type_id(room_type_id);
		roomVO.setRoom_guest_name(room_guest_name);
		roomVO.setRoom_sale_status(room_sale_status);
		roomVO.setRoom_status(room_status);
		roomVO.setCheck_in_date(check_in_date);
		roomVO.setCheck_out_date(check_out_date);
		dao.update(roomVO);

		return roomVO;
	}

	public void deleteRoom(Integer room_id) {
		dao.delete(room_id);
	}

	public RoomVO getOneRoom(Integer room_id) {
		return dao.findByPrimaryKey(room_id);
	}

	public List<RoomVO> getAll() {
		return dao.getAll();
	}

	public List<RoomVO> getAllRoomId(Integer room_type_id) {
		return dao.getAllRoomId(room_type_id);
	}

	public RoomVO getRoomId(Integer room_type_id) {
		return dao.getRoomId(room_type_id);
	}

	public List<RoomVO> getAllRoomStatus(Integer room_type_id) {
		return dao.getAllRoomStatus(room_type_id);
	}

	public Set<Room_order_listVO> getRoom_order_listByRoom(Integer room_id) {
		return dao.getRoom_order_listByRoom(room_id);
	}

	public void updateRoomStatus( Integer room_id ) {
		 dao.updateRoomStatus(room_id);
		
	}

	public List<RoomVO> getAllRoomDateStatus(Integer room_type_id) {
		return dao.getAllRoomDateStatus(room_type_id);
	}
}
