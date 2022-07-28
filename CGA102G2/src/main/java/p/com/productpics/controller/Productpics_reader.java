package p.com.productpics.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
//import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/prodpics_reader")
public class Productpics_reader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	Connection con;


    public Productpics_reader() {
        super();

    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();

//		ResultSet rs = null;
		
		try (/*Connection con = ds.getConnection();*/
				PreparedStatement pstmt = con.prepareStatement("SELECT product_photo FROM product_pics WHERE product_photo_id = ? ");)
		{
			String id = req.getParameter("product_photo_id");
			pstmt.setInt(1, Integer.valueOf(id));
			ResultSet rs = pstmt.executeQuery();



			if (rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("product_photo"));

				byte[] buf = new byte[in.available()];
				int len;
				while ((len = in.read(buf)) != -1) {
					out.write(buf, 0, len);
				}
				
				in.read(buf);
				in.close();
				rs.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	
	}

	public void init() throws ServletException {
		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CGA102_2");
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	public void destroy() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
