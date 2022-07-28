package m.com.room_type_photo.model;

import java.sql.Blob;
import java.util.List;


public class Room_type_photoService {
	private Room_type_photoDAO_interface dao;

	public Room_type_photoService() {
		dao = new Room_type_photoJDBCDAO();
	}
	
	public Room_type_photoVO addRoom_Type_Photo(Integer room_type_id, Blob room_type_photo) {

		Room_type_photoVO room_type_photoVO = new Room_type_photoVO();

		room_type_photoVO.setRoom_type_id(room_type_id);
		room_type_photoVO.setRoom_type_photo(room_type_photo);
		dao.insert(room_type_photoVO);

		return room_type_photoVO;
	}
	
	public Room_type_photoVO updateRoom_Type_Photo(Integer room_type_photo_id, Integer room_type_id, Blob room_type_photo) {

		Room_type_photoVO room_type_photoVO = new Room_type_photoVO();

		room_type_photoVO.setRoom_type_photo_id(room_type_photo_id);
		room_type_photoVO.setRoom_type_id(room_type_id);
		room_type_photoVO.setRoom_type_photo(room_type_photo);
		dao.update(room_type_photoVO);

		return room_type_photoVO;
	}
	
	public void deleteRoom_Type_Photo(Integer room_type_photo_id) {
		dao.delete(room_type_photo_id);
	}

	public Room_type_photoVO getOneRoom_Type_Photo(Integer room_type_photo_id) {
		return dao.findByPrimaryKey(room_type_photo_id);
	}

	public List<Room_type_photoVO> getAll() {
		return dao.getAll();
	}
	
	public  List<Room_type_photoVO> getAllPhoto(Integer room_type_id){
		return dao.getAllPhoto(room_type_id);
	}
	
	public  List<Room_type_photoVO> getAllType(Integer room_type_id){
		return dao.getAllType(room_type_id);
	}

}
