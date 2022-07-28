package m.com.room_order.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Room_OrderJDBCDAO implements Room_OrderDAO_interface {

	private static DataSource ds;
	static {
		try {
			Context ctx = new javax.naming.InitialContext();
			try {
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CGA102_2");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CGA102_2?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = "INSERT INTO room_order (member_id,room_order_status,room_charge,check_in_date,check_out_date) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT room_order_id,member_id,order_date,room_order_status,room_charge,check_in_date,check_out_date FROM room_order order by room_order_id";
	private static final String GET_ALL_TIME = "SELECT room_order_id,member_id,order_date,room_order_status,room_charge,check_in_date,check_out_date FROM room_order order by check_in_date";
	private static final String GET_ONE_STMT = "SELECT room_order_id,member_id,order_date,room_order_status,room_charge,check_in_date,check_out_date FROM room_order where room_order_id = ?";
	private static final String DELETE = "DELETE FROM room_order where room_order_id = ?";
	private static final String UPDATE = "UPDATE room_order set member_id=?,room_order_status=?, room_charge=?, check_in_date=?,check_out_date=? where room_order_id = ?";
	private static final String UPDATE_STATUS = "UPDATE room_order set room_order_status=? where room_order_id = ?";
	private static final String UPDATE_STATUS_OUT = "UPDATE room_order set room_order_status=? where room_order_id = ?";
	private static final String GET_ONE_CHECKIN = "SELECT * FROM room_order where check_in_date = ?";
	private static final String GET_FIRST_CHECKIN = "SELECT * FROM room_order where to_days(check_in_date) = to_days(NOW())";
	
	
	@Override
	public void insert(Room_OrderVO room_orderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			    con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, room_orderVO.getMember_id());
			pstmt.setInt(2, room_orderVO.getRoom_order_status());
			pstmt.setInt(3, room_orderVO.getRoom_charge());
			pstmt.setDate(4, room_orderVO.getCheck_in_date());
			pstmt.setDate(5, room_orderVO.getCheck_out_date());

			pstmt.executeUpdate();

			// Handle any driver errors
		}
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
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
	public void update(Room_OrderVO room_orderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			    con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, room_orderVO.getMember_id());
			pstmt.setInt(2, room_orderVO.getRoom_order_status());
			pstmt.setInt(3, room_orderVO.getRoom_charge());
			pstmt.setDate(4, room_orderVO.getCheck_in_date());
			pstmt.setDate(5, room_orderVO.getCheck_out_date());
			pstmt.setInt(6, room_orderVO.getRoom_order_id());

			pstmt.executeUpdate();

			// Handle any driver errors
		}
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
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
	public void delete(Integer room_order_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			    con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, room_order_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		}
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
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
	public Room_OrderVO findByPrimaryKey(Integer room_order_id) {
		Room_OrderVO room_orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			    con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, room_order_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				room_orderVO = new Room_OrderVO();
				room_orderVO.setRoom_order_id(rs.getInt("room_order_id"));
				room_orderVO.setMember_id(rs.getInt("member_id"));
				room_orderVO.setOrder_date(rs.getTimestamp("order_date"));
				room_orderVO.setRoom_order_status(rs.getInt("room_order_status"));
				room_orderVO.setRoom_charge(rs.getInt("room_charge"));
				room_orderVO.setCheck_in_date(rs.getDate("check_in_date"));
				room_orderVO.setCheck_out_date(rs.getDate("check_out_date"));
			}

			// Handle any driver errors
		}
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
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
		return room_orderVO;
	}

	@Override
	public List<Room_OrderVO> getAll() {
		List<Room_OrderVO> list = new ArrayList<Room_OrderVO>();
		Room_OrderVO room_orderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			    con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// room_orderVO 也稱為 Domain objects
				room_orderVO = new Room_OrderVO();
				room_orderVO.setRoom_order_id(rs.getInt("room_order_id"));
				room_orderVO.setMember_id(rs.getInt("member_id"));
				room_orderVO.setOrder_date(rs.getTimestamp("order_date"));
				room_orderVO.setRoom_order_status(rs.getInt("room_order_status"));
				room_orderVO.setRoom_charge(rs.getInt("room_charge"));
				room_orderVO.setCheck_in_date(rs.getDate("check_in_date"));
				room_orderVO.setCheck_out_date(rs.getDate("check_out_date"));
				list.add(room_orderVO); // Store the row in the list
			}

			// Handle any driver errors
		}
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
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
		return list;
	}
	
	@Override
	public List<Room_OrderVO> getAllTime() {
		List<Room_OrderVO> list = new ArrayList<Room_OrderVO>();
		Room_OrderVO room_orderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			    con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_TIME);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// room_orderVO 也稱為 Domain objects
				room_orderVO = new Room_OrderVO();
				room_orderVO.setRoom_order_id(rs.getInt("room_order_id"));
				room_orderVO.setMember_id(rs.getInt("member_id"));
				room_orderVO.setOrder_date(rs.getTimestamp("order_date"));
				room_orderVO.setRoom_order_status(rs.getInt("room_order_status"));
				room_orderVO.setRoom_charge(rs.getInt("room_charge"));
				room_orderVO.setCheck_in_date(rs.getDate("check_in_date"));
				room_orderVO.setCheck_out_date(rs.getDate("check_out_date"));
				list.add(room_orderVO); // Store the row in the list
			}

			// Handle any driver errors
		}
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
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
		return list;
	}
	
	@Override
	public void updateStatus(Room_OrderVO room_orderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			    con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STATUS);

			pstmt.setInt(1, room_orderVO.getRoom_order_status());
			pstmt.setInt(2, room_orderVO.getRoom_order_id());

			pstmt.executeUpdate();

			// Handle any driver errors
		}
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
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
	public void updateStatusout(Room_OrderVO room_orderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
    			con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STATUS_OUT);

			pstmt.setInt(1, room_orderVO.getRoom_order_status());
			pstmt.setInt(2, room_orderVO.getRoom_order_id());

			pstmt.executeUpdate();

			// Handle any driver errors
		}
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
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
	public List<Room_OrderVO> findByCheckin(Date check_in_date) {
		List<Room_OrderVO> list2 = new ArrayList<Room_OrderVO>();
		Room_OrderVO room_orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
        		con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_CHECKIN);

			pstmt.setDate(1, check_in_date);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				room_orderVO = new Room_OrderVO();
				room_orderVO.setRoom_order_id(rs.getInt("room_order_id"));
				room_orderVO.setMember_id(rs.getInt("member_id"));
				room_orderVO.setOrder_date(rs.getTimestamp("order_date"));
				room_orderVO.setRoom_order_status(rs.getInt("room_order_status"));
				room_orderVO.setRoom_charge(rs.getInt("room_charge"));
				room_orderVO.setCheck_in_date(rs.getDate("check_in_date"));
				room_orderVO.setCheck_out_date(rs.getDate("check_out_date"));
				list2.add(room_orderVO);
			}

			// Handle any driver errors
		}
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
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
		return list2;
	}
	
	
	
	@Override
	public List<Room_OrderVO> findtodayorder() {
		List<Room_OrderVO> list3 = new ArrayList<Room_OrderVO>();
		Room_OrderVO room_orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
        		con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_FIRST_CHECKIN);

			

			rs = pstmt.executeQuery();

			while (rs.next()) {
				room_orderVO = new Room_OrderVO();
				room_orderVO.setRoom_order_id(rs.getInt("room_order_id"));
				room_orderVO.setMember_id(rs.getInt("member_id"));
				room_orderVO.setOrder_date(rs.getTimestamp("order_date"));
				room_orderVO.setRoom_order_status(rs.getInt("room_order_status"));
				room_orderVO.setRoom_charge(rs.getInt("room_charge"));
				room_orderVO.setCheck_in_date(rs.getDate("check_in_date"));
				room_orderVO.setCheck_out_date(rs.getDate("check_out_date"));
				list3.add(room_orderVO);
			}

			// Handle any driver errors
		}
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
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
		return list3;
	}


	public static void main(String[] args) {

		Room_OrderJDBCDAO dao = new Room_OrderJDBCDAO();

		// 新增
//			Room_OrderVO room_orderVO1 = new Room_OrderVO();
//			room_orderVO1.setMember_id(1);
//			room_orderVO1.setRoom_order_status(0);
//			room_orderVO1.setRoom_charge(2000);
//			room_orderVO1.setCheck_in_date(Date.valueOf("2022-07-04"));
//			room_orderVO1.setCheck_out_date(Date.valueOf("2022-07-15"));
////			Date date = Date.valueOf(req.getParameter("date"));
//			dao.insert(room_orderVO1);

		// 修改
//		    Room_OrderVO room_orderVO2 = new Room_OrderVO();
//		    room_orderVO2.setRoom_order_id(1);
//		    room_orderVO2.setMember_id(2);
//		    room_orderVO2.setRoom_order_status(1);
//		    room_orderVO2.setRoom_charge(10000);
//			dao.insert(room_orderVO2);

		// 刪除
//			dao.delete(9);

		// 查詢
//		Room_OrderVO room_orderVO3 = dao.findByPrimaryKey(4);
//		System.out.print(room_orderVO3.getRoom_order_id() + ",");
//		System.out.print(room_orderVO3.getMember_id() + ",");
//		System.out.print(room_orderVO3.getOrder_date() + ",");
//		System.out.print(room_orderVO3.getRoom_order_status() + ",");
//		System.out.print(room_orderVO3.getRoom_charge() + ",");
//		System.out.print(new SimpleDateFormat("yyyy-MM-dd").format(room_orderVO3.getCheck_in_date()) + ",");
//		System.out.print(new SimpleDateFormat("yyyy-MM-dd").format(room_orderVO3.getCheck_out_date()));
//		System.out.println("---------------------");

		// 查詢
//		List<Room_OrderVO> list = dao.getAll();
//		for (Room_OrderVO aRoom_Order : list) {
//			System.out.print(aRoom_Order.getRoom_order_id() + ",");
//			System.out.print(aRoom_Order.getMember_id() + ",");
//			System.out.print(aRoom_Order.getOrder_date() + ",");
//			System.out.print(aRoom_Order.getRoom_order_status() + ",");
//			System.out.print(aRoom_Order.getRoom_charge() + ",");
//			System.out.print(new SimpleDateFormat("yyyy-MM-dd").format(aRoom_Order.getCheck_in_date()) + ",");
//			System.out.print(new SimpleDateFormat("yyyy-MM-dd").format(aRoom_Order.getCheck_out_date()));
//			System.out.println();
//		}
	}
}
