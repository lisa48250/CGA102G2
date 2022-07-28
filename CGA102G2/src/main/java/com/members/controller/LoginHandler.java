package com.members.controller;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.members.model.MemberService;
import com.members.model.MemberVO;

import javax.servlet.annotation.WebServlet;

@WebServlet("/loginhandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();

		String action = req.getParameter("action");
		if ("Login".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			String account = req.getParameter("account");
			String password = req.getParameter("password");
			String location;
			MemberService memsvc = new MemberService();
			MemberVO memberVO = memsvc.getfindByAccountAndPassword(account, password);
			HttpSession session = req.getSession();
			if (memberVO == null) {
				errorMsgs.add("帳號密碼錯誤");
				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/member/MemberLogin.jsp");
				failureView.forward(req, res);
				return;
			}
			if (memberVO != null) {	
				System.out.println("111111");
				session = req.getSession();
				location = (String) session.getAttribute("location");		
				session.setAttribute("memberVO", memberVO);
				
				if(location == null){
					System.out.println("33333333");
					System.out.println("my location2");
					session.setAttribute("memberVO", memberVO);				
					session.setAttribute("location", req.getRequestURI());					
					RequestDispatcher failureView = req.getRequestDispatcher("/front_end/frontpage/FrontPage.jsp");
					failureView.forward(req, res);
				}
				else if (location.equals("/CGA102G2/loginhandler")) {
					 System.out.println("222222");
					session.setAttribute("memberVO", memberVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/front_end/frontpage/FrontPage.jsp");
					failureView.forward(req, res);
				}
				else if(location.equals("/CGA102G2/CartPay")) {
			
			    	 RequestDispatcher failureView = req.getRequestDispatcher("/front_end/purchasehomepage/Cart.jsp");
			         failureView.forward(req, res);
			    } 
				
				else {
					
					session.setAttribute("memberVO", memberVO);
					res.sendRedirect(location);

				}
			}
		}
	}
}