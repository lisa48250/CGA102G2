package com.activity_category.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.activity.model.ActivityVO;
import com.activity_category.model.ActivityCategoryService;
import com.activity_category.model.ActivityCategoryVO;

// web.xml註冊 or ActivityCategoryServlet寫Annotation
@WebServlet(name = "ActivityCategoryServlet", urlPatterns = "/activity_category/ActivityCategoryServlet.do")
public class ActivityCategoryServlet extends HttpServlet{

	private static final long serialVersionUID = -2025930092786896467L;

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
			// 宣告一個錯誤訊息用的List
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
							// 	key		,	value
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String str = req.getParameter("activity_category_ID");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入活動類別編號");
			}
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				// 呼叫getRequestDispatcher()時需要傳入一個相對於目前請求URL的路徑資訊
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_category/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			Integer activity_category_ID = null;
			try {
				activity_category_ID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("活動類別編號格式不正確");
			}			
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_category/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			/***************************2.開始查詢資料*****************************************/
			ActivityCategoryService activityCategoryService = new ActivityCategoryService();
			ActivityCategoryVO activityCategoryVO = activityCategoryService.getOneActivityCategory(activity_category_ID);			
			if (activityCategoryVO == null) {
				errorMsgs.add("查無資料");
			}
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_category/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			// 資料庫取出的activityCategoryVO物件,存入req
			req.setAttribute("activityCategoryVO", activityCategoryVO);
			String url = "/back_end/activity_category/listOneActivityCategory.jsp";
			// 成功轉交 listOneActivityCategory.jsp
			RequestDispatcher sucessView = req.getRequestDispatcher(url);
			sucessView.forward(req, res);		
		}
				
		// 來自listAllActivityCategory.jsp的請求
		if ("getOneForUpdate".equals(action)) {
			// 宣告一個錯誤訊息用的List
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數****************************************/
			Integer activity_category_ID = Integer.valueOf(req.getParameter("activity_category_ID"));
			
			/***************************2.開始查詢資料****************************************/
			ActivityCategoryService activityCategoryService = new ActivityCategoryService();
			ActivityCategoryVO activityCategoryVO = activityCategoryService.getOneActivityCategory(activity_category_ID);
							
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			// 資料庫取出的activityCategoryVO物件,存入req
			req.setAttribute("activityCategoryVO", activityCategoryVO);
			String url = "/back_end/activity_category/updateActivityCategory.jsp";
			// 成功轉交 updateActivityCategory.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		// 來自updateActivityCategory.jsp的請求
		if ("update".equals(action)) { 
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer activity_category_ID = Integer.valueOf(req.getParameter("activity_category_ID").trim());
				
			String activity_category_name = req.getParameter("activity_category_name").trim();
												// 正則(規)表示式(regular-expression)
			String activity_category_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{4,20}$";
			if (activity_category_name == null || activity_category_name.trim().length() == 0) {
				errorMsgs.add("活動類別名稱: 請勿空白");
			} else if(!activity_category_name.trim().matches(activity_category_nameReg)) { 
				errorMsgs.add("活動類別名稱: 僅能填寫中、英文字母及數字 , 且長度必需在4到20字之間");
            }
			
			String activity_category_info = req.getParameter("editor1").trim();
			if (activity_category_info == null || activity_category_info.trim().length() == 0) {
				errorMsgs.add("活動類別資訊: 請勿空白");
			}				
					
			ActivityCategoryVO activityCategoryVO = new ActivityCategoryVO();
			activityCategoryVO.setActivity_category_ID(activity_category_ID);
			activityCategoryVO.setActivity_category_name(activity_category_name);
			activityCategoryVO.setActivity_category_info(activity_category_info);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				// 將輸入格式錯誤的activityCategoryVO物件,也存入req,RequestDispatcher時會將已輸入的欄位資料一併跳轉帶回
				req.setAttribute("activityCategoryVO", activityCategoryVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_category/updateActivityCategory.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始修改資料*****************************************/
			ActivityCategoryService activityCategoryService = new ActivityCategoryService();
			activityCategoryVO = activityCategoryService.updateActivityCategory(activity_category_ID, activity_category_name, activity_category_info);
			
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			// 資料庫update成功後,正確的的activityCategoryVO物件,存入req
			req.setAttribute("activityCategoryVO", activityCategoryVO); 
			String url = "/back_end/activity_category/listOneActivityCategory.jsp";
			// 修改成功後,轉交listOneActivityCategory.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		// 來自addActivityCategory.jsp的請求
        if ("insert".equals(action)) {   
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			String activity_category_name = req.getParameter("activity_category_name");
												// 正則(規)表示式(regular-expression)
			String activity_category_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{4,20}$";
			if (activity_category_name == null || activity_category_name.trim().length() == 0) {
				errorMsgs.add("活動類別名稱: 請勿空白");
			} else if(!activity_category_name.trim().matches(activity_category_nameReg)) {
				errorMsgs.add("活動類別名稱: 僅能填寫中、英文字母及數字 , 且長度必需在4到20字之間");
            }
			
			String activity_category_info = req.getParameter("editor1");
			if (activity_category_info == null || activity_category_info.trim().length() == 0) {
				errorMsgs.add("活動類別資訊: 請勿空白");
				}

				ActivityCategoryVO activityCategoryVO = new ActivityCategoryVO();
				activityCategoryVO.setActivity_category_name(activity_category_name);
				activityCategoryVO.setActivity_category_info(activity_category_info);

				// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				// 將輸入格式錯誤的activityCategoryVO物件,也存入req,RequestDispatcher時會將已輸入的欄位資料一併跳轉帶回
				req.setAttribute("activityCategoryVO", activityCategoryVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_category/addActivityCategory.jsp");
				failureView.forward(req, res);
				return;
			}
			
			/***************************2.開始新增資料***************************************/
			ActivityCategoryService activityCategoryService = new ActivityCategoryService();
			activityCategoryVO = activityCategoryService.addActivityCategory(activity_category_name, activity_category_info);
			
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/back_end/activity_category/listAllActivityCategory.jsp";
			// 新增成功後,轉交listAllActivityCategory.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);				
		}
		
        // 來自listAllActivityCategory.jsp
		if ("delete".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			/***************************1.接收請求參數***************************************/
			Integer activity_category_ID = Integer.valueOf(req.getParameter("activity_category_ID"));
			
			/***************************2.開始刪除資料***************************************/
			ActivityCategoryService activityCategoryService = new ActivityCategoryService();
			activityCategoryService.deleteActivityCategory(activity_category_ID);
			
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
			String url = "/back_end/activity_category/listAllActivityCategory.jsp";
			// 刪除成功後,轉交回送出刪除的來源網頁
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}		
		
		// 來自selectPage.jsp的請求
		if ("listActivitiesByActivity_category_ID".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/*************************** 1.接收請求參數 ****************************************/
			Integer activity_category_ID = Integer.valueOf(req.getParameter("activity_category_ID"));
			
			/*************************** 2.開始查詢資料 ****************************************/
			ActivityCategoryService activityCategoryService = new ActivityCategoryService();
			Set<ActivityVO> set = activityCategoryService.getActivitiesByActivity_category_ID(activity_category_ID);
			
			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			// 資料庫取出的list物件,存入request
			req.setAttribute("listActivitiesByActivity_category_ID", set);    
			// 成功轉交 listActivitiesByActivity_category_ID.jsp
			String url = "/back_end/activity_category/listActivitiesByActivity_category_ID.jsp";        
			
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
	}
	
}
