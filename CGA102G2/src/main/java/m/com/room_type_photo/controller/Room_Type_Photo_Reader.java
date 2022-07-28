package m.com.room_type_photo.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Room_Type_Photo_Reader")
public class Room_Type_Photo_Reader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Room_Type_Photo_Reader() {
        super();
      
    }

	
    Connection con;
	public static final String theURL = "jdbc:mysql://localhost:3306/CGA102_2?serverTimezone=Asia/Taipei";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();

		try {
			Statement stmt = con.createStatement();
			String id = req.getParameter("id");
			System.out.println(id);
		

			ResultSet rs = stmt.executeQuery("SELECT room_type_photo FROM room_type_photo WHERE room_type_photo_id = " + id);
			if (rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("room_type_photo"));	
				byte[] buf = new byte[in.available()]; // 4K buffer
				
				in.read(buf);
				out.write(buf);
				out.close();
				in.close();

			} 
//			else {
//				res.sendError(HttpServletResponse.SC_NOT_FOUND);
//				InputStream in = getServletContext()
//						.getResourceAsStream("images/blogger-custom-domain-404-error.jpeg");
//				BufferedInputStream bf = new BufferedInputStream(in);
//				byte[] buf = new byte[bf.available()];
//				bf.read(buf);
//				out.write(buf);
//				out.close();
//				bf.close();
//
//			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			InputStream in = getServletContext()
					.getResourceAsStream("/images/截圖 2022-07-08 下午4.54.10.png");
			BufferedInputStream bf = new BufferedInputStream(in);
			byte[] buf = new byte[bf.available()];
			bf.read(buf);
			out.write(buf);
			out.close();
			bf.close();
			System.out.println(e);
		}
		
	}

	public void init() throws ServletException {
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
