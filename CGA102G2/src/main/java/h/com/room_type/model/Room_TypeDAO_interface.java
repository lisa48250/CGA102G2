package h.com.room_type.model;

import java.util.List;
import java.util.Set;

import h.com.room_order_list.model.Room_order_listVO;

public interface Room_TypeDAO_interface {
	 public void insert(Room_TypeVO room_typeVO);
     public void update(Room_TypeVO room_typeVO);
     public void delete(Integer room_type_id);
     public Room_TypeVO findByPrimaryKey(Integer room_type_id);
     public List<Room_TypeVO> getAll();
     //萬用複合查詢(傳入參數型態Map)(回傳 List)
//   public List<EmpVO> getAll(Map<String, String[]> map); 
	public Set<Room_order_listVO> getRoom_order_listByRoom_type(Integer room_type_id);

}
