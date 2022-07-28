package h.com.room.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import h.com.room.model.RoomJDBCDAO;
import h.com.room.model.RoomVO;
import h.com.room.model.Room_Service;
import h.com.room_order_list.model.Room_order_listVO;
import h.com.room_schedule.model.Room_ScheduleService;
import h.com.room_schedule.model.Room_scheduleVO;
import h.com.room_type.model.Room_TypeService;
import h.com.room_type.model.Room_TypeVO;
import h.com.room_type_photo.model.Room_type_photoService;
import h.com.room_type_photo.model.Room_type_photoVO;

@WebServlet("/SearchRoom")
public class SearchRoomServlet extends HttpServlet {

	public SearchRoomServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");

		if ("search".equals(action)) {
			List<String> errormsg = new ArrayList<String>();

			List info = new ArrayList();

			java.sql.Date start_date = null;
			try {
				start_date = java.sql.Date.valueOf(req.getParameter("start_date"));
				info.add(start_date);
			} catch (IllegalArgumentException e) {
				start_date = new java.sql.Date(System.currentTimeMillis());
				errormsg.add("請輸入入住日期");

			}
			java.sql.Date end_date = null;
			try {
				end_date = java.sql.Date.valueOf(req.getParameter("end_date"));
				info.add(end_date);
			} catch (IllegalArgumentException e) {
				end_date = new java.sql.Date(System.currentTimeMillis());
				errormsg.add("請輸入退房日期");

			}

			Integer roomcount = null;
			String select = null;
			select = req.getParameter("select");
			if (select == null || select == "") {
				errormsg.add("請選擇房間數量");
			} else {
				roomcount = Integer.parseInt(select);
				info.add(select);
			}

			String select1 = null;
			select1 = req.getParameter("select1");
			if (select1 == null || select1 == "") {
				errormsg.add("請選擇入住人數");
			} else {
				info.add(select1);
			}
			if (end_date.getTime() - start_date.getTime() < 0) {
				errormsg.add("請重新選擇日期");
			}
			
			Integer room_type_id = null;
			String	room_type_id1 = req.getParameter("room_type_id").trim();
			System.out.println(room_type_id1);
			if(room_type_id1 == null || room_type_id1.length() == 0) {
				errormsg.add("抓不到房型編號");
			}else {
				room_type_id = Integer.valueOf(room_type_id1);
			}

			List<Integer> list = new ArrayList<Integer>();
			List<Room_order_listVO> roomorder = new ArrayList<Room_order_listVO>();
			Room_Service rm = new Room_Service();
			Room_ScheduleService rss = new Room_ScheduleService();
			Room_TypeService rts = new Room_TypeService();
			Integer roomamount = rts.getOneRoom_Type(room_type_id).getRoom_type_amount();
			Integer roomidamount;
			Integer roomid;
			int count = 0;
			// 取得房型的所有房間的數量
			for (int i = 0; i < roomamount; i++) {

				roomid = rm.getAllRoomId(room_type_id).get(i).getRoom_id();
				// 將全部房間編號加進list
				list.add(roomid);

				roomidamount = rss.getAllRoomidDate(roomid).size();
				// 判斷是否符合條件
				for (int j = 0; j < roomidamount; j++) {

					while (rss.getAllRoomidDate(roomid).get(j).getCheck_in_date().equals(start_date)
							&& rss.getAllRoomidDate(roomid).get(j).getCheck_out_date().equals(end_date)) {
						list.remove(roomid);
						break;
					}
					while (rss.getAllRoomidDate(roomid).get(j).getCheck_in_date().getTime() <= start_date.getTime() &&

							start_date.getTime() <= rss.getAllRoomidDate(roomid).get(j).getCheck_out_date().getTime()) {
						list.remove(roomid);
						break;
					}
					while (rss.getAllRoomidDate(roomid).get(j).getCheck_in_date().getTime() <= end_date.getTime() &&

							end_date.getTime() <= rss.getAllRoomidDate(roomid).get(j).getCheck_out_date().getTime()) {
						list.remove(roomid);
						break;
					}
				}
			}

			// 圖片
			List<Room_type_photoVO> roomphotoid = new ArrayList<Room_type_photoVO>();
			Room_type_photoService rtps = new Room_type_photoService();

			// 住宿天數
			long diff = end_date.getTime() - start_date.getTime();
			long days = diff / (1000 * 60 * 60 * 24);

			if (!errormsg.isEmpty()) {

				Room_TypeVO room_typeVO = rts.getOneRoom_Type(room_type_id);
				List<Room_type_photoVO> list1 = new ArrayList<Room_type_photoVO>();
				Room_type_photoService rtp = new Room_type_photoService();
				list1 = rtp.getAllPhoto(room_type_id);
				req.setAttribute("list1", list1);
				req.setAttribute("room_typeVO", room_typeVO);
				
				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/room/SearchRoom.jsp");
				failureView.forward(req, res);
				return;
			}
			if (list.size() > roomcount || list.size() == roomcount) {
				
				
				Room_TypeVO room_typeVO = rts.getOneRoom_Type(room_type_id);
				List<Room_type_photoVO> list1 = new ArrayList<Room_type_photoVO>();
				Room_type_photoService rtp = new Room_type_photoService();
				list1 = rtp.getAllPhoto(room_type_id);
				req.setAttribute("list1", list1);
				req.setAttribute("room_typeVO", room_typeVO);
				req.setAttribute("days", days);
				req.setAttribute("select", select);
				// 紀錄入住日期到退房日期的天數
//				LocalDate dBefore = LocalDate.parse(start_date, DateTimeFormatter.ISO_LOCAL_DATE);
//				LocalDate dAfter = LocalDate.parse(end_date, DateTimeFormatter.ISO_LOCAL_DATE);
//				long diff = ChronoUnit.DAYS.between(dBefore, dAfter);

				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/room/BookRoom.jsp");
				failureView.forward(req, res);
				return;
			}
			if (list.size() < roomcount) {
				
				
				Room_TypeVO room_typeVO = rts.getOneRoom_Type(room_type_id);
				Room_type_photoService rtp = new Room_type_photoService();
				req.setAttribute("room_typeVO", room_typeVO);

				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/room/NoRoom.jsp");
				failureView.forward(req, res);
				return;
			}

		}

	}
}
