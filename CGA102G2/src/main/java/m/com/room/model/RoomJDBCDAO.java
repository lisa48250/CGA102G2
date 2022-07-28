package m.com.room.model;

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

public class RoomJDBCDAO implements RoomDAO_interface{
	
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
	String url = "jdbc:mysql://localhost:3306/CGA102_2?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = 
			"INSERT INTO room (room_type_id,room_guest_name,room_sale_status,room_status) VALUES (?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT room_id,room_type_id,room_guest_name,room_sale_status,room_status FROM room order by room_id";
		private static final String GET_ONE_STMT = 
			"SELECT room_id,room_type_id,room_guest_name,room_sale_status,room_status FROM room where room_id = ?";
		private static final String DELETE = 
			"DELETE FROM room where room_id = ?";
		private static final String UPDATE = 
			"UPDATE room set room_type_id=?, room_guest_name=?, room_sale_status=?, room_status=? where room_id = ?";
		private static final String GET_ALL_TYPE = 
				"SELECT room_id,room_type_id,room_guest_name,room_sale_status,room_status FROM room where room_Type_id =?";
			
//		@Override
		public void insert(RoomVO roomVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setInt(1, roomVO.getRoom_type_id());
				pstmt.setString(2, roomVO.getRoom_guest_name());
				pstmt.setInt(3, roomVO.getRoom_sale_status());
				pstmt.setInt(4, roomVO.getRoom_status());

				pstmt.executeUpdate();

				// Handle any driver errors
			}
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
			catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		public void update(RoomVO roomVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setInt(1, roomVO.getRoom_type_id());
				pstmt.setString(2, roomVO.getRoom_guest_name());
				pstmt.setInt(3, roomVO.getRoom_sale_status());
				pstmt.setInt(4, roomVO.getRoom_status());
				pstmt.setInt(5, roomVO.getRoom_id());

				pstmt.executeUpdate();

				// Handle any driver errors
			} 
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			}
			catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		public void delete(Integer room_id) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, room_id);

				pstmt.executeUpdate();

				// Handle any driver errors
			} 
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
			catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		public RoomVO findByPrimaryKey(Integer room_id) {

			RoomVO roomVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, room_id);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// empVo 也稱為 Domain objects
					roomVO = new RoomVO();
					roomVO.setRoom_id(rs.getInt("room_id"));
					roomVO.setRoom_type_id(rs.getInt("room_type_id"));
					roomVO.setRoom_guest_name(rs.getString("room_guest_name"));
					roomVO.setRoom_sale_status(rs.getInt("room_sale_status"));
					roomVO.setRoom_status(rs.getInt("room_status"));
				}

				// Handle any driver errors
			} 
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
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
			return roomVO;
		}

		@Override
		public List<RoomVO> getAll() {
			List<RoomVO> list = new ArrayList<RoomVO>();
			RoomVO roomVO = null;

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
					// roomVO 也稱為 Domain objects
					roomVO = new RoomVO();
					roomVO.setRoom_id(rs.getInt("room_id"));
					roomVO.setRoom_type_id(rs.getInt("room_type_id"));
					roomVO.setRoom_guest_name(rs.getString("room_guest_name"));
					roomVO.setRoom_sale_status(rs.getInt("room_sale_status"));
					roomVO.setRoom_status(rs.getInt("room_status"));
					list.add(roomVO); // Store the row in the list
				}

				// Handle any driver errors
			} 
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
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
		
		@Override
		public List<RoomVO> getAllRoomType(Integer room_type_id) {
			List<RoomVO> list1 = new ArrayList<RoomVO>();
			RoomVO roomVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ALL_TYPE);
				pstmt.setInt(1, room_type_id);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					// roomVO 也稱為 Domain objects
					roomVO = new RoomVO();
					roomVO.setRoom_id(rs.getInt("room_id"));
					roomVO.setRoom_type_id(rs.getInt("room_type_id"));
					roomVO.setRoom_guest_name(rs.getString("room_guest_name"));
					roomVO.setRoom_sale_status(rs.getInt("room_sale_status"));
					roomVO.setRoom_status(rs.getInt("room_status"));
					list1.add(roomVO); // Store the row in the list
				}

				// Handle any driver errors
			} 
//			catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
//				// Handle any SQL errors
//			} 
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
			return list1;
		}


		public static void main(String[] args) {

			RoomJDBCDAO dao = new RoomJDBCDAO();

			// 新增
//			RoomVO roomVO1= new RoomVO();
//			roomVO1.setRoom_type_id(2);
//			roomVO1.setRoom_guest_name("May3");
//			roomVO1.setRoom_sale_status(1);
//			roomVO1.setRoom_status(1);
//			dao.insert(roomVO1);

			// 修改
//			RoomVO roomVO2= new RoomVO();
//			roomVO2.setRoom_id(1);
//			roomVO2.setRoom_type_id(1);
//			roomVO2.setRoom_guest_name("Paul");
//			roomVO2.setRoom_sale_status(1);
//			roomVO2.setRoom_status(1);
//			dao.update(roomVO2);

			// 刪除
//			dao.delete(10);

			// 查詢
//			RoomVO roomVO3 = dao.findByPrimaryKey(6);
//			System.out.print(roomVO3.getRoom_id() + ",");
//			System.out.print(roomVO3.getRoom_type_id() + ",");
//			System.out.print(roomVO3.getRoom_guest_name() + ",");
//			System.out.print(roomVO3.getRoom_sale_status() + ",");
//			System.out.print(roomVO3.getRoom_status());
//			System.out.println("---------------------");

			// 查詢
//			List<RoomVO> list = dao.getAll();
//			for (RoomVO aRoom : list) {
//				System.out.print(aRoom.getRoom_id() + ",");
//				System.out.print(aRoom.getRoom_type_id() + ",");
//				System.out.print(aRoom.getRoom_guest_name() + ",");
//				System.out.print(aRoom.getRoom_sale_status() + ",");
//				System.out.print(aRoom.getRoom_status());
//				System.out.println();
//			}
			
			List<RoomVO> list1 = dao.getAllRoomType(1);
			for (RoomVO aRoom : list1) {
				System.out.print(aRoom.getRoom_id() + ",");
				System.out.print(aRoom.getRoom_type_id() + ",");
				System.out.print(aRoom.getRoom_guest_name() + ",");
				System.out.print(aRoom.getRoom_sale_status() + ",");
				System.out.print(aRoom.getRoom_status());
				System.out.println();
			}
		}
}
