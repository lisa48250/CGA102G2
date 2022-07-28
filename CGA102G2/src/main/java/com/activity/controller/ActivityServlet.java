package com.activity.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.activity.model.ActivityService;
import com.activity.model.ActivityVO;
import com.activity_category.model.ActivityCategoryService;
import com.activity_photo.model.ActivityPhotoVO;


// web.xml註冊 or ActivityServlet寫Annotation
@WebServlet(name = "ActivityServlet", urlPatterns = "/activity/ActivityServlet.do")
public class ActivityServlet extends HttpServlet{

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
			String str = req.getParameter("activity_ID");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("activity_ID", "請輸入活動編號");
			}
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				// 呼叫getRequestDispatcher()時需要傳入一個相對於目前請求URL的路徑資訊
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			Integer activity_ID = null;
			try {
				activity_ID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("activity_ID", "活動編號格式不正確");
			}			
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			/***************************2.開始查詢資料*****************************************/
			ActivityService activityService = new ActivityService();
			ActivityVO activityVO = activityService.getOneActivity(activity_ID);			
			if (activityVO == null) {
				errorMsgs.put("activity_ID","查無資料");
			}
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			// 資料庫取出的activityVO物件,存入req
			req.setAttribute("activityVO", activityVO);
			String url = "/back_end/activity/listOneActivity.jsp";
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
			
			// 送出修改的來源網頁路徑: /activity/listAllActivity.jsp】
			String requestURL = req.getParameter("requestURL");
			
			/***************************1.接收請求參數****************************************/
			Integer activity_ID = Integer.valueOf(req.getParameter("activity_ID"));
			
			/***************************2.開始查詢資料****************************************/
			ActivityService activityService = new ActivityService();
			ActivityVO activityVO = activityService.getOneActivity(activity_ID);
							
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			// 資料庫取出的activityVO物件,存入req
			req.setAttribute("activityVO", activityVO);
			String url = "/back_end/activity/updateActivity.jsp";
			// 成功轉交 updateActivity.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		// 來自updateActivity.jsp的請求
		if ("update".equals(action)) { 
			
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			// 送出修改的來源網頁路徑: 【/activity/listAllActivity.jsp】 或 其他頁面
			String requestURL = req.getParameter("requestURL");
		
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer activity_ID = Integer.valueOf(req.getParameter("activity_ID").trim());
			
			Integer activity_category_ID = Integer.valueOf(req.getParameter("activity_category_ID").trim());
			
			String activity_name = req.getParameter("activity_name").trim();
									// 正則(規)表示式(regular-expression)
			String activity_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{4,20}$";
			if (activity_name == null || activity_name.trim().length() == 0) {
				errorMsgs.put("activity_name", "請輸入活動名稱");
			} else if(!activity_name.trim().matches(activity_nameReg)) { 
				errorMsgs.put("activity_name", "活動名稱: 僅能填寫中、英文字母及數字 , 且長度必需在4到20字之間");
            }
			
			Integer activity_price = null;
			try {
				activity_price = Integer.valueOf(req.getParameter("activity_price").trim());
				if (activity_price <= 0) {
					errorMsgs.put("activity_price", "活動價格: 請填寫大於0的數字");
				}
			} catch (NumberFormatException e) {
				errorMsgs.put("activity_price","請填入活動價格(數字)");
			} 
			
			java.sql.Date activity_start = null;
			try {
				activity_start = java.sql.Date.valueOf(req.getParameter("activity_start").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("activity_start", "請輸入活動開始日期");
			}

			java.sql.Date activity_end = null;
			try {
				activity_end = java.sql.Date.valueOf(req.getParameter("activity_end").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("activity_end", "請輸入活動結束日期");
			}			
			
			String activity_description = req.getParameter("editor1").trim();
			if (activity_description == null || activity_description.trim().length() == 0) {
				errorMsgs.put("activity_description", "請輸入活動描述");
			}	
			
			String activity_content = req.getParameter("editor2").trim();
			if (activity_content == null || activity_content.trim().length() == 0) {
				errorMsgs.put("activity_content", "請輸入活動內容");
			}	
			
			String activity_info = req.getParameter("editor3").trim();
			if (activity_info == null || activity_info.trim().length() == 0) {
				errorMsgs.put("activity_info", "請輸入活動資訊");
			}
			
			Integer activity_state = Integer.valueOf(req.getParameter("activity_state").trim());
			
			ActivityVO activityVO = new ActivityVO();
			activityVO.setActivity_ID(activity_ID);
			activityVO.setActivity_category_ID(activity_category_ID);
			activityVO.setActivity_name(activity_name);
			activityVO.setActivity_price(activity_price);
			activityVO.setActivity_start(activity_start);
			activityVO.setActivity_end(activity_end);
			activityVO.setActivity_description(activity_description);
			activityVO.setActivity_content(activity_content);
			activityVO.setActivity_info(activity_info);
			activityVO.setActivity_state(activity_state);			

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("activityVO", activityVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity/updateActivity.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始修改資料*****************************************/
			ActivityService activityService = new ActivityService();
			activityVO = activityService.updateActivity(activity_ID, activity_category_ID, activity_name, activity_price, activity_start, activity_end, activity_description, activity_content, activity_info, activity_state);
			
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			ActivityCategoryService activityCategoryService = new ActivityCategoryService();
			if(requestURL.equals("/back_end/activity_category/listActivitiesByActivity_category_ID.jsp") || requestURL.equals("/back_end/activity_category/listAllActivityCategory.jsp"))
				req.setAttribute("listActivitiesByActivity_category_ID",activityCategoryService.getActivitiesByActivity_category_ID(activity_category_ID)); // 資料庫取出的list物件,存入request
			
			if(requestURL.equals("/back_end/activity/listActivitiesByCompositeQuery.jsp")){
				HttpSession session = req.getSession();
				Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				List<ActivityVO> list  = activityService.getAll(map);
				req.setAttribute("listActivitiesByCompositeQuery",list); // 複合查詢, 資料庫取出的list物件,存入request
			}
			
			if(requestURL.equals("/back_end/activity/listOneActivity.jsp") || requestURL.equals("/back_end/activity/listAllActivity.jsp")) {
				req.setAttribute("activityVO", activityVO); 
			}
			
			String url = requestURL;
			// 修改成功後,轉交回來源網頁
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		// 來自addActivity.jsp的請求
        if ("insert".equals(action)) {   
			
        	Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			Integer activity_category_ID = Integer.valueOf(req.getParameter("activity_category_ID").trim());
			
			String activity_name = req.getParameter("activity_name").trim();
									// 正則(規)表示式(regular-expression)
			String activity_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{4,20}$";
			if (activity_name == null || activity_name.trim().length() == 0) {
				errorMsgs.put("activity_name", "請輸入活動名稱");
			} else if(!activity_name.trim().matches(activity_nameReg)) { 
				errorMsgs.put("activity_name", "活動名稱: 僅能填寫中、英文字母及數字 , 且長度必需在4到20字之間");
            }
			
			Integer activity_price = null;
			try {
				activity_price = Integer.valueOf(req.getParameter("activity_price").trim());
				if (activity_price <= 0) {
					errorMsgs.put("activity_price", "活動價格: 請填寫大於0的數字");
				}
			} catch (NumberFormatException e) {
				errorMsgs.put("activity_price","請填入活動價格(數字)");
			} 
			
			java.sql.Date activity_start = null;
			try {
				activity_start = java.sql.Date.valueOf(req.getParameter("activity_start").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("activity_start", "請輸入活動開始日期");
			}

			java.sql.Date activity_end = null;
			try {
				activity_end = java.sql.Date.valueOf(req.getParameter("activity_end").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("activity_end", "請輸入活動結束日期");
			}			
			
			String activity_description = req.getParameter("editor1");
			if (activity_description == null || activity_description.trim().length() == 0) {
				errorMsgs.put("activity_description", "請輸入活動描述");
			}	
			
			String activity_content = req.getParameter("editor2");
			if (activity_content == null || activity_content.trim().length() == 0) {
				errorMsgs.put("activity_content", "請輸入活動內容");
			}	
			
			String activity_info = req.getParameter("editor3");
			if (activity_info == null || activity_info.trim().length() == 0) {
				errorMsgs.put("activity_info", "請輸入活動資訊");
			}
			
			Integer activity_state = Integer.valueOf(req.getParameter("activity_state").trim());
			
			ActivityVO activityVO = new ActivityVO();
			activityVO.setActivity_category_ID(activity_category_ID);
			activityVO.setActivity_name(activity_name);
			activityVO.setActivity_price(activity_price);
			activityVO.setActivity_start(activity_start);
			activityVO.setActivity_end(activity_end);
			activityVO.setActivity_description(activity_description);
			activityVO.setActivity_content(activity_content);
			activityVO.setActivity_info(activity_info);
			activityVO.setActivity_state(activity_state);
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
			// 將輸入格式錯誤的activityVO物件,也存入req,RequestDispatcher時會將已輸入的欄位資料一併跳轉帶回
				req.setAttribute("activityVO", activityVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity/addActivity.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始新增資料***************************************/
			ActivityService activityService = new ActivityService();
			activityVO = activityService.addActivity(activity_category_ID, activity_name, activity_price, activity_start, activity_end, activity_description, activity_content, activity_info, activity_state);
			
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/back_end/activity/listAllActivity.jsp";
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
			Integer activity_ID = Integer.valueOf(req.getParameter("activity_ID"));
			
			/***************************2.開始刪除資料***************************************/
			ActivityService activityService = new ActivityService();
			ActivityVO activityVO = activityService.getOneActivity(activity_ID);
			activityService.deleteActivity(activity_ID);
			
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/	
			ActivityCategoryService activityCategoryService = new ActivityCategoryService();
			if(requestURL.equals("/back_end/activity_category/listActivitiesByActivity_category_ID.jsp") || requestURL.equals("/back_end/activity_category/listAllActivityCategory.jsp"))
				// 資料庫取出的list物件,存入request
				req.setAttribute("listActivitiesByActivity_category_ID",activityCategoryService.getActivitiesByActivity_category_ID(activityVO.getActivity_category_ID())); 
			
			if(requestURL.equals("/back_end/activity/listActivitiesByCompositeQuery.jsp")){
				HttpSession session = req.getSession();
				Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				List<ActivityVO> list  = activityService.getAll(map);
				// 複合查詢, 資料庫取出的list物件,存入request
				req.setAttribute("listActivitiesByCompositeQuery",list); 
			}
			
			if (requestURL.equals("/back_end/activity/listOneActivity.jsp")) {
				requestURL = "/back_end/activity/listAllActivity.jsp";
			}
			
			String url = requestURL;
			// 刪除成功後,轉交回送出刪除的來源網頁
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		// 來自selectPage.jsp的複合查詢請求
		if ("listActivitiesByCompositeQuery".equals(action)) { 
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
			ActivityService activityService = new ActivityService();
			List<ActivityVO> list  = activityService.getAll(map);
			
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			// 資料庫取出的list物件,存入request
			req.setAttribute("listActivitiesByCompositeQuery", list);
			// 成功轉交listActivitiesByCompositeQuery.jsp
			RequestDispatcher successView = req.getRequestDispatcher("/back_end/activity/listActivitiesByCompositeQuery.jsp"); 
			successView.forward(req, res);
		}
		
		// 來自selectPage.jsp的請求
		if ("listActivityPhotosByActivity_ID".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/*************************** 1.接收請求參數 ****************************************/
			Integer activity_ID = Integer.valueOf(req.getParameter("activity_ID"));
			
			/*************************** 2.開始查詢資料 ****************************************/
			ActivityService activityService = new ActivityService();
			Set<ActivityPhotoVO> set = activityService.getActivityPhotosByActivity_ID(activity_ID);
			
			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			// 資料庫取出的list物件,存入request
			req.setAttribute("listActivityPhotosByActivity_ID", set);    
			// 成功轉交 listActivityPhotosByActivity_ID.jsp
			String url = "/back_end/activity/listActivityPhotosByActivity_ID.jsp";        
			
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
	}
	
}
