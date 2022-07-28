package h.com.room_order.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

import h.com.room_order_list.model.*;


public class Room_orderJDBCDAO  implements Room_orderDAO_interface{
	private static DataSource ds = null;

	static {

		Context ct;
		try {
			ct = new javax.naming.InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/CGA102_2");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = 
			"INSERT INTO room_order (member_id,order_date,room_order_status,room_charge,check_in_date,check_out_date) VALUES (?, ?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT room_order_id,member_id,order_date,room_order_status,room_charge,check_in_date,check_out_date FROM room_order order by room_order_id";
		private static final String GET_ONE_STMT = 
			"SELECT room_order_id,member_id,order_date,room_order_status,room_charge,check_in_date,check_out_date FROM room_order where room_order_id = ?";
		private static final String DELETE_Room_Order = 
			"DELETE FROM room_order where room_order_id = ?";
		private static final String DELETE_Room_Order_list = 
				"DELETE FROM room_order_list where room_order_id = ?";
		private static final String UPDATE = 
			"UPDATE room_order set member_id=?, order_date=? , room_order_status=?, room_charge=?, check_in_date=? , check_out_date=? where room_order_id = ?";
		private static final String GET_Room_order_list_ByDeptno_STMT =
				"SELECT room_order_list_id ,room_type_id , room_id , room_order_id , number_of_people , special_req , room_price from room_order_list where room_order_id = ?";
		private static final String GET_ALL0 = "SELECT room_order_id,order_date,room_order_status,room_charge,check_in_date,check_out_date FROM room_order where room_order_status = ? and member_id = ? order by room_order_id ;";
		private static final String GET_ALL1 = "SELECT room_order_id,order_date,room_order_status,room_charge,check_in_date,check_out_date FROM room_order where room_order_status = ? and member_id = ? order by room_order_id ;";
		private static final String GET_ALL2 = "SELECT room_order_id,order_date,room_order_status,room_charge,check_in_date,check_out_date FROM room_order where room_order_status = ? and member_id = ? order by room_order_id ;";
		private static final String GET_ALLID ="SELECT room_order_id FROM room_order where  member_id =? ;";
		
		public Room_orderJDBCDAO() {
			
		};
		
		@Override
		public void insert(Room_orderVO room_orderVO) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT);
				pstmt.setInt(1, room_orderVO.getMember_id());
				pstmt.setTimestamp(2, room_orderVO.getOrder_date());
				pstmt.setInt(3, room_orderVO.getRoom_order_status());
				pstmt.setInt(4, room_orderVO.getRoom_charge());
				pstmt.setDate(5, room_orderVO.getCheck_in_date());
				pstmt.setDate(6, room_orderVO.getCheck_out_date());
				
				
				

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
		public void update(Room_orderVO room_orderVO) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setInt(1, room_orderVO.getMember_id());
				pstmt.setTimestamp(2, room_orderVO.getOrder_date());
				pstmt.setInt(3, room_orderVO.getRoom_order_status());
				pstmt.setInt(4, room_orderVO.getRoom_charge());
				pstmt.setDate(5, room_orderVO.getCheck_in_date());
				pstmt.setDate(6, room_orderVO.getCheck_out_date());
				pstmt.setInt(7, room_orderVO.getRoom_order_id());


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
		public void delete(Integer room_order_id) {
			int updateCount_Room_Order_list = 0;
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				
				con.setAutoCommit(false);
				//先刪訂單明細
				pstmt = con.prepareStatement(DELETE_Room_Order_list);
				pstmt.setInt(1, room_order_id);
				updateCount_Room_Order_list = pstmt.executeUpdate();
				//在刪訂單
				pstmt = con.prepareStatement(DELETE_Room_Order);
				pstmt.setInt(1, room_order_id);
				pstmt.executeUpdate();
				// 設定於 pstm.executeUpdate()之後
				con.commit();
				con.setAutoCommit(true);
				// Handle any driver errors
			} catch (SQLException se) {
				if (con != null) {
					try {
						// 3●設定於當有exception發生時之catch區塊內
						con.rollback();
					} catch (SQLException excep) {
						throw new RuntimeException("rollback error occured. "
								+ excep.getMessage());
					}
				}
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		public Room_orderVO findByPrimaryKey(Integer room_order_id) {
			Room_orderVO room_orderVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, room_order_id);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					room_orderVO = new Room_orderVO();
					room_orderVO.setRoom_order_id(rs.getInt("room_order_id"));
					room_orderVO.setMember_id(rs.getInt("member_id"));
					room_orderVO.setOrder_date(rs.getTimestamp("order_date"));
					room_orderVO.setRoom_order_status(rs.getInt("room_order_status"));
					room_orderVO.setRoom_charge(rs.getInt("room_charge"));
					room_orderVO.setCheck_in_date(rs.getDate("check_in_date"));
					room_orderVO.setCheck_out_date(rs.getDate("check_out_date"));
				}

				// Handle any driver errors
			}catch (SQLException se) {
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
			return room_orderVO;
		}
		@Override
		public List<Room_orderVO> getAll() {
			List<Room_orderVO> list = new ArrayList<Room_orderVO>();
			Room_orderVO room_orderVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					// room_orderVO 也稱為 Domain objects
					room_orderVO = new Room_orderVO();
					room_orderVO.setRoom_order_id(rs.getInt("room_order_id"));
					room_orderVO.setMember_id(rs.getInt("member_id"));
					room_orderVO.setOrder_date(rs.getTimestamp("order_date"));
					room_orderVO.setRoom_order_status(rs.getInt("room_order_status"));
					room_orderVO.setRoom_charge(rs.getInt("room_charge"));
					room_orderVO.setCheck_in_date(rs.getDate("check_in_date"));
					room_orderVO.setCheck_out_date(rs.getDate("check_out_date"));
					list.add(room_orderVO); // Store the row in the list
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
		
		
		@Override
		public Set<Room_order_listVO> getRoom_order_listByRoom_order(Integer room_order_id) {
			Set<Room_order_listVO> set = new HashSet<Room_order_listVO>();
			Room_order_listVO room_order_listVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_Room_order_list_ByDeptno_STMT);
				pstmt.setInt(1, room_order_id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					room_order_listVO = new Room_order_listVO();
					room_order_listVO.setRoom_order_list_id(rs.getInt("room_order_list_id"));
					room_order_listVO.setRoom_type_id(rs.getInt("room_type_id"));
					room_order_listVO.setRoom_id(rs.getInt("room_id"));
					room_order_listVO.setRoom_order_id(rs.getInt("room_order_id"));
					room_order_listVO.setNumber_of_people(rs.getInt("number_of_people"));
					room_order_listVO.setSpecial_req(rs.getString("special_req"));
					room_order_listVO.setRoom_price(rs.getInt("room_price"));
					set.add(room_order_listVO);
				}
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
			return set;
		}
			
			
		

		@Override
		public void insertWithRoom_order_list(Room_orderVO room_orderVO, List<Room_order_listVO> list) {
			// TODO Auto-generated method stub
			Connection con = null;
			PreparedStatement pstmt = null;
		
				try {
					con = ds.getConnection();
					//關閉自動交易
					con.setAutoCommit(false);
					//新增住宿訂單編號欄位
					String cols[] = {"room_order_id"};
					//連接sql語法
//					pstmt = con.prepareStatement(INSERT_STMT);
					pstmt=con.prepareStatement(INSERT_STMT,Statement.RETURN_GENERATED_KEYS);
					pstmt.setInt(1, room_orderVO.getMember_id());
					pstmt.setTimestamp(2, room_orderVO.getOrder_date());
					pstmt.setInt(3, room_orderVO.getRoom_order_status());
					pstmt.setInt(4, room_orderVO.getRoom_charge());
					pstmt.setDate(5, room_orderVO.getCheck_in_date());
					pstmt.setDate(6, room_orderVO.getCheck_out_date());
					Statement stmt=	con.createStatement();
					pstmt.executeUpdate();
					//選取對應的字增主鍵值
					String next_room_order = null;
//					ResultSet rs = pstmt.getGeneratedKeys();
					ResultSet rs=pstmt.getGeneratedKeys();
			
					if(rs.next()) {
						next_room_order = rs.getString(1);
						System.out.println("自增主鍵值= " + next_room_order +"(剛新增成功的住宿訂單編號)");
					}else {
						System.out.println("未取得自增主鍵值");
					}
					rs.close();
					//交易未關閉新增住宿訂單明細
					Room_order_listJDBCDAO dao = new Room_order_listJDBCDAO();
					// foreach 參數的list
					for(Room_order_listVO rol : list) {
						rol.setRoom_order_id(new Integer(next_room_order));
						dao.insert2(rol,con);
					}
					
					// 設定於 pstm.executeUpdate()之後
					con.commit();
					con.setAutoCommit(true);
				} catch (SQLException se) {
					if (con != null) {
						try {
							// 3●設定於當有exception發生時之catch區塊內
							System.err.print("Transaction is being ");
							System.err.println("rolled back-由-room_order");
							con.rollback();
						} catch (SQLException excep) {
							throw new RuntimeException("rollback error occured. "
									+ excep.getMessage());
						}
					}
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
		public List<Room_orderVO> getAll0(Integer room_order_status , Integer member_id) {
			List<Room_orderVO> list = new ArrayList();
			Room_orderVO room_orderVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL0);
				pstmt.setInt(1, room_order_status);
				pstmt.setInt(2, member_id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					room_orderVO = new Room_orderVO();
					room_orderVO.setOrder_date(rs.getTimestamp("order_date"));
					room_orderVO.setRoom_charge(rs.getInt("room_charge"));
					room_orderVO.setCheck_in_date(rs.getDate("check_in_date"));
					room_orderVO.setCheck_out_date(rs.getDate("check_out_date"));
					room_orderVO.setRoom_order_id(rs.getInt("room_order_id"));
					
					list.add(room_orderVO);
				}
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
		public List<Room_orderVO> getAll1(Integer room_order_status ,Integer member_id) {
			List<Room_orderVO> list = new ArrayList();
			Room_orderVO room_orderVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL1);
				pstmt.setInt(1, room_order_status);
				pstmt.setInt(2, member_id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					room_orderVO = new Room_orderVO();
					room_orderVO.setOrder_date(rs.getTimestamp("order_date"));
					room_orderVO.setRoom_charge(rs.getInt("room_charge"));
					room_orderVO.setCheck_in_date(rs.getDate("check_in_date"));
					room_orderVO.setCheck_out_date(rs.getDate("check_out_date"));
					room_orderVO.setRoom_order_id(rs.getInt("room_order_id"));
					list.add(room_orderVO);
				}
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
		public List<Room_orderVO> getAll2(Integer room_order_status , Integer member_id) {
			List<Room_orderVO> list = new ArrayList();
			Room_orderVO room_orderVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL2);
				pstmt.setInt(1, room_order_status);
				pstmt.setInt(2, member_id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					room_orderVO = new Room_orderVO();
					room_orderVO.setOrder_date(rs.getTimestamp("order_date"));
					room_orderVO.setRoom_charge(rs.getInt("room_charge"));
					room_orderVO.setCheck_in_date(rs.getDate("check_in_date"));
					room_orderVO.setCheck_out_date(rs.getDate("check_out_date"));
					room_orderVO.setRoom_order_id(rs.getInt("room_order_id"));
					list.add(room_orderVO);
				}
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
		public List<Room_orderVO> getAllID(Integer member_id) {
			List<Room_orderVO> list = new ArrayList();
			Room_orderVO room_orderVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALLID);
				pstmt.setInt(1, member_id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					room_orderVO = new Room_orderVO();
					room_orderVO.setRoom_order_id(rs.getInt("room_order_id"));
					list.add(room_orderVO);
				}
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

			Room_orderJDBCDAO dao = new Room_orderJDBCDAO();
			SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			// 新增
//			Room_OrderVO room_orderVO1 = new Room_OrderVO();
//			room_orderVO1.setMember_id(1);
//			room_orderVO1.setRoom_order_status(0);
//			room_orderVO1.setRoom_charge(2000);
//			dao.insert(room_orderVO1);

			// 修改
//		    Room_OrderVO room_orderVO2 = new Room_OrderVO();
//		    room_orderVO2.setRoom_order_id(1);
//		    room_orderVO2.setMember_id(2);
//		    room_orderVO2.setRoom_order_status(1);
//		    room_orderVO2.setRoom_charge(10000);
//			dao.insert(room_orderVO2);

			// 刪除
//			dao.delete(9);

			// 查詢
			Room_orderVO room_orderVO3 = dao.findByPrimaryKey(4);
			System.out.print(room_orderVO3.getRoom_order_id() + ",");
			System.out.print(room_orderVO3.getMember_id() + ",");
			System.out.print(room_orderVO3.getOrder_date() + ",");
			System.out.print(room_orderVO3.getRoom_order_status() + ",");
			System.out.print(room_orderVO3.getRoom_charge() + ",");
			System.out.print(simpledateformat.format(room_orderVO3.getCheck_in_date()) + ",");
			System.out.println(simpledateformat.format(room_orderVO3.getCheck_out_date()));
			System.out.println("---------------------");

			// 查詢
			List<Room_orderVO> list = dao.getAll();
			for (Room_orderVO aRoom_Order : list) {
				System.out.print(aRoom_Order.getRoom_order_id() + ",");
				System.out.print(aRoom_Order.getMember_id() + ",");
				System.out.print(aRoom_Order.getOrder_date() + ",");
				System.out.print(aRoom_Order.getRoom_order_status() + ",");
				System.out.print(aRoom_Order.getRoom_charge() + ",");
				System.out.print(simpledateformat.format(aRoom_Order.getCheck_in_date()) + ",");
				System.out.print(simpledateformat.format(aRoom_Order.getCheck_out_date()));
				System.out.println();
			}
		}

		

		

		
	}


