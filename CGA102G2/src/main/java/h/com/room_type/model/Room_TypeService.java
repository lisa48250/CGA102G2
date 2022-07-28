package h.com.room_type.model;

import java.sql.Blob;
import java.util.List;
import java.util.Set;

import h.com.room_order_list.model.Room_order_listVO;


public class Room_TypeService {
	
	private Room_TypeDAO_interface dao;

	public Room_TypeService() {
		dao = new Room_TypeJDBCDAO();
	}
	
	public Room_TypeVO addRoom_Type(String room_type_name, Integer room_type_amount, String room_type_content,
			Integer room_type_sale_status, String room_total_review, Blob room_type_pic, Integer room_type_price) {

		Room_TypeVO room_typeVO = new Room_TypeVO();

		room_typeVO.setRoom_type_name(room_type_name);
		room_typeVO.setRoom_type_amount(room_type_amount);
		room_typeVO.setRoom_total_review(room_total_review);
		room_typeVO.setRoom_type_content(room_type_content);
		room_typeVO.setRoom_type_sale_status(room_type_sale_status);
		room_typeVO.setRoom_type_pic(room_type_pic);
		room_typeVO.setRoom_type_price(room_type_price);
		dao.insert(room_typeVO);

		return room_typeVO;
	}
	
	public Room_TypeVO updateRoom_Type( Integer room_type_id, String room_type_name, Integer room_type_amount, String room_type_content,
			Integer room_type_sale_status, String room_total_review, Blob room_type_pic, Integer room_type_price)  {

		Room_TypeVO room_typeVO = new Room_TypeVO();

		room_typeVO.setRoom_type_id(room_type_id);
		room_typeVO.setRoom_type_name(room_type_name);
		room_typeVO.setRoom_type_amount(room_type_amount);
		room_typeVO.setRoom_total_review(room_total_review);
		room_typeVO.setRoom_type_content(room_type_content);
		room_typeVO.setRoom_type_sale_status(room_type_sale_status);
		room_typeVO.setRoom_type_pic(room_type_pic);
		room_typeVO.setRoom_type_price(room_type_price);
		dao.update(room_typeVO);

		return room_typeVO;
	}
	
	public void deleteRoom_Type(Integer room_type_id) {
		dao.delete(room_type_id);
	}

	public Room_TypeVO getOneRoom_Type(Integer room_type_id) {
		return dao.findByPrimaryKey(room_type_id);
	}

	public List<Room_TypeVO> getAll() {
		return dao.getAll();
	}
	
	public Set<Room_order_listVO> getRoom_order_listByRoom_type(Integer room_type_id) {
		return dao.getRoom_order_listByRoom_type(room_type_id);
	}
}
