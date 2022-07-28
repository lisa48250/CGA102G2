package m.com.room_review.model;

import java.sql.Connection;
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


public class Room_ReviewJDBCDAO implements Room_ReviewDAO_interface{
	
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
				"INSERT INTO room_review (room_order_id,room_type_id,room_review) VALUES (?, ?, ?)";
			private static final String GET_ALL_STMT = 
				"SELECT room_review_id,room_order_id,room_type_id,room_review,room_review_date FROM room_review order by room_review_id";
			private static final String GET_ONE_STMT = 
				"SELECT room_review_id,room_order_id,room_type_id,room_review,room_review_date FROM room_review  where room_review_id = ?";
			private static final String DELETE = 
				"DELETE FROM room_review where room_review_id = ?";
			private static final String UPDATE = 
				"UPDATE room_review set room_order_id=?, room_type_id=?, room_review=? where room_review_id = ?";

			@Override
			public void insert(Room_ReviewVO room_reviewVO) {

				Connection con = null;
				PreparedStatement pstmt = null;

				try {
					con = ds.getConnection();
//					Class.forName(driver);
//					con = DriverManager.getConnection(url, userid, passwd);
					pstmt = con.prepareStatement(INSERT_STMT);

					pstmt.setInt(1, room_reviewVO.getRoom_order_id());
					pstmt.setInt(2, room_reviewVO.getRoom_type_id());
					pstmt.setString(3, room_reviewVO.getRoom_review());

					pstmt.executeUpdate();

					// Handle any driver errors
				} 
//				catch (ClassNotFoundException e) {
//					throw new RuntimeException("Couldn't load database driver. "
//							+ e.getMessage());
//					// Handle any SQL errors
//				} 
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
			public void update(Room_ReviewVO room_reviewVO) {

				Connection con = null;
				PreparedStatement pstmt = null;

				try {
					con = ds.getConnection();
//					Class.forName(driver);
//					con = DriverManager.getConnection(url, userid, passwd);
					pstmt = con.prepareStatement(UPDATE);

					
					pstmt.setInt(1, room_reviewVO.getRoom_order_id());
					pstmt.setInt(2, room_reviewVO.getRoom_type_id());
					pstmt.setString(3, room_reviewVO.getRoom_review());
					pstmt.setInt(4, room_reviewVO.getRoom_review_id());


					pstmt.executeUpdate();

					// Handle any driver errors
				} 
//				catch (ClassNotFoundException e) {
//					throw new RuntimeException("Couldn't load database driver. "
//							+ e.getMessage());
//					// Handle any SQL errors
//				} 
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
			public void delete(Integer room_review_id) {

				Connection con = null;
				PreparedStatement pstmt = null;

				try {
					con = ds.getConnection();
//					Class.forName(driver);
//					con = DriverManager.getConnection(url, userid, passwd);
					pstmt = con.prepareStatement(DELETE);

					pstmt.setInt(1, room_review_id);

					pstmt.executeUpdate();

					// Handle any driver errors
				} 
//				catch (ClassNotFoundException e) {
//					throw new RuntimeException("Couldn't load database driver. "
//							+ e.getMessage());
//					// Handle any SQL errors
//				} 
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
			public Room_ReviewVO findByPrimaryKey(Integer room_review_id) {

				Room_ReviewVO room_reviewVO = null;
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					con = ds.getConnection();
//					Class.forName(driver);
//					con = DriverManager.getConnection(url, userid, passwd);
					pstmt = con.prepareStatement(GET_ONE_STMT);

					pstmt.setInt(1, room_review_id);

					rs = pstmt.executeQuery();

					while (rs.next()) {
						// room_reviewVO 也稱為 Domain objects
						room_reviewVO = new Room_ReviewVO();
						room_reviewVO.setRoom_review_id(rs.getInt("room_review_id"));
						room_reviewVO.setRoom_order_id(rs.getInt("room_order_id"));
						room_reviewVO.setRoom_type_id(rs.getInt("room_type_id"));
						room_reviewVO.setRoom_review(rs.getString("room_review"));
						room_reviewVO.setRoom_review_date(rs.getTimestamp("room_review_date"));
					}

					// Handle any driver errors
				} 
//				catch (ClassNotFoundException e) {
//					throw new RuntimeException("Couldn't load database driver. "
//							+ e.getMessage());
//					// Handle any SQL errors
//				} 
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
				return room_reviewVO;
			}

			@Override
			public List<Room_ReviewVO> getAll() {
				List<Room_ReviewVO> list = new ArrayList<Room_ReviewVO>();
				Room_ReviewVO room_reviewVO = null;

				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					con = ds.getConnection();
//					Class.forName(driver);
//					con = DriverManager.getConnection(url, userid, passwd);
					pstmt = con.prepareStatement(GET_ALL_STMT);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						// room_reviewVO 也稱為 Domain objects
						room_reviewVO = new Room_ReviewVO();
						room_reviewVO.setRoom_review_id(rs.getInt("room_review_id"));
						room_reviewVO.setRoom_order_id(rs.getInt("room_order_id"));
						room_reviewVO.setRoom_type_id(rs.getInt("room_type_id"));
						room_reviewVO.setRoom_review(rs.getString("room_review"));
						room_reviewVO.setRoom_review_date(rs.getTimestamp("room_review_date"));
						list.add(room_reviewVO); // Store the row in the list
						
						
					}

					// Handle any driver errors
				} 
//				catch (ClassNotFoundException e) {
//					throw new RuntimeException("Couldn't load database driver. "
//							+ e.getMessage());
//					// Handle any SQL errors
//				} 
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

			public static void main(String[] args) {

				Room_ReviewJDBCDAO dao = new Room_ReviewJDBCDAO();

				// 新增
//				Room_ReviewVO room_reviewVO1 = new Room_ReviewVO();
//				room_reviewVO1.setRoom_order_id(4);
//				room_reviewVO1.setRoom_type_id(1);
//				room_reviewVO1.setRoom_review("枕頭很好睡");
//				dao.insert(room_reviewVO1);

				// 修改
//				Room_ReviewVO room_reviewVO2 = new Room_ReviewVO();
//				room_reviewVO2.setRoom_review_id(3);
//				room_reviewVO2.setRoom_order_id(2);
//				room_reviewVO2.setRoom_type_id(3);
//				room_reviewVO2.setRoom_review("交通很方便");
//				dao.update(room_reviewVO2);

				// 刪除
//				dao.delete(3);

				// 查詢
//				Room_ReviewVO room_reviewVO3 = dao.findByPrimaryKey(1);
//				System.out.print(room_reviewVO3.getRoom_review_id() + ",");
//				System.out.print(room_reviewVO3.getRoom_order_id() + ",");
//				System.out.print(room_reviewVO3.getRoom_type_id() + ",");
//				System.out.print(room_reviewVO3.getRoom_review() + ",");
//				System.out.print(room_reviewVO3.getRoom_review_date());
//				System.out.print(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(room_reviewVO3.getRoom_review_date()));
//				System.out.println("---------------------");

				// 查詢
				List<Room_ReviewVO> list = dao.getAll();
				for (Room_ReviewVO aRoom_Review : list) {
					System.out.print(aRoom_Review.getRoom_review_id() + ",");
					System.out.print(aRoom_Review.getRoom_order_id() + ",");
					System.out.print(aRoom_Review.getRoom_type_id() + ",");
					System.out.print(aRoom_Review.getRoom_review() + ",");
					System.out.print(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(aRoom_Review.getRoom_review_date()));
					System.out.println();
				}
			}
}
