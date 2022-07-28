package com.activityJoin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http 	.HttpSession;
import javax.servlet.http.HttpSession;

import com.activity_join.model.ActivityJoinService;
import com.activity_join.model.ActivityJoinVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.members.model.MemberVO;
//import com.mysql.cj.Session;

@WebServlet("/activityJoin/activityJoin.do")
public class ActivityJoin_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
//		justForTest(req);// 記得要拿掉唷!!!
		
		

		req.setCharacterEncoding("UTF-8");
		ActivityJoinService actSVC = new ActivityJoinService();
		String action = req.getParameter("action");

		if ("Activity_Join".equals(action)) {
			List<ActivityJoinVO> list = actSVC.getActJoin(req.getParameterMap());

			req.setAttribute("Activity_Join", list);
			System.out.println(req.getContextPath() + "/back_end/activityorder/ActivityOrder_Join.jsp");
			RequestDispatcher successView = req.getRequestDispatcher("/back_end/activityorder/ActivityOrder_Join.jsp");
			successView.forward(req, res);
		}

		if ("getDetail".equals(action)) {
			String id = req.getParameter("id");
			if (id != null || id.trim().length() != 0) {
				Integer id2 = Integer.parseInt(id);
				ActivityJoinService svc = new ActivityJoinService();
				ActivityJoinVO vo = svc.getOneActivityID(id2);

				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm").create();
				res.setContentType("application/json; charset=UTF-8");
				PrintWriter out = res.getWriter();
				out.print(gson.toJson(vo));

			}
		}

		if ("update".equals(action)) {
			Integer id2 = null;
			String id = req.getParameter("id");

			
			System.out.println("id:" + id);

			id2 = Integer.parseInt(id);
			ActivityJoinService svc = new ActivityJoinService();
			svc.update(id2);

			String url = "/front_end/activity_order/ActivityOrder_State.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}

//====================活動一==============================		

		if ("insert_1".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>(); // 創建一個LinkedList集合，String型別，客戶端返回的是object須轉型
			req.setAttribute("errorMsgs", errorMsgs); // 設定參數，用于servlet 页面传递参数给jsp

			ActivityJoinVO activityJoinVO = new ActivityJoinVO();
			req.getSession().setAttribute("activityJoinVO", activityJoinVO);

			activityJoinVO.setActivityID(Integer.valueOf(req.getParameter("activityID")));

			String enrollNumber = req.getParameter("enrollNumber");
			if (enrollNumber == null || enrollNumber.trim().length() == 0) {
				errorMsgs.add("請確認報名人數");
			} else {
				activityJoinVO.setEnrollNumber(Integer.valueOf(enrollNumber));
			}

			String activitySessionDate = req.getParameter("activitySessionDate");
			if (activitySessionDate == null || activitySessionDate.trim().length() == 0) {
				errorMsgs.add("請確認活動日期");
			} else {
				try {
					activityJoinVO
							.setActivitySessionStart(new java.sql.Timestamp(SDF.parse(activitySessionDate).getTime()));
				} catch (ParseException e) {
					e.printStackTrace();
					errorMsgs.add("請確認活動日期");
				}
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front_end/activity_details/ActivityDetails_01.jsp");
				failureView.forward(req, res);
				return;
			}

			Map<String, Object> map = actSVC.getPriceById(activityJoinVO.getActivityID());
			activityJoinVO.setActivityName((String) map.get("name"));
			activityJoinVO.setOrderAmount((int) map.get("price") * activityJoinVO.getEnrollNumber());

			Map<String, Object> map2 = actSVC.getDateTimeByIdAndDate(activityJoinVO.getActivityID(),
					activityJoinVO.getActivitySessionStart());
			activityJoinVO.setActivitySessionID((Integer) map2.get("id"));
			activityJoinVO.setActivitySessionStart((Timestamp) map2.get("start"));
			activityJoinVO.setActivitySessionEnd((Timestamp) map2.get("end"));
			String url = "/front_end/activity_details/ActivityDetails_Pay.jsp"; // 都有值後轉交頁面
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		} else if ("insert_2".equals(action)) {
			
			MemberVO memberVO = (MemberVO) req.getSession().getAttribute("memberVO");
			ActivityJoinVO activityJoinVO = (ActivityJoinVO) req.getSession().getAttribute("activityJoinVO");
			String orderMemo = req.getParameter("orderMemo");
			System.out.println(orderMemo);
			System.out.println("1");
			activityJoinVO.setOrderMemo(orderMemo);
			activityJoinVO.setMember_id(memberVO.getMember_id());
			ActivityJoinVO newActivityJoinVO = actSVC.addActivityOrder(activityJoinVO);
			newActivityJoinVO.setActivityName(activityJoinVO.getActivityName());
			req.getSession().setAttribute("activityJoinVO", newActivityJoinVO);
			String url = "/front_end/activity_details/ActivityDetails_Success.jsp"; // 都有值後轉交頁面
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
			
		} else if ("insert_3".equals(action)) {
			req.getSession().setAttribute("activityJoinVO", null);
			String url = req.getContextPath() + "/front_end/index/index.html";
			res.sendRedirect(url);
		}
	



//=========================================== Fei =========================================
		// 來自selectPage.jsp的請求
		if ("getOneForDisplay".equals(action)) {
			// 宣告一個錯誤訊息用的Map
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
							// 	key		,	value
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String str = req.getParameter("activityOrderId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("activityOrderId", "請輸入活動訂單編號");
			}
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				// 呼叫getRequestDispatcher()時需要傳入一個相對於目前請求URL的路徑資訊
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_order/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			Integer activityOrderId = null;
			try {
				activityOrderId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("activityOrderId", "活動訂單編號格式不正確");
			}			
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_order/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			/***************************2.開始查詢資料*****************************************/
			ActivityJoinService activityJoinService = new ActivityJoinService();
			ActivityJoinVO activityJoinVO = activityJoinService.getOneActivityID(activityOrderId);			
			if (activityJoinVO == null) {
				errorMsgs.put("activityOrderId","查無資料");
			}
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_order/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			// 資料庫取出的activityJoinVO物件,存入req
			req.setAttribute("activityJoinVO", activityJoinVO);
			String url = "/back_end/activity_order/listOneActivityOrder.jsp";
			// 成功轉交 listOneActivityOrder.jsp
			RequestDispatcher sucessView = req.getRequestDispatcher(url);
			sucessView.forward(req, res);		
		}
		
		// 來自listAllActivityOrder.jsp的請求
		if ("getOneForUpdate".equals(action)) {
			// 宣告一個錯誤訊息用的Map
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			// 送出修改的來源網頁路徑: /activity_order/listAllActivityOrder.jsp】
			String requestURL = req.getParameter("requestURL");
			
			/***************************1.接收請求參數****************************************/
			Integer activityOrderId = Integer.valueOf(req.getParameter("activityOrderId"));
			
			/***************************2.開始查詢資料****************************************/
			ActivityJoinService activityJoinService = new ActivityJoinService();
			ActivityJoinVO activityJoinVO = activityJoinService.getOneActivityID(activityOrderId);
							
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			// 資料庫取出的activityJoinVO物件,存入req
			req.setAttribute("activityJoinVO", activityJoinVO);
			String url = "/back_end/activity_order/updateActivityOrder.jsp";
			// 成功轉交 updateActivity.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		// 來自addActivityOrder.jsp的請求
        if ("staff_insert".equals(action)) {   
			
        	Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			Integer member_id = Integer.valueOf(req.getParameter("member_id").trim());

			Integer activitySessionID = Integer.valueOf(req.getParameter("activitySessionID").trim());
			
			Integer enrollNumber = null;
			try {
				enrollNumber = Integer.valueOf(req.getParameter("enrollNumber").trim());
				if (enrollNumber <= 0) {
					errorMsgs.put("enrollNumber", "報名人數: 至少1人");
				}
			} catch (NumberFormatException e) {
				errorMsgs.put("enrollNumber","請填入報名人數(數字)");
			}
			
			Integer orderAmount = null;
			try {
				orderAmount = Integer.valueOf(req.getParameter("orderAmount").trim());
				if (orderAmount <= 0) {
					errorMsgs.put("orderAmount", "訂單總額: 至少1元");
				}
			} catch (NumberFormatException e) {
				errorMsgs.put("orderAmount","請填入訂單總額(數字)");
			} 
			
			String orderMemo = req.getParameter("editor1").trim();
			if (orderMemo == null || orderMemo.trim().length() == 0) {
				orderMemo = "無";
			}				
			
			Integer orderState = 0;
			
			Integer refundState = 0;
			
			ActivityJoinVO activityJoinVO = new ActivityJoinVO();
			activityJoinVO.setMember_id(member_id);
			activityJoinVO.setActivitySessionID(activitySessionID);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = new Date();
			Timestamp orderTime = Timestamp.valueOf(dateFormat.format(date));			
			activityJoinVO.setOrderTime(orderTime);
			
			activityJoinVO.setEnrollNumber(enrollNumber);
			activityJoinVO.setOrderAmount(orderAmount);
			activityJoinVO.setOrderState(orderState);
			activityJoinVO.setRefundState(refundState);
			activityJoinVO.setOrderMemo(orderMemo);
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
			// 將輸入格式錯誤的activitySessionVO物件,也存入req,RequestDispatcher時會將已輸入的欄位資料一併跳轉帶回
				req.setAttribute("activityJoinVO", activityJoinVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_order/addActivityOrder.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始新增資料***************************************/
			ActivityJoinService activityJoinService = new ActivityJoinService();
			activityJoinVO = activityJoinService.staff_addActivityOrder(activityJoinVO);
			
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/back_end/activity_order/listAllActivityOrder.jsp";
			// 新增成功後,轉交listAllActivityOrder.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);				
		}
        
		// 來自updateActivityOrderSession.jsp的請求
		if ("staff_update".equals(action)) { 
			
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			// 送出修改的來源網頁路徑: /activity_ordert/listOneActivityOrder.jsp】
			String requestURL = req.getParameter("requestURL");
		
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer activityOrderId = Integer.valueOf(req.getParameter("activityOrderId").trim());
			
			Integer member_id = Integer.valueOf(req.getParameter("member_id").trim());

			Integer activitySessionID = Integer.valueOf(req.getParameter("activitySessionID").trim());
			
			Timestamp orderTime = Timestamp.valueOf(req.getParameter("orderTime").trim());	
			
			Integer enrollNumber = null;
			try {
				enrollNumber = Integer.valueOf(req.getParameter("enrollNumber").trim());
				if (enrollNumber <= 0) {
					errorMsgs.put("enrollNumber", "報名人數: 至少1人");
				}
			} catch (NumberFormatException e) {
				errorMsgs.put("enrollNumber","請填入報名人數(數字)");
			}
			
			Integer orderAmount = null;
			try {
				orderAmount = Integer.valueOf(req.getParameter("orderAmount").trim());
				if (orderAmount <= 0) {
					errorMsgs.put("orderAmount", "訂單總額: 至少1元");
				}
			} catch (NumberFormatException e) {
				errorMsgs.put("orderAmount","請填入訂單總額(數字)");
			} 
			
			String orderMemo = req.getParameter("editor1").trim();
			if (orderMemo == null || orderMemo.trim().length() == 0) {
				orderMemo = "無";
			}				
			
			Integer orderState = Integer.valueOf(req.getParameter("orderState").trim());
			
			Integer refundState = Integer.valueOf(req.getParameter("refundState").trim());
			
			String activityName = req.getParameter("activityName");
			String member_name = req.getParameter("member_name");
			Timestamp activitySessionStart = Timestamp.valueOf(req.getParameter("activitySessionStart"));
			Timestamp activitySessionEnd = Timestamp.valueOf(req.getParameter("activitySessionEnd"));
			
			ActivityJoinVO activityJoinVO = new ActivityJoinVO();
			activityJoinVO.setActivityOrderId(activityOrderId);
			activityJoinVO.setMember_id(member_id);
			activityJoinVO.setActivitySessionID(activitySessionID);		
			activityJoinVO.setOrderTime(orderTime);			
			activityJoinVO.setEnrollNumber(enrollNumber);
			activityJoinVO.setOrderAmount(orderAmount);
			activityJoinVO.setOrderState(orderState);
			activityJoinVO.setRefundState(refundState);
			activityJoinVO.setOrderMemo(orderMemo);
			
			activityJoinVO.setActivityName(activityName);
			activityJoinVO.setMember_name(member_name);
			activityJoinVO.setActivitySessionStart(activitySessionStart);
			activityJoinVO.setActivitySessionEnd(activitySessionEnd);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("activityJoinVO", activityJoinVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_order/updateActivityOrder.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始修改資料*****************************************/
			ActivityJoinService activityJoinService = new ActivityJoinService();
			activityJoinVO = activityJoinService.updateActivityOrder(activityJoinVO);
			
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			// 資料庫update成功後,正確的的activityCategoryVO物件,存入req
			req.setAttribute("activityJoinVO", activityJoinVO); 
			String url = "/back_end/activity_order/listOneActivityOrder.jsp";
			// 修改成功後,轉交listOneActivityOrderCategory.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		// 來自selectPage.jsp的複合查詢請求
		if ("listActivityOrdersByCompositeQuery".equals(action)) { 
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				
			/***************************1.將輸入資料轉為Map**********************************/ 
			//採用Map<String,String[]> getParameterMap()的方法 
			//注意:an immutable java.util.Map 
			//Map<String, String[]> map = req.getParameterMap();
			HttpSession session = req.getSession();
			Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
			
			// 以下的 if 區塊只對第一次執行時有效
			if (req.getParameter("whichPage") == null){
				Map<String, String[]> map1 = new HashMap<String, String[]>(req.getParameterMap());
				// 若只寫下方程式碼，不會保存新的map值(因為map值會永遠保存無法被洗掉)，故一定要像上方一樣宣告新的map：new HashMap<String, String[]>()
				// Map<String, String[]> map1 = req.getParameterMap();
				session.setAttribute("map",map1);
				map = map1;
			} 
			
			/***************************2.開始複合查詢***************************************/
			ActivityJoinService activityJoinService = new ActivityJoinService();
			List<ActivityJoinVO> list  = activityJoinService.getAll(map);
			
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			// 資料庫取出的list物件,存入request
			req.setAttribute("listActivityOrdersByCompositeQuery", list);
			// 成功轉交listActivityOrdersByCompositeQuery.jsp
			RequestDispatcher successView = req.getRequestDispatcher("/back_end/activity_order/listActivityOrdersByCompositeQuery.jsp"); 
			successView.forward(req, res);
		}
		
	}

}
