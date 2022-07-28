package p.com.productcategory.model;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//import com.product.model.ProductVO;

//import project.category.vo.Product_categoryVO;

public class Product_category_DAO implements Product_category_DAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CGA102_2");
//			ds = (DataSource) ctx.lookup("java:comp/env/CGA102_2");
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB1");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT =
			"INSERT INTO product_category (product_category_name, product_category_detail) "
			+ "VALUES (?, ?)";
	private static final String GET_ALL_STMT =
			"SELECT product_category_id, product_category_name, product_category_detail "
			+ "FROM product_category order by product_category_id";
	private static final String GET_ONE_STMT =
			"SELECT product_category_id, product_category_name, product_category_detail "
			+ "FROM product_category where product_category_id = ?";
	private static final String DELETE =
			"DELETE FROM product_category where product_category_id = ?";
	private static final String UPDATE =
			"UPDATE product_category set product_category_name = ?, product_category_detail = ? "
			+ "where product_category_id = ?";

	
	@Override
	public void insert(Product_category_VO product_categoryVO) {
		// TODO Auto-generated method stub

//		Connection con = null;
//		PreparedStatement pstmt = null;
		String col[] = {"product_category_id"};
		
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_STMT, col);)
		{
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(INSERT_STMT);

//			"INSERT INTO product_category (product_category_name, product_category_detail) "
//			+ "VALUES (?, ?)";
			pstmt.setString(1, product_categoryVO.getProduct_category_name());
			pstmt.setString(2, product_categoryVO.getProduct_category_detail());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			product_categoryVO.setProduct_category_id(rs.getInt(1));
			
			
//int pk = pstmt.executeUpdate();
//System.out.println(pk);
//System.out.println(); //(product_categoryVO)
//ResultSet kp =  pstmt.getGeneratedKeys();
//kp.next(); Integer ck = kp.getInt(1);
//System.out.println(ck);
//product_categoryVO.setProduct_category_id(ck);


			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} /*finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		} */

	}

	@Override
	public void update(Product_category_VO product_categoryVO) {
		// TODO Auto-generated method stub


		
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE);) {

//			"UPDATE product set product_category_name = ?, product_category_detail = ? "
//			+ "where pproduct_category_id = ?";
			pstmt.setString(1, product_categoryVO.getProduct_category_name());
			pstmt.setString(2, product_categoryVO.getProduct_category_detail());
			pstmt.setInt(3, product_categoryVO.getProduct_category_id());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage()); }
			// Clean up JDBC resources
		
//		/*finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}*/
		

	}

	@Override
	public void delete(Integer product_category_id) {
		// TODO Auto-generated method stub

//		Connection con = null;
//		PreparedStatement pstmt = null;

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE);) {

//			pstmt = con.prepareStatement(DELETE);

//			"DELETE FROM product where product_category_id = ?";
			pstmt.setInt(1, product_category_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} /*finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		} */

	}

	@Override
	public Product_category_VO findByPrimarykey(Integer product_category_id) {
		// TODO Auto-generated method stub

		Product_category_VO product_categoryVO = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;

		try  (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT);
				/*ResultSet rs = null;*/) {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, product_category_id);

			ResultSet rs = pstmt.executeQuery();

//			"SELECT product_category_id, product_category_name, product_category_detail "
//			+ "FROM product where product_category_id = ?";
			
			while (rs.next()) {
				
				product_categoryVO = new Product_category_VO();
				product_categoryVO.setProduct_category_id(rs.getInt("product_category_id"));
				product_categoryVO.setProduct_category_name(rs.getString("Product_category_name"));
				product_categoryVO.setProduct_category_detail(rs.getString("Product_category_detail"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} /*finally {
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
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}*/
		return product_categoryVO;
	}

	@Override
	public List<Product_category_VO> getAll() {
		// TODO Auto-generated method stub
		List<Product_category_VO> list = new ArrayList<Product_category_VO>();
		Product_category_VO product_categoryVO = null;

//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);){
//			con = ds.getConnection();

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(GET_ALL_STMT);
			ResultSet rs = pstmt.executeQuery();

//			private static final String GET_ALL_STMT =
//					"SELECT product_category_id, product_category_name, product_category_detail "
//					+ "FROM product order by product_category_id";			
			
			while (rs.next()) {		//Product_categoryVO.java		
				product_categoryVO = new Product_category_VO();
				product_categoryVO.setProduct_category_id(rs.getInt("product_category_id"));
				product_categoryVO.setProduct_category_name(rs.getString("product_category_name"));
				product_categoryVO.setProduct_category_detail(rs.getString("product_category_detail"));

				list.add(product_categoryVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} /*finally {
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
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}*/
		return list;
	}

}
