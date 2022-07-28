package com.authority_function.model;

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



//import com.emp.model.EmpDAO_interface;

public class Authority_FunctionJDBCDAO implements Authority_FunctionDAO_interface{
	
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
			"INSERT INTO AUTHORITY_FUNCTION (function_id, function_name) VALUES (?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT function_id, function_name FROM AUTHORITY_FUNCTION order by function_id";
		private static final String GET_ONE_STMT = 
			"SELECT function_id, function_name FROM AUTHORITY_FUNCTION where function_id=?";
		private static final String DELETE = 
			"DELETE FROM AUTHORITY_FUNCTION where function_id=?";
		private static final String UPDATE = 
			"UPDATE AUTHORITY_FUNCTION set function_name=? where function_id=?";
		
		public void insert (Authority_FunctionVO functionVO) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setInt(1, functionVO.getFunction_id());
				pstmt.setString(2, functionVO.getFunction_name());
				
				pstmt.executeUpdate();
	
//			} catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
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
		public void update(Authority_FunctionVO functionVO) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(UPDATE);

			
				pstmt.setString(1, functionVO.getFunction_name());
				pstmt.setInt(2, functionVO.getFunction_id());

				pstmt.executeUpdate();

				// Handle any driver errors
//			} catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
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
		public void delete(Integer function_id) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, function_id);
				
				pstmt.executeUpdate();

				// Handle any driver errors
//			} catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
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
		public Authority_FunctionVO findByPrimaryKey(Integer function_id) {
			
			Authority_FunctionVO functionVO5 = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, function_id);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// empVo �]�٬� Domain objects
					functionVO5 = new Authority_FunctionVO();
					
					functionVO5.setFunction_id(rs.getInt("function_id"));
					functionVO5.setFunction_name(rs.getString("function_name"));
				}

				// Handle any driver errors
//			} catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
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
			return functionVO5;
		}	
		@Override
		public List<Authority_FunctionVO> getAll() {
			List<Authority_FunctionVO> list = new ArrayList<Authority_FunctionVO>();
			Authority_FunctionVO functionVO5 = null;

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
					// empVO �]�٬� Domain objects
					functionVO5 = new Authority_FunctionVO();
					functionVO5.setFunction_id(rs.getInt("function_id"));
					functionVO5.setFunction_name(rs.getString("function_name"));
					list.add(functionVO5); // Store the row in the list
				}

				// Handle any driver errors
//			} catch (ClassNotFoundException e) {
//				throw new RuntimeException("Couldn't load database driver. "
//						+ e.getMessage());
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

			Authority_FunctionJDBCDAO dao = new Authority_FunctionJDBCDAO();

//			// �s�W
			Authority_FunctionVO functionVO = new Authority_FunctionVO();
			
//			functionVO.setFunction_id(2002);
//			functionVO.setFunction_name("���u�޲z");
//			dao.insert(functionVO);

			// �R��
//			dao.delete(2002);
			
			//�ק�
//			functionVO.setFunction_name("�q�к޲z");
//			functionVO.setFunction_id(2005);
//			dao.update(functionVO);

//			// �d��
			Authority_FunctionVO functionVO5 = dao.findByPrimaryKey(2002);
			System.out.println("Function_id: " + functionVO5.getFunction_id() + ",");
			System.out.println("Function_name: " + functionVO5.getFunction_name() + ",");
			System.out.println("---------------------");
//
			// �d��
//			List<FunctionVO> list = dao.getAll();
//			for (FunctionVO afunctionVO : list) {
//				System.out.print(afunctionVO.getFunction_id() + ",");
//				System.out.print(afunctionVO.getFunction_name() + ",");
//				System.out.println();
//			}
		}	
	}
