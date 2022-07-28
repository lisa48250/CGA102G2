package d.com.product.model_controller;

import java.io.BufferedInputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
//import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/Product_reader")
public class Product_reader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	public static final String theURL = "jdbc:mysql://localhost:3306/CGA102_2?serverTimezone=Asia/Taipei";

	public Product_reader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		try {
			Statement stmt = con.createStatement();

			String product_id = req.getParameter("product_id");
			ResultSet rs = stmt.executeQuery("SELECT product_photo FROM PRODUCT_PICS WHERE product_id = " + product_id);

			

//			ResultSet rs = stmt.executeQuery("SELECT product_photo FROM room_type WHERE product_photo_id = " + id);

			if (rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("product_photo"));

				byte[] buf = new byte[in.available()];
//				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;
//				while ((len = in.read(buf)) != -1) {
//					out.write(buf, 0, len);
//				}

				in.read(buf);
				out.write(buf);
				out.close();
				in.close();
				
			} /*
				 * else { // res.sendError(HttpServletResponse.SC_NOT_FOUND); InputStream in =
				 * getServletContext() .getResourceAsStream(
				 * "/productpics/images/blogger-custom-domain-404-error.jpeg");
				 * BufferedInputStream bf = new BufferedInputStream(in); byte[] buf = new
				 * byte[bf.available()]; bf.read(buf); out.write(buf); out.close(); bf.close();
				 * 
				 * }
				 */
//			rs.close();
//			stmt.close();
		} catch (Exception e) {
//			InputStream in = getServletContext()
//					.getResourceAsStream("/productpics/images/blogger-custom-domain-404-error.jpeg");
//			BufferedInputStream bf = new BufferedInputStream(in);
//			byte[] buf = new byte[bf.available()];
//			bf.read(buf);
//			out.write(buf);
//			out.close();
//			bf.close();
			System.out.println(e);
		}

	}

	public void init() throws ServletException {
		// 改用connection pools
//		try {
////			Context ctx = new javax.naming.InitialContext();
////			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB1");
////			con = ds.getConnection();
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
//		try {
//			if (con != null)
//				con.close();
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
