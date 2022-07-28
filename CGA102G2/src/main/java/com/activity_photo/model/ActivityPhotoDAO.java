package com.activity_photo.model;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.*;

public class ActivityPhotoDAO implements ActivityPhotoDAO_interface {

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
		"insert into ACTIVITY_PHOTO(ACTIVITY_ID, ACTIVITY_PHOTO) "
		+ "values(?, ?)";
	private static final String UPDATE_STMT = 
		"update ACTIVITY_PHOTO "
		+ "set ACTIVITY_ID = ?, ACTIVITY_PHOTO = ? "
		+ "where ACTIVITY_PHOTO_ID = ?";
	private static final String DELETE_STMT = 
		"delete from ACTIVITY_PHOTO "
		+ "where ACTIVITY_PHOTO_ID = ?";
	private static final String QUERY_ONE_STMT =
		"select ACTIVITY_PHOTO_ID, ACTIVITY_ID, ACTIVITY_PHOTO "
		+ "from ACTIVITY_PHOTO "
		+ "where ACTIVITY_PHOTO_ID = ?";
	private static final String QUERY_ALL_STMT =
		"select ACTIVITY_PHOTO_ID, ACTIVITY_ID, ACTIVITY_PHOTO "
		+ "from ACTIVITY_PHOTO "
		+ "order by ACTIVITY_PHOTO_ID";

	@Override
	public void insert(ActivityPhotoVO ActivityPhotoVO) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(INSERT_STMT);
			
			ps.setInt(1, ActivityPhotoVO.getActivity_ID());
			ps.setBytes(2, ActivityPhotoVO.getActivity_photo());
			
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
	public void update(ActivityPhotoVO ActivityPhotoVO) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(UPDATE_STMT);
			
			ps.setInt(1, ActivityPhotoVO.getActivity_ID());
			ps.setBytes(2, ActivityPhotoVO.getActivity_photo());
			ps.setInt(3, ActivityPhotoVO.getActivity_photo_ID());
			
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
	public void delete(Integer activity_photo_ID) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(DELETE_STMT);
			
			ps.setInt(1, activity_photo_ID);
			
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
	public ActivityPhotoVO findByPrimaryKey(Integer activity_photo_ID) {
		
		ActivityPhotoVO activityPhotoVO = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(QUERY_ONE_STMT);
			
			ps.setInt(1, activity_photo_ID);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				activityPhotoVO = new ActivityPhotoVO();
				activityPhotoVO.setActivity_photo_ID(rs.getInt("ACTIVITY_PHOTO_ID"));
				activityPhotoVO.setActivity_ID(rs.getInt("ACTIVITY_ID"));
				activityPhotoVO.setActivity_photo(rs.getBytes("ACTIVITY_PHOTO"));
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
		
		return activityPhotoVO;
	}

	@Override
	public List<ActivityPhotoVO> getAll() {

		List<ActivityPhotoVO> list = new ArrayList<ActivityPhotoVO>();
		ActivityPhotoVO activityPhotoVO = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			conn = ds.getConnection();
			ps = conn.prepareStatement(QUERY_ALL_STMT);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				activityPhotoVO = new ActivityPhotoVO();
				activityPhotoVO.setActivity_photo_ID(rs.getInt("ACTIVITY_PHOTO_ID"));
				activityPhotoVO.setActivity_ID(rs.getInt("ACTIVITY_ID"));
				activityPhotoVO.setActivity_photo(rs.getBytes("ACTIVITY_PHOTO"));
				list.add(activityPhotoVO);
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
