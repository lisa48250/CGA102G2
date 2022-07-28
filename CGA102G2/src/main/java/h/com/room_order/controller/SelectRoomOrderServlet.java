package h.com.room_order.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import h.com.room_order.model.Room_OrderService;
import h.com.room_order.model.Room_orderVO;
import h.com.room_order_list.model.Room_Order_ListService;
import h.com.room_order_list.model.Room_order_listVO;

/**
 * Servlet implementation class SelectRoomOrderServlet
 */
@WebServlet("/SelectRoomOrderServlet")
public class SelectRoomOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectRoomOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("UTF-8");
		Room_OrderService ros = new Room_OrderService();
		//存訂單狀態為0的明細
		List<Room_order_listVO> roomorderlist0 = new ArrayList<Room_order_listVO>();
		//存訂單狀態為1的明細
		List<Room_order_listVO> roomorderlist1 = new ArrayList<Room_order_listVO>();
		//存訂單狀態為2的明細
		List<Room_order_listVO> roomorderlist2 = new ArrayList<Room_order_listVO>();
		
		for(int i = 0; i<ros.getAll0(0, 1).size(); i++) {
			Room_Order_ListService rol = new Room_Order_ListService();
			roomorderlist0=(rol.getAllDetail(ros.getAll0(0, 1).get(i).getRoom_order_id()));
	
		}
		
		for(int j = 0; j<ros.getAll1(1, 1).size(); j++) {
			Room_Order_ListService rol = new Room_Order_ListService();
			roomorderlist1=(rol.getAllDetail(ros.getAll1(1, 1).get(j).getRoom_order_id()));
		
		}
		
		for(int k = 0; k<ros.getAll2(2, 1).size(); k++) {
			Room_Order_ListService rol = new Room_Order_ListService();
			roomorderlist2=(rol.getAllDetail(ros.getAll2(2, 1).get(k).getRoom_order_id()));
		}
		
		
		req.setAttribute("roomorderlist0", roomorderlist0);
		req.setAttribute("roomorderlist1", roomorderlist1);
		req.setAttribute("roomorderlist2", roomorderlist2);

		req.getRequestDispatcher("/front_end/memberselect/selcetroomorder.jsp").forward(req, res);
	
	}

}
