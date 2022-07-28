package m.com.room.model;

import java.util.List;

public class RoomService {
	
	private RoomDAO_interface dao;
	
	public RoomService() {
		dao = new RoomJDBCDAO();
	}
	
	public RoomVO addRoom(Integer room_type_id, String room_guest_name, Integer room_sale_status, Integer room_status) {
		
		RoomVO roomVO = new RoomVO();
		
		roomVO.setRoom_type_id(room_type_id);
		roomVO.setRoom_guest_name(room_guest_name);
		roomVO.setRoom_sale_status(room_sale_status);
		roomVO.setRoom_status(room_status);
		
		dao.insert(roomVO);
		return roomVO;
	}
	
	public RoomVO updateRoom(Integer room_id, Integer room_type_id, String room_guest_name, Integer room_sale_status, Integer room_status) {
		
		RoomVO roomVO = new RoomVO();
		
		roomVO.setRoom_id(room_id);
		roomVO.setRoom_type_id(room_type_id);
		roomVO.setRoom_guest_name(room_guest_name);
		roomVO.setRoom_sale_status(room_sale_status);
		roomVO.setRoom_status(room_status);
		dao.update(roomVO);
		
		return roomVO;
	}
	
	public void deleteRoom(Integer room_id) {
		dao.delete(room_id);
	}
	
	public RoomVO getOneRoom(Integer room_id) {
		return dao.findByPrimaryKey(room_id);
	}
	
	public List<RoomVO> getAll(){
		return dao.getAll();
	}
	
	public List<RoomVO> getAllRoomType(Integer room_type_id){
		return dao.getAllRoomType(room_type_id);
	}
}
