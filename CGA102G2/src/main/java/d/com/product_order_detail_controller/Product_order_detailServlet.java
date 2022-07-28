package d.com.product_order_detail_controller;

import com.members.model.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.sql.Blob;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import d.com.product.model.ProdVO;
import d.com.product.model.Product_Service;
import d.com.product.model.Product_VO;
import d.com.product_order_detail.model.*;
import d.com.product_order_list.model.PolService;
import d.com.product_order_list.model.PolVO;

@WebServlet("/Product_order_detailServlet")
public class Product_order_detailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

//	public Blob uploadPicFromDB(Part uploadPic) {
//		return null;
//	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		HttpSession session;

		String action = req.getParameter("action");

		if ("getOne_Product_Detail".equals(action)) { // from select_page.jsp
			List<String> errorMsg = new LinkedList<String>();
			// 確保前台輸入錯誤，儲存錯誤提示於request scope及List中並顯示至前台頁面
			req.setAttribute("errorMsg", errorMsg);

			// 取的input text的name參數，並檢視其輸入是否為空值或無填寫
			String str = req.getParameter("product_id");
			if (str == null || str.trim().length() == 0) {
				errorMsg.add("請輸入正確訂單編號"); // true時儲存一個錯誤提示至list中
			}

			// 若errorMsg並非無值時，代表有錯誤發生需有提示
//			，故將其頁面forward至select_page.jsp，並顯示提示
			if (!errorMsg.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/product_order_detail/homepage.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			// 檢查是否輸入格式為數字，而非其他字元符號
			Integer product_id = null;
			try {
				product_id = Integer.parseInt(str);
			} catch (Exception e) {
				errorMsg.add("訂單編號格式不正確");

			}

			// 若errorMsg並非無值時，代表有錯誤發生需有提示
//			，故將其頁面forward至select_page.jsp，並顯示提示
			if (!errorMsg.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/product_order_detail/homepage.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			// 以上審查無錯誤，開始查詢資料...

//			呼叫工地主任
			Product_order_detailService posvc = new Product_order_detailService();
//			呼叫他的工人開始查詢
			Product_order_detailVO poVO = posvc.getOneOrderDetail(product_id);
			if (poVO.getProduct_order_id() == null) {
				errorMsg.add("查無資料");

			}

			if (!errorMsg.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/product_order_detail/homepage.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

//			查詢成功，工作完成，轉交至另一隻jsp，並view出
			req.setAttribute("poVO", poVO); // 資料庫取出的poVO物件,存入req
			String url = "/back_end/product_order_detail/listOneProduct_order_detail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);

		}

//		==================================圖片==============================
		if ("upload".equals(action)) {

			String theURL = "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei";
			ServletOutputStream out = res.getOutputStream();

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(theURL, "root", "00000000");
				Statement stmt = con.createStatement();
				String test = req.getParameter("test");
				ResultSet rs = stmt.executeQuery("SELECT PIC FROM club WHERE ID = " + test);
				if (rs.next()) {
					BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("pic"));
					// or InputSream in = rs.getBinaryStream("image");
//						InputStream in = new BufferedInputStream(rs.getBinaryStream("image")); 

					byte[] buf = new byte[in.available()]; // 4K buffer

//						while ((len = in.read(buf)) != -1) {
//							out.write(buf, 0, len);
//						}
					in.read(buf);
					out.write(buf);

					in.close();
					out.close();
				} else {
					res.sendError(HttpServletResponse.SC_NOT_FOUND);
//					InputStream in = getServletContext().getResourceAsStream("/NoData/404.png");
//					byte[] b = new byte[in.available()];
//					in.read(b);
//					out.write(b);
//					in.close();

				}
				rs.close();
				stmt.close();
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

//			==========針對以會員編號做查詢訂單===========
		if ("getOne_Product_DetailbyMember".equals(action)) {
			List<String> errorMsg = new LinkedList<String>();
			req.setAttribute("errorMsg", errorMsg);
			Integer memberId = Integer.parseInt(req.getParameter("memId"));
			Product_order_detailService posvc = new Product_order_detailService();
//			呼叫他的工人開始查詢
			List<Product_order_detailVO> orderList = posvc.getOrderListByMemberId(memberId);
			if(orderList.isEmpty()) {
				errorMsg.add("查無資料");
			}
			
			if(!errorMsg.isEmpty()) {
				String url = "/back_end/product_order_detail/homepage.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
				return;
			}
			
			req.setAttribute("orderList", orderList);
			String url = "/back_end/product_order_detail/listProduct_order_detailbyMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);

		}

//		==========針對以會員編號做刪除訂單===========
		if ("delete_member_order".equals(action)) {
			Integer memberId =  Integer.valueOf(req.getParameter("memberId"));
			Integer productId = Integer.valueOf(req.getParameter("product_order_id"));
			Product_order_detailService posvc = new Product_order_detailService();
			PolService psvc = new PolService();
			List<Product_order_detailVO> orderList = posvc.getOrderListByMemberId(memberId);
			posvc.delete(productId);

			req.setAttribute("orderList", orderList);
			String url = "/back_end/product_order_detail/listProduct_order_detailbyMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);

		}

		// ==============新增資料============
		if ("insert".equals(action)) {

			List<String> errorMsg = new LinkedList<String>();
			req.setAttribute("errorMsg", errorMsg);

			// 針對會員編號輸入格式

			Integer memberId = null;
			try {
				memberId = Integer.valueOf(req.getParameter("memberId").trim());
				MembersJDBCDAO members = new MembersJDBCDAO();
				if (members.findByPrimaryKey(memberId) == null) {
					errorMsg.add("查無此會員資料");
				} // 這裡是join
			} catch (NumberFormatException e) {
				memberId = 0;
				errorMsg.add("請填寫會員編號並為數字");
			}

			// 針對購買商品數量
			Integer productNums = null;
			try {
				productNums = Integer.valueOf(req.getParameter("productNums").trim());
				if (productNums == 0) {
					errorMsg.add("請填寫商品數量不可為零");
				}
			} catch (NumberFormatException e) {
				productNums = 0;
				errorMsg.add("請填寫商品數量並為數字");
			}

			// 針對付款方式 + 付款狀態
//			Integer productOrderId = Integer.parseInt(req.getParameter("product_order_id").trim());
//			java.sql.Date orderDate = java.sql.Date.valueOf(req.getParameter("orderDate").trim());
			Integer paymentMethod = Integer.parseInt(req.getParameter("paymentMethod").trim());
			Integer orderStatus = Integer.parseInt(req.getParameter("orderStatus").trim());
			Integer productId = Integer.parseInt(req.getParameter("productId").trim());
			// 開始新增資料
			Product_order_detailVO poVO = new Product_order_detailVO();

			poVO.setProduct_id(productId);
			poVO.setMember_id(memberId);
			poVO.setProduct_amount(productNums);
			poVO.setPayment_method(paymentMethod);
			poVO.setOrder_status(orderStatus);

			if (!errorMsg.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/product_order_detail/addProduct_order.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			Product_order_detailService posvc = new Product_order_detailService();
			posvc.addProductOrderDetail(productId, memberId, productNums, paymentMethod, orderStatus);
			// 新增完畢顯示資料
			req.setAttribute("poVO", poVO);
			String url = "/back_end/product_order_detail/homepage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);

		}
//				===============修改資料================
		if ("getOne_For_Update".equals(action)) {
			List<String> errorMsg = new LinkedList<String>();
			req.setAttribute("errorMsg", errorMsg);

			// 取的當前欲修改的那筆訂單資料
			Integer productOderId = Integer.parseInt(req.getParameter("product_order_id").trim());
			System.out.println(productOderId);
			Product_order_detailVO poVo = new Product_order_detailVO();
			Product_order_detailService posvc = new Product_order_detailService();
			poVo = posvc.getOneOrderDetail(productOderId);
			System.out.println(poVo.getOrder_status());
			req.setAttribute("poVo", poVo);
			// 將該筆資料轉交至update_product_order.jsp
			String url = "/back_end/product_order_detail/update_product_order.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);

		}
//			===================修改判斷========================
		if ("update".equals(action)) {

			List<String> errorMsg = new LinkedList<String>();
			req.setAttribute("errorMsg", errorMsg);

			// 判斷產品數量是否輸入正確
			Integer productNums = null;
			try {
				productNums = Integer.valueOf(req.getParameter("productNums"));
				if (productNums == null || productNums < 1) {
					errorMsg.add("請填寫正確數量");
				}
			} catch (NumberFormatException e) {
				errorMsg.add("請填寫數字");

			}
//			

			Integer productOrderId = Integer.parseInt(req.getParameter("product_order_id"));
			Integer memberId = Integer.parseInt(req.getParameter("memberId"));
			java.sql.Date orderDate = java.sql.Date.valueOf(req.getParameter("orderDate"));
			Integer paymentMethod = Integer.parseInt(req.getParameter("payMethod"));
			Integer orderStatus = Integer.parseInt(req.getParameter("orderStatus"));

			Product_order_detailVO poVo = new Product_order_detailVO();
//			poVo.setProduct_order_id(productOrderId);
//			poVo.setMember_id(memberId);
//			poVo.setProduct_order_date(orderDate);
//			poVo.setProduct_amount(productNums);
//			poVo.setPayment_method(paymentMethod);
//			poVo.setOrder_status(orderStatus);

			if (!errorMsg.isEmpty()) {
				req.setAttribute("poVo", poVo);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/product_order_detail/update_product_order.jsp");
				failureView.forward(req, res);
				return;
			}

			Product_order_detailService posvc = new Product_order_detailService();
			poVo = posvc.updateProductOrderDetail(productOrderId ,memberId, orderDate, productNums, paymentMethod, orderStatus);
			req.setAttribute("poVO", poVo);
			// 轉交
			String url = "/back_end/product_order_detail/listOneProduct_order_detail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}

//			===============刪除資料================
		if ("delete".equals(action)) {

			Integer productOrderId = Integer.parseInt(req.getParameter("product_order_id"));
			System.out.println(productOrderId);
			
			Product_order_detailService posvc = new Product_order_detailService();
			PolService psvc = new PolService();
			
			psvc.delete(productOrderId);
			
			posvc.delete(productOrderId);

			String url = "/back_end/product_order_detail/listAll.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);

		}
		
		
		if("buy_now".equals(action)) {
			System.out.println("Im =======here!!!!!");
			Integer productId = Integer.valueOf(req.getParameter("product_Id")); 
			System.out.println(productId); 
			System.out.println(req.getParameter("product_name"));
			System.out.println(req.getParameter("product_price"));
			System.out.println(req.getParameter("product_describtion"));
			
			
			
			
			Product_Service posvc = new Product_Service();
			Product_VO poVO = posvc.getOneProduct(productId);
			req.setAttribute("poVO", poVO);
			RequestDispatcher successView = req.getRequestDispatcher("/front_end/purchasehomepage/Show_productpage0.jsp");
			successView.forward(req, res);
		}

//		===============針對前往付款按鈕=============
//		if ("buy_now".equals(action)) {
//			if ("前往付款".equals(req.getParameter("payNow"))) {
//
//				Integer amounts = Integer.valueOf(req.getParameter("input-amounts"));
////			取得數量
//				Integer productId = null;
//
//				String id = req.getParameter("productId");
//				// ID
//				productId = Integer.valueOf(id);
//
////				HttpSession session1 = req.getSession();
////				MemberVO memberVO = (MemberVO) session1.getAttribute("memberVO");
////				if (memberVO == null) {
////					String url = "/front_end/member/MemberLogin.jsp";
////					RequestDispatcher successView = req.getRequestDispatcher(url);
////					successView.forward(req, res);
////				} else {
////														這個1必須由session取得
////			podVO = podsvc.addProductOrderDetail(productId, 1, amounts, 1, 0);
////			List<PolVO> polVOlist = new ArrayList<PolVO>();
////			PolVO polVO = new PolVO();
////			polVO.setOrder_quantity(amounts);
////			polVO.setProduct_id(productId);
////			
////			polVOlist.add(polVO);
//////			
////			podsvc.insertToPol(podVO, polVOlist);
//
//					Product_Service posvc = new Product_Service();
//					Product_VO poVo = posvc.getOneProduct(productId);
////					session1.setAttribute("memberId", memberVO.getMember_id());
//					req.setAttribute("amounts", amounts); // 數量
//					req.setAttribute("poVo", poVo);// 產品
//					String url = "/front_end/purchasehomepage/Payment.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url);
//					successView.forward(req, res);
//				
//
//			}
//		}

//		==================來自信用卡付款按鈕==============
//		if ("來自信用卡付款".equals(action)) {
//
//			System.out.println("信用卡付款成功");
//			HttpSession session1 = req.getSession();
//			Integer productId = Integer.valueOf(req.getParameter("productId"));
//			System.out.println("商品編號: " + productId);
//			Integer amounts = Integer.valueOf(req.getParameter("amounts"));
//			System.out.println("數量: " + amounts);
//			String name = req.getParameter("input-name");
//			System.out.println("會員姓名:" + name);
//
//			Product_order_detailVO podVO = new Product_order_detailVO();
//			Product_order_detailService podsvc = new Product_order_detailService();
//
////			HttpSession session = req.getSession();取的會員資料
////															這個1必須由會員session取得
////			podVO = podsvc.addProductOrderDetail(productId, 1, amounts, 0, 0); // 一定是信用卡+已付款 0, 0的訂單
//			MemberVO member = (MemberVO) session1.getAttribute("memberVO");
//			podVO.setProduct_id(productId);
//			podVO.setMember_id(member.getMember_id()); // session會員
//			podVO.setProduct_amount(amounts);
//			podVO.setOrder_status(0); // 已付款
//			podVO.setPayment_method(0); // 信用卡
//
//			List<PolVO> polVOlist = new ArrayList<PolVO>();
//			PolVO polVO = new PolVO(); // 訂單明細
//			polVO.setOrder_quantity(amounts);
//			polVO.setProduct_id(productId);
//
//			polVOlist.add(polVO);
//
//			podsvc.insertToPol(podVO, polVOlist);
//			String url = "/front_end/OrderSuccess/OrderSuccess.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);
//			successView.forward(req, res);
//
//		}

//				=============購物車===========
//		if ("buy_now".equals(action)) {
//			if ("加入購物車".equals(req.getParameter("goCar"))) {
//
//				Product_VO poVO = new Product_VO();
//
//				Integer product_id = Integer.valueOf(req.getParameter("productId"));
//				String product_describtion = (req.getParameter("product_describtion"));
//				Integer product_price = Integer.valueOf(req.getParameter("product_price"));
//				String product_name = (req.getParameter("product_name"));
//				Integer amounts = Integer.valueOf(req.getParameter("input-amounts"));
//				poVO.setProduct_id(product_id);
//				poVO.setProduct_describtion(product_describtion);
//				poVO.setProduct_price(product_price);
//				poVO.setProduct_name(product_name);
//				poVO.setProduct_quantity(amounts);
//
//				session = req.getSession();
//				Object buyList = session.getAttribute("shoppingcart");
//				List<Product_VO> shoppingcart;
//				if (buyList == null) {
//					shoppingcart = new Vector<Product_VO>();
//				} else {
//					shoppingcart = (List<Product_VO>) buyList;
//				}
//				shoppingcart.add(poVO); // 將該物品加入購物車
//
//				session.setAttribute("shoppingcart", shoppingcart);
//
//				System.out.println("成功轉出");
//				req.getRequestDispatcher("/front_end/purchasehomepage/PurchaseHomePage.jsp").forward(req, res);
//
////				
//
//			}
//
//		}

//		===========前往購物車結帳============
//		if ("購物車結帳".equals(action)) {
//			session = req.getSession();
//			MemberVO member = (MemberVO) session.getAttribute("memberVO");
//			Integer memberID = member.getMember_id();
//			System.out.println(member.getMember_id());
//			req.setAttribute("memberID", memberID);
//			RequestDispatcher rd = req.getRequestDispatcher("/front_end/purchasehomepage/Cart_payment.jsp");
//			rd.forward(req, res);
//
//		}
		if("送出訂單".equals(action)) {
			System.out.println("HERE?");
			session = req.getSession();
			List<Product_VO> shoppingcart = (List<Product_VO>) session.getAttribute("shoppingcart");
//			List<Product_VO> shoppingcart;
			Product_order_detailVO podVO = new Product_order_detailVO();
			Product_order_detailService podsvc = new Product_order_detailService();

			MemberVO member = (MemberVO) session.getAttribute("memberVO");
			
			for (Product_VO povo : shoppingcart) {
				podVO.setMember_id(member.getMember_id()); // 這裡需session
				podVO.setProduct_amount(povo.getProduct_quantity());
				podVO.setProduct_id(povo.getProduct_id());
				podVO.setOrder_status(1); // 完成
				podVO.setPayment_method(1); // 現金

//				polVOlist = new ArrayList<PolVO>();
				List<PolVO> polVOlist = new ArrayList<PolVO>();
				PolVO polVO = new PolVO(); // 訂單明細
				polVO.setOrder_quantity(povo.getProduct_quantity());
				polVO.setProduct_id(povo.getProduct_id());
				polVOlist.add(polVO);
				podsvc.insertToPol(podVO, polVOlist);

			}
			String url = "/front_end/OrderSuccess/OrderSuccess.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}
		
//		===========購物車結帳+產生訂單============
		if ("來自信用卡付款".equals(action)) {
			
			session = req.getSession();
			List<Product_VO> shoppingcart = (List<Product_VO>) session.getAttribute("shoppingcart");
//			List<Product_VO> shoppingcart;
			Product_order_detailVO podVO = new Product_order_detailVO();
			Product_order_detailService podsvc = new Product_order_detailService();

			MemberVO member = (MemberVO) session.getAttribute("memberVO");
			
			for (Product_VO povo : shoppingcart) {
				podVO.setMember_id(member.getMember_id()); // 這裡需session
				podVO.setProduct_amount(povo.getProduct_quantity());
				podVO.setProduct_id(povo.getProduct_id());
				podVO.setOrder_status(0); // 信用卡
				podVO.setPayment_method(0); // 已結帳

//				polVOlist = new ArrayList<PolVO>();
				List<PolVO> polVOlist = new ArrayList<PolVO>();
				PolVO polVO = new PolVO(); // 訂單明細
				polVO.setOrder_quantity(povo.getProduct_quantity());
				polVO.setProduct_id(povo.getProduct_id());
				polVOlist.add(polVO);
				podsvc.insertToPol(podVO, polVOlist);

			}
			String url = "/front_end/OrderSuccess/OrderSuccess.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}

//						=====會員查詢功能=======
		if ("getOne_Product_DetailForMembers".equals(action)) { // from select_page.jsp
			List<String> errorMsg = new LinkedList<String>();
			// 確保前台輸入錯誤，儲存錯誤提示於request scope及List中並顯示至前台頁面
			req.setAttribute("errorMsg", errorMsg);

			// 取的input text的name參數，並檢視其輸入是否為空值或無填寫
			String str = req.getParameter("product_id");
			if (str == null || str.trim().length() == 0) {
				errorMsg.add("請輸入正確訂單編號"); // true時儲存一個錯誤提示至list中
			}

			// 若errorMsg並非無值時，代表有錯誤發生需有提示
//			，故將其頁面forward至select_page.jsp，並顯示提示
			if (!errorMsg.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front_end/membersorders/Member_home_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			// 檢查是否輸入格式為數字，而非其他字元符號
			Integer product_id = null;
			try {
				product_id = Integer.parseInt(str);
			} catch (Exception e) {
				errorMsg.add("訂單編號格式不正確");

			}

			// 若errorMsg並非無值時，代表有錯誤發生需有提示
//			，故將其頁面forward至select_page.jsp，並顯示提示
			if (!errorMsg.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front_end/membersorders/Member_home_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			// 以上審查無錯誤，開始查詢資料...

//			呼叫工地主任
			Product_order_detailService posvc = new Product_order_detailService();
//			呼叫他的工人開始查詢
			Product_order_detailVO poVO = posvc.getOneOrderDetail(product_id);
			if (poVO.getProduct_order_id() == null) {
				errorMsg.add("查無資料");

			}

			if (!errorMsg.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front_end/membersorders/Member_home_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

//			查詢成功，工作完成，轉交至另一隻jsp，並view出
			req.setAttribute("poVO", poVO); // 資料庫取出的poVO物件,存入req
			String url = "/front_end/membersorders/listSelectProductOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

//		===========	會員查看訂單管理詳情=================
		if ("查看詳情".equals(action)) {
			// 取得訂單編號
			Integer productOrderId = Integer.valueOf(req.getParameter("product_order_listID"));
			Product_order_detailService podSVC = new Product_order_detailService();
			Product_Service poSVC = new Product_Service();
			Product_order_detailVO podVO = podSVC.getOneOrderDetail(productOrderId);
//			System.out.println(podVO.getProduct_id());
			// 時間
			Date time = podVO.getProduct_order_date();
			// 取得會員編號
			Integer memberID = podVO.getMember_id();
			// 產品名稱
			String productName = poSVC.getOneProduct(podVO.getProduct_id()).getProduct_name();
			// price
			Integer price = poSVC.getOneProduct(podVO.getProduct_id()).getProduct_price();
			// amounts
			Integer amounts = podVO.getProduct_amount();
			// pay method
			Integer payMethod = podVO.getPayment_method();
			// status
			Integer status = podVO.getOrder_status();
			// total
			Integer total = amounts * price;
			System.out.println("I got : " + time + "\n" + memberID + "\n" + productName + "\n" + price + "\n" + amounts
					+ "\n" + payMethod + "\n" + status + "\n" + total);

			req.setAttribute("time", time);
			req.setAttribute("memberID", memberID);
			req.setAttribute("productName", productName);
			req.setAttribute("price", price);
			req.setAttribute("amounts", amounts);
			req.setAttribute("payMethod", payMethod);
			req.setAttribute("status", status);
			req.setAttribute("total", total);
			String url = "/front_end/membersorders/Member_order_page.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		
//		if ("order-status".equals(action)) {
////			HttpSession sesion = req.getSession();
////			MemberVO membervo = (MemberVO) sesion.getAttribute("memberVO");
////			System.out.println(membervo.getMember_id());
//			System.out.println("here");
//			Product_order_detailService podsvc = new Product_order_detailService();
//			Integer status = Integer.valueOf(req.getParameter("status1"));
//
//			List<Product_order_detailVO> podVOlist = podsvc.getAll();
//			List<Product_order_detailVO> podVOlist1 = new ArrayList<Product_order_detailVO>();
//
//			for (Product_order_detailVO podVO : podVOlist) {
//				
//					if (podVO.getOrder_status() == status) {
//						podVOlist1.add(podVO);
//					
//				}
//			}
//			req.setAttribute("podVOlist1", podVOlist1);
//			String url = "/back_end/product_order_detail/status.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher("/back_end/product_order_detail/status.jsp"); // 成功轉交 listOneEmp.jsp
//			successView.forward(req, res);		
//		}
		
		
		

//		========針對訂單狀態查詢=========
		if ("status-select".equals(action)) {
			HttpSession sesion = req.getSession();
			MemberVO membervo = (MemberVO) sesion.getAttribute("memberVO");
			System.out.println(membervo.getMember_id());

			Product_order_detailService podsvc = new Product_order_detailService();
			Integer status = Integer.valueOf(req.getParameter("status"));

			List<Product_order_detailVO> podVOlist = podsvc.getAll();
			List<Product_order_detailVO> podVOlist1 = new ArrayList<Product_order_detailVO>();

			for (Product_order_detailVO podVO : podVOlist) {
				if (podVO.getMember_id().equals(membervo.getMember_id())) {
					if (podVO.getOrder_status() == status) {
						podVOlist1.add(podVO);
					}
				}

//				System.out.println(membervo.getMember_id() == podVO.getMember_id());
			}

//				if (podVO.getMember_id() == membervo.getMember_id()) {
//					System.out.println(podVO.getMember_id());
//					if (podVO.getOrder_status() == status) {
//						podVOlist1.add(podVO);
//					}
//				}

			req.setAttribute("podVOlist1", podVOlist1);
			String url = "/front_end/membersorders/selectByStatus.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

//		===========查詢最新訂單=============
		if ("newest-order".equals(action)) {
			HttpSession sesion = req.getSession();
			MemberVO membervo = (MemberVO) sesion.getAttribute("memberVO");
			Product_order_detailService podsvc = new Product_order_detailService();
			List<Product_order_detailVO> podVOlist2 = podsvc.getOrdersFromToday();
			List<Product_order_detailVO> podVOlist = new ArrayList<Product_order_detailVO>();
			for (Product_order_detailVO poVO : podVOlist2) {
				if (poVO.getMember_id().equals(membervo.getMember_id())) {
					podVOlist.add(poVO);
				}
			}
			req.setAttribute("podVOlist", podVOlist);
			String url = "/front_end/membersorders/selectFromDays.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}
		if ("yesterday-order".equals(action)) {
			HttpSession sesion = req.getSession();
			MemberVO membervo = (MemberVO) sesion.getAttribute("memberVO");
			Product_order_detailService podsvc = new Product_order_detailService();
			List<Product_order_detailVO> podVOlist2 = podsvc.getOrdersFormYesterday();
			List<Product_order_detailVO> podVOlist = new ArrayList<Product_order_detailVO>();
			for (Product_order_detailVO poVO : podVOlist2) {
				if (poVO.getMember_id().equals(membervo.getMember_id())) {
					podVOlist.add(poVO);
				}
			}
			req.setAttribute("podVOlist", podVOlist);
			String url = "/front_end/membersorders/selectFromDays.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}
		if ("7days-order".equals(action)) {
			HttpSession sesion = req.getSession();
			MemberVO membervo = (MemberVO) sesion.getAttribute("memberVO");
			Product_order_detailService podsvc = new Product_order_detailService();
			List<Product_order_detailVO> podVOlist2 = podsvc.getOrdersFrom7days();
			List<Product_order_detailVO> podVOlist = new ArrayList<Product_order_detailVO>();
			for (Product_order_detailVO poVO : podVOlist2) {
				if (poVO.getMember_id().equals(membervo.getMember_id())) {
					podVOlist.add(poVO);
				}
			}
			req.setAttribute("podVOlist", podVOlist);
			String url = "/front_end/membersorders/selectFromDays.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

//					=========刪除購物車的商品=============

		if ("移除全部商品".equals(req.getParameter("deleteBTNall"))) {

			session = req.getSession();
			Vector<Product_VO> shoppingcart = (Vector<Product_VO>) session.getAttribute("shoppingcart");
			shoppingcart.clear();
			RequestDispatcher successView = req.getRequestDispatcher("/front_end/purchasehomepage/Cart_empty.jsp"); // 成功轉交
																													// listOneEmp.jsp
			successView.forward(req, res);

		}

		if ("移除商品".equals(req.getParameter("deleteBTN"))) {
			session = req.getSession();
			Vector<Product_VO> shoppingcart = (Vector<Product_VO>) session.getAttribute("shoppingcart");
			Integer index = Integer.valueOf(req.getParameter("index"));
			shoppingcart.removeElementAt(index);
//				System.out.println("romoved!" + shoppingcart.elementAt(index));

			if (!shoppingcart.isEmpty()) {
				System.out.println("romoved successfully");
				session.setAttribute("shoppingcart", shoppingcart);
				RequestDispatcher successView = req.getRequestDispatcher("/front_end/purchasehomepage/Cart.jsp"); // 成功轉交
																													// listOneEmp.jsp
				successView.forward(req, res);
			} else {
				System.out.println("Cart is empty!");
				session.setAttribute("shoppingcart", shoppingcart);
				RequestDispatcher successView = req.getRequestDispatcher("/front_end/purchasehomepage/Cart_empty.jsp"); // 成功轉交
																														// listOneEmp.jsp
				successView.forward(req, res);
			}

		}
			
	}

}
