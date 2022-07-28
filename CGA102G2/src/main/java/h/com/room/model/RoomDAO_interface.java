package h.com.room.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import h.com.room_order_list.model.Room_order_listVO;

public interface RoomDAO_interface {
	 public void insert(RoomVO roomVO);
     public void update(RoomVO roomVO);
     public void delete(Integer room_id);
     public RoomVO findByPrimaryKey(Integer room_id);
     public List<RoomVO> getAll();
     // 房型編號查詢房間狀態是未預定的房間編號
     public List<RoomVO> getAllRoomId(Integer room_type_id);
     public RoomVO getRoomId(Integer room_type_id);
     //萬用複合查詢(傳入參數型態Map)(回傳 List)
//   public List<EmpVO> getAll(Map<String, String[]> map); 
	public Set<Room_order_listVO> getRoom_order_listByRoom(Integer room_id);
	//新增訂單的入住退房時間給房間的表格
	public void updateRoomStatus(Integer room_id);
	//查詢間狀態
	public List<RoomVO> getAllRoomStatus(Integer room_type_id);
	//查詢所有房間入退住日期(依房型)
	public List<RoomVO> getAllRoomDateStatus(Integer room_type_id);
}
