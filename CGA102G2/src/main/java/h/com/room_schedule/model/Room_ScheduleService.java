package h.com.room_schedule.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Room_ScheduleService {

	private Room_scheduleDAO_interface dao;

	public Room_ScheduleService() {
		dao = new Room_scheduleJDBCDAO();
	}

	public Room_scheduleVO insertRoomTypeSchedule(Integer room_type_id, Integer room_id, Date check_in_date,
			Date check_out_date) {
		Room_scheduleVO rol = new Room_scheduleVO();
		rol.setRoom_type_id(room_type_id);
		rol.setRoom_id(room_id);
		rol.setCheck_in_date(check_in_date);
		rol.setCheck_out_date(check_out_date);
		dao.insert(rol);
		return rol;

	}

	public Room_scheduleVO updateRoomTypeSchedule(Integer room_type_id, Integer room_id, Date check_in_date,
			Date check_out_date) {
		Room_scheduleVO rol = new Room_scheduleVO();
		rol.setRoom_type_id(room_type_id);
		rol.setRoom_id(room_id);
		rol.setCheck_in_date(check_in_date);
		rol.setCheck_out_date(check_out_date);
		dao.update(rol);
		return rol;

	}

	public void deleteRoomTypeSchedule(Integer room_schedule_id) {
		dao.delete(room_schedule_id);
	}

	public Room_scheduleVO findByPrimaryKeyRoomTypeSchedule(Integer room_schedule_id) {
		return dao.findByPrimaryKey(room_schedule_id);
	}

	public List<Room_scheduleVO> getAllRoomTypeSchedule() {
		return dao.getAll();
	}

	public List<Room_scheduleVO> getAllRoomidDate(Integer room_id) {
		return dao.getAllRoomidDate(room_id);
	}
	public List<Room_scheduleVO> getNew(Date check_in_date ,Date check_out_date , Integer room_type_id ){
		return dao.getNew(check_in_date,check_out_date, room_type_id);
	}
}
