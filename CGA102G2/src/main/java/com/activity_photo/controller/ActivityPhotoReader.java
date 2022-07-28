package com.activity_photo.controller;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ActivityPhotoReader", urlPatterns = "/activity_photo/ActivityPhotoReader.do")
@MultipartConfig
public class ActivityPhotoReader extends HttpServlet {
	private static final long serialVersionUID = -5274029904676134821L;
		
	public ActivityPhotoReader() {
		super();
	}

	Connection con;
	public static final String URL ="jdbc:mysql://localhost:3306/cga102_2?serverTimezone=Asia/Taipei";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		res.setContentType("image/gif");
		ServletOutputStream sos = res.getOutputStream();
		
		try {
			Statement stmt = con.createStatement();
			String activity_photo_ID = req.getParameter("activity_photo_ID");
			System.out.println("activity_photo_ID = " + activity_photo_ID);
			
			ResultSet rs = stmt.executeQuery("select ACTIVITY_PHOTO from ACTIVITY_PHOTO where ACTIVITY_PHOTO_ID = "+ activity_photo_ID );
			
			if (rs.next()) {
				
				BufferedInputStream bis = new BufferedInputStream(rs.getBinaryStream("ACTIVITY_PHOTO"));
				byte[] pic = new byte[bis.available()];
				
				bis.read(pic);
				sos.write(pic);
				sos.close();
				bis.close();
				
			} else {
				
				InputStream is = getServletContext().getResourceAsStream("/images/none3.jpg");
				BufferedInputStream bis = new BufferedInputStream(is);
				byte[] pic = new byte[bis.available()];
				bis.read(pic);
				sos.write(pic);
				sos.close();
				bis.close();
				is.close();
			}
			
			rs.close();
			stmt.close();
			
		} catch (Exception e) {
			
//			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			InputStream is = getServletContext().getResourceAsStream("/images/null2.jpg");
			BufferedInputStream bis = new BufferedInputStream(is);
			byte[] pic = new byte[bis.available()];
			bis.read(pic);
			sos.write(pic);
			sos.close();
			bis.close();
			System.out.println(e);
		}		
		
	}
	
	public void init() throws ServletException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "root", "password");
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
