package com.activity_session.controller;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import com.activity.model.ActivityService;
import com.activity_session.model.ActivitySessionService;
import com.activity_session.model.ActivitySessionVO;


// web.xml註冊 or ActivitySessionServlet寫Annotation
@WebServlet(name = "ActivitySessionServlet", urlPatterns = "/activity_session/ActivitySessionServlet.do")
public class ActivitySessionServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// 指定當取得請求參數時使用的編碼，如若瀏覽器以UTF-8發送請求，接收時也要使用UTF-8編碼字串
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		// 來自selectPage.jsp的請求
		if ("getOneForDisplay".equals(action)) {
			// 宣告一個錯誤訊息用的Map
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
							// 	key		,	value
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String str = req.getParameter("activity_session_ID");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("activity_session_ID", "請輸入活動場次編號");
			}
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				// 呼叫getRequestDispatcher()時需要傳入一個相對於目前請求URL的路徑資訊
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_session/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			Integer activity_session_ID = null;
			try {
				activity_session_ID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("activity_session_ID", "活動場次編號格式不正確");
			}			
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_session/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			/***************************2.開始查詢資料*****************************************/
			ActivitySessionService activitySessionService = new ActivitySessionService();
			ActivitySessionVO activitySessionVO = activitySessionService.getOneActivitySession(activity_session_ID);			
			if (activitySessionVO == null) {
				errorMsgs.put("activity_session_ID","查無資料");
			}
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_session/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			// 資料庫取出的activitySessionVO物件,存入req
			req.setAttribute("activitySessionVO", activitySessionVO);
			String url = "/back_end/activity_session/listOneActivitySession.jsp";
			// 成功轉交 listOneActivity.jsp
			RequestDispatcher sucessView = req.getRequestDispatcher(url);
			sucessView.forward(req, res);		
		}
		
		// 來自listAllActivity.jsp的請求
		if ("getOneForUpdate".equals(action)) {
			// 宣告一個錯誤訊息用的Map
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			// 送出修改的來源網頁路徑: /activity_session/listAllActivitySession.jsp】
			String requestURL = req.getParameter("requestURL");
			
			/***************************1.接收請求參數****************************************/
			Integer activity_session_ID = Integer.valueOf(req.getParameter("activity_session_ID"));
			
			/***************************2.開始查詢資料****************************************/
			ActivitySessionService activitySessionService = new ActivitySessionService();
			ActivitySessionVO activitySessionVO = activitySessionService.getOneActivitySession(activity_session_ID);
							
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			// 資料庫取出的activitySessionVO物件,存入req
			req.setAttribute("activitySessionVO", activitySessionVO);
			String url = "/back_end/activity_session/updateActivitySession.jsp";
			// 成功轉交 updateActivity.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		// 來自updateActivitySession.jsp的請求
		if ("update".equals(action)) { 
			
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			// 送出修改的來源網頁路徑: /activity_session/listOneActivitySession.jsp】
			String requestURL = req.getParameter("requestURL");
		
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer activity_session_ID = Integer.valueOf(req.getParameter("activity_session_ID").trim());
			
			Integer activity_ID = Integer.valueOf(req.getParameter("activity_ID").trim());
			
			java.sql.Timestamp activity_session_start = null; 
			try {
				if (req.getParameter("activity_session_start") != null) {
					activity_session_start = java.sql.Timestamp.valueOf(req.getParameter("activity_session_start").trim());
				} else {
					errorMsgs.put("activity_session_start", "請輸入活動場次開始日期及時間");
				}
			} catch (IllegalArgumentException e) {
//				errorMsgs.put("activity_session_start", e.getMessage());
				errorMsgs.put("activity_session_start", "請輸入活動場次開始日期及時間(時、分、秒)");
			}
			
			java.sql.Timestamp activity_session_end = null; 
			try {
				if (req.getParameter("activity_session_end") != null) {
					activity_session_end = java.sql.Timestamp.valueOf(req.getParameter("activity_session_end").trim());
				} else {
					errorMsgs.put("activity_session_end", "請輸入活動場次結束日期及時間");
				}
			} catch (IllegalArgumentException e) {
				errorMsgs.put("activity_session_end", "請輸入活動場次結束日期及時間(時、分、秒)");
			}
			
			Integer activity_enroll_state = Integer.valueOf(req.getParameter("activity_enroll_state").trim());
			
			String status_note = req.getParameter("activity_description");
			if (status_note == null || status_note.trim().length() == 0) {
				status_note = "無";
			}				
			
			Integer activity_max_part = null;
			try {
				activity_max_part = Integer.valueOf(req.getParameter("activity_max_part").trim());
				if (activity_max_part <= 0) {
					errorMsgs.put("activity_max_part", "活動場次人數上限: 請填寫大於0的數字");
				}
			} catch (NumberFormatException e) {
				errorMsgs.put("activity_max_part","請填入活動場次人數上限(數字)");
			} 
			
			Integer activity_min_part = null;
			try {
				activity_min_part = Integer.valueOf(req.getParameter("activity_min_part").trim());
				if (activity_min_part <= 0) {
					errorMsgs.put("activity_min_part", "活動場次人數下限: 請填寫大於0的數字");
				}
			} catch (NumberFormatException e) {
				errorMsgs.put("activity_min_part","請填入活動場次人數下限(數字)");
			} 
			
			Integer enroll_total = Integer.valueOf(req.getParameter("enroll_total").trim());
			
			java.sql.Date enroll_start = null;
			try {
				enroll_start = java.sql.Date.valueOf(req.getParameter("enroll_start").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("enroll_start", "請輸入活動報名開始日期");
			}

			java.sql.Date enroll_end = null;
			try {
				enroll_end = java.sql.Date.valueOf(req.getParameter("enroll_end").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("enroll_end", "請輸入活動報名結束日期");
			}			
			
			Integer activity_session_state = Integer.valueOf(req.getParameter("activity_session_state").trim());
			
			ActivitySessionVO activitySessionVO = new ActivitySessionVO();
			activitySessionVO.setActivity_session_ID(activity_session_ID);
			activitySessionVO.setActivity_ID(activity_ID);
			activitySessionVO.setActivity_session_start(activity_session_start);
			activitySessionVO.setActivity_session_end(activity_session_end);
			activitySessionVO.setActivity_enroll_state(activity_enroll_state);
			activitySessionVO.setStatus_note(status_note);
			activitySessionVO.setActivity_max_part(activity_max_part);
			activitySessionVO.setActivity_min_part(activity_min_part);
			activitySessionVO.setEnroll_total(enroll_total);
			activitySessionVO.setEnroll_start(enroll_start);
			activitySessionVO.setEnroll_end(enroll_end);
			activitySessionVO.setActivity_session_state(activity_session_state);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("activitySessionVO", activitySessionVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_session/updateActivitySession.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始修改資料*****************************************/
			ActivitySessionService activitySessionService = new ActivitySessionService();
			activitySessionVO = activitySessionService.updateActivitySession(activitySessionVO);
			
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			ActivityService activityService = new ActivityService();
			if(requestURL.equals("/back_end/activity/listActivitySessionsByActivity_ID.jsp") || requestURL.equals("/back_end/activity_session/listAllActivity.jsp" ))
				req.setAttribute("listActivitySessionsByActivity_ID",activityService.getActivitySessionsByActivity_ID(activity_ID)); // 資料庫取出的list物件,存入request
			
			if(requestURL.equals("/back_end/activity_session/listActivitySessionsByCompositeQuery.jsp")){
				HttpSession session = req.getSession();
				Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				List<ActivitySessionVO> list  = activitySessionService.getAll(map);
				req.setAttribute("listActivitySessionsByCompositeQuery",list); // 複合查詢, 資料庫取出的list物件,存入request
			}
			
			if(requestURL.equals("/back_end/activity_session/listOneActivitySession.jsp")) {
				req.setAttribute("activitySessionVO", activitySessionVO); 
			}			
			
			String url = requestURL;
			// 修改成功後,轉交listOneActivitySession.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		// 來自addActivity.jsp的請求
        if ("insert".equals(action)) {   
			
        	Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			Integer activity_ID = Integer.valueOf(req.getParameter("activity_ID").trim());
			
			java.sql.Timestamp activity_session_start = null; 
			try {
				if (req.getParameter("activity_session_start") != null) {
					activity_session_start = java.sql.Timestamp.valueOf(req.getParameter("activity_session_start").trim()+":00");
				} else {
					errorMsgs.put("activity_session_start", "請輸入活動場次開始日期及時間");
				}
			} catch (IllegalArgumentException e) {
//				errorMsgs.put("activity_session_start", e.getMessage());
				errorMsgs.put("activity_session_start", "請輸入活動場次開始日期及時間(時、分)");
			}
			
			java.sql.Timestamp activity_session_end = null; 
			try {
				if (req.getParameter("activity_session_end") != null) {
					activity_session_end = java.sql.Timestamp.valueOf(req.getParameter("activity_session_end").trim()+":00");
				} else {
					errorMsgs.put("activity_session_end", "請輸入活動場次結束日期及時間");
				}
			} catch (IllegalArgumentException e) {
				errorMsgs.put("activity_session_end", "請輸入活動場次結束日期及時間(時、分)");
			}
			
			Integer activity_enroll_state = 0;
			
			String status_note = req.getParameter("editor1").trim();
			if (status_note == null || status_note.trim().length() == 0) {
				status_note = "無";
			}				
			
			Integer activity_max_part = null;
			try {
				activity_max_part = Integer.valueOf(req.getParameter("activity_max_part").trim());
				if (activity_max_part <= 0) {
					errorMsgs.put("activity_max_part", "活動場次人數上限: 請填寫大於0的數字");
				}
			} catch (NumberFormatException e) {
				errorMsgs.put("activity_max_part","請填入活動場次人數上限(數字)");
			} 
			
			Integer activity_min_part = null;
			try {
				activity_min_part = Integer.valueOf(req.getParameter("activity_min_part").trim());
				if (activity_min_part <= 0) {
					errorMsgs.put("activity_min_part", "活動場次人數下限: 請填寫大於0的數字");
				}
			} catch (NumberFormatException e) {
				errorMsgs.put("activity_min_part","請填入活動場次人數下限(數字)");
			} 
			
			Integer enroll_total = 0;
			
			java.sql.Date enroll_start = null;
			try {
				enroll_start = java.sql.Date.valueOf(req.getParameter("enroll_start").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("enroll_start", "請輸入活動報名開始日期");
			}

			java.sql.Date enroll_end = null;
			try {
				enroll_end = java.sql.Date.valueOf(req.getParameter("enroll_end").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("enroll_end", "請輸入活動報名結束日期");
			}			
			
			Integer activity_session_state = 0;
			
			ActivitySessionVO activitySessionVO = new ActivitySessionVO();
			activitySessionVO.setActivity_ID(activity_ID);
			activitySessionVO.setActivity_session_start(activity_session_start);
			activitySessionVO.setActivity_session_end(activity_session_end);
			activitySessionVO.setActivity_enroll_state(activity_enroll_state);
			activitySessionVO.setStatus_note(status_note);
			activitySessionVO.setActivity_max_part(activity_max_part);
			activitySessionVO.setActivity_min_part(activity_min_part);
			activitySessionVO.setEnroll_total(enroll_total);
			activitySessionVO.setEnroll_start(enroll_start);
			activitySessionVO.setEnroll_end(enroll_end);
			activitySessionVO.setActivity_session_state(activity_session_state);
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
			// 將輸入格式錯誤的activitySessionVO物件,也存入req,RequestDispatcher時會將已輸入的欄位資料一併跳轉帶回
				req.setAttribute("activitySessionVO", activitySessionVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_session/addActivitySession.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始新增資料***************************************/
			ActivitySessionService activitySessionService = new ActivitySessionService();
			activitySessionVO = activitySessionService.addActivitySession(activitySessionVO);
			
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/back_end/activity_session/listAllActivitySession.jsp";
			// 新增成功後,轉交listAllActivity.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);				
		}
		
        // 來自listAllActivity.jsp
		if ("delete".equals(action)) { 

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL");
	
			/***************************1.接收請求參數***************************************/
			Integer activity_session_ID = Integer.valueOf(req.getParameter("activity_session_ID"));
			
			/***************************2.開始刪除資料***************************************/
			ActivitySessionService activitySessionService = new ActivitySessionService();
			ActivitySessionVO activitySessionVO = activitySessionService.getOneActivitySession(activity_session_ID);
			activitySessionService.deleteActivitySession(activity_session_ID);
			
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/	
			ActivityService activityService = new ActivityService();
			if(requestURL.equals("/back_end/activity/listActivitySessionsByActivity_ID.jsp") || requestURL.equals("/back_end/activity/listAllActivity.jsp"))
				// 資料庫取出的list物件,存入request
				req.setAttribute("listActivitySessionsByActivity_ID",activityService.getActivitySessionsByActivity_ID(activitySessionVO.getActivity_ID())); 
			
			if(requestURL.equals("/back_end/activity_session/listActivitySessionsByCompositeQuery.jsp")){
				HttpSession session = req.getSession();
				Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				List<ActivitySessionVO> list  = activitySessionService.getAll(map);
				// 複合查詢, 資料庫取出的list物件,存入request
				req.setAttribute("listActivitySessionsByCompositeQuery",list); 
			}
			
			if (requestURL.equals("/back_end/activity_session/listOneActivitySession.jsp")) {
				requestURL = "/back_end/activity_session/listAllActivitySession.jsp";
			}
			
			String url = requestURL;
			// 刪除成功後,轉交回送出刪除的來源網頁
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		// 來自selectPage.jsp的複合查詢請求
		if ("listActivitySessionsByCompositeQuery".equals(action)) { 
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
				ActivitySessionService activitySessionService = new ActivitySessionService();
				List<ActivitySessionVO> list  = activitySessionService.getAll(map);
				
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				// 資料庫取出的list物件,存入request
				req.setAttribute("listActivitySessionsByCompositeQuery", list);
				// 成功轉交listActivitiesByCompositeQuery.jsp
				RequestDispatcher successView = req.getRequestDispatcher("/back_end/activity_session/listActivitySessionsByCompositeQuery.jsp"); 
				successView.forward(req, res);
		}
		
	}
	
}
