package h.com.room.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

import h.com.room_order_list.model.Room_order_listVO;

public class RoomJDBCDAO implements RoomDAO_interface {

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

	private static final String INSERT_STMT = "INSERT INTO room ( room_type_id,room_sale_status,room_status ) VALUES ( ? ,? ,?)";
	private static final String GET_ALL_STMT = "SELECT room_id,room_type_id,room_guest_name,room_sale_status,room_status   FROM room order by room_id";
	private static final String GET_ONE_STMT = "SELECT room_id,room_type_id,room_guest_name,room_sale_status,room_status   FROM room where room_id = ?";
	private static final String DELETE = "DELETE FROM room where room_id = ?";
	private static final String UPDATE = "UPDATE room set room_type_id=?, room_guest_name=?, room_sale_status=?, room_status=?  where room_id = ?";
	private static final String SELECTROOM_ID = "select  room_id from room where room_type_id = ? && room_status = 0 limit 1;";

	private static final String SELECTALLROOM_ID = "select  room_id from room where room_type_id = ?  ;";

	private static final String SELECTALLROOM_STATUS = "SELECT room_status FROM room where room_type_id =?;";

	private static final String GETRoom_order_listByRoomSTMT = "SELECT room_order_list_id , room_type_id , room_id , room_order_id , number_of_people ,special_req , room_price  from room_order_list where room_id =? order by room_id;";
//取消
	private static final String UPDATEROOM_STATUS = "update room set room_status = 2  where room_id =?;";
//取消
	private static final String SELECT_ALLDATE_STATUS = "select check_in_date , check_out_date , room_status from room where room_type_id = ?;";

	public RoomJDBCDAO() {
	};

//		@Override
	public void insert(RoomVO roomVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, roomVO.getRoom_type_id());
			pstmt.setInt(2, roomVO.getRoom_sale_status());
			pstmt.setInt(3, roomVO.getRoom_status());
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(RoomVO roomVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, roomVO.getRoom_type_id());
			pstmt.setString(2, roomVO.getRoom_guest_name());
			pstmt.setInt(3, roomVO.getRoom_sale_status());
			pstmt.setInt(4, roomVO.getRoom_status());
			pstmt.setInt(5, roomVO.getRoom_id());
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(Integer room_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, room_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public RoomVO findByPrimaryKey(Integer room_id) {

		RoomVO roomVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, room_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				roomVO = new RoomVO();
				roomVO.setRoom_id(rs.getInt("room_id"));
				roomVO.setRoom_type_id(rs.getInt("room_type_id"));
				roomVO.setRoom_guest_name(rs.getString("room_guest_name"));
				roomVO.setRoom_sale_status(rs.getInt("room_sale_status"));
				roomVO.setRoom_status(rs.getInt("room_status"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return roomVO;
	}

	@Override
	public List<RoomVO> getAll() {
		List<RoomVO> list = new ArrayList<RoomVO>();
		RoomVO roomVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// roomVO 也稱為 Domain objects
				roomVO = new RoomVO();
				roomVO.setRoom_id(rs.getInt("room_id"));
				roomVO.setRoom_type_id(rs.getInt("room_type_id"));
				roomVO.setRoom_guest_name(rs.getString("room_guest_name"));
				roomVO.setRoom_sale_status(rs.getInt("room_sale_status"));
				roomVO.setRoom_status(rs.getInt("room_status"));
				list.add(roomVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public List<RoomVO> getAllRoomId(Integer room_type_id) {
		List<RoomVO> list = new ArrayList<RoomVO>();

		RoomVO roomVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECTALLROOM_ID);
			pstmt.setInt(1, room_type_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				roomVO = new RoomVO();
				roomVO.setRoom_id(rs.getInt("room_id"));
				list.add(roomVO);
			}
		}  catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public RoomVO getRoomId(Integer room_type_id) {
		// TODO Auto-generated method stub
		RoomVO roomVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECTROOM_ID);
			pstmt.setInt(1, room_type_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				roomVO = new RoomVO();
				roomVO.setRoom_id(rs.getInt("room_id"));
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return roomVO;
	}

	@Override
	public Set<Room_order_listVO> getRoom_order_listByRoom(Integer room_id) {
		// TODO Auto-generated method stub
		Set<Room_order_listVO> set = new LinkedHashSet<Room_order_listVO>();
		Room_order_listVO room_order_listVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GETRoom_order_listByRoomSTMT);
			pstmt.setInt(1, room_id);
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

	@Override
	public void updateRoomStatus(Integer room_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATEROOM_STATUS);
			pstmt.setInt(1, room_id);
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public List<RoomVO> getAllRoomStatus(Integer room_type_id) {

		List<RoomVO> list = new ArrayList<RoomVO>();
		RoomVO roomVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECTALLROOM_STATUS);
			pstmt.setInt(1, room_type_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				roomVO = new RoomVO();
				roomVO.setRoom_status(rs.getInt("room_status"));
				list.add(roomVO);
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public List<RoomVO> getAllRoomDateStatus(Integer room_type_id) {
		// TODO Auto-generated method stub

		List<RoomVO> list = new ArrayList<RoomVO>();
		RoomVO roomVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALLDATE_STATUS);
			pstmt.setInt(1, room_type_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				roomVO = new RoomVO();
				roomVO.setCheck_in_date(rs.getDate("check_in_date"));
				roomVO.setCheck_out_date(rs.getDate("check_out_date"));
				roomVO.setRoom_status(rs.getInt("room_status"));
				list.add(roomVO);
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

		RoomJDBCDAO dao = new RoomJDBCDAO();
//		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
		// 新增
//			RoomVO roomVO1= new RoomVO();
//			roomVO1.setRoom_type_id(4);
////			roomVO1.setRoom_guest_name("May");
//			roomVO1.setRoom_sale_status(0);
//			roomVO1.setRoom_status(0);
//			
//			dao.insert(roomVO1);
		dao.getAllRoomId(1);
		System.out.println(dao.getAllRoomId(1).get(0).getRoom_id());
		// 修改
//			RoomVO roomVO2= new RoomVO();
//			roomVO2.setRoom_id(1);
//			roomVO2.setRoom_type_id(1);
//			roomVO2.setRoom_guest_name("Paul");
//			roomVO2.setRoom_sale_status(1);
//			roomVO2.setRoom_status(1);
//			dao.update(roomVO2);

		// 刪除
//			dao.delete(1);

		// 查詢
//			RoomVO roomVO3 = dao.findByPrimaryKey(6);
//			System.out.print(roomVO3.getRoom_id() + ",");
//			System.out.print(roomVO3.getRoom_type_id() + ",");
//			System.out.print(roomVO3.getRoom_guest_name() + ",");
//			System.out.print(roomVO3.getRoom_sale_status() + ",");
//			System.out.print(roomVO3.getRoom_status());
//			System.out.println("---------------------");

		// 查詢
//			List<RoomVO> list = dao.getAll();
//			for (RoomVO aRoom : list) {
//				System.out.print(aRoom.getRoom_id() + ",");
//				System.out.print(aRoom.getRoom_type_id() + ",");
//				System.out.print(aRoom.getRoom_guest_name() + ",");
//				System.out.print(aRoom.getRoom_sale_status() + ",");
//				System.out.print(aRoom.getRoom_status());
//				System.out.println();
//			}
//		dao.getAllRoomDateStatus(1).get(1).getCheck_in_date();
//		for (int i = 0; i < 5; i++) {
//			System.out.println(dao.getAllRoomDateStatus(1).get(i).getCheck_out_date());
//		}
			
			

	}

}
