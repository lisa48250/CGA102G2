package h.com.new_list.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import h.com.new_list.model.News_listService;
import h.com.new_list.model.News_listVO;

@WebServlet("/NewsBack")
@MultipartConfig()
public class NewsServletback extends HttpServlet {
	public NewsServletback() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		if ("insert".equals(action)) {
			//錯誤訊息
//			List<String> errormsg = new ArrayList<String>();
//			req.setAttribute("errormsg", errormsg);
			//未輸入錯誤提示
			Map<String , String> map = new HashMap();
			req.setAttribute("map", map);
			
			
			String title = req.getParameter("title");
			if (title == null || title.trim().length() == 0) {
				map.put("title","請輸入標題");

			}
			String editor1 = req.getParameter("editor1");
			if (editor1 == null || editor1.trim().length() == 0) {
				map.put("editor1","請輸入內容");

			}
			java.sql.Date date = null;
			try {
				date = java.sql.Date.valueOf(req.getParameter("date").trim());
			} catch (IllegalArgumentException e) {
				date = new java.sql.Date(System.currentTimeMillis());
				map.put("date","請輸入日期");

			}
			Part part = req.getPart("pic");
			InputStream in = part.getInputStream();
			byte[] pic = new byte[in.available()];
			in.read(pic);
			in.close();
			if (part.getSize() == 0) {
				map.put("pic","請上傳圖片");
			}
			
			//保留使用者輸入的資料
			News_listVO news_listVO = new News_listVO();
			news_listVO.setNews_id_title(title);
			news_listVO.setNews_id_description(editor1);
			news_listVO.setNews_id_date(date);
			news_listVO.setNews_id_photo(pic);

			
			if (!map.isEmpty()) {
			
				req.setAttribute("news_listVO", news_listVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/news/NewsBackInsert.jsp");
				failureView.forward(req, res);
				return;

			} else {

				News_listService news_listservice = new News_listService();
				News_listVO list = news_listservice.insertNews(title, editor1, date, pic);

				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/news/NewsBackselectAll.jsp");
				failureView.forward(req, res);
			}
		}

	}
}
