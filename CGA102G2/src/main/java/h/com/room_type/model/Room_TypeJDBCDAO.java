package h.com.room_type.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

import h.com.room_order_list.model.Room_order_listVO;
import h.com.room_type_photo.model.Room_type_photoVO;



public class Room_TypeJDBCDAO implements Room_TypeDAO_interface{
	
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
			"INSERT INTO room_type (room_type_name,room_type_amount,room_type_content,room_type_sale_status,room_total_review,room_type_pic,room_type_price) VALUES (?, ?, ?, ?, ?, ?,?)";
		private static final String GET_ALL_STMT = 
			"SELECT room_type_id,room_type_name,room_type_amount,room_type_content,room_type_sale_status,room_total_review,room_type_pic,room_type_price FROM room_type order by room_type_id";
		private static final String GET_ONE_STMT = 
			"SELECT room_type_id,room_type_name,room_type_amount,room_type_content,room_type_sale_status,room_total_review,room_type_pic,room_type_price FROM room_type where room_type_id = ?";
		private static final String DELETE = 
			"DELETE FROM room_type where room_type_id = ?";
		private static final String UPDATE = 
			"UPDATE room_type set room_type_name=?, room_type_amount=?, room_type_content=?, room_type_sale_status=?, room_total_review=?, room_type_pic=?,  room_type_price=? where room_type_id = ?";
		private static final String GET_Room_order_listbyRoom_type = 
				"SELECT  room_id  from room_order_list where room_type_id =? order by room_type_id;";		
		public Room_TypeJDBCDAO() {};
		
		@Override
		public void insert(Room_TypeVO room_typeVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setString(1, room_typeVO.getRoom_type_name());
				pstmt.setInt(2, room_typeVO.getRoom_type_amount());
				pstmt.setString(3, room_typeVO.getRoom_type_content());
				pstmt.setInt(4, room_typeVO.getRoom_type_sale_status());
				pstmt.setString(5, room_typeVO.getRoom_total_review());
				pstmt.setBlob(6, room_typeVO.getRoom_type_pic());
				pstmt.setInt(7, room_typeVO.getRoom_type_price());
				
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
		public void update(Room_TypeVO room_typeVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);
				
				pstmt.setString(1, room_typeVO.getRoom_type_name());
				pstmt.setInt(2, room_typeVO.getRoom_type_amount());
				pstmt.setString(3, room_typeVO.getRoom_type_content());
				pstmt.setInt(4, room_typeVO.getRoom_type_sale_status());
				pstmt.setString(5, room_typeVO.getRoom_total_review());
				pstmt.setBlob(6, room_typeVO.getRoom_type_pic());
				pstmt.setInt(7, room_typeVO.getRoom_type_price());
				pstmt.setInt(8, room_typeVO.getRoom_type_id());

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
		public void delete(Integer room_type_id) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, room_type_id);

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
		public Room_TypeVO findByPrimaryKey(Integer room_type_id) {

			Room_TypeVO room_typeVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, room_type_id);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// empVo 也稱為 Domain objects
					room_typeVO = new Room_TypeVO();
					room_typeVO.setRoom_type_id(rs.getInt("room_type_id"));
					room_typeVO.setRoom_type_name(rs.getString("room_type_name"));
					room_typeVO.setRoom_type_amount(rs.getInt("room_type_amount"));
					room_typeVO.setRoom_total_review(rs.getString("room_total_review"));
					room_typeVO.setRoom_type_content(rs.getString("room_type_content"));
					room_typeVO.setRoom_type_sale_status(rs.getInt("room_type_sale_status"));
					room_typeVO.setRoom_type_pic(rs.getBlob("room_type_pic"));
					room_typeVO.setRoom_type_price(rs.getInt("room_type_price"));
				
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
			return room_typeVO;
		}

		@Override
		public List<Room_TypeVO> getAll() {
			List<Room_TypeVO> list = new ArrayList<Room_TypeVO>();
			Room_TypeVO room_typeVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					// empVO 也稱為 Domain objects
					room_typeVO = new Room_TypeVO();
					room_typeVO.setRoom_type_id(rs.getInt("room_type_id"));
					room_typeVO.setRoom_type_name(rs.getString("room_type_name"));
					room_typeVO.setRoom_type_amount(rs.getInt("room_type_amount"));
					room_typeVO.setRoom_total_review(rs.getString("room_total_review"));
					room_typeVO.setRoom_type_content(rs.getString("room_type_content"));
					room_typeVO.setRoom_type_sale_status(rs.getInt("room_type_sale_status"));
					room_typeVO.setRoom_type_pic(rs.getBlob("room_type_pic"));
					room_typeVO.setRoom_type_price(rs.getInt("room_type_price"));
					list.add(room_typeVO); // Store the row in the list
					
					
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
			return list;
		}
		
		
		@Override
		public Set<Room_order_listVO> getRoom_order_listByRoom_type(Integer room_type_id) {
			// TODO Auto-generated method stub
			Set<Room_order_listVO> set = new LinkedHashSet<Room_order_listVO>();
			Room_order_listVO room_order_listVO = null;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = con.prepareStatement(GET_Room_order_listbyRoom_type);
				pstmt.setInt(1,room_type_id);
				rs = pstmt.executeQuery();
				while (rs.next()) {
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
				throw new RuntimeException("A database error occured. " + se.getMessage());
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
		
		
		
		

		public static void main(String[] args) {

			Room_TypeJDBCDAO dao = new Room_TypeJDBCDAO();

//			 新增
			Room_TypeVO room_typeVO1 = new Room_TypeVO();
			room_typeVO1.setRoom_type_name("總統套房");
			room_typeVO1.setRoom_type_amount(5);
			room_typeVO1.setRoom_type_content(" <h4>30坪 兩大床（Queen size）</h4> "
					+ "                設施 :<br>\n"
					+ "                吹風機、戶外半露天池、乾濕分離浴室、TV、WIFI、熱水壺、冷暖氣機、礦泉水、泡麵、飲料、<br> "
					+ "                吊扇、咖啡包、茶包、棉棒、牙籤、浴帽、大小毛巾、牙刷、面膜、電冰箱");
			room_typeVO1.setRoom_type_sale_status(0);
			room_typeVO1.setRoom_total_review("讚讚讚！");
			room_typeVO1.setRoom_type_pic(null);
			room_typeVO1.setRoom_type_price(12800);
			dao.insert(room_typeVO1);

			// 修改
//			Room_TypeVO room_typeVO2 = new Room_TypeVO();
//			room_typeVO2.setRoom_type_id(7);
//			room_typeVO2.setRoom_type_name("尊絕四人房");
//			room_typeVO2.setRoom_type_amount(1);
//			room_typeVO2.setRoom_type_content("不錯");
//			room_typeVO2.setRoom_sale_status(1);
//			room_typeVO2.setRoom_total_review("可以捏");
//			room_typeVO2.setRoom_type_pic(null);
//			room_typeVO2.setRoom_type_price(1000);
//			dao.update(room_typeVO2);

			// 刪除
//			dao.delete(6);

			// 查詢
//			Room_TypeVO room_typeVO3 = dao.findByPrimaryKey(3);
//			System.out.print(room_typeVO3.getRoom_type_id() + ",");
//			System.out.print(room_typeVO3.getRoom_type_name() + ",");
//			System.out.print(room_typeVO3.getRoom_type_amount() + ",");
//			System.out.print(room_typeVO3.getRoom_total_review() + ",");
//			System.out.print(room_typeVO3.getRoom_type_content() + ",");
//			System.out.print(room_typeVO3.getRoom_type_sale_status() + ",");
//			System.out.print(room_typeVO3.getRoom_type_pic() + ",");
//			System.out.println(room_typeVO3.getRoom_type_price());
//			System.out.println("---------------------");

			// 查詢
//			List<Room_TypeVO> list = dao.getAll();
//			for (Room_TypeVO aRoom_Type : list) {
//				System.out.print(aRoom_Type.getRoom_type_id() + ",");
//				System.out.print(aRoom_Type.getRoom_type_name() + ",");
//				System.out.print(aRoom_Type.getRoom_type_amount() + ",");
//				System.out.print(aRoom_Type.getRoom_total_review() + ",");
//				System.out.print(aRoom_Type.getRoom_type_content() + ",");
//				System.out.print(aRoom_Type.getRoom_type_sale_status() + ",");
//				System.out.print(aRoom_Type.getRoom_type_pic() + ",");
//				System.out.print(aRoom_Type.getRoom_type_price());
//				System.out.println();
//			}
		}

		

}
