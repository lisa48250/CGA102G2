package com.activity_session.model;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.activity.model.ActivityVO;

import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Activity;
import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_ActivitySession;

import java.sql.*;

public class ActivitySessionDAO implements ActivitySessionDAO_interface {

	// 一個應用程式中, 針對一個資料庫, 共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CGA102_2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = 
		"insert into ACTIVITY_SESSION(ACTIVITY_ID, ACTIVITY_SESSION_START, ACTIVITY_SESSION_END, ACTIVITY_ENROLL_STATE, STATUS_NOTE, ACTIVITY_MAX_PART, ACTIVITY_MIN_PART, ENROLL_TOTAL, ENROLL_START, ENROLL_END, ACTIVITY_SESSION_STATE) "
		+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = 
		"update ACTIVITY_SESSION "
		+ "set ACTIVITY_ID = ?, ACTIVITY_SESSION_START = ?, ACTIVITY_SESSION_END = ?, ACTIVITY_ENROLL_STATE = ?, STATUS_NOTE = ?, ACTIVITY_MAX_PART = ?, ACTIVITY_MIN_PART = ?, ENROLL_TOTAL = ?, ENROLL_START = ?, ENROLL_END = ?, ACTIVITY_SESSION_STATE = ? "
		+ "where ACTIVITY_SESSION_ID = ?";
	private static final String DELETE_STMT = 
		"delete from ACTIVITY_SESSION "
		+ "where ACTIVITY_SESSION_ID = ?";
	private static final String QUERY_ONE_STMT =
		"select ACTIVITY_SESSION_ID, ACTIVITY_ID, ACTIVITY_SESSION_START, ACTIVITY_SESSION_END, ACTIVITY_ENROLL_STATE, STATUS_NOTE, ACTIVITY_MAX_PART, ACTIVITY_MIN_PART, ENROLL_TOTAL, ENROLL_START, ENROLL_END, ACTIVITY_SESSION_STATE "
		+ "from ACTIVITY_SESSION "
		+ "where ACTIVITY_SESSION_ID = ?";
	private static final String QUERY_ALL_STMT =
		"select ACTIVITY_SESSION_ID, ACTIVITY_ID, ACTIVITY_SESSION_START, ACTIVITY_SESSION_END, ACTIVITY_ENROLL_STATE, STATUS_NOTE, ACTIVITY_MAX_PART, ACTIVITY_MIN_PART, ENROLL_TOTAL, ENROLL_START, ENROLL_END, ACTIVITY_SESSION_STATE "
		+ "from ACTIVITY_SESSION "
		+ "order by ACTIVITY_SESSION_ID";
	private static final String QUERY_STATE_IS_ONE_STMT =
		"select ACTIVITY_SESSION_ID, ACTIVITY_ID, ACTIVITY_SESSION_START, ACTIVITY_SESSION_END, ACTIVITY_ENROLL_STATE, STATUS_NOTE, ACTIVITY_MAX_PART, ACTIVITY_MIN_PART, ENROLL_TOTAL, ENROLL_START, ENROLL_END, ACTIVITY_SESSION_STATE "
		+ "from ACTIVITY_SESSION "
		+ "where ACTIVITY_SESSION_STATE = 1 "
		+ "order by ACTIVITY_SESSION_ID";

	@Override
	public void insert(ActivitySessionVO ActivitySessionVO) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(INSERT_STMT);
			
			ps.setInt(1, ActivitySessionVO.getActivity_ID());
			ps.setTimestamp(2, ActivitySessionVO.getActivity_session_start());
			ps.setTimestamp(3, ActivitySessionVO.getActivity_session_end());
			ps.setInt(4, ActivitySessionVO.getActivity_enroll_state());
			ps.setString(5, ActivitySessionVO.getStatus_note());
			ps.setInt(6, ActivitySessionVO.getActivity_max_part());
			ps.setInt(7, ActivitySessionVO.getActivity_min_part());
			ps.setInt(8, ActivitySessionVO.getEnroll_total());
			ps.setDate(9, ActivitySessionVO.getEnroll_start());
			ps.setDate(10, ActivitySessionVO.getEnroll_end());
			ps.setInt(11, ActivitySessionVO.getActivity_session_state());			
			
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
	public void update(ActivitySessionVO ActivitySessionVO) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(UPDATE_STMT);
			
			ps.setInt(1, ActivitySessionVO.getActivity_ID());
			ps.setTimestamp(2, ActivitySessionVO.getActivity_session_start());
			ps.setTimestamp(3, ActivitySessionVO.getActivity_session_end());
			ps.setInt(4, ActivitySessionVO.getActivity_enroll_state());
			ps.setString(5, ActivitySessionVO.getStatus_note());
			ps.setInt(6, ActivitySessionVO.getActivity_max_part());
			ps.setInt(7, ActivitySessionVO.getActivity_min_part());
			ps.setInt(8, ActivitySessionVO.getEnroll_total());
			ps.setDate(9, ActivitySessionVO.getEnroll_start());
			ps.setDate(10, ActivitySessionVO.getEnroll_end());
			ps.setInt(11, ActivitySessionVO.getActivity_session_state());
			ps.setInt(12, ActivitySessionVO.getActivity_session_ID());
			
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
	public void delete(Integer activity_session_ID) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(DELETE_STMT);
			
			ps.setInt(1, activity_session_ID);
			
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
	public ActivitySessionVO findByPrimaryKey(Integer activity_session_ID) {
		
		ActivitySessionVO actVO = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(QUERY_ONE_STMT);
			
			ps.setInt(1, activity_session_ID);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				actVO = new ActivitySessionVO();				
				actVO.setActivity_session_ID(rs.getInt("ACTIVITY_SESSION_ID"));
				actVO.setActivity_ID(rs.getInt("ACTIVITY_ID"));
				actVO.setActivity_session_start(rs.getTimestamp("ACTIVITY_SESSION_START"));
				actVO.setActivity_session_end(rs.getTimestamp("ACTIVITY_SESSION_END"));
				actVO.setActivity_enroll_state(rs.getInt("ACTIVITY_ENROLL_STATE"));
				actVO.setStatus_note(rs.getString("STATUS_NOTE"));
				actVO.setActivity_max_part(rs.getInt("ACTIVITY_MAX_PART"));
				actVO.setActivity_min_part(rs.getInt("ACTIVITY_MIN_PART"));
				actVO.setEnroll_total(rs.getInt("ENROLL_TOTAL"));
				actVO.setEnroll_start(rs.getDate("ENROLL_START"));
				actVO.setEnroll_end(rs.getDate("ENROLL_END"));
				actVO.setActivity_session_state(rs.getInt("ACTIVITY_SESSION_STATE"));
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
		
		return actVO;
	}

	@Override
	public List<ActivitySessionVO> getAll() {

		List<ActivitySessionVO> list = new ArrayList<ActivitySessionVO>();
		ActivitySessionVO activitySessionVO = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(QUERY_ALL_STMT);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				activitySessionVO = new ActivitySessionVO();
				activitySessionVO.setActivity_session_ID(rs.getInt("ACTIVITY_SESSION_ID"));
				activitySessionVO.setActivity_ID(rs.getInt("ACTIVITY_ID"));
				activitySessionVO.setActivity_session_start(rs.getTimestamp("ACTIVITY_SESSION_START"));
				activitySessionVO.setActivity_session_end(rs.getTimestamp("ACTIVITY_SESSION_END"));
				activitySessionVO.setActivity_enroll_state(rs.getInt("ACTIVITY_ENROLL_STATE"));
				activitySessionVO.setStatus_note(rs.getString("STATUS_NOTE"));
				activitySessionVO.setActivity_max_part(rs.getInt("ACTIVITY_MAX_PART"));
				activitySessionVO.setActivity_min_part(rs.getInt("ACTIVITY_MIN_PART"));
				activitySessionVO.setEnroll_total(rs.getInt("ENROLL_TOTAL"));
				activitySessionVO.setEnroll_start(rs.getDate("ENROLL_START"));
				activitySessionVO.setEnroll_end(rs.getDate("ENROLL_END"));
				activitySessionVO.setActivity_session_state(rs.getInt("ACTIVITY_SESSION_STATE"));
				list.add(activitySessionVO);
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

	@Override
	public List<ActivitySessionVO> getAll(Map<String, String[]> map) {
		List<ActivitySessionVO> list = new ArrayList<ActivitySessionVO>();
		ActivitySessionVO activitySessionVO = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			
			conn = ds.getConnection();
			String finalSQL = "select * from ACTIVITY_SESSION "
		          + jdbcUtil_CompositeQuery_ActivitySession.get_WhereCondition(map)
		          + "order by ACTIVITY_SESSION_ID";
			ps = conn.prepareStatement(finalSQL);
			System.out.println("●●finalSQL(by DAO) = "+finalSQL);
			rs = ps.executeQuery();
	
			while (rs.next()) {
				activitySessionVO = new ActivitySessionVO();
				activitySessionVO.setActivity_session_ID(rs.getInt("ACTIVITY_SESSION_ID"));
				activitySessionVO.setActivity_ID(rs.getInt("ACTIVITY_ID"));
				activitySessionVO.setActivity_session_start(rs.getTimestamp("ACTIVITY_SESSION_START"));
				activitySessionVO.setActivity_session_end(rs.getTimestamp("ACTIVITY_SESSION_END"));
				activitySessionVO.setActivity_enroll_state(rs.getInt("ACTIVITY_ENROLL_STATE"));
				activitySessionVO.setStatus_note(rs.getString("STATUS_NOTE"));
				activitySessionVO.setActivity_max_part(rs.getInt("ACTIVITY_MAX_PART"));
				activitySessionVO.setActivity_min_part(rs.getInt("ACTIVITY_MIN_PART"));
				activitySessionVO.setEnroll_total(rs.getInt("ENROLL_TOTAL"));
				activitySessionVO.setEnroll_start(rs.getDate("ENROLL_START"));
				activitySessionVO.setEnroll_end(rs.getDate("ENROLL_END"));
				activitySessionVO.setActivity_session_state(rs.getInt("ACTIVITY_SESSION_STATE"));
				list.add(activitySessionVO); // Store the row in the List
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

	@Override
	public List<ActivitySessionVO> getActivitySessionsWhereStateIsOne() {

		List<ActivitySessionVO> list = new ArrayList<ActivitySessionVO>();
		ActivitySessionVO activitySessionVO = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(QUERY_STATE_IS_ONE_STMT);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				activitySessionVO = new ActivitySessionVO();
				activitySessionVO.setActivity_session_ID(rs.getInt("ACTIVITY_SESSION_ID"));
				activitySessionVO.setActivity_ID(rs.getInt("ACTIVITY_ID"));
				activitySessionVO.setActivity_session_start(rs.getTimestamp("ACTIVITY_SESSION_START"));
				activitySessionVO.setActivity_session_end(rs.getTimestamp("ACTIVITY_SESSION_END"));
				activitySessionVO.setActivity_enroll_state(rs.getInt("ACTIVITY_ENROLL_STATE"));
				activitySessionVO.setStatus_note(rs.getString("STATUS_NOTE"));
				activitySessionVO.setActivity_max_part(rs.getInt("ACTIVITY_MAX_PART"));
				activitySessionVO.setActivity_min_part(rs.getInt("ACTIVITY_MIN_PART"));
				activitySessionVO.setEnroll_total(rs.getInt("ENROLL_TOTAL"));
				activitySessionVO.setEnroll_start(rs.getDate("ENROLL_START"));
				activitySessionVO.setEnroll_end(rs.getDate("ENROLL_END"));
				activitySessionVO.setActivity_session_state(rs.getInt("ACTIVITY_SESSION_STATE"));
				list.add(activitySessionVO); // Store the row in the List
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