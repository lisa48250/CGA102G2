package h.com.room_order.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import h.com.room.model.Room_Service;
import h.com.room_order.model.Room_OrderService;
import h.com.room_order.model.Room_orderVO;
import h.com.room_order_list.model.Room_order_listVO;
import h.com.room_schedule.model.Room_ScheduleService;
import h.com.room_type.model.Room_TypeService;
import h.com.room_type.model.Room_TypeVO;
import h.com.room_type_photo.model.Room_type_photoService;
import h.com.room_type_photo.model.Room_type_photoVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertRoomOrder")
public class RoomOrderServlet extends HttpServlet {
	public RoomOrderServlet() {
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
		if ("insert".equals(action)) {
			List<String> errormsg = new ArrayList<String>();
			req.setAttribute("errormsg", errormsg);
			// 會員編號欄位
			Integer member = null;
			String mem = null;
			 mem = req.getParameter("member");
			if (mem.trim().length() == 0 || mem == null ) {
				errormsg.add("請輸入會員編號");
			}else {
				member = Integer.parseInt(mem);
			}

			// 會員名稱欄位
			String name = null;
			name = req.getParameter("name");
			if (name == null || name.length() == 0) {
				errormsg.add("請輸入會員名稱");
			}
			// mail
			String mail = null;
			mail = req.getParameter("mail");
			if (name == null || name.length() == 0) {
				errormsg.add("請輸入電子信箱");
			}
			// 手機
			String ph =null;
			Integer phone = null;
			 ph = req.getParameter("phone").trim();		
			if (ph.length() == 0 || ph == null) {
				errormsg.add("手機號碼");
			}else {
				phone = Integer.parseInt(ph);
			}
			
			// 入住時間
			java.sql.Date checkin = null;
			try {
				checkin = java.sql.Date.valueOf(req.getParameter("checkin").trim());
			} catch (IllegalArgumentException e) {
				checkin = new java.sql.Date(System.currentTimeMillis());
				errormsg.add("請輸入入住日期");

			}
			// 退房時間
			java.sql.Date checkout = null;
			try {
				checkout = java.sql.Date.valueOf(req.getParameter("checkout").trim());
			} catch (IllegalArgumentException e) {
				checkout = new java.sql.Date(System.currentTimeMillis());
				errormsg.add("請輸入退房日期");

			}
			// 人數
			Integer pcount = null;
			pcount = Integer.parseInt(req.getParameter("pcount").trim());
			if (pcount == null) {
				errormsg.add("請選擇入住人數");
			}
			// 房間數量
			Integer rcount = null;
			rcount = Integer.parseInt(req.getParameter("rcount").trim());
			if (rcount == null) {
				errormsg.add("請選擇房間數量");
			}
			
			Integer room_type_id =null;
			String room_type_id1 = null;
			room_type_id1 = req.getParameter("room_type_id").trim();
			if(room_type_id1 == null || room_type_id1.length() == 0) {
				errormsg.add("抓不到房型編號");
			}else {
				room_type_id = Integer.valueOf(room_type_id1);
			}
			// 特殊要求 可以為空
			String content = null;
			content = req.getParameter("content").trim();

			if (!errormsg.isEmpty()) {
				// 還未帶入會員資料跳轉有誤
				System.out.println(errormsg);			
				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/room/BookRoom.jsp");
				failureView.forward(req, res);
				return;

			} else {
				List<Integer> list = new ArrayList<Integer>();
				List<Room_order_listVO> roomorder = new ArrayList<Room_order_listVO>();
				Room_Service rm = new Room_Service();
				Room_ScheduleService rss = new Room_ScheduleService();

				Room_TypeService rts = new Room_TypeService();
				Integer roomamount = rts.getOneRoom_Type(room_type_id).getRoom_type_amount();
				Integer roomidamount;
				Integer roomid;
				int count = 0;
				for (int i = 0; i < roomamount; i++) {
					//取得每個房間編號
					roomid = rm.getAllRoomId(room_type_id).get(i).getRoom_id();
					list.add(roomid);
					// 房間編號在預定表有幾筆
					roomidamount = rss.getAllRoomidDate(roomid).size();
					//判斷符合日期條件的房間編號
					for (int j = 0; j < roomidamount; j++) {

						while(rss.getAllRoomidDate(roomid).get(j).getCheck_in_date()== null && rss.getAllRoomidDate(roomid).get(j).getCheck_out_date()== null) {
							break;
						}

						while (rss.getAllRoomidDate(roomid).get(j).getCheck_in_date().equals(checkin)
								&& rss.getAllRoomidDate(roomid).get(j).getCheck_out_date().equals(checkout)) {
							list.remove(roomid);
							break;
						}
						while (rss.getAllRoomidDate(roomid).get(j).getCheck_in_date().getTime() < checkin.getTime() &&
								checkin.getTime() < rss.getAllRoomidDate(roomid).get(j).getCheck_out_date()
										.getTime()) {
							list.remove(roomid);
							break;
						}
						while (rss.getAllRoomidDate(roomid).get(j).getCheck_in_date().getTime() < checkout.getTime() &&
								checkout.getTime() < rss.getAllRoomidDate(roomid).get(j).getCheck_out_date()
										.getTime()) {
							list.remove(roomid);
							break;
						}
					}
				}
				//住宿天數
				long diff = checkout.getTime() - checkin.getTime();
				int days = (int) (diff / (1000 * 60 * 60 * 24));
				
				
				// get房型價格
				Room_TypeService rt = new Room_TypeService();
				Integer price = rt.getOneRoom_Type(room_type_id).getRoom_type_price();

				// 取得訂單產生當下時間
				Long date = System.currentTimeMillis();
				Timestamp timestamp = new Timestamp(date);

				// 新增訂單
				Room_OrderService dao = new Room_OrderService();
				Room_orderVO rovo = new Room_orderVO();

				rovo.setMember_id(member);
				rovo.setOrder_date(timestamp);
				rovo.setRoom_order_status(2);
				rovo.setRoom_charge(price*rcount*days);
				rovo.setCheck_in_date(checkin);
				rovo.setCheck_out_date(checkout);

				
				Integer id =null;
				// 從符合條件的房間編號從list取出而最大數根據客人選擇的房間數量
				for (int z = 0; z < rcount; z++) {
					Room_order_listVO rolv = new Room_order_listVO();
					// get房間編號
					 id = list.get(z);
				
					rolv.setRoom_type_id(room_type_id);
					rolv.setNumber_of_people(pcount);
					rolv.setSpecial_req(content);
					rolv.setRoom_id(id);
					rolv.setNumber_of_people(pcount);
					rolv.setSpecial_req(content);
					rolv.setRoom_price(price);
					
					roomorder.add(rolv);

					rss.insertRoomTypeSchedule(1, id, checkin, checkout);
				}
				
				dao.insertWithRoom_order_list(rovo, roomorder);
				
				
				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/room/OrderSuccess.jsp");
				failureView.forward(req, res);
				return;
			}
		}
	}
}
