package com.members.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		  doPost(req,res);
	  } 

	 public void doPost(HttpServletRequest req, HttpServletResponse res)
             throws ServletException, IOException {

		 req.setCharacterEncoding("UTF-8");
		 res.setContentType("text/html; charset=UTF-8"); 
		 
		 HttpSession session = req.getSession();
		 session.invalidate();
		 String url = req.getContextPath()+"/front_end/frontpage/FrontPage.jsp";
		 res.sendRedirect(url);
	 }
}