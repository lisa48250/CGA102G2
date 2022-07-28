package p.com.productpics.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//import project.pics.vo.Product_picsVO;

public class Product_pics_DAO implements Product_pics_DAO_interface {

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
			"INSERT INTO product_pics (product_id, product_photo) "
			+ "VALUES (?, ?)";
	private static final String GET_ALL_STMT =
			"SELECT product_photo_id, product_id, product_photo "
			+ "FROM product_pics order by product_photo_id";
	private static final String GET_ONE_STMT =
			"SELECT product_photo_id, product_id, product_photo "
			+ "FROM product_pics where product_photo_id = ?";
	private static final String DELETE =
			"DELETE FROM product_pics where product_photo_id = ?";
	private static final String UPDATE =
			"UPDATE product_pics set product_id = ?, product_photo = ? "
			+ "where product_photo_id = ?";
	private static final String GET_PRODUCT_ID_STMT =
			"SELECT product_photo_id, product_id, product_photo "
			+ "FROM product_pics where product_id = ?";
	
	
	@Override
	public List<Product_pics_VO> findByProductID(Integer product_id) {
		List<Product_pics_VO> list = new ArrayList<Product_pics_VO>();
//		Product_pics_VO product_pics_VO;
		ResultSet rs = null;

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_PRODUCT_ID_STMT);)
		{
			pstmt.setInt(1, product_id);

			rs = pstmt.executeQuery();
			


			while (rs.next()) {		
				
				Product_pics_VO product_picsVO = new Product_pics_VO();
				product_picsVO.setProduct_photo_id(rs.getInt("product_photo_id"));
				product_picsVO.setProduct_id(rs.getInt("product_id"));
				product_picsVO.setProduct_photo(rs.getBytes("product_photo"));
				
				list.add(product_picsVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		}
		return list;
	}

	@Override
	public void insert(Product_pics_VO product_picsVO) {
		// TODO Auto-generated method stub

//		Connection con = null;
//		PreparedStatement pstmt = null;
		String col[] = {"product_photo_id"};
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_STMT, col);)
		{

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(INSERT_STMT);

//			"INSERT INTO product_pics (product_id, product_phto) "
//			+ "VALUES (?, ?)";
			pstmt.setInt(1, product_picsVO.getProduct_id());
			pstmt.setBytes(2, product_picsVO.getProduct_photo());
			pstmt.executeUpdate();
			// 從MySQL取得auto increment PK
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			product_picsVO.setProduct_photo_id(rs.getInt(1));
			
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
		}*/

	}

	@Override
	public void update(Product_pics_VO product_picsVO) {
		// TODO Auto-generated method stub

//		Connection con = null;
//		PreparedStatement pstmt = null;

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE);)
		{

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(UPDATE);

//			"UPDATE product_pics set product_id = ?, product_photo = ? "
//			+ "where product_photo_id = ?";
			pstmt.setInt(1, product_picsVO.getProduct_id());
			pstmt.setBytes(2, product_picsVO.getProduct_photo());
			pstmt.setInt(3, product_picsVO.getProduct_photo_id());

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
		}*/

	}

	@Override
	public void delete(Integer product_photo_id) {

//		Connection con = null;
//		PreparedStatement pstmt = null;

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE);)
		{

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(DELETE);
//			"DELETE FROM product_pics where product_photo_id = ?";
			
			pstmt.setInt(1, product_photo_id);
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
		}*/

	}

	@Override
	public Product_pics_VO findByPrimarykey(Integer product_photo_id) {
		// TODO Auto-generated method stub

		Product_pics_VO product_picsVO = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT);)
		{

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, product_photo_id);

			rs = pstmt.executeQuery();

//			"SELECT product_category_id, product_category_name, product_category_detail "
//			+ "FROM product where product_category_id = ?";
			
			while (rs.next()) {
				
				product_picsVO = new Product_pics_VO();
				product_picsVO.setProduct_id(rs.getInt("product_id"));
				product_picsVO.setProduct_photo_id(rs.getInt("product_photo_id"));
				product_picsVO.setProduct_photo(rs.getBytes("product_photo"));
//				product_picsVO.setProduct_photo(rs.getByte(""));
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
		return product_picsVO;
	}

	@Override
	public List<Product_pics_VO> getAll() {
		List<Product_pics_VO> list = new ArrayList<Product_pics_VO>();
		ResultSet rs = null;

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);)
		{
			rs = pstmt.executeQuery();
			


			while (rs.next()) {		
				
				Product_pics_VO product_picsVO = new Product_pics_VO();
				product_picsVO.setProduct_photo_id(rs.getInt("product_photo_id"));
				product_picsVO.setProduct_id(rs.getInt("product_id"));
				product_picsVO.setProduct_photo(rs.getBytes("product_photo"));
				
				list.add(product_picsVO); // Store the row in the list
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
