package m.com.room_order_list.controller;

import java.io.IOException;
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
import m.com.room_order_list.model.Room_Order_ListService;
import m.com.room_order_list.model.Room_order_listVO;


@WebServlet("/RoomOrderListServlet")
public class Room_Order_ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Room_Order_ListServlet() {
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

			Integer room_order_list_id = Integer.valueOf(req.getParameter("room_order_list_id"));

			/*************************** 2.開始查詢資料 ****************************************/

			Room_Order_ListService room_order_listSvc = new Room_Order_ListService();
			Room_order_listVO room_order_listVO = room_order_listSvc.getOneRoom_Order_List(room_order_list_id);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/

			req.setAttribute("room_order_listVO", room_order_listVO);
			String url = "/back_end/room_order_list/update_room_order_list_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_room_order_input.jsp
			successView.forward(req, res);
		}
		
		if ("update".equals(action)) { //from update_room_order_list_input
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer room_order_list_id = Integer.valueOf(req.getParameter("room_order_list_id").trim());
			
			Integer room_order_id = Integer.valueOf(req.getParameter("room_order_id").trim());

			Integer room_type_id = Integer.valueOf(req.getParameter("room_type_id").trim());
			
			Integer room_id = Integer.valueOf(req.getParameter("room_id").trim());
			
			Integer number_of_people = Integer.valueOf(req.getParameter("number_of_people").trim());
			
			Integer room_price = Integer.valueOf(req.getParameter("room_price").trim());
			
			String special_req = req.getParameter("special_req");
			
			Room_order_listVO room_order_listVO = new Room_order_listVO();
			room_order_listVO.setRoom_order_list_id(room_order_list_id);
			room_order_listVO.setRoom_order_id(room_order_id);
			room_order_listVO.setRoom_type_id(room_type_id);
			room_order_listVO.setRoom_id(room_id);
			room_order_listVO.setNumber_of_people(number_of_people);
			room_order_listVO.setRoom_price(room_price);
			room_order_listVO.setSpecial_req(special_req);
			
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("room_order_listVO", room_order_listVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/room_order_list/update_room_order_list_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}
			
			/*************************** 2.開始修改資料 *****************************************/
			
			Room_Order_ListService room_order_listSvc = new Room_Order_ListService();
			room_order_listVO = room_order_listSvc.updateRoom_Order_List(room_order_list_id, room_type_id, room_id, room_order_id, number_of_people, special_req, room_price);
		
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("room_order_listVO", room_order_listVO); // 資料庫update成功後,正確的的room_order_listVO物件,存入req
			String url = "/back_end/room_order_list/listOneRoom_Order_List.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}
}
}
