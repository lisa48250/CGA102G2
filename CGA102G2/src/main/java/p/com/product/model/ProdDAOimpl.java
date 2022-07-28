package p.com.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ProdDAOimpl implements ProdDAO {
	private static final String Get_All_Prod_stmt = "SELECT p.product_id, p.product_name, p.product_price, pic.product_photo, pc.product_category_name, p.product_describtion "
			+ "FROM product as p "
			+ "JOIN product_pics as pic on p.product_id = pic.product_id "
			+ "JOIN product_category as pc on p.product_category_id = pc.product_category_id ";
	
//	private static final String Get_All_Prod_stmt = "SELECT p.product_id, p.product_name, p.product_price, pic.product_photo, pc.product_category_name, p.product_describtion "
//	+ "FROM product as p "
//	+ "LEFT JOIN product_pics as pic on p.product_id = pic.product_id "
//	+ "LEFT JOIN product_category as pc on p.product_id = pc.product_category_id ";
	
// ---------------------
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = /*"jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei";*/
	               "jdbc:mysql://localhost:3306/"
	               + "CGA102_2?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
// ----------------------	
	
	@Override
	public List<ProdVO> findAllProd() {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProdVO> list= new ArrayList<>();
		ProdVO prodvo = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt = conn.prepareStatement(Get_All_Prod_stmt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				prodvo = new ProdVO();
				prodvo.setProduct_id(rs.getInt("product_id"));

				prodvo.setProduct_name(rs.getString("product_name"));
//				prodvo.setProduct_photo(rs.getBytes("product_photo"));
				prodvo.setProduct_price(rs.getInt("product_price"));
//				prodvo.setProduct_category_name(rs.getString("product_category_name"));
				prodvo.setProductPhotoStr(Base64.getEncoder().encodeToString(rs.getBytes("product_photo")));
				list.add(prodvo);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		return list;
	}

}
