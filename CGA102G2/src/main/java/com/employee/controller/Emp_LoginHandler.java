package com.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.model.EmployeeService;
import com.employee.model.EmployeeVO;
import com.job.model.JobService;
import com.job.model.JobVO;
import com.job_authority.model.Job_AuthorityService;
import com.job_authority.model.Job_AuthorityVO;

@WebServlet("/emploginhandler")
public class Emp_LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();

		String action = req.getParameter("action");
		
		if ("Login_Emp".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			   
			String account = req.getParameter("account");
			String password = req.getParameter("password");

			EmployeeService empsvc = new EmployeeService();
			EmployeeVO employeeVO = empsvc.getfindByAccountAndPassword(account, password); //比對帳號密碼取得符合的資料

			 if (employeeVO == null) {
				    errorMsgs.add("帳號密碼錯誤");
				    RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/EmployeeLogin.jsp");
				    failureView.forward(req, res);
				    return;
				   }
			 
			if (employeeVO != null) {  // employeeVO 不等於null 登入成功!

				Integer job_id = employeeVO.getJob_id();  //employee取得job_id
				Job_AuthorityService jobAuthSev = new Job_AuthorityService();  
				Job_AuthorityVO autoVO = jobAuthSev.getOneJob_Authority(job_id); 
				
				JobService jobsvc = new JobService();
				JobVO jobVO = jobsvc.getOneJob(job_id);
				
				HttpSession session = req.getSession();
				
				session.setAttribute("employeeVO", employeeVO);
				session.setAttribute("autoVO", autoVO);
				session.setAttribute("jobVO", jobVO);
				
				
//		System.out.println("成功");
				String location = (String) session.getAttribute("location");

//				if (location != null) {
//					System.out.println("2222");
//					res.sendRedirect(location);
//				} else {
					RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/Employee_Login_Success.jsp");
					failureView.forward(req, res);
System.out.println("1111");
					return;
//			res.sendRedirect("/" + req.getContextPath() + "/back_end/member/listOneMember.jsp");
				
			}
		}
	}
}
