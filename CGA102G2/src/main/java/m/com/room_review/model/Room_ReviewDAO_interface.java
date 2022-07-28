package m.com.room_review.model;

import java.util.List;

public interface Room_ReviewDAO_interface {
	 public void insert(Room_ReviewVO room_reviewVO);
     public void update(Room_ReviewVO empVO);
     public void delete(Integer room_review_id);
     public Room_ReviewVO findByPrimaryKey(Integer room_review_id);
     public List<Room_ReviewVO> getAll();
     //萬用複合查詢(傳入參數型態Map)(回傳 List)
//   public List<EmpVO> getAll(Map<String, String[]> map); 
}
