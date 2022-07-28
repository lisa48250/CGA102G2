package com.members.controller;

import java.io.*;
import java.sql.Blob;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import com.members.model.*;

@WebServlet("/Member_Servlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)

public class Member_Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		// 註冊
		if ("register".equals(action)) { // 來自Registered_Member的請求

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			String member_email = req.getParameter("member_email");
			String emailReg = "[A-Za-z0-9+_.-]+@(.+)$";
			if (member_email == null || member_email.trim().length() == 0) {
				errorMsgs.add("信箱: 請勿空白");
			} else if (!member_email.trim().matches(emailReg)) {
				errorMsgs.add("信箱帳號: 只能是英文字母、數字");
			}

			MemberService membersvc = new MemberService();
			List<MemberVO> memberVOs = membersvc.getAll();
			for (MemberVO memberVO : memberVOs) {
				if (member_email.equals(memberVO.getMember_email())) {
					errorMsgs.add("信箱已被註冊過了");
				}

			}

			String member_password = req.getParameter("member_password");
			if (member_password == null || member_password.trim().length() == 0) {
				errorMsgs.add("密碼請勿空白");
			}

			String member_name = req.getParameter("member_name");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (member_name == null || member_name.trim().length() == 0) {
				errorMsgs.add("姓名: 請勿空白");
			} else if (!member_name.trim().matches(enameReg)) {
				errorMsgs.add("會員姓名: 只能是中、英文字母、數字");
			}

			String member_phone = req.getParameter("member_phone");
			if (member_phone == null || member_phone.trim().length() == 0) {
				errorMsgs.add("會員電話請勿空白");
			}

			String member_address = req.getParameter("member_address");
			
			if (member_address == null || member_address.trim().length() == 0) {
				errorMsgs.add("地址: 請勿空白");
			} 

			String city = req.getParameter("county");
			String town = req.getParameter("district");
			String address = city + town + member_address;

			MemberVO memberVO = new MemberVO();
			memberVO.setMember_email(member_email);
			memberVO.setMember_password(member_password);
			memberVO.setMember_name(member_name);
			memberVO.setMember_phone(member_phone);
			memberVO.setMember_address(address);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memberVO", memberVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/member/Registered_Member.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始查詢資料 ***************************************/
			MemberService memberSvc = new MemberService();
			memberVO = memberSvc.register(member_email, member_password, member_name, member_phone, address);

			/************************** 3.查詢完成,準備轉交(Send the Success view) ***********/
			String url = "/front_end/member/MemberLogin.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/***************************
			 * 1.�����ШD�Ѽ� - ��J�榡�����~�B�z
			 **********************/

			String str = req.getParameter("member_id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("會員id請勿為空");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/member/select_member.jsp");
				failureView.forward(req, res);
				return;//
			}

			Integer member_id = null;
			try {
				member_id = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("id不能為空");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/member/select_member.jsp");
				failureView.forward(req, res);
				return;//

			}

			/***************************
			 * 2.�}�l�d�߸��
			 *****************************************/
			MemberService memberSvc = new MemberService();
			MemberVO memberVO = memberSvc.getOneMember(member_id);
			if (memberVO == null) {
				errorMsgs.add("�d�L���");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/member/select_Member.jsp");
				failureView.forward(req, res);
				return;//
			}

			/*************************** 準備轉交 *************/
			req.setAttribute("memberVO", memberVO);
			String url = "/back_end/member/listOneMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer member_id = Integer.valueOf(req.getParameter("member_id"));

			/*************************** 2.開始查詢資料 ****************************************/

//			InputStream in = req.getPart("pic").getInputStream();
//			byte[] member_pic = new byte[in.available()];
//			in.read(member_pic);
//			in.close();			

			MemberService memberSvc = new MemberService();
			MemberVO memberVO = memberSvc.getOneMember(member_id);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("memberVO", memberVO); // 資料庫取出的empVO物件,存入req
			String url = "/front_end/protect/Member_Data_Update.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 Member_Data_Update.jsp
			successView.forward(req, res);

		}

//修改
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
				List<String> errorMsgs = new LinkedList<String>();
				System.out.println("近來了 確認修改");
				req.setAttribute("errorMsgs", errorMsgs);
				
				/*************************** 1.接收請求參數 **********************/
				Integer member_id = Integer.valueOf(req.getParameter("member_id").trim());
				System.out.println(member_id);

				String member_name = req.getParameter("member_name");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (member_name == null || member_name.trim().length() == 0) {
					errorMsgs.add("會員姓名: 請勿空白");
				} else if (!member_name.trim().matches(enameReg)) {
					errorMsgs.add("會員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				String member_phone = req.getParameter("member_phone");
				if (member_phone == null || member_phone.trim().length() == 0) {
					errorMsgs.add("電話請勿空白");
				}

				String member_address = req.getParameter("member_address");
				if (member_address == null || member_address.trim().length() == 0) {
					errorMsgs.add("會員地址: 請勿空白");
				} else if (!member_address.trim().matches(enameReg)) {
					errorMsgs.add("會員地址: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				String member_password = req.getParameter("member_password");
				if (member_password == null || member_password.trim().length() == 0) {
					errorMsgs.add("密碼請勿空白");
				}

				MemberVO memberVO = new MemberVO();
				memberVO.setMember_id(member_id);
				memberVO.setMember_password(member_password);
				memberVO.setMember_name(member_name);
				memberVO.setMember_phone(member_phone);
				memberVO.setMember_address(member_address);

				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberVO", memberVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front_end/protect/Member_Data_Update.jsp");
					failureView.forward(req, res);
					return; //
				}

//			/*************************** 2.開始更新資料 *****************************************/
				InputStream in = req.getPart("pic").getInputStream();
				byte[] pics = new byte[in.available()];
				in.read(pics);
				in.close();
				System.out.println(pics);
				
				
				MemberService memberSvc = new MemberService();
				memberSvc.updatePics(pics, member_id);
				
				memberVO = memberSvc.updateMember(member_id, member_password, member_name, member_phone,
						member_address);
				

				memberVO = memberSvc.getOneMember(member_id); // 把更新的內容 存到新的session 更新session
				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/

				HttpSession session = req.getSession();
				session.setAttribute("memberVO", memberVO);
				req.setAttribute("memberVO", memberVO);
				// 先把它存在session裡

				String url = "/front_end/protect/Member_Data.jsp"; // 按了確認修改後 轉交給會員資料頁面
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
			}
		

//		if ("update_back_end".equals(action)) { // 來自update_emp_input.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//		
//			req.setAttribute("errorMsgs", errorMsgs);
//
////			/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
//			Integer member_id = Integer.valueOf(req.getParameter("member_id").trim());
//			System.out.println(member_id);
//			
//			String member_email = req.getParameter("member_email");
//
//			String member_password = req.getParameter("member_password");
//			
//			String member_name = req.getParameter("member_name");
//			
//			String member_phone = req.getParameter("member_phone");
//			
//			String member_address = req.getParameter("member_address");
//			
//			String str = req.getParameter("member_status").trim();
//			if (str == null || str.trim().length() == 0) {
//				errorMsgs.add("�|�����A�ФŪť�");
//			}
//			Integer member_status = null;
//			try {
//				member_status = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMsgs.add("�|�����A�����T");
//			}
//
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/member/addMember.jsp"); // �Y¾��s���ťթΤ����T
//																									
//				failureView.forward(req, res);
//				return;
//			}
//
//			MemberVO memberVO = new MemberVO();
//			memberVO.setMember_id(member_id);
//			memberVO.setMember_email(member_email);
//			memberVO.setMember_password(member_password);
//			memberVO.setMember_name(member_name);
//			memberVO.setMember_phone(member_phone);
//			memberVO.setMember_address(member_address);
//			memberVO.setMember_status(member_status);
//
//			if (!errorMsgs.isEmpty()) {
//				req.setAttribute("memberVO", memberVO); 
//				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/member/update_member_input.jsp");
//				failureView.forward(req, res);
//				return;
//			}
//
////			/*************************** 2.�}�l�ק��� *****************************************/
//			MemberService memberSvc = new MemberService();
//			memberVO = memberSvc.updateMember(member_id, member_email, member_password, member_name, member_phone,
//					member_address, member_status);
//
//			/*************************** 3.�ק粒��,�ǳ����(Send the Success view) *************/
//			req.setAttribute("memberVO", memberVO); 
//			String url = "/back_end/member/listOneMember.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); 
//			successView.forward(req, res);
//		}

		if ("insert".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			/***********************
			 * 1.�����ШD�Ѽ� - ��J�榡�����~�B�z
			 *************************/

//			Member_Servlet msrv = new Member_Servlet();
//			Blob pic1 = null;
//			
//			if(req.getPart("pic1").getSize() !=0) {
//				pic1 = msrv.insertPicToDB(req.getPart("pic1"));
//			}

			String member_email = req.getParameter("member_email");
			if (member_email == null || member_email.trim().length() == 0) {
				errorMsgs.add("會員信箱請勿空白");
			}

			String member_password = req.getParameter("member_password");
			if (member_password == null || member_password.trim().length() == 0) {
				errorMsgs.add("密碼請勿空白");
			}

			String member_name = req.getParameter("member_name");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (member_name == null || member_name.trim().length() == 0) {
				errorMsgs.add("姓名: 請勿空白");
			} else if (!member_name.trim().matches(enameReg)) {
				errorMsgs.add("會員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String member_phone = req.getParameter("member_phone");
			if (member_phone == null || member_phone.trim().length() == 0) {
				errorMsgs.add("電話請勿空白");
			}

			String member_address = req.getParameter("member_address");
			if (member_address == null || member_address.trim().length() == 0) {
				errorMsgs.add("地址請勿空白");
			}

			MemberVO memberVO = new MemberVO();
			memberVO.setMember_email(member_email);
			memberVO.setMember_password(member_password);
			memberVO.setMember_name(member_name);
			memberVO.setMember_phone(member_phone);
			memberVO.setMember_address(member_address);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memberVO", memberVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/back_end/member/addMember.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始查詢資料 ***************************************/
			MemberService memberSvc = new MemberService();
			memberVO = memberSvc.addMember(member_email, member_password, member_name, member_phone, member_address);

			/************************** 3.查詢完成,準備轉交(Send the Success view) ***********/
			String url = "/back_end/member/listAllMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("delete".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/***************************
			 * 1.�����ШD�Ѽ�
			 ***************************************/
			Integer member_id = Integer.valueOf(req.getParameter("member_id"));

			/***************************
			 * 2.�}�l�R�����
			 ***************************************/
			MemberService memberSvc = new MemberService();
			memberSvc.deleteMember(member_id);

			/***************************
			 * 3.�R������,�ǳ����(Send the Success view)
			 ***********/
			String url = "/back_end/member/AllMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
	}
}