package h.com.room_review.model;

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


public class Room_reviewJDBCDAO implements Room_reviewDAO_interface{
	private static DataSource ds = null;

	static {

		Context ct;
		try {
			ct = new javax.naming.InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/cga102");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		private static final String INSERT_STMT = 
				"INSERT INTO room_review (room_order_id,room_type_id,room_review,room_review_date) VALUES (?, ?, ? ,?)";
			private static final String GET_ALL_STMT = 
				"SELECT room_review_id,room_order_id,room_type_id,room_review,room_review_date FROM room_review order by room_review_id";
			private static final String GET_ONE_STMT = 
				"SELECT room_review_id,room_order_id,room_type_id,room_review,room_review_date FROM room_review  where room_review_id = ?";
			private static final String DELETE = 
				"DELETE FROM room_review where room_review_id = ?";
			private static final String UPDATE = 
				"UPDATE room_review set room_order_id=?, room_type_id=?, room_review=? where room_review_id = ?";

			
			public Room_reviewJDBCDAO() {
				
			};
			
			@Override
			public void insert(Room_reviewVO room_reviewVO) {

				Connection con = null;
				PreparedStatement pstmt = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(INSERT_STMT);

					pstmt.setInt(1, room_reviewVO.getRoom_order_id());
					pstmt.setInt(2, room_reviewVO.getRoom_type_id());
					pstmt.setString(3, room_reviewVO.getRoom_review());
					pstmt.setTimestamp(4, room_reviewVO.getRoom_review_date());
					pstmt.executeUpdate();

					// Handle any driver errors
				} catch (SQLException se) {
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
			public void update(Room_reviewVO room_reviewVO) {

				Connection con = null;
				PreparedStatement pstmt = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(UPDATE);

					
					pstmt.setInt(1, room_reviewVO.getRoom_order_id());
					pstmt.setInt(2, room_reviewVO.getRoom_type_id());
					pstmt.setString(3, room_reviewVO.getRoom_review());
					pstmt.setInt(4, room_reviewVO.getRoom_review_id());


					pstmt.executeUpdate();

					// Handle any driver errors
				} catch (SQLException se) {
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
					pstmt = con.prepareStatement(GET_ONE_STMT);

					pstmt.setInt(1, room_review_id);

					pstmt.executeUpdate();

					// Handle any driver errors
				} catch (SQLException se) {
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
			public Room_reviewVO findByPrimaryKey(Integer room_review_id) {

				Room_reviewVO room_reviewVO = null;
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(GET_ONE_STMT);

					pstmt.setInt(1, room_review_id);

					rs = pstmt.executeQuery();

					while (rs.next()) {
						// room_reviewVO 也稱為 Domain objects
						room_reviewVO = new Room_reviewVO();
						room_reviewVO.setRoom_review_id(rs.getInt("room_review_id"));
						room_reviewVO.setRoom_order_id(rs.getInt("room_order_id"));
						room_reviewVO.setRoom_type_id(rs.getInt("room_type_id"));
						room_reviewVO.setRoom_review(rs.getString("room_review"));
						room_reviewVO.setRoom_review_date(rs.getTimestamp("room_review_date"));
					}

					// Handle any driver errors
				} catch (SQLException se) {
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
			public List<Room_reviewVO> getAll() {
				List<Room_reviewVO> list = new ArrayList<Room_reviewVO>();
				Room_reviewVO room_reviewVO = null;

				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(GET_ALL_STMT);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						// room_reviewVO 也稱為 Domain objects
						room_reviewVO = new Room_reviewVO();
						room_reviewVO.setRoom_review_id(rs.getInt("room_review_id"));
						room_reviewVO.setRoom_order_id(rs.getInt("room_order_id"));
						room_reviewVO.setRoom_type_id(rs.getInt("room_type_id"));
						room_reviewVO.setRoom_review(rs.getString("room_review"));
						room_reviewVO.setRoom_review_date(rs.getTimestamp("room_review_date"));
						list.add(room_reviewVO); // Store the row in the list
						
						
					}

					// Handle any driver errors
				} catch (SQLException se) {
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

				Room_reviewJDBCDAO dao = new Room_reviewJDBCDAO();
				SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
				Room_reviewVO room_reviewVO3 = dao.findByPrimaryKey(1);
				System.out.print(room_reviewVO3.getRoom_review_id() + ",");
				System.out.print(room_reviewVO3.getRoom_order_id() + ",");
				System.out.print(room_reviewVO3.getRoom_type_id() + ",");
				System.out.print(room_reviewVO3.getRoom_review() + ",");
				System.out.print(simpledateformat.format(room_reviewVO3.getRoom_review_date()));
				System.out.println("---------------------");

				// 查詢
				List<Room_reviewVO> list = dao.getAll();
				for (Room_reviewVO aRoom_Review : list) {
					System.out.print(aRoom_Review.getRoom_review_id() + ",");
					System.out.print(aRoom_Review.getRoom_order_id() + ",");
					System.out.print(aRoom_Review.getRoom_type_id() + ",");
					System.out.print(aRoom_Review.getRoom_review() + ",");
					System.out.print(simpledateformat.format(aRoom_Review.getRoom_review_date()));
					System.out.println();
				}
			}
}
