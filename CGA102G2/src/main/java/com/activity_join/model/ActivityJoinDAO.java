package com.activity_join.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_ActivityOrder;

public class ActivityJoinDAO implements ActivityJoin_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CGA102_2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String GET_ORDER_ID = "select * from ACTIVITY_ORDER where ACTIVITY_ORDER_ID = ?";
	private static final String GET_ALL_STMT = "SELECT ACTIVITY_ORDER_ID,ACTIVITY_ID, MEMBER_ID, ACTIVITY_SESSION_ID, ORDER_TIME,ENROLL_NUMBER, ORDER_AMOUNT,ORDER_STATE ,REFUND_STATE, ORDER_MEMO FROM ACTIVITY_ORDER order by ACTIVITY_ORDER_ID";
	private static final String GET_ONE_STMT = "				SELECT " + "				 ao.ACTIVITY_ORDER_ID, "
			+ "				 a.ACTIVITY_ID, " + "				 a.ACTIVITY_NAME, " + "				 m.MEMBER_NAME, "
			+ "				 m.MEMBER_ID, " + "				 ase.ACTIVITY_SESSION_ID, "
			+ "				 ase.ACTIVITY_SESSION_START,  " + "				 ase.ACTIVITY_SESSION_END,  "
			+ "				 ao.ORDER_TIME,  " + "				 ao.ENROLL_NUMBER,  "
			+ "				 ao.ORDER_AMOUNT,  " + "				 ao.ORDER_STATE,  "
			+ "				 ao.REFUND_STATE, " + "				 ao.ORDER_MEMO  " + "				 from "
			+ "				 ACTIVITY a join ACTIVITY_SESSION ase  "
			+ "				 on a.ACTIVITY_ID = ase.ACTIVITY_ID join ACTIVITY_ORDER ao on ase.ACTIVITY_SESSION_ID = ao.ACTIVITY_SESSION_ID  "
			+ "				 join MEMBERS m on ao.MEMBER_ID = m.MEMBER_ID "
			+ "				 where ACTIVITY_ORDER_ID = ?;";
	private static final String GET_JOIN = "select  " + "    ao.ACTIVITY_ORDER_ID, " + "	a.ACTIVITY_ID, "
			+ "    a.ACTIVITY_NAME, " + "    m.MEMBER_NAME, " + "    m.MEMBER_ID, " + "    ase.ACTIVITY_SESSION_ID, "
			+ "    ase.ACTIVITY_SESSION_START, " + "    ase.ACTIVITY_SESSION_END, " + "    ao.ORDER_TIME, "
			+ "    ao.ENROLL_NUMBER, " + "    ao.ORDER_AMOUNT, " + "    ao.ORDER_STATE, " + "    ao.REFUND_STATE, "
			+ "    ao.ORDER_MEMO " + "from " + "	ACTIVITY a " + "	join ACTIVITY_SESSION ase "
			+ "		on a.ACTIVITY_ID = ase.ACTIVITY_ID " + "	join ACTIVITY_ORDER ao "
			+ "		on ase.ACTIVITY_SESSION_ID = ao.ACTIVITY_SESSION_ID " + "	join MEMBERS m "
			+ "		on ao.MEMBER_ID = m.MEMBER_ID" + " where 1 = 1 ";
	private static final String GET_ACTJOIN_STATEZERO = "SELECT  " + "ao.ACTIVITY_ORDER_ID,  " + "a.ACTIVITY_ID, "
			+ "a.ACTIVITY_NAME,  " + "m.MEMBER_NAME, " + "m.MEMBER_ID, " + "ase.ACTIVITY_SESSION_ID, "
			+ "ase.ACTIVITY_SESSION_START,  " + "ase.ACTIVITY_SESSION_END,  " + "ao.ORDER_TIME,  "
			+ "ao.ENROLL_NUMBER,  " + "ao.ORDER_AMOUNT,  " + "ao.ORDER_STATE,  " + "ao.REFUND_STATE, "
			+ "ao.ORDER_MEMO  " + "from " + "ACTIVITY a join ACTIVITY_SESSION ase  "
			+ "on a.ACTIVITY_ID = ase.ACTIVITY_ID join ACTIVITY_ORDER ao on ase.ACTIVITY_SESSION_ID = ao.ACTIVITY_SESSION_ID  "
			+ "join MEMBERS m on ao.MEMBER_ID = m.MEMBER_ID " + "where ORDER_STATE = 0 and m.MEMBER_ID =?;";
	private static final String GET_ACTJOIN_STATEONE = "SELECT  " + "ao.ACTIVITY_ORDER_ID,  " + "a.ACTIVITY_ID, "
			+ "a.ACTIVITY_NAME,  " + "m.MEMBER_NAME, " + "m.MEMBER_ID, " + "ase.ACTIVITY_SESSION_ID, "
			+ "ase.ACTIVITY_SESSION_START,  " + "ase.ACTIVITY_SESSION_END,  " + "ao.ORDER_TIME,  "
			+ "ao.ENROLL_NUMBER,  " + "ao.ORDER_AMOUNT,  " + "ao.ORDER_STATE,  " + "ao.REFUND_STATE, "
			+ "ao.ORDER_MEMO  " + "from " + "ACTIVITY a join ACTIVITY_SESSION ase  "
			+ "on a.ACTIVITY_ID = ase.ACTIVITY_ID join ACTIVITY_ORDER ao on ase.ACTIVITY_SESSION_ID = ao.ACTIVITY_SESSION_ID  "
			+ "join MEMBERS m on ao.MEMBER_ID = m.MEMBER_ID " + "where ORDER_STATE = 1 and m.MEMBER_ID =?;";

	private static final String GET_ACTJOIN_STATETWO = "SELECT  " + "ao.ACTIVITY_ORDER_ID,  " + "a.ACTIVITY_ID, "
			+ "a.ACTIVITY_NAME,  " + "m.MEMBER_NAME, " + "m.MEMBER_ID, " + "ase.ACTIVITY_SESSION_ID, "
			+ "ase.ACTIVITY_SESSION_START,  " + "ase.ACTIVITY_SESSION_END,  " + "ao.ORDER_TIME,  "
			+ "ao.ENROLL_NUMBER,  " + "ao.ORDER_AMOUNT,  " + "ao.ORDER_STATE,  " + "ao.REFUND_STATE, "
			+ "ao.ORDER_MEMO  " + "from " + "ACTIVITY a join ACTIVITY_SESSION ase  "
			+ "on a.ACTIVITY_ID = ase.ACTIVITY_ID join ACTIVITY_ORDER ao on ase.ACTIVITY_SESSION_ID = ao.ACTIVITY_SESSION_ID  "
			+ "join MEMBERS m on ao.MEMBER_ID = m.MEMBER_ID " + "where ORDER_STATE = 2 and m.MEMBER_ID =?;";

	private static final String UPDATE_STATE = "UPDATE ACTIVITY_ORDER set ORDER_STATE =2 ,REFUND_STATE =1  where ACTIVITY_ORDER_ID = ?"
			+ ";";

	private static final String INSERT_ACTJOIN_ORDER = "INSERT INTO ACTIVITY_ORDER( MEMBER_ID, ACTIVITY_SESSION_ID, ORDER_TIME, ENROLL_NUMBER, ORDER_AMOUNT, ORDER_MEMO) "
			+ "VALUES(?,?,NOW(),?,?,?);";

	private static final String SELECT_PRICE_BY_ID = "select ACTIVITY_NAME, ACTIVITY_PRICE from ACTIVITY where ACTIVITY_ID = ?";

	private static final String SELECT_DATETIME_BY_ID_DATE = "select ACTIVITY_SESSION_ID, ACTIVITY_SESSION_START, ACTIVITY_SESSION_END from ACTIVITY_SESSION where ACTIVITY_ID = ? and DATE(ACTIVITY_SESSION_START) = ?";
	
	//=========================================== Fei =========================================		
			private static final String GET_All = 
					"select  "
					+ "    ao.ACTIVITY_ORDER_ID, "
					+ "	   a.ACTIVITY_ID, "
					+ "    a.ACTIVITY_NAME, "
					+ "    m.MEMBER_NAME, "
					+ "    m.MEMBER_ID, "
					+ "    ase.ACTIVITY_SESSION_ID, "
					+ "    ase.ACTIVITY_SESSION_START, "
					+ "    ase.ACTIVITY_SESSION_END, "
					+ "    ao.ORDER_TIME, "
					+ "    ao.ENROLL_NUMBER, "
					+ "    ao.ORDER_AMOUNT, "
					+ "    ao.ORDER_STATE, "
					+ "    ao.REFUND_STATE, "
					+ "    ao.ORDER_MEMO "
					+ "from "
					+ "	ACTIVITY a "
					+ "	join ACTIVITY_SESSION ase "
					+ "		on a.ACTIVITY_ID = ase.ACTIVITY_ID "
					+ "	join ACTIVITY_ORDER ao "
					+ "		on ase.ACTIVITY_SESSION_ID = ao.ACTIVITY_SESSION_ID "
					+ "	join MEMBERS m "
					+ "		on ao.MEMBER_ID = m.MEMBER_ID "
					+ " order by ao.ACTIVITY_ORDER_ID";
			
			private static final String UPDATE_ACTIVITY_ORDER_STMT = 
					"update ACTIVITY_ORDER "
					+ "set REFUND_STATE = ? "
					+ " , ORDER_STATE = ? "
					+ "where ACTIVITY_ORDER_ID = ?";		
			
			
	//=========================================== 結束 =========================================		
	
	
	@Override
	public ActivityJoinVO findByPrimaryKey(Integer activityOrderId) {

		ActivityJoinVO activityJoinVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ds.getConnection();
			pstmt = conn.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, activityOrderId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				activityJoinVO = new ActivityJoinVO();
				activityJoinVO.setActivityOrderId(rs.getInt("ACTIVITY_ORDER_ID"));
				activityJoinVO.setActivityID(rs.getInt("ACTIVITY_ID"));
				activityJoinVO.setActivityName(rs.getString("ACTIVITY_NAME"));
				activityJoinVO.setMember_name(rs.getString("MEMBER_NAME"));
				activityJoinVO.setMember_id(rs.getInt("MEMBER_ID"));
				activityJoinVO.setActivitySessionID(rs.getInt("ACTIVITY_SESSION_ID"));
				activityJoinVO.setActivitySessionStart(rs.getTimestamp("ACTIVITY_SESSION_START"));
				activityJoinVO.setActivitySessionEnd(rs.getTimestamp("ACTIVITY_SESSION_END"));
				activityJoinVO.setOrderTime(rs.getTimestamp("ORDER_TIME"));
				activityJoinVO.setEnrollNumber(rs.getInt("ENROLL_NUMBER"));
				activityJoinVO.setOrderAmount(rs.getInt("ORDER_AMOUNT"));
				activityJoinVO.setOrderState(rs.getInt("ORDER_STATE"));
				activityJoinVO.setRefundState(rs.getInt("REFUND_STATE"));
				activityJoinVO.setOrderMemo(rs.getString("ORDER_MEMO"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
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
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return activityJoinVO;
	}

//	@Override
//	public List<ActivityJoinVO> getAll() {
//		List<ActivityJoinVO> list = new ArrayList<ActivityJoinVO>();
//
//		ActivityJoinVO activityJoinVO = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			conn = ds.getConnection();
//			pstmt = conn.prepareStatement(GET_JOIN);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				activityJoinVO = new ActivityJoinVO();
//				activityJoinVO.setActivityOrderId(rs.getInt("ACTIVITY_ORDER_ID"));
//				activityJoinVO.setActivityID(rs.getInt("ACTIVITY_ID"));
//				activityJoinVO.setActivityName(rs.getString("ACTIVITY_NAME"));
//				activityJoinVO.setMember_name(rs.getString("MEMBER_NAME"));
//				activityJoinVO.setMember_id(rs.getInt("MEMBER_ID"));
//				activityJoinVO.setActivitySessionID(rs.getInt("ACTIVITY_SESSION_ID"));
//				activityJoinVO.setActivitySessionStart(rs.getTimestamp("ACTIVITY_ENROLL_STATE"));
//				activityJoinVO.setActivitySessionEnd(rs.getTimestamp("ACTIVITY_SESSION_END"));
//				activityJoinVO.setOrderTime(rs.getTimestamp("ORDER_TIME"));
//				activityJoinVO.setEnrollNumber(rs.getInt("ENROLL_NUMBER"));
//				activityJoinVO.setOrderAmount(rs.getInt("ORDER_AMOUNT"));
//				activityJoinVO.setOrderState(rs.getInt("ORDER_STATE"));
//				activityJoinVO.setRefundState(rs.getInt("REFUND_STATE"));
//				activityJoinVO.setOrderMemo(rs.getString("ORDER_MEMO"));
//			}
//
//			// Handle any driver errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. " + se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//		return list;
//	}

	@Override
	public List<ActivityJoinVO> getJoin(Map<String, String[]> map) {
		List<ActivityJoinVO> list = new ArrayList<ActivityJoinVO>();
		ActivityJoinVO activityJoinVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = ds.getConnection();
			pstmt = conn.prepareStatement(GET_JOIN + getWhereClause(map));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				activityJoinVO = new ActivityJoinVO();
				activityJoinVO.setActivityOrderId(rs.getInt("ACTIVITY_ORDER_ID"));
				activityJoinVO.setActivityID(rs.getInt("ACTIVITY_ID"));
				activityJoinVO.setActivityName(rs.getString("ACTIVITY_NAME"));
				activityJoinVO.setMember_name(rs.getString("MEMBER_NAME"));
				activityJoinVO.setMember_id(rs.getInt("MEMBER_ID"));
				activityJoinVO.setActivitySessionID(rs.getInt("ACTIVITY_SESSION_ID"));
				activityJoinVO.setActivitySessionStart(rs.getTimestamp("ACTIVITY_SESSION_START"));
				activityJoinVO.setActivitySessionEnd(rs.getTimestamp("ACTIVITY_SESSION_END"));
				activityJoinVO.setOrderTime(rs.getTimestamp("ORDER_TIME"));
				activityJoinVO.setEnrollNumber(rs.getInt("ENROLL_NUMBER"));
				activityJoinVO.setOrderAmount(rs.getInt("ORDER_AMOUNT"));
				activityJoinVO.setOrderState(rs.getInt("ORDER_STATE"));
				activityJoinVO.setRefundState(rs.getInt("REFUND_STATE"));
				activityJoinVO.setOrderMemo(rs.getString("ORDER_MEMO"));
				list.add(activityJoinVO);
			}

			// Handle any driver errors
		} catch (SQLException se) {
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
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static String getWhereClause(Map<String, String[]> map) {
		StringBuffer whereClause = new StringBuffer();
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			String[] values = entry.getValue();
			if (Objects.equals("action", entry.getKey()) || values == null || values.length == 0 || values[0] == null
					|| values[0].length() == 0) {
				continue;
			}

			whereClause.append("and ").append(entry.getKey()).append(" = '").append(values[0]).append("' ");
		}
		return whereClause.toString();
	}

	@Override
	public List<ActivityJoinVO> getactStateZero(Integer member_id) {
		List<ActivityJoinVO> list = new ArrayList<ActivityJoinVO>();
		ActivityJoinVO activityJoinVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ACTJOIN_STATEZERO);
			pstmt.setInt(1,member_id);
			rs = pstmt.executeQuery();
			

			while (rs.next()) {
				activityJoinVO = new ActivityJoinVO();
				activityJoinVO.setActivityOrderId(rs.getInt("ACTIVITY_ORDER_ID"));
				activityJoinVO.setActivityID(rs.getInt("ACTIVITY_ID"));
				activityJoinVO.setActivityName(rs.getString("ACTIVITY_NAME"));
				activityJoinVO.setMember_name(rs.getString("MEMBER_NAME"));
				activityJoinVO.setMember_id(rs.getInt("MEMBER_ID"));
				activityJoinVO.setActivitySessionID(rs.getInt("ACTIVITY_SESSION_ID"));
				activityJoinVO.setActivitySessionStart(rs.getTimestamp("ACTIVITY_SESSION_START"));
				activityJoinVO.setActivitySessionEnd(rs.getTimestamp("ACTIVITY_SESSION_END"));
				activityJoinVO.setOrderTime(rs.getTimestamp("ORDER_TIME"));
				activityJoinVO.setEnrollNumber(rs.getInt("ENROLL_NUMBER"));
				activityJoinVO.setOrderAmount(rs.getInt("ORDER_AMOUNT"));
				activityJoinVO.setOrderState(rs.getInt("ORDER_STATE"));
				activityJoinVO.setRefundState(rs.getInt("REFUND_STATE"));
				activityJoinVO.setOrderMemo(rs.getString("ORDER_MEMO"));
				list.add(activityJoinVO);
			}

			// Handle any driver errors
		} catch (SQLException se) {
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
	public List<ActivityJoinVO> getactStateOne(Integer member_id) {
		List<ActivityJoinVO> list = new ArrayList<ActivityJoinVO>();
		ActivityJoinVO activityJoinVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ACTJOIN_STATEONE);
			pstmt.setInt(1,member_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				activityJoinVO = new ActivityJoinVO();
				activityJoinVO.setActivityOrderId(rs.getInt("ACTIVITY_ORDER_ID"));
				activityJoinVO.setActivityID(rs.getInt("ACTIVITY_ID"));
				activityJoinVO.setActivityName(rs.getString("ACTIVITY_NAME"));
				activityJoinVO.setMember_name(rs.getString("MEMBER_NAME"));
				activityJoinVO.setMember_id(rs.getInt("MEMBER_ID"));
				activityJoinVO.setActivitySessionID(rs.getInt("ACTIVITY_SESSION_ID"));
				activityJoinVO.setActivitySessionStart(rs.getTimestamp("ACTIVITY_SESSION_START"));
				activityJoinVO.setActivitySessionEnd(rs.getTimestamp("ACTIVITY_SESSION_END"));
				activityJoinVO.setOrderTime(rs.getTimestamp("ORDER_TIME"));
				activityJoinVO.setEnrollNumber(rs.getInt("ENROLL_NUMBER"));
				activityJoinVO.setOrderAmount(rs.getInt("ORDER_AMOUNT"));
				activityJoinVO.setOrderState(rs.getInt("ORDER_STATE"));
				activityJoinVO.setRefundState(rs.getInt("REFUND_STATE"));
				activityJoinVO.setOrderMemo(rs.getString("ORDER_MEMO"));
				list.add(activityJoinVO);
			}

			// Handle any driver errors
		} catch (SQLException se) {
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
	public List<ActivityJoinVO> getactStateTwo(Integer member_id) {
		List<ActivityJoinVO> list = new ArrayList<ActivityJoinVO>();
		ActivityJoinVO activityJoinVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ACTJOIN_STATETWO);
			pstmt.setInt(1,member_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				activityJoinVO = new ActivityJoinVO();
				activityJoinVO.setActivityOrderId(rs.getInt("ACTIVITY_ORDER_ID"));
				activityJoinVO.setActivityID(rs.getInt("ACTIVITY_ID"));
				activityJoinVO.setActivityName(rs.getString("ACTIVITY_NAME"));
				activityJoinVO.setMember_name(rs.getString("MEMBER_NAME"));
				activityJoinVO.setMember_id(rs.getInt("MEMBER_ID"));
				activityJoinVO.setActivitySessionID(rs.getInt("ACTIVITY_SESSION_ID"));
				activityJoinVO.setActivitySessionStart(rs.getTimestamp("ACTIVITY_SESSION_START"));
				activityJoinVO.setActivitySessionEnd(rs.getTimestamp("ACTIVITY_SESSION_END"));
				activityJoinVO.setOrderTime(rs.getTimestamp("ORDER_TIME"));
				activityJoinVO.setEnrollNumber(rs.getInt("ENROLL_NUMBER"));
				activityJoinVO.setOrderAmount(rs.getInt("ORDER_AMOUNT"));
				activityJoinVO.setOrderState(rs.getInt("ORDER_STATE"));
				activityJoinVO.setRefundState(rs.getInt("REFUND_STATE"));
				activityJoinVO.setOrderMemo(rs.getString("ORDER_MEMO"));
				list.add(activityJoinVO);
			}

			// Handle any driver errors
		} catch (SQLException se) {
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
	public void update(Integer activityOrderId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_STATE);
			pstmt.setInt(1, activityOrderId);
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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
	public void insert(ActivityJoinVO activityJoinVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_ACTJOIN_ORDER, new String[] { "ACTIVITY_ORDER_ID" }); // INSERT_STMT變數帶入，等於下面這行code的意思
			pstmt.setInt(1, activityJoinVO.getMember_id());
			pstmt.setInt(2, activityJoinVO.getActivitySessionID());
			pstmt.setInt(3, activityJoinVO.getEnrollNumber());
			pstmt.setInt(4, activityJoinVO.getOrderAmount());
			pstmt.setString(5, activityJoinVO.getOrderMemo());
			pstmt.executeUpdate();
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				if (rs.next()) {
					activityJoinVO.setActivityOrderId(rs.getInt(1));
				}
			}
		} catch (SQLException se) {
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
	public Map<String, Object> findPriceById(Integer activityId) {
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_PRICE_BY_ID)) {
			pstmt.setInt(1, activityId);
			try (ResultSet rs = pstmt.executeQuery()) {
				Map<String, Object> map = new HashMap<>();
				if (rs.next()) {
					map.put("name", rs.getString(1));
					map.put("price", rs.getInt(2));
					return map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return null;
	}

	@Override
	public Map<String, Object> findDateTimeByIdAndDate(Integer activityId, Timestamp date) {
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_DATETIME_BY_ID_DATE)) {
			pstmt.setInt(1, activityId);
			pstmt.setTimestamp(2, date);
			try (ResultSet rs = pstmt.executeQuery()) {
				Map<String, Object> map = new HashMap<>();
				if (rs.next()) {
					map.put("id", rs.getInt(1));
					map.put("start", rs.getTimestamp(2));
					map.put("end", rs.getTimestamp(3));
					return map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return null;
	}

	@Override
	public ActivityJoinVO findOrderById(Integer activityOrderId) {
		try (
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(GET_ORDER_ID);
		) {
			pstmt.setInt(1, activityOrderId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ActivityJoinVO vo = new ActivityJoinVO();
					vo.setActivityOrderId(rs.getInt(1));
					vo.setMember_id(rs.getInt(2));
					vo.setActivitySessionID(rs.getInt(3));
					vo.setOrderTime(rs.getTimestamp(4));
					vo.setEnrollNumber(rs.getInt(5));
					vo.setOrderAmount(rs.getInt(6));
					vo.setOrderState(rs.getInt(7));
					vo.setRefundState(rs.getInt(8));
					vo.setOrderMemo(rs.getString(9));
					return vo;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//=========================================== Fei =========================================
			@Override
			public List<ActivityJoinVO> getAll() {
				List<ActivityJoinVO> list = new ArrayList<ActivityJoinVO>();
				ActivityJoinVO activityJoinVO = null;
				Connection conn = null; 
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(GET_All);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					activityJoinVO = new ActivityJoinVO();
					activityJoinVO.setActivityOrderId(rs.getInt("ACTIVITY_ORDER_ID"));
					activityJoinVO.setActivityID(rs.getInt("ACTIVITY_ID"));
					activityJoinVO.setActivityName(rs.getString("ACTIVITY_NAME"));
					activityJoinVO.setMember_name(rs.getString("MEMBER_NAME"));
					activityJoinVO.setMember_id(rs.getInt("MEMBER_ID"));
					activityJoinVO.setActivitySessionID(rs.getInt("ACTIVITY_SESSION_ID"));
					activityJoinVO.setActivitySessionStart(rs.getTimestamp("ACTIVITY_SESSION_START"));
					activityJoinVO.setActivitySessionEnd(rs.getTimestamp("ACTIVITY_SESSION_END"));
					activityJoinVO.setOrderTime(rs.getTimestamp("ORDER_TIME"));
					activityJoinVO.setEnrollNumber(rs.getInt("ENROLL_NUMBER"));
					activityJoinVO.setOrderAmount(rs.getInt("ORDER_AMOUNT"));
					activityJoinVO.setOrderState(rs.getInt("ORDER_STATE"));
					activityJoinVO.setRefundState(rs.getInt("REFUND_STATE"));
					activityJoinVO.setOrderMemo(rs.getString("ORDER_MEMO"));
					list.add(activityJoinVO);
					}

					// Handle any driver errors
				}catch (SQLException se) {
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
					if (conn != null) {
						try {
							conn.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}
					return list;
			}
		
			@Override
			public void updateActivityOrder(ActivityJoinVO ActivityJoinVO) {

				Connection conn = null;
				PreparedStatement ps = null;
				
				try {
					
					conn = ds.getConnection();
					ps = conn.prepareStatement(UPDATE_ACTIVITY_ORDER_STMT);
					
					ps.setInt(1, ActivityJoinVO.getRefundState());
					ps.setInt(2, ActivityJoinVO.getOrderState());
					ps.setInt(3, ActivityJoinVO.getActivityOrderId());
					
					ps.executeUpdate();	
					
					// Handle any driver errors
				} catch (SQLException se) {			
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
					
					// Clean up JDBC resources
				} finally {
					if (ps != null) {
						try {
							ps.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					
					if (conn != null) {
						try {
							conn.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}
				
			}
			
			@Override
			public List<ActivityJoinVO> getAll(Map<String, String[]> map) {
				List<ActivityJoinVO> list = new ArrayList<ActivityJoinVO>();
				ActivityJoinVO activityJoinVO = null;
				
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
			
				try {
					
					conn = ds.getConnection();
					String finalSQL = "select * from ACTIVITY_ORDER "
				          + jdbcUtil_CompositeQuery_ActivityOrder.get_WhereCondition(map)
				          + "order by ACTIVITY_ORDER_ID";
					ps = conn.prepareStatement(finalSQL);
					System.out.println("���inalSQL(by DAO) = "+finalSQL);
					rs = ps.executeQuery();
			
					while (rs.next()) {
						activityJoinVO = new ActivityJoinVO();
						activityJoinVO.setActivityOrderId(rs.getInt("ACTIVITY_ORDER_ID"));
						activityJoinVO.setMember_id(rs.getInt("MEMBER_ID"));
						activityJoinVO.setActivitySessionID(rs.getInt("ACTIVITY_SESSION_ID"));
						activityJoinVO.setOrderTime(rs.getTimestamp("ORDER_TIME"));
						activityJoinVO.setEnrollNumber(rs.getInt("ENROLL_NUMBER"));
						activityJoinVO.setOrderAmount(rs.getInt("ORDER_AMOUNT"));
						activityJoinVO.setOrderState(rs.getInt("ORDER_STATE"));
						activityJoinVO.setRefundState(rs.getInt("REFUND_STATE"));
						activityJoinVO.setOrderMemo(rs.getString("ORDER_MEMO"));
						list.add(activityJoinVO); // Store the row in the List
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
					if (ps != null) {
						try {
							ps.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
					if (conn != null) {
						try {
							conn.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}
				return list;
			}
}