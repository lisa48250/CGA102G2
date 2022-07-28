package m.com.room_order.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import m.com.room_order.model.Room_OrderService;
import m.com.room_order.model.Room_OrderVO;
import m.com.room_order_list.model.Room_order_listVO;
import m.com.room_type.model.Room_TypeService;
import m.com.room_type.model.Room_TypeVO;

@WebServlet("/Room_OrderServlet")
public class Room_OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Room_OrderServlet() {
		super();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Update".equals(action)) { // from listall
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/

			Integer room_order_id = Integer.valueOf(req.getParameter("room_order_id"));

			/*************************** 2.開始查詢資料 ****************************************/

			Room_OrderService room_orderSvc = new Room_OrderService();
			Room_OrderVO room_orderVO = room_orderSvc.getOneRoom_Order(room_order_id);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/

			req.setAttribute("room_orderVO", room_orderVO);
			String url = "/back_end/room_order/update_room_order_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_room_order_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // from update_room_order_input.jsp
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer room_order_id = Integer.valueOf(req.getParameter("room_order_id").trim());

			Integer member_id = Integer.valueOf(req.getParameter("member_id").trim());

			java.sql.Timestamp order_date =  java.sql.Timestamp.valueOf(req.getParameter("order_date").trim());
			

			Integer room_order_status = Integer.valueOf(req.getParameter("room_order_status").trim());

			Integer room_charge = null;
			try {
				room_charge = Integer.valueOf(req.getParameter("room_charge").trim());
			} catch (NumberFormatException e) {
				room_charge = 0;
				errorMsgs.add("訂單總金額請填數字.");
			}

			Date check_in_date = null;
			try {
				check_in_date = Date.valueOf(req.getParameter("check_in_date").trim());
			} catch (IllegalArgumentException e) {
				check_in_date = new Date(System.currentTimeMillis());
				errorMsgs.add("請輸入入住日期!");
			}

			Date check_out_date = null;
			try {
				check_out_date = Date.valueOf(req.getParameter("check_out_date").trim());
			} catch (IllegalArgumentException e) {
				check_out_date = new Date(System.currentTimeMillis());
				errorMsgs.add("請輸入退房日期!");
			}

			Room_OrderVO room_orderVO = new Room_OrderVO();
			room_orderVO.setRoom_order_id(room_order_id);
			room_orderVO.setMember_id(member_id);
			room_orderVO.setOrder_date(order_date);
			room_orderVO.setRoom_order_status(room_order_status);
			room_orderVO.setRoom_charge(room_charge);
			room_orderVO.setCheck_in_date(check_in_date);
			room_orderVO.setCheck_out_date(check_out_date);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("room_orderVO", room_orderVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("back_end//room_order/update_room_order_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}
			
			/***************************2.開始修改資料*****************************************/
			
			Room_OrderService room_orderSvc = new Room_OrderService();
			room_orderVO = room_orderSvc.updateRoom_Order(room_order_id, member_id, order_date, room_order_status, room_charge, check_in_date, check_out_date);
			
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			
			req.setAttribute("room_orderVO", room_orderVO);
			String url = "back_end/room_order/listOneRoom_Order.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}
		
		if("CHECK IN".equals(action)) { // from listall
			Integer room_order_id = Integer.valueOf(req.getParameter("room_order_id"));
			
			Room_OrderService room_orderSvc = new Room_OrderService();
			Room_OrderVO room_orderVO = room_orderSvc.getOneRoom_Order(room_order_id);
			
			room_orderVO = room_orderSvc.updateStatus(room_orderVO);
			
			req.setAttribute("room_order_id", room_order_id);
			String url = "back_end/room_order/listAllRoom_Order.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		if("CHECK OUT".equals(action)) { // from listall
			Integer room_order_id = Integer.valueOf(req.getParameter("room_order_id"));
			
			Room_OrderService room_orderSvc = new Room_OrderService();
			Room_OrderVO room_orderVO = room_orderSvc.getOneRoom_Order(room_order_id);
			
			room_orderVO = room_orderSvc.updateStatusout(room_orderVO);
			
			req.setAttribute("room_order_id", room_order_id);
			String url = "back_end/room_order/listAllRoom_Order.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		if("CHECK IN2".equals(action)) { // from listall
			Integer room_order_id = Integer.valueOf(req.getParameter("room_order_id"));
			
			Room_OrderService room_orderSvc = new Room_OrderService();
			Room_OrderVO room_orderVO = room_orderSvc.getOneRoom_Order(room_order_id);
			
			room_orderVO = room_orderSvc.updateStatus(room_orderVO);
			
			req.setAttribute("room_order_id", room_order_id);
			String url = "back_end/room_order/listcheckindate.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		if("CHECK OUT2".equals(action)) { // from listall
			Integer room_order_id = Integer.valueOf(req.getParameter("room_order_id"));
			
			Room_OrderService room_orderSvc = new Room_OrderService();
			Room_OrderVO room_orderVO = room_orderSvc.getOneRoom_Order(room_order_id);
			
			room_orderVO = room_orderSvc.updateStatusout(room_orderVO);
			
			req.setAttribute("room_order_id", room_order_id);
			String url = "back_end/room_order/listcheckindate.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		if ("getOne_For_Display".equals(action)) { // from select
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Date check_in_date = Date.valueOf(req.getParameter("check_in_date").trim());
			
			Room_OrderService room_orderSvc = new Room_OrderService();
			List<Room_OrderVO> room_orderVO = room_orderSvc.getCheckin(check_in_date);
			
			req.setAttribute("room_orderVO", room_orderVO);
			req.setAttribute("check_in_date", check_in_date);
			String url = "back_end/room_order/listcheckindate.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
	}
		
		if ("getOne_For_DisplayList".equals(action)) { // from select
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			String str = req.getParameter("room_order_id").trim();
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入訂單編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room_order/select_room_order_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			
			Integer room_order_id = null;
			try{
				room_order_id = Integer.valueOf(str);
			}catch (Exception e) {
				errorMsgs.add("訂單編號格式不正確");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room_order/select_room_order_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			
			
			Room_OrderService room_orderSvc = new Room_OrderService();
			List<Room_order_listVO> room_order_listVO = room_orderSvc.getList(room_order_id);
			System.out.println(room_order_listVO);
			if(room_order_listVO.isEmpty() == true) {
				errorMsgs.add("查無資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room_order/select_room_order_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			
			req.setAttribute("room_order_listVO", room_order_listVO);
			req.setAttribute("room_order_id", room_order_id);
			String url = "back_end/room_order/listcheckinorder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
	}
}
}
