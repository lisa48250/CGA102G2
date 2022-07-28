package com.news_post.controller;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.news_post.model.NewsPostService;

@WebServlet("/NewsPost_Reader")
@MultipartConfig
public class NewsPost_Reader extends HttpServlet { // 版本一
	private static final long serialVersionUID = 1L;
	
	
	public NewsPost_Reader() {
		
	}
	
	Connection con;
	public static final String theURL ="jdbc:mysql://localhost:3306/cga102_2?serverTimezone=Asia/Taipei";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		
		try {
			Statement stmt = con.createStatement();
			String id = req.getParameter("newsPostId");
			System.out.println(id);
			
			ResultSet rs = stmt.executeQuery("SELECT NEWS_PHOTO_FILE from NEWS_POST where NEWS_POST_ID = "+ id);
			
			if(rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("NEWS_PHOTO_FILE"));
				byte[] buf = new byte[in.available()];
				
				in.read(buf);
				out.write(buf);
				out.close();
				in.close();
			}else {
				InputStream in = getServletContext().getResourceAsStream("/newspost/images/tomcat.png");
				BufferedInputStream bf = new BufferedInputStream(in);
				byte[] buf = new byte[bf.available()];
				bf.read(buf);
				out.write(buf);
				out.close();
				bf.close();
			}
			rs.close();
			stmt.close();
		}catch(Exception e) {
			InputStream in = getServletContext()
					.getResourceAsStream("/images/withe.jpg");
			BufferedInputStream bf = new BufferedInputStream(in);
			byte[] buf = new byte[bf.available()];
			bf.read(buf);
			out.write(buf);
			out.close();
			bf.close();
			System.out.println(e);
		}
		
		
	}
	
	public void init() throws ServletException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(theURL, "root", "password");
		} catch (ClassNotFoundException e) {
			throw new UnavailableException("Couldn't load JdbcOdbcDriver");
		} catch (SQLException e) {
			throw new UnavailableException("Couldn't get db connection");
		}	
	}
	
	public void destroy() {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}	
	
}
