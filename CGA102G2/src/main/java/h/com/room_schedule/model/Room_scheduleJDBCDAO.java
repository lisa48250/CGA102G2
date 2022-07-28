package h.com.room_schedule.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Room_scheduleJDBCDAO implements Room_scheduleDAO_interface {

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

	
	private static final String INSERT_STMT = "insert into room_schedule (room_type_id , room_id , check_in_date , check_out_date) "
			+ "value(? , ? , ? ,?);";
	private static final String GET_ALL_STMT = "select room_schedule_id , room_type_id , room_id , check_in_date , check_out_date from room_schedule order by  room_schedule_id ;";
	private static final String GET_ONE_STMT = "select room_schedule_id , room_type_id , room_id , check_in_date , check_out_datefrom room_schedule where room_schedule_id = ?; ";
	private static final String DELETE = "delete from room_schedule where room_schedule_id = ?;";
	private static final String UPDATE = "update room_schedule set room_type_id = ? , room_id = ? , check_in_date = ? , check_out_date = ? where room_schedule_id = ?;";
	private static final String GET_ROOMID_DATE ="SELECT  room_id ,check_in_date , check_out_date from room_schedule where room_id = ?;";
	
	private static final String GAT = "SELECT distinct r.room_id"
			+ "			FROM "
			+ "				ROOM r "
			+ "			    left join ROOM_SCHEDULE rs "
			+ "					on r.ROOM_ID = rs.ROOM_ID "
			+ "			where "
			+ "				rs.ROOM_SCHEDULE_ID is not null "
			+ "				and ? not between CHECK_IN_DATE and CHECK_OUT_DATE "
			+ "			        and ? not between CHECK_IN_DATE and CHECK_OUT_DATE"
			+ "                    and CHECK_IN_DATE not between ? and ?"
			+ "                    and CHECK_OUT_DATE not between ? and ?"
			+ "                    and  CHECK_IN_DATE != ? "
			+ "                    and CHECK_IN_DATE != ? "
			+ "                   and  CHECK_OUT_DATE != ? "
			+ "                    and CHECK_OUT_DATE != ? "
			+ "                     and r.room_type_id = ? "
			+ "			    or "
			+ "			    rs.ROOM_SCHEDULE_ID is null"
			+ "                and r.room_type_id = ? ;";
	public Room_scheduleJDBCDAO() {};
	
	@Override
	public void insert(Room_scheduleVO room_scheduleVO) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, room_scheduleVO.getRoom_type_id());
			pstmt.setInt(2, room_scheduleVO.getRoom_id());
			pstmt.setDate(3, room_scheduleVO.getCheck_in_date());
			pstmt.setDate(4, room_scheduleVO.getCheck_out_date());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		}  finally {
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
	public void update(Room_scheduleVO room_scheduleVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, room_scheduleVO.getRoom_type_id());
			pstmt.setInt(2, room_scheduleVO.getRoom_id());
			pstmt.setDate(3, room_scheduleVO.getCheck_in_date());
			pstmt.setDate(4, room_scheduleVO.getCheck_out_date());
			pstmt.setInt(5, room_scheduleVO.getRoom_schedule_id());
			
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
	public void delete(Integer room_type_schedule_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, room_type_schedule_id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		}finally {
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
	public Room_scheduleVO findByPrimaryKey(Integer room_schedule_id) {
		// TODO Auto-generated method stub
		Room_scheduleVO room_scheduleVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, room_schedule_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				room_scheduleVO = new Room_scheduleVO();
				room_scheduleVO.setRoom_schedule_id(rs.getInt("room_schedule_id"));
				room_scheduleVO.setRoom_type_id(rs.getInt("room_type_id"));
				room_scheduleVO.setRoom_id(rs.getInt("room_id"));
				room_scheduleVO.setCheck_in_date(rs.getDate("check_in_date"));
				room_scheduleVO.setCheck_out_date(rs.getDate("check_out_date"));
				
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
		return room_scheduleVO;
	}
	

	@Override
	public List<Room_scheduleVO> getAll() {

		// TODO Auto-generated method stub
		List<Room_scheduleVO> list = new ArrayList<Room_scheduleVO>();

		Room_scheduleVO room_scheduleVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				room_scheduleVO = new Room_scheduleVO();
				room_scheduleVO.setRoom_schedule_id(rs.getInt("room_schedule_id"));
				room_scheduleVO.setRoom_type_id(rs.getInt("room_type_id"));
				room_scheduleVO.setRoom_id(rs.getInt("room_id"));
				room_scheduleVO.setCheck_in_date(rs.getDate("check_in_date"));
				room_scheduleVO.setCheck_out_date(rs.getDate("check_out_date"));
				list.add(room_scheduleVO);
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
		return list;
	}
	
	public List<Room_scheduleVO> getAllRoomidDate(Integer room_id){
		
		List<Room_scheduleVO> list = new ArrayList<Room_scheduleVO>();
		Room_scheduleVO room_scheduleVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ROOMID_DATE);

			pstmt.setInt(1, room_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				room_scheduleVO = new Room_scheduleVO();
				room_scheduleVO.setRoom_id(rs.getInt("room_id"));
				room_scheduleVO.setCheck_in_date(rs.getDate("check_in_date"));
				room_scheduleVO.setCheck_out_date(rs.getDate("check_out_date"));
				list.add(room_scheduleVO);
			}
			
	}catch (SQLException se) {
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
	
	 
	public List<Room_scheduleVO> getNew(Date check_in_date ,Date check_out_date , Integer room_type_id ){
		
		List<Room_scheduleVO> list = new ArrayList<Room_scheduleVO>();
		
		Room_scheduleVO room_scheduleVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GAT);

			pstmt.setDate(1, check_in_date);
			pstmt.setDate(2, check_out_date);
			pstmt.setDate(3, check_in_date);
			pstmt.setDate(4, check_out_date);
			pstmt.setDate(5, check_in_date);
			pstmt.setDate(6, check_out_date);
			pstmt.setDate(7, check_in_date);
			pstmt.setDate(8, check_out_date);
			pstmt.setDate(9, check_in_date);
			pstmt.setDate(10, check_out_date);
			pstmt.setInt(11, room_type_id);
			pstmt.setInt(12, room_type_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				room_scheduleVO = new Room_scheduleVO();
			
				room_scheduleVO.setRoom_id(rs.getInt("room_id"));
				
				list.add(room_scheduleVO);
			}
			
	}catch (SQLException se) {
		
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
//		Room_scheduleJDBCDAO rtsVo = new Room_scheduleJDBCDAO();
//		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		
		
//		
//		System.out.println(rtsVo.getAllRoomidDate(1));
//		rtsVo.getAllRoomidDate(1);
		
//		Room_scheduleVO rts = new Room_scheduleVO();
//		rts.setRoom_type_id(4);
//		rts.setRoom_amount(1);
//		rts.setRoom_rsv_booked(1);
//		rts.setRoom_order_date(java.sql.Timestamp.valueOf("2002-06-06"));
//		rtsVo.insert(rts);
//		
//		Room_scheduleVO rts1 = new Room_scheduleVO();
//		rts1.setRoom_type_id(2);
//		rts1.setRoom_amount(2);
//		rts1.setRoom_rsv_booked(2);
//		rts1.setRoom_order_date(java.sql.Timestamp.valueOf("2002-05-05"));
//		rts1.setRoom_type_schedule_id(7);
//		rtsVo.update(rts1);
//		
//		rtsVo.delete(12);
//		
//		Room_scheduleVO rts2 = rtsVo.findByPrimaryKey(4);
//		System.out.println(rts2.getRoom_type_schedule_id()+ ",");
//		System.out.println(rts2.getRoom_type_id()+ ",");
//		System.out.println(rts2.getRoom_amount()+ ",");
//		System.out.println(rts2.getRoom_rsv_booked()+ ",");
//		System.out.println(simpledateformat.format(rts2.getRoom_order_date())+ ",");
//		
//		
//		
//		
//		List<Room_scheduleVO> list = rtsVo.getAll();
//		for(Room_scheduleVO rts3 : list) {
//		System.out.println(rts3.getRoom_type_schedule_id()+ ",");
//		System.out.println(rts3.getRoom_type_id()+ ",");
//		System.out.println(rts3.getRoom_amount()+ ",");
//		System.out.println(rts3.getRoom_rsv_booked()+ ",");
//		System.out.println(simpledateformat.format(rts3.getRoom_order_date())+ ",");
//		}
	}
}
