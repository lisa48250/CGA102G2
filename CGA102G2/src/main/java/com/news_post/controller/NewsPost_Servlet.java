package com.news_post.controller;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.RunnableScheduledFuture;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.rowset.serial.SerialBlob;

import com.google.gson.Gson;
import com.news_post.model.*;
@WebServlet("/newspost/newspost.do")
@MultipartConfig(fileSizeThreshold=1024*1024, maxFileSize=5*1024*1024, maxRequestSize=5*5*1024*1024) 
public class NewsPost_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
System.out.println("fff");
		req.setCharacterEncoding("UTF-8");
//		System.out.println(req);
		String action = req.getParameter("action");
		System.out.println(action);
		
//		if("update".equals(action)) {
//			Integer newsPostId = Integer.parseInt(req.getParameter("newsPostId")); 
//			//前端回來的資料是string，強轉成ing，接下前台回傳的參數=>用newsPostId查資料
//			System.out.println(newsPostId);
//			NewsPostService newspostVOSvc = new NewsPostService(); // 設計師呼叫工地主任
//			NewsPostVO newspostVO = newspostVOSvc.getOneNewsPost(newsPostId);
//			System.out.println(newspostVO);
//			Gson gson = new Gson();  //建立gson來處理資料
//			res.setContentType("application/json; charset=UTF-8");
//			PrintWriter out = res.getWriter();  //用out來裝要打回前端的資料
//			out.print(gson.toJson(newspostVO));  //把資料打去前端
//			
//		}
		
		
		
if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// // 将此集合存储在请求范围内，以备不时之需
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("newsPostId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入媒體編號");
			}
			/// 如果有错误，将使用发送回表单
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/newspost/select_page_news.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer newsPostId = null;
			try {
				newsPostId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("媒體編號格式不正確");
			}
			// 如果有错误，将使用发送回表单
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/newspost/select_page_news.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			
			


			/*************************** 2.開始查詢資料 *****************************************/
			NewsPostService newspostVOSvc = new NewsPostService(); // 設計師呼叫工地主任
			NewsPostVO newspostVO = newspostVOSvc.getOneNewsPost(newsPostId);
			if (newspostVO == null) {
				errorMsgs.add("查無資料");
			}
			// 如果有错误，将使用发送回表单
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/newspost/select_page_news.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("newspostVO", newspostVO); // 資料庫取出的newspostVO物件,存入req
			String url = "/back_end/newspost/listOneNewsPost.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}


if ("getOne_For_Status".equals(action)) { // 來自select_page.jsp的請求
String str = req.getParameter("newsStatus");
System.out.println("====" + str);
System.out.println("status: "+ action);

		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		Integer newsStatus = Integer.parseInt(req.getParameter("newsStatus")); // 資料庫取出的newspostVO物件,存入req
		System.out.println("newsStatus:"+newsStatus);
		
		NewsPostService a = new NewsPostService();
		List<NewsPostVO> newVoList = a.getStatus(newsStatus);
		System.out.println("newVoList:"+newVoList);
		
		
		req.getSession().setAttribute("newVoList", newVoList);
		req.getSession().setAttribute("newsStatus", newsStatus);
		String url = "/back_end/newspost/listStatusNewsPost.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
		successView.forward(req, res);
	}



if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			

			/*************************** 1.接收請求參數 ****************************************/
			Integer newsPostId = Integer.valueOf(req.getParameter("newsPostId").trim());

			/*************************** 2.開始查詢資料 ****************************************/
			NewsPostService newspostVOSvc = new NewsPostService();
			NewsPostVO newspostVO = newspostVOSvc.getOneNewsPost(newsPostId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			
			req.setAttribute("newspostVO", newspostVO); // 資料庫取出的newspostVO物件,存入req
			String url = "/back_end/newspost/update_newspost_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// 將此集合存儲在請求範圍內，以備不時之需
			// 發送 ErrorPage 視圖。
			
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer newsPostId = Integer.valueOf(req.getParameter("newsPostId").trim());
			NewsPostService newspostSvc = new NewsPostService();
			
			Part part = req.getPart("newsPhotoFile");
			InputStream in = part.getInputStream();
			BufferedInputStream buff = new BufferedInputStream(in);
			byte [] pic = new byte[in.available()];
			buff.read(pic);
			buff.close();
			if(part.getSize() == 0) {
				pic = newspostSvc.getOneNewsPost(newsPostId).getNewsPhotoFile();
			}
	

String title = req.getParameter("title");
			if (title == null || title.trim().length() == 0) {
				errorMsgs.add("標題: 請勿空白");
			} else if (title.length() > 30) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("標題長度不得超過30字");
			}

String summary = req.getParameter("summary");
			if (summary == null || summary.trim().length() == 0) {
				errorMsgs.add("摘要: 請勿空白");
			} else if (summary.length() > 20) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("摘要長度不得超過20字");
			}


Integer newsStatus = Integer.valueOf(req.getParameter("newsStatus").trim());
			if (newsStatus == null) {
				errorMsgs.add("狀態: 請勿空白");
			}

java.sql.Date newsPostDate = null; // 確認日期
			try {
				newsPostDate = java.sql.Date.valueOf(req.getParameter("newsPostDate").trim()); // 傳進來的日期("newsPostDate")，轉(valueOf)成物件格式
			} catch (IllegalArgumentException e) {
				newsPostDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入報導日期!");
			}


String postComeFrom = req.getParameter("postComeFrom");
			if (postComeFrom == null || postComeFrom.trim().length() == 0) {
				errorMsgs.add("報導出處: 請勿空白");
			} else if (postComeFrom.length() > 10) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("報導出處不得超過10字");
			}
			
			String content = req.getParameter("editor1");
			if (content == null || content.trim().length() == 0) {
				errorMsgs.add("內容: 請勿空白");
			} else if (content.length() > 200) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("內容長度不得超過200字");
			}

			NewsPostVO newspostVO = new NewsPostVO();
			newspostVO.setNewsPostId(newsPostId);
			newspostVO.setNewsPhotoFile(pic);
			newspostVO.setTitle(title);
			newspostVO.setSummary(summary);
			newspostVO.setContent(content);
			newspostVO.setNewsStatus(newsStatus);
			newspostVO.setNewsPostDate(newsPostDate);
			newspostVO.setPostComeFrom(postComeFrom);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("newspostVO", newspostVO); // 含有輸入格式錯誤的newspostVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/newspost/update_newspost_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

			newspostVO = newspostSvc.updateEmp(newsPostId ,pic, title, summary, content, newsStatus, newsPostDate,
					postComeFrom);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("newspostVO", newspostVO); // 資料庫update成功後,正確的的newspostVO物件,存入req
			String url = "/back_end/newspost/listOneNewsPost.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

if ("insert".equals(action)) { // 來自addEmp.jsp的請求
System.out.println("nnnnn");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 輸入格式的錯誤處理 **************************/
			NewsPostService newspostSvc = new NewsPostService();

			String newsPhotoFile = req.getParameter("newsPhotoFile");
			Part part = req.getPart("newsPhotoFile");
			InputStream in = part.getInputStream();
			byte [] pic = new byte[in.available()];
			in.read(pic);
			in.close();


			
			System.out.println("ccccccccccccc");
String title = req.getParameter("title");
			if (title == null || title.trim().length() == 0) {
				errorMsgs.add("標題: 請勿空白");
			} else if (title.length() > 30) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("標題長度不得超過30字");
			}

String summary = req.getParameter("summary");
			if (summary == null || summary.trim().length() == 0) {
				errorMsgs.add("摘要: 請勿空白");
			} else if (title.length() > 1000) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("摘要長度不得超過1000字");
			}

			
Integer newsStatus = Integer.valueOf(req.getParameter("newsStatus").trim());

			System.out.println(newsStatus);
java.sql.Date newsPostDate = null; // 確認日期
			try {
				newsPostDate = java.sql.Date.valueOf(req.getParameter("newsPostDate").trim()); // 傳進來的日期("newsPostDate")，轉(valueOf)成物件格式
			} catch (IllegalArgumentException e) {
				newsPostDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入報導日期!");
			}

String postComeFrom = req.getParameter("postComeFrom");
			if (postComeFrom == null || postComeFrom.trim().length() == 0) {
				errorMsgs.add("報導出處: 請勿空白");
			} else if (postComeFrom.length() > 10) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("報導出處不得超過10字");
			}
			
			String content = req.getParameter("editor1");
			if (content == null || content.trim().length() == 0) {
				errorMsgs.add("內容: 請勿空白");
			} else if (content.length() > 1000) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("內容長度不得超過1000字");
			}
			System.out.println(content);

			NewsPostVO newspostVO = new NewsPostVO();
			newspostVO.setNewsPhotoFile(pic);
			newspostVO.setTitle(title);
			newspostVO.setSummary(summary);
			newspostVO.setContent(content);
			newspostVO.setNewsStatus(newsStatus);
			newspostVO.setNewsPostDate(newsPostDate);
			newspostVO.setPostComeFrom(postComeFrom);

//			System.out.println("nnnnn");
			// 如果有错误，将使用发送回表单
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("newspostVO", newspostVO); // 含有輸入格式錯誤的newspostVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/newspost/addNewsPost.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
//			NewsPostService newspostSvc = new NewsPostService();
			newspostVO = newspostSvc.addNewsPost(pic, title, summary, content, newsStatus, newsPostDate,
					postComeFrom);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/newspost/select_page_news.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// 将此集合存储在请求范围内，以备不时之需
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer newsPostId = Integer.valueOf(req.getParameter("newsPostId"));

			/*************************** 2.開始刪除資料 ***************************************/
			NewsPostService newspostVOSvc = new NewsPostService();
			newspostVOSvc.deleteNewsPost(newsPostId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/newspost/select_page_news.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
