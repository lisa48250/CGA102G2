package com.job_authority.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class Job_AuthorityJDBCDAO implements Job_AuthorityDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CGA102_2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CGA102_2");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = 
		"INSERT INTO JOB_AUTHORITY (job_id, function_id) VALUES (?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT job_id, function_id FROM JOB_AUTHORITY order by job_id, function_id";
	private static final String GET_ONE_STMT = 
		"SELECT job_id, function_id FROM JOB_AUTHORITY where job_id= ?";
	private static final String DELETE = 
		"DELETE FROM JOB_AUTHORITY where job_id= ? ";
	private static final String UPDATE = 
		"UPDATE JOB_AUTHORITY set job_id=?, function_id=? where job_id= ?, function_id= ?";

	@Override
	public void insert(Job_AuthorityVO job_authorityVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, job_authorityVO.getJob_id());
			pstmt.setInt(2, job_authorityVO.getFunction_id());

			pstmt.executeUpdate();

//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
			// Handle any SQL errors
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
	public void update(Job_AuthorityVO job_authorityVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, job_authorityVO.getJob_id());
			pstmt.setInt(2, job_authorityVO.getFunction_id());

			pstmt.executeUpdate();

//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
			// Handle any SQL errors
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
	public void delete(Integer job_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, job_id);
			
			
			pstmt.executeUpdate();

			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
			// Handle any SQL errors
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
	public Job_AuthorityVO findByPrimaryKey(Integer job_id) {
		// TODO Auto-generated method stub
		Job_AuthorityVO job_authorityVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, job_id);
//			pstmt.setInt(2, function_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				job_authorityVO = new Job_AuthorityVO();
				job_authorityVO.setJob_id(rs.getInt("job_id"));
				job_authorityVO.setFunction_id(rs.getInt("function_id"));
	
			}

			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
			// Handle any SQL errors
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
		return job_authorityVO;
	}
	@Override
	public List<Job_AuthorityVO> getAll() {
		// TODO Auto-generated method stub
		List<Job_AuthorityVO> list = new ArrayList<Job_AuthorityVO>();
		Job_AuthorityVO job_authorityVO5 = null;

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
				// empVO �]�٬� Domain objects
				job_authorityVO5 = new Job_AuthorityVO();
				job_authorityVO5.setJob_id(rs.getInt("Job_id"));
				job_authorityVO5.setFunction_id(rs.getInt("Function_id"));
				list.add(job_authorityVO5); // �s�blist
			}

			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
			// Handle any SQL errors
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

		Job_AuthorityJDBCDAO dao = new Job_AuthorityJDBCDAO();
	
		Job_AuthorityVO job_authorityVO = new Job_AuthorityVO();
		job_authorityVO.setJob_id(1005);
		job_authorityVO.setFunction_id(2005);
		dao.insert(job_authorityVO);
		
//		�R��   
//		dao.delete(1005);
		
//		�ק�  XXXXXXXXXXXX
//		Job_AuthorityVO job_authorityVO = new Job_AuthorityVO();
//		job_authorityVO.setJob_id(null);
//		job_authorityVO.setFunction_id(null);
//		dao.update(job_authorityVO);
		
//		�d�浧  
//		Job_AuthorityVO job_authorityVO = dao.findByPrimaryKey(1001);
//		System.out.println("Job_id: " + job_authorityVO.getJob_id() + ",");
//		System.out.println("Function_id: " + job_authorityVO.getFunction_id() + ",");
		
//		�d�h�� 
//		List<Job_AuthorityVO> list = dao.getAll();
//		for(Job_AuthorityVO aEmp : list) {
//			System.out.println(aEmp.getJob_id() + ",");
//			System.out.println(aEmp.getFunction_id() + ",");
//			System.out.println();
//		}
	}	
}