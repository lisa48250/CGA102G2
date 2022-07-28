package h.com.new_list.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import h.com.new_list.model.News_listService;

@WebServlet("/News")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewsServlet() {
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
		
		

		News_listService list = new News_listService();
		
		req.setAttribute("list",list.getAll());
		req.getRequestDispatcher("/front_end/news/NewSelectAll.jsp").forward(req, res);
	}
}