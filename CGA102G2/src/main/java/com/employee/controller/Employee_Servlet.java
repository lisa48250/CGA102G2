package com.employee.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import com.employee.model.EmployeeService;
import com.employee.model.EmployeeVO;


//@MultipartConfig(fileSizeThreshold=1024*1024, maxFileSize=5*1024*1024, maxRequestSize=5*5*1024*1024)
@WebServlet("/Employee_Servlet")
public class Employee_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z **********************/

			String str = req.getParameter("emp_no");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("員工id不能為空");
			}

			if (!errorMsgs.isEmpty()) { 
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/Employee_Authority.jsp");
				failureView.forward(req, res);
				return;
			}

			Integer emp_no = null;
			try {
				emp_no = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("員工編號不正確");
			}

	
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/Employee_Authority.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.�}�l�d�߸�� *****************************************/
			EmployeeService empSvc = new EmployeeService();
			EmployeeVO employeeVO = empSvc.getOneEmployee(emp_no);
			if (employeeVO == null) {
				errorMsgs.add("�d�L���");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/Employee_Management.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 3.�d�ߧ���,�ǳ����(Send the Success view) *************/
			req.setAttribute("employeeVO", employeeVO);
			String url = "/back_end/emp/OneEmployee.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			/***************************1.接收請求參數***************************************/
			Integer emp_no = Integer.valueOf(req.getParameter("emp_no"));

			/***************************2.開始查詢資料****************************************/

			EmployeeService empSvc = new EmployeeService();
			EmployeeVO employeeVO = empSvc.getOneEmployee(emp_no);

			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			req.setAttribute("employeeVO_edit", employeeVO); 
			String url = "/back_end/emp/Employee_Data_Update.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}

		if ("update".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

//			/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
			Integer emp_no = Integer.valueOf(req.getParameter("emp_no").trim());
			System.out.println(emp_no);

			Integer job_id = Integer.valueOf(req.getParameter("job_id").trim());
			System.out.println(job_id);
			
			String emp_name = req.getParameter("emp_name");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (emp_name == null || emp_name.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			} else if (!emp_name.trim().matches(enameReg)) {
				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			Integer emp_status = Integer.valueOf(req.getParameter("emp_status").trim());
			
			String emp_account = req.getParameter("emp_account");
			
			if (emp_account == null || emp_account.trim().length() == 0) {
				errorMsgs.add("帳號請勿空白");
			} 
			
			String emp_password = req.getParameter("emp_password");
			String passwordReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (emp_password == null || emp_password.trim().length() == 0) {
				errorMsgs.add("員工密碼:請勿空白");
			} else if (!emp_password.trim().matches(passwordReg)) {
				errorMsgs.add("員工密碼:只能是英文與數字");
			}
			

			EmployeeVO employeeVO = new EmployeeVO();
			employeeVO.setEmp_no(emp_no);
			employeeVO.setJob_id(job_id);
			employeeVO.setEmp_name(emp_name);
			employeeVO.setEmp_status(emp_status);
			employeeVO.setEmp_account(emp_account);
			employeeVO.setEmp_password(emp_password);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("employeeVO", employeeVO); 
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/Employee_Data_Update.jsp");
				failureView.forward(req, res);
				return; 
			}

			/*************************** 2.�}�l�ק��� *****************************************/
			EmployeeService empSvc = new EmployeeService();
			employeeVO = empSvc.updateEmployee(emp_no, job_id, emp_name, emp_status, emp_account, emp_password);

			/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
//			HttpSession session = req.getSession();
//			session.setAttribute("employeeVO", employeeVO);
			req.setAttribute("employeeVO", employeeVO); 
			
			
			String url = "/back_end/emp/OneEmployee.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); 
			successView.forward(req, res);
		}

		
		if ("insert".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z *************************/
			
			Integer job_id = Integer.valueOf(req.getParameter("job_id").trim());
			
//			String str = req.getParameter("job_id").trim();
//			if (str == null || str.trim().length() == 0) {
//				errorMsgs.add("");
//			}
//			Integer job_id = null;
//			try {
//				job_id = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMsgs.add("");
//			}

//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/addEmployee.jsp"); 
//																								
//				failureView.forward(req, res);
//				return;
//			}

			String emp_name = req.getParameter("emp_name");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (emp_name == null || emp_name.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			} else if (!emp_name.trim().matches(enameReg)) {
				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String str1 = req.getParameter("emp_status").trim();
			if (str1 == null || str1.trim().length() == 0) {
				errorMsgs.add("員工狀態不能為空");
			}
			Integer emp_status = null;
			try {
				emp_status = Integer.valueOf(str1);
			} catch (Exception e) {
				errorMsgs.add("狀態錯誤");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/addEmployee.jsp"); 
				failureView.forward(req, res);
				return;
			}
			
			String emp_account = req.getParameter("emp_account");
			
			if (emp_account == null || emp_account.trim().length() == 0) {
				errorMsgs.add("帳號請勿空白");
			} 
			EmployeeService empsvc = new EmployeeService();
			List<EmployeeVO> empVos = empsvc.getAll();
			for (EmployeeVO employeeVO : empVos) {
				if (emp_account.equals(employeeVO.getEmp_account())) {
					errorMsgs.add("帳號已被註冊過");
				}
			}
			
			String emp_password = req.getParameter("emp_password");
			String passwordReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (emp_password == null || emp_password.trim().length() == 0) {
				errorMsgs.add("員工密碼:請勿空白");
			} else if (!emp_password.trim().matches(passwordReg)) {
				errorMsgs.add("員工密碼:只能是英文與數字");
			}
			


			EmployeeVO employeeVO = new EmployeeVO();
			employeeVO.setJob_id(job_id);
			employeeVO.setEmp_name(emp_name);
			employeeVO.setEmp_status(emp_status);
			employeeVO.setEmp_account(emp_account);
			employeeVO.setEmp_password(emp_password);


			if (!errorMsgs.isEmpty()) {
				req.setAttribute("employeeVO", employeeVO); 
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/emp/addEmployee.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.�}�l�s�W��� ***************************************/
			EmployeeService empSvc = new EmployeeService();
			employeeVO = empSvc.addEmployee(job_id, emp_name, emp_status, emp_account, emp_password);

			/*************************** 3.�s�W����,�ǳ����(Send the Success view) ***********/
			String url = "/back_end/emp/AllEmployee.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); 
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.�����ШD�Ѽ� ***************************************/
			Integer emp_no = Integer.valueOf(req.getParameter("emp_no"));

			/*************************** 2.�}�l�R����� ***************************************/
			EmployeeService empSvc = new EmployeeService();
			empSvc.deleteEmployee(emp_no);

			/*************************** 3.�R������,�ǳ����(Send the Success view) ***********/
			String url = "/back_end/emp/AllEmployee.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
	}
}