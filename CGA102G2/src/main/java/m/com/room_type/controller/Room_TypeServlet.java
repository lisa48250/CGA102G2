package m.com.room_type.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Provider.Service;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import h.com.room_type_photo.model.Room_type_photoService;
import h.com.room_type_photo.model.Room_type_photoVO;
import m.com.room_type.model.Room_TypeService;
import m.com.room_type.model.Room_TypeVO;

@WebServlet("/room_type.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class Room_TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Room_TypeServlet() {
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
			String str = req.getParameter("room_type_id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入房型編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room_type/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer room_type_id = null;
			try {
				room_type_id = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("房型編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room_type/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			Room_TypeService room_typeSvc = new Room_TypeService();
			Room_TypeVO room_typeVO = room_typeSvc.getOneRoom_Type(room_type_id);
			if (room_typeVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room_type/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("room_typeVO", room_typeVO); // 資料庫取出的empVO物件,存入req
			String url = "/back_end/room_type/listOneRoom_Type.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id"));

			/*************************** 2.開始查詢資料 ****************************************/
			Room_TypeService room_typeSvc = new Room_TypeService();
			Room_TypeVO room_typeVO = room_typeSvc.getOneRoom_Type(room_type_id);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("room_typeVO", room_typeVO); // 資料庫取出的empVO物件,存入req
			String url = "/back_end/room_type/update_room_type_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id").trim());

			String room_type_name = req.getParameter("room_type_name");
			String room_type_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,20}$";
			if (room_type_name == null || room_type_name.trim().length() == 0) {
				errorMsgs.add("房型名稱: 請勿空白");
			} else if (!room_type_name.trim().matches(room_type_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("房型名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到20之間");
			}

			Integer room_type_amount = null;
			try {
				room_type_amount = Integer.valueOf(req.getParameter("room_type_amount").trim());
			} catch (NumberFormatException e) {
				room_type_amount = 0;
				errorMsgs.add("房型數量請填數字.");
			}

			String room_type_content = req.getParameter("room_type_content").trim();
			if (room_type_content == null || room_type_content.trim().length() == 0) {
				errorMsgs.add("房型說明請勿空白");
			}

			Integer room_type_sale_status = null;
			try {
				room_type_sale_status = Integer.parseInt(req.getParameter("room_type_sale_status").trim());
			} catch (NumberFormatException e) {
				room_type_sale_status = 0;
				errorMsgs.add("上下架狀態請勿空白");
			}

			String room_total_review = req.getParameter("room_total_review").trim();

//				<input type="file" name="xxx">
			InputStream is = req.getPart("room_type_pic").getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			byte[] bytes = new byte[bis.available()];
			bis.read(bytes);
			Blob room_type_pic = null;
			try {
				room_type_pic = new SerialBlob(bytes);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Integer room_type_price = null;
			try {
				room_type_price = Integer.valueOf(req.getParameter("room_type_price").trim());
			} catch (NumberFormatException e) {
				room_type_price = 0;
				errorMsgs.add("房型價格請填數字");
			}

			Room_TypeVO room_typeVO = new Room_TypeVO();
			room_typeVO.setRoom_type_id(room_type_id);
			room_typeVO.setRoom_type_name(room_type_name);
			room_typeVO.setRoom_type_amount(room_type_amount);
			room_typeVO.setRoom_type_content(room_type_content);
			room_typeVO.setRoom_type_sale_status(room_type_sale_status);
			room_typeVO.setRoom_total_review(room_total_review);
			room_typeVO.setRoom_type_pic(room_type_pic);
			room_typeVO.setRoom_type_price(room_type_price);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("room_typeVO", room_typeVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/room_type/update_room_type_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}
			/*************************** 2.開始修改資料 *****************************************/
			Room_TypeService room_typeSvc = new Room_TypeService();
			room_typeVO = room_typeSvc.updateRoom_Type(room_type_id, room_type_name, room_type_amount,
					room_type_content, room_type_sale_status, room_total_review, room_type_pic, room_type_price);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("room_typeVO", room_typeVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back_end/room_type/listOneRoom_Type.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String room_type_name = req.getParameter("room_type_name");
			String room_type_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,20}$";
			if (room_type_name == null || room_type_name.trim().length() == 0) {
				errorMsgs.add("房型名稱: 請勿空白");
			} else if (!room_type_name.trim().matches(room_type_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("房型名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到20之間");
			}

			Integer room_type_amount = null;
			try {
				room_type_amount = Integer.valueOf(req.getParameter("room_type_amount").trim());
			} catch (NumberFormatException e) {
				room_type_amount = 0;
				errorMsgs.add("房型數量請填數字.");
			}

			String room_type_content = req.getParameter("room_type_content").trim();
			if (room_type_content == null || room_type_content.trim().length() == 0) {
				errorMsgs.add("房型說明請勿空白");
			}

			Integer room_type_sale_status = null;
			try {
				room_type_sale_status = Integer.valueOf(req.getParameter("room_type_sale_status").trim());
			} catch (NumberFormatException e) {
				room_type_sale_status = 0;
				errorMsgs.add("上下架狀態請勿空白");
			}

			String room_total_review = req.getParameter("room_total_review").trim();

//				<input type="file" name="xxx">

			InputStream is = req.getPart("room_type_pic").getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			byte[] bytes = new byte[bis.available()];
			bis.read(bytes);
			Blob room_type_pic = null;
			try {
				room_type_pic = new SerialBlob(bytes);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Integer room_type_price = null;
			try {
				room_type_price = Integer.valueOf(req.getParameter("room_type_price").trim());
			} catch (NumberFormatException e) {
				room_type_price = 0;
				errorMsgs.add("房型價格請填數字");
			}

			Room_TypeVO room_typeVO = new Room_TypeVO();
			room_typeVO.setRoom_type_name(room_type_name);
			room_typeVO.setRoom_type_amount(room_type_amount);
			room_typeVO.setRoom_type_content(room_type_content);
			room_typeVO.setRoom_type_sale_status(room_type_sale_status);
			room_typeVO.setRoom_total_review(room_total_review);
			room_typeVO.setRoom_type_pic(room_type_pic);
			room_typeVO.setRoom_type_price(room_type_price);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("room_typeVO", room_typeVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room_type/addRoom_Type.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			Room_TypeService room_typeSvc = new Room_TypeService();
			room_typeVO = room_typeSvc.addRoom_Type(room_type_name, room_type_amount, room_type_content,
					room_type_sale_status, room_total_review, room_type_pic, room_type_price);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/room_type/listAllRoom_Type.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id"));
//			Room_order_listJDBCDAO r = new Room_order_listJDBCDAO();
//			List<Room_order_listVO> roomOrderList  = r.getAll();
//			try {
//			for(Room_order_listVO roomOrder : roomOrderList) {
//				if(room_type_id == roomOrder.getRoom_type_id()) {
//					errorMsgs.add("不可刪除");
//				}
//			}
//			}catch(RuntimeException e ) {
//				errorMsgs.add("不可刪除");
//			}
//			if(r.findByPrimaryKey(room_type_id) == room_type_id) {
//			};

			/*************************** 2.開始刪除資料 ***************************************/
			Room_TypeService room_typeSvc = new Room_TypeService();
			room_typeSvc.deleteRoom_Type(room_type_id);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/room_type/listAllRoom_Type.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}

//		==============給more的按鈕====================

		if ("More".equals(req.getParameter("action"))) {
			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id"));
			Room_TypeService room_typeSvc = new Room_TypeService();
			Room_TypeVO room_typeVO = room_typeSvc.getOneRoom_Type(room_type_id);

			req.setAttribute("room_typeVO", room_typeVO);
			req.setAttribute("room_type_id", room_type_id);

			String url = "/front_end/room_type/room_type_content5.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);

		}

//		if ("More".equals(req.getParameter("action2"))) {
//			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id2"));
//			Room_TypeService room_typeSvc = new Room_TypeService();
//			Room_TypeVO room_typeVO = room_typeSvc.getOneRoom_Type(room_type_id);
//
//			req.setAttribute("roomtypeVO", room_typeVO);
//			req.setAttribute("room_type_id2", room_type_id);
//			String url = "/front_end/room_type/room_type_content2.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//			successView.forward(req, res);
//		}
//
//		if ("More".equals(req.getParameter("action3"))) {
//			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id3"));
//			Room_TypeService room_typeSvc = new Room_TypeService();
//			Room_TypeVO room_typeVO = room_typeSvc.getOneRoom_Type(room_type_id);
//			req.setAttribute("roomtypeVO", room_typeVO);
//			req.setAttribute("room_type_id3", room_type_id);
//			String url = "/front_end/room_type/room_type_content3.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//			successView.forward(req, res);
//		}
//
//		if ("More".equals(req.getParameter("action4"))) {
//			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id4"));
//			Room_TypeService room_typeSvc = new Room_TypeService();
//			Room_TypeVO room_typeVO = room_typeSvc.getOneRoom_Type(room_type_id);
//
//			req.setAttribute("roomtypeVO", room_typeVO);
//			req.setAttribute("room_type_id4", room_type_id);
//			String url = "/front_end/room_type/room_type_content4.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//			successView.forward(req, res);
//		}

//		==============給立即訂房的按鈕====================
		if ("立即訂房".equals(req.getParameter("action1"))) {

			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id1"));
			Room_TypeService room_typeSvc = new Room_TypeService();
			Room_TypeVO room_typeVO = room_typeSvc.getOneRoom_Type(room_type_id);

			Room_type_photoService rtp = new Room_type_photoService();
			List<Room_type_photoVO> list1 = new ArrayList<Room_type_photoVO>();
			list1 = rtp.getAllPhoto(room_type_id);

			HttpSession session = req.getSession();

			session.setAttribute("list1", list1);
			session.setAttribute("room_typeVO", room_typeVO);

			String url = "/front_end/room/SearchRoom.jsp"; // 放冠霖要連的
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}

//		if ("立即訂房".equals(req.getParameter("action2"))) {
//
//			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id2"));
//			Room_TypeService room_typeSvc = new Room_TypeService();
//			Room_TypeVO room_typeVO = room_typeSvc.getOneRoom_Type(room_type_id);
//
//			Room_type_photoService rtp = new Room_type_photoService();
//			List<Room_type_photoVO> list1 = new ArrayList<Room_type_photoVO>();
//			list1 = rtp.getAllPhoto(room_type_id);
//
//			HttpSession session = req.getSession();
//
//			session.setAttribute("list1", list1);
//			session.setAttribute("room_typeVO", room_typeVO);
//
//			String url = "/front_end/room/SearchRoom.jsp"; // 放冠霖要連的
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//			successView.forward(req, res);
//		}
//
//		if ("立即訂房".equals(req.getParameter("action3"))) {
//
//			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id3"));
//			Room_TypeService room_typeSvc = new Room_TypeService();
//			Room_TypeVO room_typeVO = room_typeSvc.getOneRoom_Type(room_type_id);
//
//			Room_type_photoService rtp = new Room_type_photoService();
//			List<Room_type_photoVO> list1 = new ArrayList<Room_type_photoVO>();
//			list1 = rtp.getAllPhoto(room_type_id);
//			HttpSession session = req.getSession();
//
//			session.setAttribute("list1", list1);
//			session.setAttribute("room_typeVO", room_typeVO);
//
//			String url = "/front_end/room/SearchRoom.jsp"; // 放冠霖要連的
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//			successView.forward(req, res);
//		}
//
//		if ("立即訂房".equals(req.getParameter("action4"))) {
//
//			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id4"));
//			Room_TypeService room_typeSvc = new Room_TypeService();
//			Room_TypeVO room_typeVO = room_typeSvc.getOneRoom_Type(room_type_id);
//
//			Room_type_photoService rtp = new Room_type_photoService();
//			List<Room_type_photoVO> list1 = new ArrayList<Room_type_photoVO>();
//			list1 = rtp.getAllPhoto(room_type_id);
//			HttpSession session = req.getSession();
//
//			session.setAttribute("list1", list1);
//			session.setAttribute("room_typeVO", room_typeVO);
//
//			String url = "/front_end/room/SearchRoom.jsp"; // 放冠霖要連的
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//			successView.forward(req, res);
//		}

	}

}
