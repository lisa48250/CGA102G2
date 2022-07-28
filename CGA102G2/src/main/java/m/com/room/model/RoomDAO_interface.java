package m.com.room.model;

import java.util.List;

public interface RoomDAO_interface {
	 public void insert(RoomVO roomVO);
     public void update(RoomVO roomVO);
     public void delete(Integer room_id);
     public RoomVO findByPrimaryKey(Integer room_id);
     public List<RoomVO> getAll();
     public List<RoomVO> getAllRoomType(Integer room_type_id);
	
 	
     //萬用複合查詢(傳入參數型態Map)(回傳 List)
//   public List<EmpVO> getAll(Map<String, String[]> map); 
}
