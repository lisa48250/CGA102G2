package m.com.room_type_photo.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import m.com.room.model.RoomService;
import m.com.room.model.RoomVO;
import m.com.room_type_photo.model.Room_type_photoService;
import m.com.room_type_photo.model.Room_type_photoVO;

/**
 * Servlet implementation class Room_Type_PhotoServlet
 */
@WebServlet("/Room_Type_PhotoServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class Room_Type_PhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Room_Type_PhotoServlet() {
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
			String str = req.getParameter("room_type_photo_id");
			System.out.print("str=" + str);
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入照片編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/room_type_photo/select_room_type_photo_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			
			Integer	room_type_photo_id =null;
			try {
//				str = req.getParameter("room_type_photo_id");
					room_type_photo_id = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("照片編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/room_type_photo/select_room_type_photo_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			Room_type_photoService room_type_photoSvc = new Room_type_photoService();
			Room_type_photoVO room_type_photoVO = room_type_photoSvc.getOneRoom_Type_Photo(room_type_photo_id);
			if (room_type_photoVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/room_type_photo/select_room_type_photo_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
//			Integer id = Integer.valueOf(req.getParameter("room_type_id").trim());
//			System.out.println("id");
			req.setAttribute("room_type_id", str);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("room_type_photoVO", room_type_photoVO); // 資料庫取出的empVO物件,存入req
			String url = "/back_end/room_type_photo/listOneRoom_Type_Photo.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}
		
		if ("getOne_For_DisplayPH".equals(action)) { // 來自select_page.jsp 房型的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id"));
			
			/************e*************** 2.開始查詢資料 *****************************************/
			Room_type_photoService roomPHSvc = new Room_type_photoService();
			List <Room_type_photoVO> room_type_photoVO = roomPHSvc.getAllType(room_type_id);
			
			if (room_type_id == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/room_type_photo/listOneRoom_Type_Photo.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("room_type_photoVO", room_type_photoVO); // 資料庫取出的empVO物件,存入req
			req.setAttribute("room_type_id", room_type_id); 
			String url = "/back_end/room_type_photo/listOneRoom_Type_Photo.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer room_type_photo_id = Integer.valueOf(req.getParameter("room_type_photo_id"));

			/*************************** 2.開始查詢資料 ****************************************/
			Room_type_photoService room_type_photoSvc = new Room_type_photoService();
			Room_type_photoVO room_type_photoVO = room_type_photoSvc.getOneRoom_Type_Photo(room_type_photo_id);
			
			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			
			
			req.setAttribute("room_type_photoVO", room_type_photoVO); // 資料庫取出的empVO物件,存入req
			String url = "/back_end/room_type_photo/update_room_type_photo_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer room_type_photo_id = Integer.valueOf(req.getParameter("room_type_photo_id").trim());

			Integer room_type_id = null;
			try {
				room_type_id = Integer.valueOf(req.getParameter("room_type_id").trim());
			} catch (NumberFormatException e) {
				room_type_id = 0;
				errorMsgs.add("房型編號請填數字.");
			}

			InputStream is = req.getPart("room_type_photo").getInputStream(); 
			BufferedInputStream bis = new BufferedInputStream(is);
			byte[] bytes = new byte[bis.available()];
			bis.read(bytes);
			Blob room_type_photo = null;
			try {
				room_type_photo = new SerialBlob(bytes);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Room_type_photoVO room_type_photoVO = new Room_type_photoVO();
			room_type_photoVO.setRoom_type_photo_id(room_type_photo_id);
			room_type_photoVO.setRoom_type_id(room_type_id);
			room_type_photoVO.setRoom_type_photo(room_type_photo);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("room_type_photoVO", room_type_photoVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/room_type_photo/update_room_type_photo_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}
			
			/*************************** 2.開始修改資料 *****************************************/
			Room_type_photoService room_type_photoSvc = new Room_type_photoService();
			room_type_photoVO = room_type_photoSvc.updateRoom_Type_Photo(room_type_photo_id, room_type_id,
					room_type_photo);
			
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			
			req.setAttribute("room_type_photoVO", room_type_photoVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back_end/room_type_photo/listonephoto.jsp";
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
				room_type_id = Integer.valueOf(req.getParameter("room_type_id").trim());
			} catch (NumberFormatException e) {
				room_type_id = 0;
				errorMsgs.add("房型編號請填數字.");
			}

			InputStream is = req.getPart("room_type_photo").getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			byte[] bytes = new byte[bis.available()];
			bis.read(bytes);
			Blob room_type_photo = null;
			try {
				room_type_photo = new SerialBlob(bytes);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Room_type_photoVO room_type_photoVO = new Room_type_photoVO();
			room_type_photoVO.setRoom_type_id(room_type_id);
			room_type_photoVO.setRoom_type_photo(room_type_photo);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("room_type_photoVO", room_type_photoVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/room_type_photo/addRoom_Type_Photo.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			Room_type_photoService room_type_photoSvc = new Room_type_photoService();
			room_type_photoVO = room_type_photoSvc.addRoom_Type_Photo(room_type_id, room_type_photo);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			String url = "/back_end/room_type_photo/listAllRoom_Type_Photo.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer room_type_photo_id = Integer.valueOf(req.getParameter("room_type_photo_id"));
			/*************************** 2.開始刪除資料 ***************************************/
			Room_type_photoService room_type_photoSvc = new Room_type_photoService();
			room_type_photoSvc.deleteRoom_Type_Photo(room_type_photo_id);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/room_type_photo/listAllRoom_Type_Photo.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}

	}
}
