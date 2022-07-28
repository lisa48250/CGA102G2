package m.com.room_type_schedule.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Room_type_scheduleJDBCDAO implements Room_type_scheduleDAO_interface {
	
	private static DataSource ds;
	static {
		try {
	Context ctx = new javax.naming.InitialContext();
	try {
	ds=(DataSource)ctx.lookup("java:comp/env/jdbc/CGA102_2");
	}catch(Exception e){
		e.printStackTrace();
	}
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CGA102_2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT_STMT = "insert into room_type_schedule (room_type_id , room_amount , room_rsv_booked , room_order_date) "
			+ "value(? , ? , ? ,?);";
	private static final String GET_ALL_STMT = "select room_type_schedule_id , room_type_id , room_amount , room_rsv_booked , room_order_date from room_type_schedule order by  room_type_schedule_id ;";
	private static final String GET_ONE_STMT = "select room_type_schedule_id , room_type_id , room_amount , room_rsv_booked , room_order_date from room_type_schedule where room_type_schedule_id = ?; ";
	private static final String DELETE = "delete from room_type_schedule where room_type_schedule_id = ?;";
	private static final String UPDATE = "update room_type_schedule set room_type_id = ? , room_amount = ? , room_rsv_booked = ? , room_order_date = ? where room_type_schedule_id = ?;";
	
	@Override
	public void insert(Room_type_scheduleVO room_type_scheduleVO) {
		
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, room_type_scheduleVO.getRoom_type_id());
			pstmt.setInt(2, room_type_scheduleVO.getRoom_amount());
			pstmt.setInt(3, room_type_scheduleVO.getRoom_rsv_booked());
			pstmt.setTimestamp(4, room_type_scheduleVO.getRoom_order_date());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} 
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			throw new RuntimeException("A database error occured. " + e.getMessage());
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
	public void update(Room_type_scheduleVO room_type_scheduleVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, room_type_scheduleVO.getRoom_type_id());
			pstmt.setInt(2, room_type_scheduleVO.getRoom_amount());
			pstmt.setInt(3, room_type_scheduleVO.getRoom_rsv_booked());
			pstmt.setTimestamp(4, room_type_scheduleVO.getRoom_order_date());
			pstmt.setInt(5, room_type_scheduleVO.getRoom_type_schedule_id());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} 
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			throw new RuntimeException("A database error occured. " + e.getMessage());
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
	public void delete(Integer room_type_schedule_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, room_type_schedule_id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} 
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			throw new RuntimeException("A database error occured. " + e.getMessage());
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
	public Room_type_scheduleVO findByPrimaryKey(Integer room_type_schedule_id) {
		// TODO Auto-generated method stub
		Room_type_scheduleVO room_type_scheduleVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, room_type_schedule_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				room_type_scheduleVO = new Room_type_scheduleVO();
				room_type_scheduleVO.setRoom_type_schedule_id(rs.getInt("room_type_schedule_id"));
				room_type_scheduleVO.setRoom_type_id(rs.getInt("room_type_id"));
				room_type_scheduleVO.setRoom_amount(rs.getInt("room_amount"));
				room_type_scheduleVO.setRoom_rsv_booked(rs.getInt("room_rsv_booked"));
				room_type_scheduleVO.setRoom_order_date(rs.getTimestamp("room_order_date"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} 
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			throw new RuntimeException("A database error occured. " + e.getMessage());
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
		return room_type_scheduleVO;
	}
	

	@Override
	public List<Room_type_scheduleVO> getAll() {

		// TODO Auto-generated method stub
		List<Room_type_scheduleVO> list = new ArrayList<Room_type_scheduleVO>();

		Room_type_scheduleVO room_type_scheduleVO = null;
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

				room_type_scheduleVO = new Room_type_scheduleVO();
				room_type_scheduleVO.setRoom_type_schedule_id(rs.getInt("room_type_schedule_id"));
				room_type_scheduleVO.setRoom_type_id(rs.getInt("room_type_id"));
				room_type_scheduleVO.setRoom_amount(rs.getInt("room_amount"));
				room_type_scheduleVO.setRoom_rsv_booked(rs.getInt("room_rsv_booked"));
				room_type_scheduleVO.setRoom_order_date(rs.getTimestamp("room_order_date"));
				list.add(room_type_scheduleVO);
			}

		} 
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//
//		} 
		catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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
	public static void main(String[] args) {
		Room_type_scheduleJDBCDAO rtsVo = new Room_type_scheduleJDBCDAO();
		
		Room_type_scheduleVO rts = new Room_type_scheduleVO();
		rts.setRoom_type_id(4);
		rts.setRoom_amount(1);
		rts.setRoom_rsv_booked(1);
		rts.setRoom_order_date(java.sql.Timestamp.valueOf("2002-06-06"));
		rtsVo.insert(rts);
		
		Room_type_scheduleVO rts1 = new Room_type_scheduleVO();
		rts1.setRoom_type_id(2);
		rts1.setRoom_amount(2);
		rts1.setRoom_rsv_booked(2);
		rts1.setRoom_order_date(java.sql.Timestamp.valueOf("2002-05-05"));
		rts1.setRoom_type_schedule_id(7);
		rtsVo.update(rts1);
		
		rtsVo.delete(12);
		
		Room_type_scheduleVO rts2 = rtsVo.findByPrimaryKey(4);
		System.out.println(rts2.getRoom_type_schedule_id()+ ",");
		System.out.println(rts2.getRoom_type_id()+ ",");
		System.out.println(rts2.getRoom_amount()+ ",");
		System.out.println(rts2.getRoom_rsv_booked()+ ",");
		System.out.println(rts2.getRoom_order_date()+ ",");
		
		
		
		
		List<Room_type_scheduleVO> list = rtsVo.getAll();
		for(Room_type_scheduleVO rts3 : list) {
		System.out.println(rts3.getRoom_type_schedule_id()+ ",");
		System.out.println(rts3.getRoom_type_id()+ ",");
		System.out.println(rts3.getRoom_amount()+ ",");
		System.out.println(rts3.getRoom_rsv_booked()+ ",");
		System.out.println(rts3.getRoom_order_date()+ ",");
		}
	}
}
