package h.com.room_type_photo.model;

import java.util.List;

public interface Room_type_photoDAO_interface {
	
	public void insert(Room_type_photoVO room_type_photoVO);

	public void update(Room_type_photoVO room_type_photoVO);

	public void delete(Integer room_type_photo_id);

	public Room_type_photoVO findByPrimaryKey(Integer room_type_photo_id);

	public List<Room_type_photoVO> getAll();
	
	public  List<Room_type_photoVO> getAllPhoto(Integer room_type_id);
	
	public  List<Room_type_photoVO> getAllPhotoID(Integer room_type_id);

}
