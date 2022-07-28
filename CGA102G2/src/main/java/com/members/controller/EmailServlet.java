package com.members.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Element;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.members.model.MemberService;
import com.members.model.MemberVO;


/**
 * Servlet implementation class MemberForgetPWDServlet
 */
@WebServlet("/Email_Servlet")
public class EmailServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
//  response.getWriter().append("Served at: ").append(request.getContextPath());
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
  
  //獲取前端傳過來訊息
  String usrEmail = request.getParameter("usrEmail");  //usrEmail 這個是input的name到時候自己取
    
  MemberService memsv = new MemberService();
        MemberVO memVOs = memsv.findPasswordEmail(usrEmail); //usrEmail 這個是input的name到時候自己取
            if (memVOs == null) {
             request.setAttribute("errorMsgs", "查無此信箱!");
             RequestDispatcher failureView = request
       .getRequestDispatcher("/front_end/member/forgetpassword.jsp");
       failureView.forward(request, response);
       return; //程式中斷
            }else {
             memsv.sendMail(usrEmail);
             request.setAttribute("errorMsgs", "已寄出，請查閱信箱!");
             RequestDispatcher failureView = request
       .getRequestDispatcher("/front_end/member/forgetpassword.jsp");
       failureView.forward(request, response);
       return; //程式中斷
            }
        }
	}
//  Map<String, String> map= new HashMap<>();
//  map.put("stat", "success");
//  System.out.println("123");
//  MemService memservice = new MemService();
//  memservice.sendMail(usrEmail);
//  try(PrintWriter pw = response.getWriter()){
//   pw.print(gson.toJson(map));
//  } catch(Exception e){
//   e.printStackTrace();
   
//  }
//  String url = "/front-end/mem/index.jsp";
//  RequestDispatcher successView = request.getRequestDispatcher(url); // 修改成功後,轉交index.jsp
//  successView.forward(request, response);