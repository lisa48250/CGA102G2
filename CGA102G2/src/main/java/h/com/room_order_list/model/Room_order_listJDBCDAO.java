package h.com.room_order_list.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Room_order_listJDBCDAO implements Room_order_listDAO_interface {

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


	private static final String INSERT_STMT = "insert into room_order_list (room_type_id , room_id , room_order_id , number_of_people , special_req , room_price) "
			+ "value( ? , ?, ? , ? , ? , ?);";
	private static final String GET_ALL_STMT = "SELECT room_order_list_id , room_type_id , room_id , room_order_id , number_of_people , special_req , room_price FROM room_order_list order by room_order_list_id ;";
	private static final String GET_ONE_STMT = "SELECT room_order_list_id , room_type_id , room_id , room_order_id , number_of_people , special_req , room_price FROM room_order_list where room_order_list_id = ?;";
	private static final String DELETE = "delete from room_order_list where room_order_list_id = ?;";
	private static final String UPDATE = "update room_order_list set room_type_id = ? , room_id = ? , room_order_id = ? , number_of_people = ?, special_req = ?, room_price = ? where  room_order_list_id = ?;";
	private static final String GETALLDETAIL = "SELECT room_type_id , room_id, number_of_people , special_req ,room_price FROM ROOM_ORDER_LIST where room_order_id = ?;";
	
	public Room_order_listJDBCDAO() {
		
	};
	
	@Override
	public void insert(Room_order_listVO room_order_listVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, room_order_listVO.getRoom_type_id());
			pstmt.setInt(2, room_order_listVO.getRoom_id());
			pstmt.setInt(3, room_order_listVO.getRoom_order_id());
			pstmt.setInt(4, room_order_listVO.getNumber_of_people());
			pstmt.setString(5, room_order_listVO.getSpecial_req());
			pstmt.setInt(6, room_order_listVO.getRoom_price());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
	public void update(Room_order_listVO room_order_listVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, room_order_listVO.getRoom_type_id());
			pstmt.setInt(2, room_order_listVO.getRoom_id());
			pstmt.setInt(3, room_order_listVO.getRoom_order_id());
			pstmt.setInt(4, room_order_listVO.getNumber_of_people());
			pstmt.setString(5, room_order_listVO.getSpecial_req());
			pstmt.setInt(6, room_order_listVO.getRoom_price());
			pstmt.setInt(7, room_order_listVO.getRoom_order_list_id());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
	public void delete(Integer room_order_list_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, room_order_list_id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
	public Room_order_listVO findByPrimaryKey(Integer room_order_list_id) {
		// TODO Auto-generated method stub
		Room_order_listVO room_order_listVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, room_order_list_id);

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
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
		return room_order_listVO;
	}

	@Override
	public List<Room_order_listVO> getAll() {
		// TODO Auto-generated method stub
		List<Room_order_listVO> list = new ArrayList<Room_order_listVO>();

		Room_order_listVO room_order_listVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
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
				list.add(room_order_listVO);
			}

		}  catch (SQLException se) {
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
		return list;
	}

	public void insert2 (Room_order_listVO room_order_listVO ,Connection con ) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, room_order_listVO.getRoom_type_id());
			pstmt.setInt(2, room_order_listVO.getRoom_id());
			pstmt.setInt(3, room_order_listVO.getRoom_order_id());
			pstmt.setInt(4, room_order_listVO.getNumber_of_people());
			pstmt.setString(5, room_order_listVO.getSpecial_req());
			pstmt.setInt(6, room_order_listVO.getRoom_price());
			
			Statement stmt=	con.createStatement();
			pstmt.executeUpdate();
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					System.err.print("Transaction is being ");
					System.err.println("rolled back-由-room_order_list");
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
		}

	}
	
	
	@Override
	public  List<Room_order_listVO> getAllDetail(Integer room_order_id) {
		List<Room_order_listVO> list = new ArrayList<Room_order_listVO>();
		Room_order_listVO room_order_listVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GETALLDETAIL);

			pstmt.setInt(1, room_order_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				room_order_listVO = new Room_order_listVO();
				room_order_listVO.setRoom_type_id(rs.getInt("room_type_id"));
				room_order_listVO.setRoom_id(rs.getInt("room_id"));
				room_order_listVO.setNumber_of_people(rs.getInt("number_of_people"));
				room_order_listVO.setSpecial_req(rs.getString("special_req"));
				room_order_listVO.setRoom_price(rs.getInt("room_price"));
				list.add(room_order_listVO);
			}

		}  catch (SQLException se) {
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
		return list;
	}
	
	
	public static void main(String[] args) {
		Room_order_listJDBCDAO rol = new Room_order_listJDBCDAO();
		
		Room_order_listVO rolvo = new Room_order_listVO();
		rolvo.setRoom_type_id(1);
		rolvo.setRoom_id(1);
		rolvo.setRoom_order_id(1);
		rolvo.setNumber_of_people(3);
		rolvo.setSpecial_req("哈哈");
		rolvo.setRoom_price(68000);
		rol.insert(rolvo);;
		
		Room_order_listVO rolvo1 = new Room_order_listVO();
		rolvo1.setRoom_type_id(2);
		rolvo1.setRoom_id(2);
		rolvo1.setRoom_order_id(2);
		rolvo1.setNumber_of_people(4);
		rolvo1.setSpecial_req("改成功了");
		rolvo1.setRoom_price(77000);
		rolvo1.setRoom_order_list_id(8);
		rol.update(rolvo1);
		
		rol.delete(8);
		
		Room_order_listVO rolvo2 = rol.findByPrimaryKey(6);
		System.out.println(rolvo2.getRoom_order_list_id()+ ",");
		System.out.println(rolvo2.getRoom_type_id()+ ",");
		System.out.println(rolvo2.getRoom_id()+ ",");
		System.out.println(rolvo2.getRoom_order_id()+ ",");
		System.out.println(rolvo2.getNumber_of_people()+ ",");
		System.out.println(rolvo2.getSpecial_req()+ ",");
		System.out.println(rolvo2.getRoom_price());
		
		
		
		List<Room_order_listVO> list = rol.getAll();
		for(Room_order_listVO rolVO : list) {
		System.out.println(rolVO.getRoom_order_list_id()+ ",");
		System.out.println(rolVO.getRoom_type_id()+ ",");
		System.out.println(rolVO.getRoom_id()+ ",");
		System.out.println(rolVO.getRoom_order_id()+ ",");
		System.out.println(rolVO.getNumber_of_people()+ ",");
		System.out.println(rolVO.getSpecial_req()+ ",");
		System.out.println(rolVO.getRoom_price());
		}
	}


		
}
