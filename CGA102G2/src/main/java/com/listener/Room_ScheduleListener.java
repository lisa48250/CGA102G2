package com.listener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import h.com.room_schedule.model.Room_ScheduleService;
import h.com.room_schedule.model.Room_scheduleVO;

/**
 * Application Lifecycle Listener implementation class Room_ScheduleListener
 *
 */
@WebListener
public class Room_ScheduleListener implements ServletContextListener {
	Timer timer;
	java.sql.Date du;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Listener關閉了");
		timer.cancel();

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		timer = new Timer();
		du = new java.sql.Date(System.currentTimeMillis());
		
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println("Listener啟動了");
				//刪除房間預訂表已退房的訂單
				Room_ScheduleService rss = new Room_ScheduleService();
				List<Room_scheduleVO> list = new ArrayList<Room_scheduleVO>();
				list = rss.getAllRoomTypeSchedule();

				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getCheck_out_date().getTime() == du.getTime()
							|| list.get(i).getCheck_out_date().getTime() < du.getTime()) {
						rss.deleteRoomTypeSchedule(list.get(i).getRoom_schedule_id());
					}

				}
			}

		};
		Calendar cal = new GregorianCalendar(2022, Calendar.JULY, 5, 0, 0, 0);
		timer.scheduleAtFixedRate(task, cal.getTime(), 24*3600*1000);

	}

}
