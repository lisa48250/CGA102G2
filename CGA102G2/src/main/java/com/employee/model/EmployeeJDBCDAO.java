package com.employee.model;

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




public class EmployeeJDBCDAO implements EmployeeDAO_interface {
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
			"INSERT INTO EMPLOYEE (job_id, emp_name, emp_status, emp_password, emp_account) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT * FROM EMPLOYEE order by emp_no";
	private static final String GET_ONE_STMT = 
			"SELECT emp_no, job_id, emp_name, emp_status, emp_password, emp_account FROM EMPLOYEE where emp_no = ?";
	private static final String DELETE = 
			"DELETE FROM EMPLOYEE where emp_no = ?";
	private static final String UPDATE = 
			"UPDATE EMPLOYEE set job_id=? , emp_name=?, emp_status=?, emp_password=?, emp_account=? where emp_no = ?;";
	private static final String FIND_EMP = 
			"select * from CGA102_2.EMPLOYEE where EMP_ACCOUNT = ? and EMP_PASSWORD = ?";
	
		@Override
		public void insert(EmployeeVO employeeVO) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setInt(1, employeeVO.getJob_id());
				pstmt.setString(2, employeeVO.getEmp_name());
				pstmt.setInt(3, employeeVO.getEmp_status());
				pstmt.setString(4,employeeVO.getEmp_password());
				pstmt.setString(5, employeeVO.getEmp_account());

				pstmt.executeUpdate();
	
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
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
		public void update(EmployeeVO employeeVO) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setInt(1, employeeVO.getJob_id());
				pstmt.setString(2, employeeVO.getEmp_name());
				pstmt.setInt(3, employeeVO.getEmp_status());
				pstmt.setString(4,employeeVO.getEmp_password());
				pstmt.setString(5, employeeVO.getEmp_account());
				pstmt.setInt(6, employeeVO.getEmp_no());  //嚙踝蕭嚙踝蕭NO嚙踝蕭怮嚙瑾嚙踝蕭

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
		public void delete(Integer Emp_no) {
			// TODO Auto-generated method stub
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, Emp_no);

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
		
		public EmployeeVO findByPrimaryKey(Integer Emp_no) {
	
			EmployeeVO employeeVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, Emp_no);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// empVo 嚙稽嚙誶穿蕭 Domain objects
					employeeVO = new EmployeeVO();
					employeeVO.setEmp_no(rs.getInt("emp_no"));
					employeeVO.setJob_id(rs.getInt("job_id"));
					employeeVO.setEmp_name(rs.getString("emp_name"));
					employeeVO.setEmp_status(rs.getInt("emp_status"));
					employeeVO.setEmp_password(rs.getString("emp_password"));
					employeeVO.setEmp_account(rs.getString("emp_account"));
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
			return employeeVO;
		}
		@Override
		public List<EmployeeVO> getAll() {
			List<EmployeeVO> list = new ArrayList<EmployeeVO>();
			EmployeeVO employeeVO = null;

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
					// empVO 嚙稽嚙誶穿蕭 Domain objects
					employeeVO = new EmployeeVO();
					employeeVO.setEmp_no(rs.getInt(1));
					employeeVO.setJob_id(rs.getInt("Job_id"));
					employeeVO.setEmp_name(rs.getString("Emp_name"));
					employeeVO.setEmp_status(rs.getInt("Emp_status"));
					employeeVO.setEmp_password(rs.getString("Emp_password"));
					employeeVO.setEmp_account(rs.getString("Emp_account"));
					
					list.add(employeeVO); // 嚙編嚙箭list
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

		public EmployeeVO findByAccountAndPassword(String account, String password) {
	    	EmployeeVO employeeVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = ds.getConnection();
//				Class.forName(driver);
//				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(FIND_EMP);
				pstmt.setString(1, account);
				pstmt.setString(2, password);

				rs = pstmt.executeQuery();
				while (rs.next()) {

					employeeVO = new EmployeeVO();

					employeeVO.setEmp_no(rs.getInt("Emp_no"));
					employeeVO.setJob_id(rs.getInt("Job_id"));
					employeeVO.setEmp_name(rs.getString("emp_name"));
					employeeVO.setEmp_status(rs.getInt("emp_status"));
				}

//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
			} catch (SQLException s) {
				s.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException ss) {
					ss.printStackTrace();
				}
			}
			return employeeVO;
		}
		
		public static void main(String[] args) {

			EmployeeJDBCDAO dao = new EmployeeJDBCDAO();
			// 嚙編嚙磕
			EmployeeVO employeeVO = new EmployeeVO();
			
//			employeeVO.setJob_id(1005);
//			employeeVO.setEmp_name("摰旨鈭�");
//		    employeeVO.setEmp_status(0);
//			employeeVO.setEmp_password("123");
//			employeeVO.setEmp_account("a123");
//			dao.insert(employeeVO);

//		==========================================
//			 嚙磋嚙踝蕭
//			dao.delete(17);
			
			// 嚙論改蕭
//			EmployeeVO employeeVO = new EmployeeVO();

			employeeVO.setJob_id(1004);
			employeeVO.setEmp_name("David1");
			employeeVO.setEmp_status(0);
			employeeVO.setEmp_password("123");
			employeeVO.setEmp_account("a123");
			employeeVO.setEmp_no(33);
			
			dao.update(employeeVO);
			
			// 嚙範嚙踝蕭
//			List<EmployeeVO> list = dao.getAll();
//			for (EmployeeVO aEmp : list) {
//				System.out.print(aEmp.getEmp_no() + ",");
//				System.out.print(aEmp.getJob_id() + ",");
//				System.out.print(aEmp.getEmp_name() + ",");
//				System.out.print(aEmp.getEmp_status() + ",");
//				System.out.println();
//			}
			
//			EmployeeVO employeeVO5 = dao.findByPrimaryKey(20);
//			System.out.println("Emp_no: " + employeeVO5.getEmp_no() + ",");
//			System.out.println("Job_id: " + employeeVO5.getJob_id() + ",");
//			System.out.println("Emp_name: " + employeeVO5.getEmp_name() + ",");
//			System.out.println("Emp_status: " + employeeVO5.getEmp_status() + ",");
		}
	}