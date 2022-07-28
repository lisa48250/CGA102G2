package h.com.room_schedule.model;

import java.sql.Date;
import java.util.List;

public interface Room_scheduleDAO_interface {
	
	public void insert(Room_scheduleVO room_type_scheduleVO);

	public void update(Room_scheduleVO room_type_scheduleVO);

	public void delete(Integer room_type_scheduleVO);

	public Room_scheduleVO findByPrimaryKey(Integer room_type_scheduleVO);

	public List<Room_scheduleVO> getAll();

	public List<Room_scheduleVO> getAllRoomidDate(Integer room_id);

	public List<Room_scheduleVO> getNew(Date check_in_date, Date check_out_date, Integer room_type_id);
}
