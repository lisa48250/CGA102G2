package h.com.new_list.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import h.com.new_list.model.News_listService;
import h.com.new_list.model.News_listVO;

@WebServlet("/NewsBackUpdate")
@MultipartConfig()
public class NewsServletBackDelete extends HttpServlet {

	public NewsServletBackDelete() {
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

		if ("delete".equals(action)) {

			Integer news_id = Integer.parseInt(req.getParameter("news_id"));
			News_listService news_listservice = new News_listService();
			news_listservice.deleteNews(news_id);
			RequestDispatcher successView = req.getRequestDispatcher("/back_end/news/NewsBackUpdate.jsp");
			successView.forward(req, res);

		} else if ("forward".equals(action)) {

			Integer news_id = Integer.parseInt(req.getParameter("news_id"));
			News_listService news_listservice = new News_listService();
			News_listVO news_listvo = news_listservice.findByPrimaryKeyNews(news_id);
			req.setAttribute("list", news_listvo);
			RequestDispatcher successView = req.getRequestDispatcher("/back_end/news/NewsBackUpdate1.jsp");
			successView.forward(req, res);

		} else if ("update".equals(action)) {

//			List<String> errormsg = new ArrayList<String>();
//			req.setAttribute("errormsg", errormsg);
			
			Map<String , String> map = new HashMap();
			req.setAttribute("map", map);
			
			String title = null;
			title = req.getParameter("title");
			if (title == null || title.trim().length() == 0) {
				map.put("title","請輸入標題");

			}

			String editor1 = null;
			editor1 = req.getParameter("editor1");
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

			// TODO Auto-generated catch block

			int id = Integer.parseInt(req.getParameter("id").trim());

			Part part = req.getPart("pic");
			InputStream in = part.getInputStream();
			byte[] pic = new byte[in.available()];
			in.read(pic);

			if (part.getSize() == 0 && in.read() == -1) {
				map.put("pic","請上傳圖片");
				News_listService news_listservice1 = new News_listService();
				pic = news_listservice1.findByPrimaryKeyNews(id).getNews_id_photo();
				in.close();
			}

//			News_listVO news_listVO = new News_listVO();
//			news_listVO.setNews_id_title(title);
//			news_listVO.setNews_id_description(editor1);
//			news_listVO.setNews_id_date(date);
//			news_listVO.setNews_id_photo(pic);

			if (!map.isEmpty()) {

				News_listService news_listservice = new News_listService();

				News_listVO list = news_listservice.updateNews(title, editor1, date, pic, id);
				req.setAttribute("list", list);

				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/news/NewsBackUpdate1.jsp");
				failureView.forward(req, res);
				return;

			} else {

				News_listService news_listservice = new News_listService();

				News_listVO list = news_listservice.updateNews(title, editor1, date, pic, id);
				req.setAttribute("list", list);
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/news/NewsBackselectAll.jsp");
				failureView.forward(req, res);
			}
		}

	}
}
