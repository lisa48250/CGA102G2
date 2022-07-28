package m.com.room_order.model;

import java.sql.Date;
import java.util.List;

public interface Room_OrderDAO_interface {
	
	public void insert(Room_OrderVO room_orderVO);
    public void update(Room_OrderVO room_orderVO);
    public void delete(Integer room_order_id);
    public Room_OrderVO findByPrimaryKey(Integer room_order_id);
    public List<Room_OrderVO> getAll();
    public List<Room_OrderVO> getAllTime();
    public void updateStatus(Room_OrderVO room_orderVO);
    public void updateStatusout(Room_OrderVO room_orderVO);
    public List<Room_OrderVO> findByCheckin(Date check_in_date);
    public List<Room_OrderVO> findtodayorder() ;
}
