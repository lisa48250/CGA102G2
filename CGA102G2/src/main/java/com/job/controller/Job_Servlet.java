package com.job.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.model.JobService;
import com.job.model.JobVO;

@WebServlet("/Job_Servlet")

public class Job_Servlet extends HttpServlet{


		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doPost(req, res);
		}

		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			req.setCharacterEncoding("UTF-8");
			String action = req.getParameter("action");
			
			if("getOne_For_Display".equals(action)) {
				
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				
				String str = req.getParameter("job_id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("職位id不能為空");
				}

				if (!errorMsgs.isEmpty()) { 
					RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/Employee_Management.jsp");
					failureView.forward(req, res);
					return;
				}

				Integer job_id = null;
				try {
					job_id = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("");
				}

		
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/Employee_Management.jsp");
					failureView.forward(req, res);
					return;

				}
				
				//====================查詢資料===================
				JobService jobSvc = new JobService();
				JobVO jobVO =jobSvc.getOneJob(job_id);
				if(jobVO == null) {
					errorMsgs.add("");
				}
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/Employee_Management.jsp");
					failureView.forward(req, res);
					return;
				}

				//=====================成功轉交==================
				
				req.setAttribute("jobVO", jobVO);
				String url = "/back_end/emp/OneJob.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
			}

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		}
