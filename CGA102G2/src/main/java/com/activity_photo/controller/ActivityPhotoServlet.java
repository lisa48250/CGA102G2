package com.activity_photo.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.activity.model.ActivityService;
import com.activity_photo.model.ActivityPhotoService;
import com.activity_photo.model.ActivityPhotoVO;


// web.xml註冊 or ActivityPhotoServlet寫Annotation
@WebServlet(name = "ActivityPhotoServlet", urlPatterns = "/activity_photo/ActivityPhotoServlet.do")
@MultipartConfig(fileSizeThreshold = 1024*1024, maxFileSize = 5*1024*1024, maxRequestSize = 5*5*1024*1024)
public class ActivityPhotoServlet extends HttpServlet{
	private static final long serialVersionUID = 7078491853219442260L;

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
			String str = req.getParameter("activity_photo_ID");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("activity_photo_ID", "請輸入活動圖片編號");
			}
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				// 呼叫getRequestDispatcher()時需要傳入一個相對於目前請求URL的路徑資訊
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_photo/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			Integer activity_photo_ID = null;
			try {
				activity_photo_ID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("activity_photo_ID", "活動圖片編號格式不正確");
			}			
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_photo/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			/***************************2.開始查詢資料*****************************************/
			ActivityPhotoService activityPhotoService = new ActivityPhotoService();
			ActivityPhotoVO activityPhotoVO = activityPhotoService.getOneActivityPhoto(activity_photo_ID);			
			if (activityPhotoVO == null) {
				errorMsgs.put("activity_photo_ID","查無資料");
			}
			// 若有errors, 將錯誤訊息顯示在form表單中
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_photo/selectPage.jsp");
				failureView.forward(req, res);
				return;	// 程式中斷
			}
			
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			// 資料庫取出的activityPhotoVO物件,存入req
			req.setAttribute("activityPhotoVO", activityPhotoVO);
			String url = "/back_end/activity_photo/listOneActivityPhoto.jsp";
			// 成功轉交 listOneActivityPhoto.jsp
			RequestDispatcher sucessView = req.getRequestDispatcher(url);
			sucessView.forward(req, res);		
		}
		
		// 來自listAllActivityPhoto.jsp的請求
		if ("getOneForUpdate".equals(action)) {
			// 宣告一個錯誤訊息用的Map
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			// 送出修改的來源網頁路徑: /activity_photo/listAllActivityPhoto.jsp】
			String requestURL = req.getParameter("requestURL");
			
			/***************************1.接收請求參數****************************************/
			Integer activity_photo_ID = Integer.valueOf(req.getParameter("activity_photo_ID"));
			
			/***************************2.開始查詢資料****************************************/
			ActivityPhotoService activityPhotoService = new ActivityPhotoService();
			ActivityPhotoVO activityPhotoVO = activityPhotoService.getOneActivityPhoto(activity_photo_ID);
							
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			// 資料庫取出的activityPhotoVO物件,存入req
			req.setAttribute("activityPhotoVO", activityPhotoVO);
			String url = "/back_end/activity_photo/updateActivityPhoto.jsp";
			// 成功轉交 updateActivityPhoto.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		// 來自updateActivityPhoto.jsp的請求
		if ("update".equals(action)) { 
			
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			// 送出修改的來源網頁路徑: /activity_photo/listAllActivityPhoto.jsp】
			String requestURL = req.getParameter("requestURL");
		
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer activity_photo_ID = Integer.valueOf(req.getParameter("activity_photo_ID").trim());
			
			Integer activity_ID = Integer.valueOf(req.getParameter("activity_ID").trim());
			
			ActivityPhotoService activityPhotoService = new ActivityPhotoService();
			
			Part part = req.getPart("activity_photo");
			InputStream is = part.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			byte [] pic = new byte[bis.available()];
			bis.read(pic);
			bis.close();
			is.close();
			if (part.getSize() == 0) {
				pic = activityPhotoService.getOneActivityPhoto(activity_photo_ID).getActivity_photo();
			};
			
			ActivityPhotoVO activityPhotoVO = new ActivityPhotoVO();
			activityPhotoVO.setActivity_photo_ID(activity_photo_ID);
			activityPhotoVO.setActivity_ID(activity_ID);
			activityPhotoVO.setActivity_photo(pic);
		

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("activityPhotoVO", activityPhotoVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_photo/updateActivityPhoto.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始修改資料*****************************************/
			activityPhotoVO = activityPhotoService.updateActivityPhoto(activity_photo_ID, activity_ID, pic);
			
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			ActivityService activityService = new ActivityService();
			if(requestURL.equals("/back_end/activity/listActivityPhotosByActivity_ID.jsp") || requestURL.equals("/back_end/activity/listAllActivity.jsp"))
				// 資料庫取出的list物件,存入request
				req.setAttribute("listActivityPhotosByActivity_ID",activityService.getActivityPhotosByActivity_ID(activity_ID)); 
			
			if(requestURL.equals("/back_end/activity_photo/listOneActivityPhoto.jsp")) {
				// 資料庫取出的list物件,存入request
				req.setAttribute("activityPhotoVO",activityPhotoVO); 				
			}			
						
			String url = requestURL;
			// 修改成功後,轉交listOneActivityPhoto.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		// 來自addActivityPhoto.jsp的請求
        if ("insert".equals(action)) {   
			
        	Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			Integer activity_ID = Integer.valueOf(req.getParameter("activity_ID").trim());
			
			ActivityPhotoService activityPhotoService = new ActivityPhotoService();
			
			Part part = req.getPart("activity_photo");
			InputStream is = part.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			byte [] pic = new byte[bis.available()];
			bis.read(pic);
			bis.close();
			is.close();
			if (part.getSize() == 0) {
				errorMsgs.put("activity_photo", "請上傳圖片");
			};
			
			ActivityPhotoVO activityPhotoVO = new ActivityPhotoVO();
			activityPhotoVO.setActivity_ID(activity_ID);
			activityPhotoVO.setActivity_photo(pic);
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
			// 將輸入格式錯誤的activityPhotoVO物件,也存入req,RequestDispatcher時會將已輸入的欄位資料一併跳轉帶回
				req.setAttribute("activityPhotoVO", activityPhotoVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/activity_photo/addActivityPhoto.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			
			/***************************2.開始新增資料***************************************/
			activityPhotoVO = activityPhotoService.addActivityPhoto(activity_ID, pic);
			
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
			String url = "/back_end/activity_photo/listAllActivityPhoto.jsp";
			// 新增成功後,轉交listAllActivityPhoto.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);				
		}
		
        // 來自listAllActivityPhoto.jsp
		if ("delete".equals(action)) { 

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			// Store this set in the request scope, in case we need to send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL");
	
			/***************************1.接收請求參數***************************************/
			Integer activity_photo_ID = Integer.valueOf(req.getParameter("activity_photo_ID"));
			
			/***************************2.開始刪除資料***************************************/
			ActivityPhotoService activityPhotoService = new ActivityPhotoService();
			ActivityPhotoVO activityPhotoVO = activityPhotoService.getOneActivityPhoto(activity_photo_ID);
			activityPhotoService.deleteActivityPhoto(activity_photo_ID);
			
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/	
			ActivityService activityService = new ActivityService();
			if(requestURL.equals("/back_end/activity/listActivityPhotosByActivity_ID.jsp") || requestURL.equals("/back_end/activity/listAllActivity.jsp"))
				// 資料庫取出的list物件,存入request
				req.setAttribute("listActivityPhotosByActivity_ID",activityService.getActivityPhotosByActivity_ID(activityPhotoVO.getActivity_ID())); 
			
			if(requestURL.equals("/back_end/activity_photo/listAllActivityPhoto.jsp")) {
				// 資料庫取出的list物件,存入request
				req.setAttribute("activityPhotoVO",activityPhotoVO); 				
			}
			
			if (requestURL.equals("/back_end/activity_photo/listOneActivityPhoto.jsp")) {
				requestURL = "/back_end/activity_photo/listAllActivityPhoto.jsp";
			}
			
			String url = requestURL;
			// 刪除成功後,轉交回送出刪除的來源網頁
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
	}
	
}
