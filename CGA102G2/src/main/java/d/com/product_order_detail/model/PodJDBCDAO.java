package d.com.product_order_detail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.DestroyFailedException;
import javax.sql.DataSource;

import d.com.product_order_list.model.PolJDBCDAO;
import d.com.product_order_list.model.PolVO;
//import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Emp2;
import jdbc.util.CompositeQueryforMembers.jdbcUtil_CompositeQuery_Members;

public class PodJDBCDAO implements Product_order_detailDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CGA102_2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
//	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/CGA102_2?serverTimezone=Asia/Taipei";
//	// 記得修改database => CGA102_2
//	String userid = "root";
//	String passwd = "00000000";

	private static final String INSERT_STMT = "INSERT INTO PRODUCT_ORDER_DETAIL (product_id, member_id, product_amount, payment_method, order_status) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM PRODUCT_ORDER_DETAIL order by product_order_id";
	private static final String GET_ONE_STMT = "SELECT * FROM PRODUCT_ORDER_DETAIL where product_order_id = ?";
	private static final String DELETE = "DELETE FROM PRODUCT_ORDER_DETAIL where product_order_id = ?";
	private static final String UPDATE = "UPDATE PRODUCT_ORDER_DETAIL set product_amount=?, payment_method=?, order_status=? where product_order_id=?";
	private static final String GET_ALL_BY_MEMBER = "select * from PRODUCT_ORDER_DETAIL where member_id=?";
	private static final String GET_NEWEST_ORDER = "SELECT * FROM CGA102_2.PRODUCT_ORDER_DETAIL where to_days(product_order_date) = to_days(NOW()) ";
	private static final String GET_ORDER_FROM_YESTERDAY = "SELECT * FROM CGA102_2.PRODUCT_ORDER_DETAIL where to_days(NOW()) - to_days(PRODUCT_ORDER_DATE) = 1";
	private static final String GET_ORDER_FROM_7DAYS = "SELECT * FROM CGA102_2.PRODUCT_ORDER_DETAIL where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(PRODUCT_ORDER_DATE) order by product_order_date desc";
	
	
	@Override
	public void insert(Product_order_detailVO order) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, order.getProduct_id());
			pstmt.setInt(2, order.getMember_id());
			pstmt.setInt(3, order.getProduct_amount());
			pstmt.setInt(4, order.getPayment_method());
			pstmt.setInt(5, order.getOrder_status());

			pstmt.executeUpdate();

			// Handle any driver errors
		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		}
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		}
	}

	@Override
	public void update(Product_order_detailVO newOrder_detail, Integer order_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, newOrder_detail.getProduct_amount());
			pstmt.setInt(2, newOrder_detail.getPayment_method());
			pstmt.setInt(3, newOrder_detail.getOrder_status());

			pstmt.setInt(4, order_id);

			pstmt.executeUpdate();
			}

			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
//		}
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		}

	}

	@Override
	public void delete(Integer order_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, order_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		}
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		}

	}

	@Override
	public Product_order_detailVO findByPrimaryKey(Integer order_id) {
		Product_order_detailVO product_order_detail = new Product_order_detailVO();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, order_id);
//			pstmt.setInt(2, member_id);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				product_order_detail.setProduct_order_id(rs.getInt("product_order_id"));
				product_order_detail.setProduct_id(rs.getInt("product_id"));
				product_order_detail.setMember_id(rs.getInt("member_id"));
				product_order_detail.setProduct_order_date(rs.getDate("product_order_date"));
				product_order_detail.setProduct_amount(rs.getInt("product_amount"));
				product_order_detail.setPayment_method(rs.getInt("payment_method"));
				product_order_detail.setOrder_status(rs.getInt("order_status"));

			}

			// Handle any driver errors
		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		} 
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		}

		return product_order_detail;
	}

	@Override
	public List<Product_order_detailVO> getAll() {

		List<Product_order_detailVO> All_order_detail = new ArrayList<Product_order_detailVO>();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product_order_detailVO order_detail = new Product_order_detailVO();
				order_detail.setProduct_order_id(rs.getInt("product_order_id"));
				order_detail.setProduct_id(rs.getInt("product_id"));
				order_detail.setMember_id(rs.getInt("member_id"));
				order_detail.setProduct_order_date(rs.getDate("product_order_date"));
				order_detail.setProduct_amount(rs.getInt("product_amount"));
				order_detail.setPayment_method(rs.getInt("payment_method"));
				order_detail.setOrder_status(rs.getInt("order_status"));
				All_order_detail.add(order_detail);
			}

			// Handle any driver errors
		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		} 
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		}

		return All_order_detail;

	}

	
	public List<Product_order_detailVO> getOrderListByMemberId(Integer memberId) {
		List<Product_order_detailVO> All_order_detail = new ArrayList<Product_order_detailVO>();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_BY_MEMBER);
			pstmt.setInt(1, memberId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product_order_detailVO order_detail = new Product_order_detailVO();
				order_detail.setProduct_order_id(rs.getInt("product_order_id"));
				order_detail.setProduct_id(rs.getInt("product_id"));
				order_detail.setMember_id(rs.getInt("member_id"));
				order_detail.setProduct_order_date(rs.getDate("product_order_date"));
				order_detail.setProduct_amount(rs.getInt("product_amount"));
				order_detail.setPayment_method(rs.getInt("payment_method"));
				order_detail.setOrder_status(rs.getInt("order_status"));
				All_order_detail.add(order_detail);
			}

			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
		} 
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		}

		return All_order_detail;
	}

	public void insertToPol(Product_order_detailVO podVO, List<PolVO> PolVOlist) {
		Connection con = null;
		PreparedStatement pps = null;
		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);

			// 1●設定於 pstm.executeUpdate()之前
			con.setAutoCommit(false);

			// (新增訂單）
			String cols[] = { "PRODUCT_ORDER_ID" };
			pps = con.prepareStatement(INSERT_STMT, cols);
//			member_id, product_amount, payment_method, order_status
			pps.setInt(1,podVO.getProduct_id());
			pps.setInt(2,podVO.getMember_id());
			pps.setInt(3,podVO.getProduct_amount());
			pps.setInt(4,podVO.getPayment_method());
			pps.setInt(5,podVO.getOrder_status());
			Integer product_amounts = podVO.getProduct_amount();
			Integer productId = podVO.getProduct_id();
			pps.executeUpdate();
			// 掘取對應的訂單自增主鍵
			String product_order_Id = null;
			ResultSet rs = pps.getGeneratedKeys();
			if(rs.next()) {
				product_order_Id = rs.getString(1);
			}else {
				System.out.println("未取得AI");
			}
			rs.close();
			
			// 抓到id後 同時新增訂單明細表格
			PolJDBCDAO dao = new PolJDBCDAO();
			for(PolVO polVo : PolVOlist) {
				
				polVo.setProduct_id(productId);
				polVo.setProduct_order_id(new Integer(product_order_Id));
				polVo.setOrder_quantity(product_amounts);
				dao.insertForPodVO(polVo, con);
			}
			con.commit();
			con.setAutoCommit(true);
		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//		} 
		catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					System.err.print("Transaction is being ");
					System.err.println("rolled back-由-dept");
					
					con.rollback(); 
					
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. " + excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (pps != null) {
				try {
					pps.close();
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
		}
	}

	public List<Product_order_detailVO> getAll(Map<String, String[]> map){
		List<Product_order_detailVO> list = new ArrayList<Product_order_detailVO>();
		Product_order_detailVO podVO = null;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			
			con = ds.getConnection();
			String finalSQL = "select * from PRODUCT_ORDER_DETAIL "
		          + jdbcUtil_CompositeQuery_Members.get_WhereCondition(map)
		          + "order by product_order_id desc";
			pstmt = con.prepareStatement(finalSQL);
			System.out.println("●●finalSQL(by DAO) = "+finalSQL);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				podVO = new Product_order_detailVO();
				podVO.setProduct_order_id(rs.getInt("product_order_id"));
				podVO.setProduct_id(rs.getInt("product_id"));
				podVO.setMember_id(rs.getInt("member_id"));
				podVO.setProduct_order_date(rs.getDate("product_order_date"));
				podVO.setProduct_amount(rs.getInt("product_amount"));
				podVO.setPayment_method(rs.getInt("payment_method"));
				podVO.setOrder_status(rs.getInt("order_status"));
				
				list.add(podVO); // Store the row in the List
			}
	
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	
	} // 複合查詢
	
	public List<Product_order_detailVO> getAllFromToday() {
		List<Product_order_detailVO> All_order_detail = new ArrayList<Product_order_detailVO>();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_NEWEST_ORDER);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product_order_detailVO order_detail = new Product_order_detailVO();
				order_detail.setProduct_order_id(rs.getInt("product_order_id"));
				order_detail.setProduct_id(rs.getInt("product_id"));
				order_detail.setMember_id(rs.getInt("member_id"));
				order_detail.setProduct_order_date(rs.getDate("product_order_date"));
				order_detail.setProduct_amount(rs.getInt("product_amount"));
				order_detail.setPayment_method(rs.getInt("payment_method"));
				order_detail.setOrder_status(rs.getInt("order_status"));
				All_order_detail.add(order_detail);
			}

			// Handle any driver errors
		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		} 
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		}

		return All_order_detail;
	}
	
	public List<Product_order_detailVO> getAllFormYesterday() {
		List<Product_order_detailVO> All_order_detail = new ArrayList<Product_order_detailVO>();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ORDER_FROM_YESTERDAY);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product_order_detailVO order_detail = new Product_order_detailVO();
				order_detail.setProduct_order_id(rs.getInt("product_order_id"));
				order_detail.setProduct_id(rs.getInt("product_id"));
				order_detail.setMember_id(rs.getInt("member_id"));
				order_detail.setProduct_order_date(rs.getDate("product_order_date"));
				order_detail.setProduct_amount(rs.getInt("product_amount"));
				order_detail.setPayment_method(rs.getInt("payment_method"));
				order_detail.setOrder_status(rs.getInt("order_status"));
				All_order_detail.add(order_detail);
			}

			// Handle any driver errors
		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		} 
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		}

		return All_order_detail;
	}
	
	public List<Product_order_detailVO> getAllFrom7days() {
		List<Product_order_detailVO> All_order_detail = new ArrayList<Product_order_detailVO>();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ORDER_FROM_7DAYS);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product_order_detailVO order_detail = new Product_order_detailVO();
				order_detail.setProduct_order_id(rs.getInt("product_order_id"));
				order_detail.setProduct_id(rs.getInt("product_id"));
				order_detail.setMember_id(rs.getInt("member_id"));
				order_detail.setProduct_order_date(rs.getDate("product_order_date"));
				order_detail.setProduct_amount(rs.getInt("product_amount"));
				order_detail.setPayment_method(rs.getInt("payment_method"));
				order_detail.setOrder_status(rs.getInt("order_status"));
				All_order_detail.add(order_detail);
			}

			// Handle any driver errors
		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		} 
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
		}

		return All_order_detail;
	} 

	public static void main(String[] args) {
		PodJDBCDAO dao = new PodJDBCDAO();

//		新增
//		Product_order_detailVO order = new Product_order_detailVO();
//		order.setOrder_status(0);
//		order.setProduct_id(2);
//		order.setMember_id(2);
//		order.setPayment_method(1);
//		order.setProduct_amount(4);
//		dao.insert(order);

		// 修改
//		Product_order_detailVO order = new Product_order_detailVO();
//		order.setOrder_status(0);
//		order.setMember_id(2);
//		order.setPayment_method(1);
//		order.setProduct_amount(5);
//		dao.update(order, 72);

		// 刪除
//		Product_order_detailVO order_id = new Product_order_detailVO();
//		dao.delete(7);

		// find one
		Product_order_detailVO order = new Product_order_detailVO();
		order = dao.findByPrimaryKey(108);
		String order_detail = order.toString();
		System.out.println(order.getProduct_id());

		// find all in once
//		List<Product_order_detailVO> allOrder = dao.getAll();
//		for (Product_order_detailVO each_order_detail : allOrder) {
//			System.out.println(each_order_detail);
//		}
//		List<Product_order_detailVO> orders = dao.getOrderListByMemberId(1);
//		for (Product_order_detailVO each_order_detail : orders) {
//			System.out.println(each_order_detail);
//		}
		
		
		
//		Product_order_detailVO podVO = new Product_order_detailVO();
//		podVO.setMember_id(1);
//		podVO.setOrder_status(1);
//		podVO.setPayment_method(0);
//		podVO.setProduct_amount(100);
//		podVO.setProduct_id(3);
//		List<PolVO> polList = new ArrayList<PolVO>();
//		PolVO polvo = new PolVO();
//		polList.add(polvo);
//		dao.insertToPol(podVO, polList);
		
	}

}
