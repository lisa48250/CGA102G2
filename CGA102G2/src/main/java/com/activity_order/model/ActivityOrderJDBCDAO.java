//package com.activity_order.model;
//import java.util.*;
//
//import javax.sql.rowset.serial.SerialBlob;
//
//import com.mysql.cj.jdbc.Blob;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.sql.*;
//
//public class ActivityOrderJDBCDAO implements ActivityOrder_interface{
//
//		String driver = "com.mysql.cj.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/cga102_2?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
//		String userid = "root"; // cga102_2 => 連接mysql的檔案名稱
//		String passwd = "password";
//
//		private static final String INSERT_STMT = 
//				"INSERT INTO ACTIVITY_ORDER (MEMBER_ID, ACTIVITY_SESSION_ID, ORDER_TIME, ENROLL_NUMBER, ORDER_AMOUNT, ORDER_STATE, REFUND_STATE, ORDER_MEMO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//		private static final String GET_ALL_STMT = "SELECT ACTIVITY_ORDER_ID, MEMBER_ID, ACTIVITY_SESSION_ID, ORDER_TIME,ENROLL_NUMBER, ORDER_AMOUNT,ORDER_STATE ,REFUND_STATE, ORDER_MEMO FROM ACTIVITY_ORDER order by ACTIVITY_ORDER_ID";
//		private static final String GET_ONE_STMT = "SELECT ACTIVITY_ORDER_ID, MEMBER_ID, ACTIVITY_SESSION_ID, ORDER_TIME,ENROLL_NUMBER, ORDER_AMOUNT,ORDER_STATE ,REFUND_STATE, ORDER_MEMO FROM ACTIVITY_ORDER where ACTIVITY_ORDER_ID = ?";
//		//private static final String DELETE = "DELETE FROM NEWS_POST where NEWS_POST_ID = ?";
//		private static final String UPDATE = "UPDATE ACTIVITY_ORDER set MEMBER_ID= ?, ACTIVITY_SESSION_ID=?, ORDER_TIME=?, ENROLL_NUMBER=?, ORDER_AMOUNT =?, ORDER_STATE =?, REFUND_STATE =?, ORDER_MEMO=? where ACTIVITY_ORDER_ID = ?;";
//		private static final String JOIN = 
//				"select  "
//				+ "    ao.ACTIVITY_ORDER_ID, "
//				+ "	a.ACTIVITY_ID, "
//				+ "    a.ACTIVITY_NAME, "
//				+ "    m.MEMBER_NAME, "
//				+ "    m.MEMBER_ID, "
//				+ "    ase.ACTIVITY_SESSION_ID, "
//				+ "    ase.ACTIVITY_SESSION_START, "
//				+ "    ase.ACTIVITY_SESSION_END, "
//				+ "    ao.ORDER_TIME, "
//				+ "    ao.ENROLL_NUMBER, "
//				+ "    ao.ORDER_AMOUNT, "
//				+ "    ao.ORDER_STATE, "
//				+ "    ao.REFUND_STATE, "
//				+ "    ao.ORDER_MEMO "
//				+ "from "
//				+ "	ACTIVITY a "
//				+ "	join ACTIVITY_SESSION ase "
//				+ "		on a.ACTIVITY_ID = ase.ACTIVITY_ID "
//				+ "	join ACTIVITY_ORDER ao "
//				+ "		on ase.ACTIVITY_SESSION_ID = ao.ACTIVITY_SESSION_ID "
//				+ "	join MEMBERS m "
//				+ "		on ao.MEMBER_ID = m.MEMBER_ID;";
//		
//		@Override
//		public void insert(ActivityOrderVO activityOrderVO) {
//
//			Connection con = null;
//			PreparedStatement pstmt = null;
//
//			try {
//
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
//				pstmt = con.prepareStatement(INSERT_STMT); // INSERT_STMT變數帶入，等於下面這行code的意思
//
//
//				pstmt.setInt(1, activityOrderVO.getMemberId());
//				pstmt.setInt(2, activityOrderVO.getActivitySessionId());
//				pstmt.setTimestamp(3, activityOrderVO.getOrderTime());
//				pstmt.setInt(4, activityOrderVO.getEnrollNumber());
//				pstmt.setInt(5, activityOrderVO.getOrderAmount());
//				pstmt.setInt(6, activityOrderVO.getObderState());
//				pstmt.setInt(7, activityOrderVO.getRefundState());
//				pstmt.setString(8, activityOrderVO.getOrderMemo());
//
//				pstmt.executeUpdate();
//
//				// Handle any driver errors
//			} catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//				// Handle any SQL errors
//			} catch (SQLException se) {
//				throw new RuntimeException("A database error occured. " + se.getMessage());
//				// Clean up JDBC resources
//			} finally {
//				
//				if (pstmt != null) {
//					try {
//						pstmt.close();
//					} catch (SQLException se) {
//						se.printStackTrace(System.err);
//					}
//				}
//				if (con != null) {
//					try {
//						con.close();
//					} catch (Exception e) {
//						e.printStackTrace(System.err);
//					}
//				}
//			}
//
//		}
//
//		@Override
//		public void update(ActivityOrderVO activityOrderVO) {
//
//			Connection con = null;
//			PreparedStatement pstmt = null;
//
//			try {
//
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
//				pstmt = con.prepareStatement(UPDATE);
//
//				pstmt.setInt(1, activityOrderVO.getMemberId());
//				pstmt.setInt(2, activityOrderVO.getActivitySessionId());
//				pstmt.setTimestamp(3, activityOrderVO.getOrderTime());
//				pstmt.setInt(4, activityOrderVO.getEnrollNumber());
//				pstmt.setInt(5, activityOrderVO.getOrderAmount());
//				pstmt.setInt(6, activityOrderVO.getObderState());
//				pstmt.setInt(7, activityOrderVO.getRefundState());
//				pstmt.setString(8, activityOrderVO.getOrderMemo());
//				pstmt.setInt(9, activityOrderVO.getActivityOrderId());
//
//
//				pstmt.executeUpdate();
//
//				// Handle any driver errors
//			} catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//				// Handle any SQL errors
//			} catch (SQLException se) {
//				throw new RuntimeException("A database error occured. " + se.getMessage());
//				// Clean up JDBC resources
//			} finally {
//				if (pstmt != null) {
//					try {
//						pstmt.close();
//					} catch (SQLException se) {
//						se.printStackTrace(System.err);
//					}
//				}
//				if (con != null) {
//					try {
//						con.close();
//					} catch (Exception e) {
//						e.printStackTrace(System.err);
//					}
//				}
//			}
//
//		}
//
//		@Override
//		public ActivityOrderVO findByPrimaryKey(Integer activityOrderId) {
//
//			ActivityOrderVO activityOrderVO = null;
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//
//			try {
//
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
//				pstmt = con.prepareStatement(GET_ONE_STMT);
//
//				pstmt.setInt(1, activityOrderId);
//
//				rs = pstmt.executeQuery();
//
//
//				while (rs.next()) {
//
//					activityOrderVO = new ActivityOrderVO();
//					activityOrderVO.setActivityOrderId(rs.getInt("ACTIVITY_ORDER_ID"));
//					activityOrderVO.setMemberId(rs.getInt("MEMBER_ID"));
//					activityOrderVO.setActivitySessionId(rs.getInt("ACTIVITY_SESSION_ID"));
//					activityOrderVO.setOrderTime(rs.getTimestamp("ORDER_TIME"));
//					activityOrderVO.setEnrollNumber(rs.getInt("ENROLL_NUMBER"));
//					activityOrderVO.setOrderAmount(rs.getInt("ORDER_AMOUNT"));
//					activityOrderVO.setObderState(rs.getInt("ORDER_STATE"));
//					activityOrderVO.setRefundState(rs.getInt("REFUND_STATE"));
//					activityOrderVO.setOrderMemo(rs.getString("ORDER_MEMO"));
//
//				}
//
//				// Handle any driver errors
//			} catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//				// Handle any SQL errors
//			} catch (SQLException se) {
//				throw new RuntimeException("A database error occured. " + se.getMessage());
//				// Clean up JDBC resources
//			} finally {
//				if (rs != null) {
//					try {
//						rs.close();
//					} catch (SQLException se) {
//						se.printStackTrace(System.err);
//					}
//				}
//				if (pstmt != null) {
//					try {
//						pstmt.close();
//					} catch (SQLException se) {
//						se.printStackTrace(System.err);
//					}
//				}
//				if (con != null) {
//					try {
//						con.close();
//					} catch (Exception e) {
//						e.printStackTrace(System.err);
//					}
//				}
//			}
//			return activityOrderVO;
//		}
//
//		@Override
//		public List<ActivityOrderVO> getAll() {
//			List<ActivityOrderVO> list = new ArrayList<ActivityOrderVO>();
//			
//			ActivityOrderVO activityOrderVO = null;
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//
//			try {
//
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
//				pstmt = con.prepareStatement(GET_ALL_STMT);
//				rs = pstmt.executeQuery();
//
//				while (rs.next()) {
//					activityOrderVO = new ActivityOrderVO();
//					activityOrderVO.setActivityOrderId(rs.getInt("ACTIVITY_ORDER_ID"));
//					activityOrderVO.setMemberId(rs.getInt("MEMBER_ID"));
//					activityOrderVO.setActivitySessionId(rs.getInt("ACTIVITY_SESSION_ID"));
//					activityOrderVO.setOrderTime(rs.getTimestamp("ORDER_TIME"));
//					activityOrderVO.setEnrollNumber(rs.getInt("ENROLL_NUMBER"));
//					activityOrderVO.setOrderAmount(rs.getInt("ORDER_AMOUNT"));
//					activityOrderVO.setObderState(rs.getInt("ORDER_STATE"));
//					activityOrderVO.setRefundState(rs.getInt("REFUND_STATE"));
//					activityOrderVO.setOrderMemo(rs.getString("ORDER_MEMO"));
//					list.add(activityOrderVO); // Store the row in the list
//				}
//
//				// Handle any driver errors
//			} catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//				// Handle any SQL errors
//			} catch (SQLException se) {
//				throw new RuntimeException("A database error occured. " + se.getMessage());
//				// Clean up JDBC resources
//			} finally {
//				if (rs != null) {
//					try {
//						rs.close();
//					} catch (SQLException se) {
//						se.printStackTrace(System.err);
//					}
//				}
//				if (pstmt != null) {
//					try {
//						pstmt.close();
//					} catch (SQLException se) {
//						se.printStackTrace(System.err);
//					}
//				}
//				if (con != null) {
//					try {
//						con.close();
//					} catch (Exception e) {
//						e.printStackTrace(System.err);
//					}
//				}
//			}
//			return list;
//		}
//
//	
//		
//		
//		
//		public static void main(String[] args) throws IOException {
//
//			ActivityOrderJDBCDAO dao = new ActivityOrderJDBCDAO();
//
//			// 新增
////			ActivityOrderVO activityOrderVO1 = new ActivityOrderVO();
////			
////			activityOrderVO1.setMemberId(2);
////			activityOrderVO1.setActivitySessionId(14);
////			activityOrderVO1.setOrderTime(java.sql.Timestamp.valueOf("2022-07-07 13:00"));
////			activityOrderVO1.setEnrollNumber(1);
////			activityOrderVO1.setOrderAmount(2000);
////			activityOrderVO1.setObderState(0);
////			activityOrderVO1.setRefundState(0);
////			activityOrderVO1.setOrderMemo("無");
////				dao.insert(activityOrderVO1);
//
//			// 修改
////			ActivityOrderVO activityOrderVO2 = new ActivityOrderVO();
////			activityOrderVO2.setActivityOrderId(1);
////		
////			activityOrderVO2.setMemberId(3);
////			activityOrderVO2.setActivitySessionId(2);
////			activityOrderVO2.setOrderTime(java.sql.Timestamp.valueOf("2022-01-07 15:00:00"));
////			activityOrderVO2.setEnrollNumber(2);
////			activityOrderVO2.setOrderAmount(5000);
////			activityOrderVO2.setObderState(1);
////			activityOrderVO2.setRefundState(1);
////			activityOrderVO2.setOrderMemo("修改過的內容");
////			dao.update(activityOrderVO2);
//
//
//			// 單一查詢
////			ActivityOrderVO activityOrderVO3 = dao.findByPrimaryKey(1);
////			System.out.print(activityOrderVO3.getMemberId() + ",");
////			System.out.print(activityOrderVO3.getActivitySessionId() + ",");
////			System.out.print(activityOrderVO3.getOrderTime() + ",");
////			System.out.print(activityOrderVO3.getEnrollNumber() + ",");
////			System.out.println(activityOrderVO3.getOrderAmount() + ",");
////			System.out.print(activityOrderVO3.getObderState() + ",");
////			System.out.print(activityOrderVO3.getRefundState() + ",");
////			System.out.println(activityOrderVO3.getOrderMemo());
////			
////			System.out.println("---------------------");
//
//			// 查詢全部
////				List<ActivityOrderVO> list = dao.getAll();
////				for (ActivityOrderVO aorder : list) {
////					System.out.print(aorder.getActivityOrderId() + ",");
////					System.out.print(aorder.getMemberId() + ",");
////					System.out.print(aorder.getActivitySessionId() + ",");
////					System.out.print(aorder.getOrderTime() + ",");
////					System.out.print(aorder.getEnrollNumber() + ",");
////					System.out.print(aorder.getOrderAmount() + ",");
////					System.out.print(aorder.getObderState() + ",");
////					System.out.print(aorder.getRefundState() + ",");
////					System.out.print(aorder.getOrderMemo());
////					System.out.println();
////				}
//
//		}
//	}
//
