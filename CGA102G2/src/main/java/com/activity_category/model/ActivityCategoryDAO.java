package com.activity_category.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.activity.model.ActivityVO;

public class ActivityCategoryDAO implements ActivityCategoryDAO_interface {

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
		"insert into ACTIVITY_CATEGORY(ACTIVITY_CATEGORY_NAME, ACTIVITY_CATEGORY_INFO) "
		+ "values(?, ?)";
	
	private static final String UPDATE_STMT = 
		"update ACTIVITY_CATEGORY set ACTIVITY_CATEGORY_NAME = ?, ACTIVITY_CATEGORY_INFO = ? "
		+ "where ACTIVITY_CATEGORY_ID = ?";
	
	private static final String DELETE_STMT = 
		"delete from ACTIVITY_CATEGORY "
		+ "where ACTIVITY_CATEGORY_ID = ?";
	
	private static final String QUERY_ONE_STMT =
		"select ACTIVITY_CATEGORY_ID, ACTIVITY_CATEGORY_NAME, ACTIVITY_CATEGORY_INFO from ACTIVITY_CATEGORY "
		+ "where ACTIVITY_CATEGORY_ID = ?";
	private static final String QUERY_ALL_STMT =
		"select ACTIVITY_CATEGORY_ID, ACTIVITY_CATEGORY_NAME, ACTIVITY_CATEGORY_INFO from ACTIVITY_CATEGORY "
		+ "order by ACTIVITY_CATEGORY_ID";
	private static final String QUERY_Activities_ByActivity_category_ID_STMT =
		"select ACTIVITY_ID, ACTIVITY_CATEGORY_ID, ACTIVITY_NAME, ACTIVITY_PRICE, ACTIVITY_START, ACTIVITY_END, ACTIVITY_DESCRIPTION, ACTIVITY_CONTENT, ACTIVITY_INFO, ACTIVITY_STATE "
		+ "from ACTIVITY "
		+ "where ACTIVITY_CATEGORY_ID = ? "
		+ "order by ACTIVITY_ID";
	

	@Override
	public void insert(ActivityCategoryVO ActivityCategoryVO) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(INSERT_STMT);
			
			ps.setString(1, ActivityCategoryVO.getActivity_category_name());
			ps.setString(2, ActivityCategoryVO.getActivity_category_info());
			
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
	public void update(ActivityCategoryVO ActivityCategoryVO) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(UPDATE_STMT);
			
			ps.setString(1, ActivityCategoryVO.getActivity_category_name());
			ps.setString(2, ActivityCategoryVO.getActivity_category_info());
			ps.setInt(3, ActivityCategoryVO.getActivity_category_ID());
			
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
	public void delete(Integer activity_category_ID) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(DELETE_STMT);
			
			ps.setInt(1, activity_category_ID);
			
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
	public ActivityCategoryVO findByPrimaryKey(Integer activity_category_ID) {
		
		ActivityCategoryVO activityCategoryVO = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(QUERY_ONE_STMT);
			
			ps.setInt(1, activity_category_ID);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				activityCategoryVO = new ActivityCategoryVO();
				activityCategoryVO.setActivity_category_ID(rs.getInt("ACTIVITY_CATEGORY_ID"));
				activityCategoryVO.setActivity_category_name(rs.getString("ACTIVITY_CATEGORY_NAME"));
				activityCategoryVO.setActivity_category_info(rs.getString("ACTIVITY_CATEGORY_INFO"));
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
		
		return activityCategoryVO;
	}

	@Override
	public List<ActivityCategoryVO> getAll() {

		List<ActivityCategoryVO> list = new ArrayList<ActivityCategoryVO>();
		ActivityCategoryVO activityCategoryVO = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(QUERY_ALL_STMT);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				activityCategoryVO = new ActivityCategoryVO();
				activityCategoryVO.setActivity_category_ID(rs.getInt("ACTIVITY_CATEGORY_ID"));
				activityCategoryVO.setActivity_category_name(rs.getString("ACTIVITY_CATEGORY_NAME"));
				activityCategoryVO.setActivity_category_info(rs.getString("ACTIVITY_CATEGORY_INFO"));
				list.add(activityCategoryVO);
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
	public Set<ActivityVO> getActivitiesByActivity_category_ID(Integer activity_category_ID) {
		Set<ActivityVO> set = new LinkedHashSet<ActivityVO>();
		ActivityVO activityVO = null;
	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
	
			conn = ds.getConnection();
			ps = conn.prepareStatement(QUERY_Activities_ByActivity_category_ID_STMT);
			ps.setInt(1, activity_category_ID);
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
				set.add(activityVO); // Store the row in the List
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
	
}