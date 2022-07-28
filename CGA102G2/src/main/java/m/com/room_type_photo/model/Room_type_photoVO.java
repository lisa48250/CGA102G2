package m.com.room_type_photo.model;

import java.sql.Blob;

public class Room_type_photoVO implements java.io.Serializable{
	private Integer room_type_photo_id;
	private Integer room_type_id;
	private Blob room_type_photo;
	
	public Integer getRoom_type_photo_id() {
		return room_type_photo_id;
	}
	public void setRoom_type_photo_id(Integer room_type_photo_id) {
		this.room_type_photo_id = room_type_photo_id;
	}
	public Integer getRoom_type_id() {
		return room_type_id;
	}
	public void setRoom_type_id(Integer room_type_id) {
		this.room_type_id = room_type_id;
	}
	public Blob getRoom_type_photo() {
		return room_type_photo;
	}
	public void setRoom_type_photo(Blob room_type_photo) {
		this.room_type_photo = room_type_photo;
	}
}
