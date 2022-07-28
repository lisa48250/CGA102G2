package d.com.productpics.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;

//import com.mysql.cj.jdbc.Blob;

//import project.pics.vo.Product_picsVO;

public class Product_pics_DAO implements Product_pics_DAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	
	private static  DataSource ds;
	static {
		try {
			Context ctx = new javax.naming.InitialContext();
			try {
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CGA102_2");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

//	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = /* "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei"; */
//			"jdbc:mysql://localhost:3306/"
//					+ "CGA102_2?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
//	String userid = "root";
////	String passwd = "password";
//	String passwd = "00000000";

	private static final String INSERT_STMT = "INSERT INTO product_pics (product_id, product_photo) " + "VALUES (?, ?)";
	private static final String GET_ALL_STMT = "SELECT product_photo_id, product_id, product_photo "
			+ "FROM product_pics order by product_photo_id";
	private static final String GET_ONE_STMT = "SELECT product_photo_id, product_id, product_photo "
			+ "FROM product_pics where product_photo_id = ?";
	private static final String DELETE = "DELETE FROM product_pics where product_photo_id = ?";
	private static final String UPDATE = "UPDATE product_pics set product_id = ?, product_photo = ? "
			+ "where product_photo_id = ?";
	private static final String GET_ALLPIC_STMT = "select product_photo_id, product_photo from product_pics where product_id = ?";
	
	
	@Override
	public void insert(Product_pics_VO product_picsVO) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

//			"INSERT INTO product_pics (product_id, product_phto) "
//			+ "VALUES (?, ?)";
			pstmt.setInt(1, product_picsVO.getProduct_id());
			pstmt.setBytes(2, product_picsVO.getProduct_photo());
			pstmt.executeUpdate();
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
		} 
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public void update(Product_pics_VO product_picsVO) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;

		try  {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

//			"UPDATE product_pics set product_id = ?, product_photo = ? "
//			+ "where product_photo_id = ?";
			pstmt.setInt(1, product_picsVO.getProduct_id());
			pstmt.setBytes(2, product_picsVO.getProduct_photo());
			pstmt.setInt(3, product_picsVO.getProduct_photo_id());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} 
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
			  finally { if (pstmt != null) { try { pstmt.close(); } catch (SQLException se)
			  { se.printStackTrace(System.err); } } if (con != null) { try { con.close(); }
			  catch (Exception e) { e.printStackTrace(System.err); } } }
			 

	}

	@Override
	public void delete(Integer product_photo_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
//			"DELETE FROM product_pics where product_photo_id = ?";

			pstmt.setInt(1, product_photo_id);
			pstmt.executeUpdate();

			// Handle any driver errors
		} 
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} 
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
			  finally { if (pstmt != null) { try { pstmt.close(); } catch (SQLException se)
			  { se.printStackTrace(System.err); } } if (con != null) { try { con.close(); }
			 catch (Exception e) { e.printStackTrace(System.err); } } }
			 

	}

	@Override
	public Product_pics_VO findByPrimarykey(Integer product_photo_id) {
		// TODO Auto-generated method stub

		Product_pics_VO product_picsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

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
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} 
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
			  finally { if (rs != null) { try { rs.close(); } catch (SQLException se) {
			  se.printStackTrace(System.err); } } if (pstmt != null) { try { pstmt.close();
			  } catch (SQLException se) { se.printStackTrace(System.err); } } if (con !=
			  null) { try { con.close(); } catch (Exception e) {
			  e.printStackTrace(System.err); } } }
			 
		return product_picsVO;
	}

	@Override
	public List<Product_pics_VO> getAll() {
		// TODO Auto-generated method stub
		List<Product_pics_VO> list = new ArrayList<Product_pics_VO>();
//		Product_picsVO product_picsVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
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
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} 
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
			  finally { if (rs != null) { try { rs.close(); } catch (SQLException se) {
			  se.printStackTrace(System.err); } } if (pstmt != null) { try { pstmt.close();
			  } catch (SQLException se) { se.printStackTrace(System.err); } } if (con !=
			  null) { try { con.close(); } catch (Exception e) {
			  e.printStackTrace(System.err); } } }
			 
		return list;
	}

	
	public List<Product_pics_VO> getAllbyId(Integer product_id){
		List<Product_pics_VO> list = new ArrayList<Product_pics_VO>();
//		Product_picsVO product_picsVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement(GET_ALLPIC_STMT);
			pstmt.setInt(1, product_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Product_pics_VO product_picsVO = new Product_pics_VO();
				product_picsVO.setProduct_photo_id(rs.getInt("product_photo_id"));
//				product_picsVO.setProduct_id(rs.getInt("product_id"));
				product_picsVO.setProduct_photo(rs.getBytes("product_photo"));

				list.add(product_picsVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} 
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
			  finally { if (rs != null) { try { rs.close(); } catch (SQLException se) {
			  se.printStackTrace(System.err); } } if (pstmt != null) { try { pstmt.close();
			  } catch (SQLException se) { se.printStackTrace(System.err); } } if (con !=
			  null) { try { con.close(); } catch (Exception e) {
			  e.printStackTrace(System.err); } } }
		return list;
	}
	
	

	public static void main(String[] args) throws IOException {
		Product_pics_DAO dao = new Product_pics_DAO();

//		FileInputStream fi = new FileInputStream(
//				"/Users/tgec192635/Desktop/CGA102_webAPP/eclips_wtp_workspace1/CGA102G2/src/main/webapp/images/沐浴露 - 3.jpg");
//
//		byte[] pics = new byte[fi.available()];
////				fi.close();
//		fi.read(pics);
//		
//		Product_pics_VO ppVO = new Product_pics_VO();
//		ppVO.setProduct_id(3);
//		ppVO.setProduct_photo(pics);
//
//		dao.insert(ppVO);
		
		
		
//		System.out.println(dao.getAllbyId(4));
//		List<Product_pics_VO> ppicsVO = dao.getAllbyId(4);
//		for(Product_pics_VO vo : ppicsVO) {
//			System.out.println(vo.getProduct_photo_id());
//		}

	}
}
