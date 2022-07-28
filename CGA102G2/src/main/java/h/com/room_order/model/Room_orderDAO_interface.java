package h.com.room_order.model;

import java.util.List;
import java.util.Set;

import h.com.room_order_list.model.Room_order_listVO;





public interface Room_orderDAO_interface {
	
	public void insert(Room_orderVO room_orderVO);
    public void update(Room_orderVO room_orderVO);
    public void delete(Integer room_order_id);
    public Room_orderVO findByPrimaryKey(Integer room_order_id);
    public List<Room_orderVO> getAll();
    public Set<Room_order_listVO> getRoom_order_listByRoom_order(Integer room_order_id);
    public void insertWithRoom_order_list(Room_orderVO room_orderVO , List<Room_order_listVO> list);
    public List<Room_orderVO> getAll0(Integer room_order_status , Integer member_id);
    public List<Room_orderVO> getAll1(Integer room_order_status , Integer member_id);
    public List<Room_orderVO> getAll2(Integer room_order_status , Integer member_id);
    public List<Room_orderVO> getAllID( Integer member_id);
}
