package m.com.room.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import m.com.room.model.RoomService;
import m.com.room.model.RoomVO;
import m.com.room_order_list.model.Room_order_listJDBCDAO;
import m.com.room_order_list.model.Room_order_listVO;
import m.com.room_type.model.Room_TypeService;
import m.com.room_type.model.Room_TypeVO;

@WebServlet("/Roomservlet")
public class Roomservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Roomservlet() {
		super();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("room_id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入房間編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room/select_room_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer room_id = null;
			try {
				room_id = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("房間編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room/select_room_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			RoomService roomSvc = new RoomService();
			RoomVO roomVO = roomSvc.getOneRoom(room_id);
			if (roomVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room/select_room_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("roomVO", roomVO); // 資料庫取出的empVO物件,存入req
			req.setAttribute("room_id", room_id); 
			String url = "/back_end/room/listOneRoom2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}
		
		if ("getOne_For_DisplayRT".equals(action)) { // 來自select_page.jsp 房型的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id"));
			
			/*************************** 2.開始查詢資料 *****************************************/
			RoomService roomSvc = new RoomService();
			List <RoomVO> roomVO = roomSvc.getAllRoomType(room_type_id);
			
			if (room_type_id == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("roomVO", roomVO); // 資料庫取出的empVO物件,存入req
			req.setAttribute("room_type_id", room_type_id); 
			String url = "/back_end/room/listOneRoom.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer room_id = Integer.valueOf(req.getParameter("room_id"));

			/*************************** 2.開始查詢資料 ****************************************/
			RoomService roomSvc = new RoomService();
			RoomVO roomVO = roomSvc.getOneRoom(room_id);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("roomVO", roomVO); // 資料庫取出的empVO物件,存入req
			String url = "/back_end/room/update_room_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer room_id = Integer.valueOf(req.getParameter("room_id").trim());
			
			Integer room_type_id = null;
			try {
				room_type_id = Integer.parseInt(req.getParameter("room_type_id").trim());
			} catch (NumberFormatException e) {
				room_type_id = 0;
				errorMsgs.add("房型編號請勿空白");
			}
				
//			Integer room_type_id = null;
//			try {
//				room_type_id = Integer.valueOf(req.getParameter("room_type_id").trim());
//			} catch (NumberFormatException e) {
//				room_type_id = 0;
//				errorMsgs.add("房型編號請填數字.");
//			}
			
//			＝＝＝＝＝＝＝＝＝＊應結合會員下拉選項＊＝＝＝＝＝＝＝＝＝
			String room_guest_name = req.getParameter("room_guest_name");
			String room_guest_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)(\\s\\d)]{1,45}$";
//			if (room_guest_name == null || room_guest_name.trim().length() == 0) {
//				errorMsgs.add("住客名單: 請勿空白");
//			} else if (!room_guest_name.trim().matches(room_guest_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("住客名單: 只能是中、英文字母、數字和空白格 , 且長度必需在1到45之間");
//			}

			Integer room_sale_status = null;
			try {
				room_sale_status = Integer.parseInt(req.getParameter("room_sale_status").trim());
			} catch (NumberFormatException e) {
				room_sale_status = 0;
				errorMsgs.add("上下架狀態請勿空白");
			}

			Integer room_status = null;
			try {
				room_status = Integer.parseInt(req.getParameter("room_status").trim());
			} catch (NumberFormatException e) {
				room_status = 0;
				errorMsgs.add("房間狀態請勿空白");
			}

			RoomVO roomVO = new RoomVO();
			roomVO.setRoom_id(room_id);
			roomVO.setRoom_type_id(room_type_id);
//			roomVO.setRoom_guest_name(room_guest_name);
			roomVO.setRoom_sale_status(room_sale_status);
			roomVO.setRoom_status(room_status);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("roomVO", roomVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room/update_room_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}
			/*************************** 2.開始修改資料 *****************************************/
			RoomService roomSvc = new RoomService();
			roomVO = roomSvc.updateRoom(room_id, room_type_id, room_guest_name, room_sale_status, room_status);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("roomVO", roomVO); // 資料庫update成功後,正確的的empVO物件,存入req
			req.setAttribute("room_id", room_id); 
			String url = "/back_end/room/listOneRoom2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}
		
		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer room_type_id = null;
			try {
				room_type_id = Integer.parseInt(req.getParameter("room_type_id").trim());
			} catch (NumberFormatException e) {
				room_type_id = 0;
				errorMsgs.add("房型編號請勿空白");
			}
				
//			Integer room_type_id = null;
//			try {
//				room_type_id = Integer.valueOf(req.getParameter("room_type_id").trim());
//			} catch (NumberFormatException e) {
//				room_type_id = 0;
//				errorMsgs.add("房型編號請填數字.");
//			}

//			＝＝＝＝＝＝＝＝＝＊應結合會員下拉選項＊＝＝＝＝＝＝＝＝＝
			String room_guest_name = req.getParameter("room_guest_name");
			String room_guest_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)(\\s\\d)]{1,45}$";
//			if (room_guest_name == null || room_guest_name.trim().length() == 0) {
//				errorMsgs.add("住客名單: 請勿空白");
//			} else if (!room_guest_name.trim().matches(room_guest_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("住客名單: 只能是中、英文字母、數字和空白格 , 且長度必需在1到45之間");
//			}

			Integer room_sale_status = null;
			try {
				room_sale_status = Integer.parseInt(req.getParameter("room_sale_status").trim());
			} catch (NumberFormatException e) {
				room_sale_status = 0;
				errorMsgs.add("上下架狀態請勿空白");
			}

			Integer room_status = null;
			try {
				room_status = Integer.parseInt(req.getParameter("room_status").trim());
			} catch (NumberFormatException e) {
				room_status = 0;
				errorMsgs.add("房間狀態請勿空白");
			}

			RoomVO roomVO = new RoomVO();
			roomVO.setRoom_type_id(room_type_id);
//			roomVO.setRoom_guest_name(room_guest_name);
			roomVO.setRoom_sale_status(room_sale_status);
			roomVO.setRoom_status(room_status);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("roomVO", roomVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room/addRoom.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}
			
			/*************************** 2.開始新增資料 ***************************************/
			RoomService roomSvc = new RoomService();
			roomVO = roomSvc.addRoom(room_type_id, room_guest_name, room_sale_status, room_status);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/room/listAllRoom.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/*************************** 1.接收請求參數 ***************************************/
			Integer room_id = Integer.valueOf(req.getParameter("room_id"));
			
			/*************************** 2.開始刪除資料 ***************************************/
			RoomService roomSvc = new RoomService();
			roomSvc.deleteRoom(room_id);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/room/listAllRoom.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}

}
