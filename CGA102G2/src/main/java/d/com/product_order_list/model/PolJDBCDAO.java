package d.com.product_order_list.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class PolJDBCDAO implements PolDAO_interface {
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CGA102_2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CGA102_2?serverTimezone=Asia/Taipei";
	// 記得修改database => CGA102_2
	String userid = "root";
	String passwd = "00000000";

	private static final String INSERT_STMT = "INSERT INTO product_order_list (product_order_id, product_id, order_quantity) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM product_order_list order by product_order_id";
	private static final String GET_ONE_STMT = "SELECT * FROM product_order_list where product_order_id = ?";
	private static final String DELETE = "DELETE FROM product_order_list where product_order_id = ?";
	private static final String UPDATE = "UPDATE product_order_list set order_quantity=? where product_order_id = ?";

	@Override
	public void insert(PolVO order_list) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, order_list.getProduct_order_id());
			pstmt.setInt(2, order_list.getProduct_id());
			pstmt.setInt(3, order_list.getOrder_quantity());

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
	public void update(Integer product_order_id, Integer qauntity) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setInt(1, qauntity);
			pstmt.setInt(2, product_order_id);

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
	public void delete(Integer product_order_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, product_order_id);

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
		finally {
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
	public PolVO findByPrimaryKey(Integer product_order_id) {
		PolVO order_list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 已連線，免動
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, product_order_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				order_list = new PolVO();
				order_list.setProduct_order_id(rs.getInt("product_order_id"));
				order_list.setProduct_id(rs.getInt("product_id"));
				order_list.setOrder_quantity(rs.getInt("order_quantity"));

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
		return order_list;
	}

	@Override
	public List<PolVO> getAll() {
		
		List<PolVO> list = new ArrayList<PolVO>();
		PolVO pol = null;

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
				// empVO 也稱為 Domain objects
				pol = new PolVO();
				pol.setProduct_order_id(rs.getInt("product_order_id"));
				pol.setProduct_id(rs.getInt("product_id"));
				pol.setOrder_quantity(rs.getInt("order_quantity"));
				list.add(pol); // Store the row in the list
			}

			// Handle any driver errors
		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//			// Handle any SQL errors
//		}
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	}

	public void insertForPodVO(PolVO polVO, java.sql.Connection con) {
		PreparedStatement pps = null;
		
		try {
			pps = con.prepareStatement(INSERT_STMT);
//			product_order_id, product_id, order_quantity
			pps.setInt(1, polVO.getProduct_order_id());
			pps.setInt(2, polVO.getProduct_id());
			pps.setInt(3, polVO.getOrder_quantity());
			pps.executeUpdate();
		}catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					System.err.print("Transaction is being ");
					System.err.println("rolled back-由-emp");
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pps != null) {
				try {
					pps.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
	}

	public static void main(String[] args) {

		PolJDBCDAO dao = new PolJDBCDAO();

		// insert
//		PolVO order_list = new PolVO();
//		order_list.setProduct_order_id(3);
//		order_list.setProduct_id(1);
//		order_list.setOrder_quantity(15);
//		dao.insert(order_list);

		// update
//		dao.update(1, 20);

		// delete
		dao.delete(88);

		// find one
//		PolVO product_order_list = dao.findByPrimaryKey(1);
//		System.out.println(product_order_list);
		
		// find all
//		List<PolVO> all_order_list = dao.getAll();
//		for(PolVO each_order_list : all_order_list) {
//			System.out.println(each_order_list);
//		}
		
	}

}
