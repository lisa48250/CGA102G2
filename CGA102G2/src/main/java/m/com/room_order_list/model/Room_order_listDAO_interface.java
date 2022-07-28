package m.com.room_order_list.model;

import java.util.List;

public interface Room_order_listDAO_interface {
	
	public void insert(Room_order_listVO room_order_listVO);

	public void update(Room_order_listVO room_order_listVO);

	public void delete(Integer room_order_list_id);

	public Room_order_listVO findByPrimaryKey(Integer room_order_list_id);

	public List<Room_order_listVO> getAll();
	
	public List<Room_order_listVO> getAllOrder(Integer room_order_id);
}
