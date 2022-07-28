package com.activity.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.activity_photo.model.ActivityPhotoVO;
import com.activity_session.model.ActivitySessionVO;

import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Activity;

public class ActivityDAO implements ActivityDAO_interface {

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
		"insert into ACTIVITY(ACTIVITY_CATEGORY_ID, ACTIVITY_NAME, ACTIVITY_PRICE, ACTIVITY_START, ACTIVITY_END, ACTIVITY_DESCRIPTION, ACTIVITY_CONTENT, ACTIVITY_INFO, ACTIVITY_STATE) "
		+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String UPDATE_STMT = 
		"update ACTIVITY "
		+ "set ACTIVITY_CATEGORY_ID = ?, ACTIVITY_NAME = ?, ACTIVITY_PRICE = ?, ACTIVITY_START = ?, ACTIVITY_END = ?, ACTIVITY_DESCRIPTION = ?, ACTIVITY_CONTENT = ?, ACTIVITY_INFO = ?, ACTIVITY_STATE = ? "
		+ "where ACTIVITY_ID = ?";
	
	private static final String DELETE_STMT = 
		"delete from ACTIVITY "
		+ "where ACTIVITY_ID = ?";
	
	private static final String QUERY_ONE_STMT =
		"select ACTIVITY_ID, ACTIVITY_CATEGORY_ID, ACTIVITY_NAME, ACTIVITY_PRICE, ACTIVITY_START, ACTIVITY_END, ACTIVITY_DESCRIPTION, ACTIVITY_CONTENT, ACTIVITY_INFO, ACTIVITY_STATE "
		+ "from ACTIVITY "
		+ "where ACTIVITY_ID = ?";
	private static final String QUERY_ALL_STMT =
		"select ACTIVITY_ID, ACTIVITY_CATEGORY_ID, ACTIVITY_NAME, ACTIVITY_PRICE, ACTIVITY_START, ACTIVITY_END, ACTIVITY_DESCRIPTION, ACTIVITY_CONTENT, ACTIVITY_INFO, ACTIVITY_STATE "
		+ "from ACTIVITY "
		+ "order by ACTIVITY_ID";
	private static final String QUERY_ActivitySessions_ByActivity_ID_STMT =
		"select ACTIVITY_SESSION_ID, ACTIVITY_ID, ACTIVITY_SESSION_START, ACTIVITY_SESSION_END, ACTIVITY_ENROLL_STATE, STATUS_NOTE, ACTIVITY_MAX_PART, ACTIVITY_MIN_PART, ENROLL_TOTAL, ENROLL_START, ENROLL_END, ACTIVITY_SESSION_STATE "
		+ "from ACTIVITY_SESSION "
		+ "where ACTIVITY_ID = ? "
		+ "order by ACTIVITY_SESSION_ID";
	private static final String QUERY_ActivityPhotos_ByActivity_ID_STMT =
		"select ACTIVITY_PHOTO_ID, ACTIVITY_ID, ACTIVITY_PHOTO "
		+ "from ACTIVITY_PHOTO "
		+ "where ACTIVITY_ID = ? "
		+ "order by ACTIVITY_PHOTO_ID";
	private static final String QUERY_STATE_IS_ONE_STMT =
		"select ACTIVITY_ID, ACTIVITY_CATEGORY_ID, ACTIVITY_NAME, ACTIVITY_PRICE, ACTIVITY_START, ACTIVITY_END, ACTIVITY_DESCRIPTION, ACTIVITY_CONTENT, ACTIVITY_INFO, ACTIVITY_STATE "
		+ "from ACTIVITY "
		+ "where ACTIVITY_STATE = 1 "
		+ "order by ACTIVITY_ID";
	

	@Override
	public void insert(ActivityVO ActivityVO) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(INSERT_STMT);
			
			ps.setInt(1, ActivityVO.getActivity_category_ID());
			ps.setString(2, ActivityVO.getActivity_name());
			ps.setInt(3, ActivityVO.getActivity_price());
			ps.setDate(4, ActivityVO.getActivity_start());
			ps.setDate(5, ActivityVO.getActivity_end());
			ps.setString(6, ActivityVO.getActivity_description());
			ps.setString(7, ActivityVO.getActivity_content());
			ps.setString(8, ActivityVO.getActivity_info());
			ps.setInt(9, ActivityVO.getActivity_state());
			
			
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
	public void update(ActivityVO ActivityVO) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(UPDATE_STMT);
			
			ps.setInt(1, ActivityVO.getActivity_category_ID());
			ps.setString(2, ActivityVO.getActivity_name());
			ps.setInt(3, ActivityVO.getActivity_price());
			ps.setDate(4, ActivityVO.getActivity_start());
			ps.setDate(5, ActivityVO.getActivity_end());
			ps.setString(6, ActivityVO.getActivity_description());
			ps.setString(7, ActivityVO.getActivity_content());
			ps.setString(8, ActivityVO.getActivity_info());
			ps.setInt(9, ActivityVO.getActivity_state());
			ps.setInt(10, ActivityVO.getActivity_ID());
			
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
	public void delete(Integer activity_ID) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(DELETE_STMT);
			
			ps.setInt(1, activity_ID);
			
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
	public ActivityVO findByPrimaryKey(Integer activity_ID) {
		
		ActivityVO actVO = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(QUERY_ONE_STMT);
			
			ps.setInt(1, activity_ID);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				actVO = new ActivityVO();
				actVO.setActivity_ID(rs.getInt("ACTIVITY_ID"));
				actVO.setActivity_category_ID(rs.getInt("ACTIVITY_CATEGORY_ID"));
				actVO.setActivity_name(rs.getString("ACTIVITY_NAME"));
				actVO.setActivity_price(rs.getInt("ACTIVITY_PRICE"));
				actVO.setActivity_start(rs.getDate("ACTIVITY_START"));
				actVO.setActivity_end(rs.getDate("ACTIVITY_END"));
				actVO.setActivity_description(rs.getString("ACTIVITY_DESCRIPTION"));
				actVO.setActivity_content(rs.getString("ACTIVITY_CONTENT"));
				actVO.setActivity_info(rs.getString("ACTIVITY_INFO"));
				actVO.setActivity_state(rs.getInt("ACTIVITY_STATE"));
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
	public List<ActivityVO> getAll() {

		List<ActivityVO> list = new ArrayList<ActivityVO>();
		ActivityVO activityVO = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(QUERY_ALL_STMT);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				activityVO = new ActivityVO();
				activityVO.setActivity_ID(rs.getInt("ACTIVITY_ID"));
				activityVO.setActivity_category_ID(rs.getInt("ACTIVITY_CATEGORY_ID"));
				activityVO.setActivity_name(rs.getString("ACTIVITY_NAME"));
				activityVO.setActivity_price(rs.getInt("ACTIVITY_PRICE"));
				activityVO.setActivity_start(rs.getDate("ACTIVITY_START"));
				activityVO.setActivity_end(rs.getDate("ACTIVITY_END"));
				activityVO.setActivity_description(rs.getString("ACTIVITY_DESCRIPTION"));
				activityVO.setActivity_content(rs.getString("ACTIVITY_CONTENT"));
				activityVO.setActivity_info(rs.getString("ACTIVITY_INFO"));
				activityVO.setActivity_state(rs.getInt("ACTIVITY_STATE"));
				list.add(activityVO);
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
	public List<ActivityVO> getAll(Map<String, String[]> map) {
		List<ActivityVO> list = new ArrayList<ActivityVO>();
		ActivityVO activityVO = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			
			conn = ds.getConnection();
			String finalSQL = "select * from ACTIVITY "
		          + jdbcUtil_CompositeQuery_Activity.get_WhereCondition(map)
		          + "order by ACTIVITY_ID";
			ps = conn.prepareStatement(finalSQL);
			System.out.println("●●finalSQL(by DAO) = "+finalSQL);
			rs = ps.executeQuery();
	
			while (rs.next()) {
				activityVO = new ActivityVO();
				activityVO.setActivity_ID(rs.getInt("ACTIVITY_ID"));
				activityVO.setActivity_category_ID(rs.getInt("ACTIVITY_CATEGORY_ID"));
				activityVO.setActivity_name(rs.getString("ACTIVITY_NAME"));
				activityVO.setActivity_price(rs.getInt("ACTIVITY_PRICE"));
				activityVO.setActivity_start(rs.getDate("ACTIVITY_START"));
				activityVO.setActivity_end(rs.getDate("ACTIVITY_END"));
				activityVO.setActivity_description(rs.getString("ACTIVITY_DESCRIPTION"));
				activityVO.setActivity_content(rs.getString("ACTIVITY_CONTENT"));
				activityVO.setActivity_info(rs.getString("ACTIVITY_INFO"));
				activityVO.setActivity_state(rs.getInt("ACTIVITY_STATE"));
				list.add(activityVO); // Store the row in the List
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
	public Set<ActivitySessionVO> getActivitySessionsByActivity_ID(Integer activity_ID) {
		Set<ActivitySessionVO> set = new LinkedHashSet<ActivitySessionVO>();
		ActivitySessionVO activitySessionVO = null;
	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
	
			conn = ds.getConnection();
			ps = conn.prepareStatement(QUERY_ActivitySessions_ByActivity_ID_STMT);
			ps.setInt(1, activity_ID);
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
				set.add(activitySessionVO); // Store the row in the List
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
		return set;
	}

	@Override
	public Set<ActivityPhotoVO> getActivityPhotosByActivity_ID(Integer activity_ID) {
		Set<ActivityPhotoVO> set = new LinkedHashSet<ActivityPhotoVO>();
		ActivityPhotoVO activityPhotoVO = null;
	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
	
			conn = ds.getConnection();
			ps = conn.prepareStatement(QUERY_ActivityPhotos_ByActivity_ID_STMT);
			ps.setInt(1, activity_ID);
			rs = ps.executeQuery();
	
			while (rs.next()) {
				activityPhotoVO = new ActivityPhotoVO();
				activityPhotoVO.setActivity_photo_ID(rs.getInt("ACTIVITY_PHOTO_ID"));
				activityPhotoVO.setActivity_ID(rs.getInt("ACTIVITY_ID"));
				activityPhotoVO.setActivity_photo(rs.getBytes("ACTIVITY_PHOTO"));
				set.add(activityPhotoVO); // Store the row in the List
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
		return set;
	}

	@Override
	public List<ActivityVO> getActivitiesWhereStateIsOne() {

		List<ActivityVO> list = new ArrayList<ActivityVO>();
		ActivityVO activityVO = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(QUERY_STATE_IS_ONE_STMT);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				activityVO = new ActivityVO();
				activityVO.setActivity_ID(rs.getInt("ACTIVITY_ID"));
				activityVO.setActivity_category_ID(rs.getInt("ACTIVITY_CATEGORY_ID"));
				activityVO.setActivity_name(rs.getString("ACTIVITY_NAME"));
				activityVO.setActivity_price(rs.getInt("ACTIVITY_PRICE"));
				activityVO.setActivity_start(rs.getDate("ACTIVITY_START"));
				activityVO.setActivity_end(rs.getDate("ACTIVITY_END"));
				activityVO.setActivity_description(rs.getString("ACTIVITY_DESCRIPTION"));
				activityVO.setActivity_content(rs.getString("ACTIVITY_CONTENT"));
				activityVO.setActivity_info(rs.getString("ACTIVITY_INFO"));
				activityVO.setActivity_state(rs.getInt("ACTIVITY_STATE"));
				list.add(activityVO);
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