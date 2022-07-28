package com.authority_function.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.authority_function.model.Authority_FunctionService;
import com.authority_function.model.Authority_FunctionVO;


@WebServlet("/Authority_function_Servlet")

public class Authority_function_Servlet extends HttpServlet{


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	req.setCharacterEncoding("UTF-8");
	String action = req.getParameter("action");
	
	if("getOne_For_Display".equals(action)) {
		
		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		
		String str = req.getParameter("function_id");
		if (str == null || (str.trim()).length() == 0) {
			errorMsgs.add("職位id不能為空");
		}

		if (!errorMsgs.isEmpty()) { 
			RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/Employee_Authority");
			failureView.forward(req, res);
			return;
		}

		Integer function_id = null;
		try {
			function_id = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("");
		}


		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/Employee_Authority.jsp");
			failureView.forward(req, res);
			return;

		}
		
		//====================查詢資料===================
		Authority_FunctionService authority_functionSvc = new Authority_FunctionService();
		Authority_FunctionVO authority_functionVO = authority_functionSvc.getOneAuthority_Function(function_id);
		if(authority_functionVO == null) {
			errorMsgs.add("");
		}
		
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/Employee_Authority.jsp");
			failureView.forward(req, res);
			return;
		}

		//=====================成功轉交==================
		
		req.setAttribute("authority_functionVO", authority_functionVO);
		String url = "/back_end/emp/OneAuthority_Function.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
	}

		
		
		
		
		
				
		
		
		
		
		
		
		}
	}

