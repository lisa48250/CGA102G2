package h.com.room_review.model;

import java.sql.Timestamp;
import java.util.List;


public class RoomReviewService {

	
	private Room_reviewDAO_interface dao;

	public RoomReviewService() {
		dao = new Room_reviewJDBCDAO();
	}

	public void insertRoomReview(Integer room_order_id, Integer room_type_id, String room_review, Timestamp room_review_date) {
		Room_reviewVO rr =new Room_reviewVO();
		rr.setRoom_order_id(room_order_id);
		rr.setRoom_type_id(room_type_id);
		rr.setRoom_review(room_review);
		rr.setRoom_review_date(room_review_date);
	}

	public void updateRoomReview(Integer room_order_id, Integer room_type_id, String room_review, Timestamp room_review_date , Integer room_review_id) {
		Room_reviewVO rr =new Room_reviewVO();
		rr.setRoom_order_id(room_order_id);
		rr.setRoom_type_id(room_type_id);
		rr.setRoom_review(room_review);
		rr.setRoom_review_date(room_review_date);
		rr.setRoom_review_id(room_review_id);

	}

	public void deleteRoomReview(Integer room_order_id) {
		dao.delete(room_order_id);
	}

	public Room_reviewVO findByPrimaryKeyRoomReview(Integer room_order_id) {
		return dao.findByPrimaryKey(room_order_id);
	}

	public List<Room_reviewVO> getAllRoomReview() {
		return dao.getAll();
	}

}
