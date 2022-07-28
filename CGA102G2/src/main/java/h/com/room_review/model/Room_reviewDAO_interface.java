package h.com.room_review.model;

import java.util.List;

public interface Room_reviewDAO_interface {
	 public void insert(Room_reviewVO room_reviewVO);
     public void update(Room_reviewVO empVO);
     public void delete(Integer room_review_id);
     public Room_reviewVO findByPrimaryKey(Integer room_review_id);
     public List<Room_reviewVO> getAll();
     //萬用複合查詢(傳入參數型態Map)(回傳 List)
//   public List<EmpVO> getAll(Map<String, String[]> map); 
}
