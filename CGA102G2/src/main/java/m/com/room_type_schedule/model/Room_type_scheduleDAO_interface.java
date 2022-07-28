package m.com.room_type_schedule.model;

import java.util.List;

public interface Room_type_scheduleDAO_interface {
	
	public void insert(Room_type_scheduleVO room_type_scheduleVO);

	public void update(Room_type_scheduleVO room_type_scheduleVO);

	public void delete(Integer room_type_scheduleVO);

	public Room_type_scheduleVO findByPrimaryKey(Integer room_type_scheduleVO);

	public List<Room_type_scheduleVO> getAll();
}
