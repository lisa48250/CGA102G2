package h.com.room_type_photo.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;

public class Room_type_photoJDBCDAO implements Room_type_photoDAO_interface{
	
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
	
	private static final String INSERT_STMT = "insert into room_type_photo(room_type_id, room_type_photo ) "
			+ "value(?, ?);";
	private static final String GET_ALL_STMT = "SELECT room_type_photo_id , room_type_id ,room_type_photo FROM room_type_photo order by room_type_photo_id;";
	private static final String GET_ONE_STMT = "SELECT room_type_photo_id , room_type_id ,room_type_photo FROM room_type_photo where room_type_photo_id =?;";
	private static final String DELETE = "delete from room_type_photo where room_type_photo_id = ?;";
	private static final String UPDATE ="update room_type_photo set room_type_id = ? where room_type_photo_id = ?;";
	private static final String GET_ALL_PHOTO ="select room_type_photo , room_type_photo_id from room_type_photo where room_type_id = ? ;" ;
	private static final String GET_ALL_PHOTO_ID ="select room_type_photo_id from room_type_photo where room_type_id =?;";
	@Override
	public void insert(Room_type_photoVO room_type_photoVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, room_type_photoVO.getRoom_type_id());
			pstmt.setBlob(2, room_type_photoVO.getRoom_type_photo());
			

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
	public void update(Room_type_photoVO room_type_photoVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, room_type_photoVO.getRoom_type_id());
			pstmt.setInt(2, room_type_photoVO.getRoom_type_photo_id());
			
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
	public void delete(Integer room_type_photo_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, room_type_photo_id);

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
	public Room_type_photoVO findByPrimaryKey(Integer room_type_photo_id) {
		// TODO Auto-generated method stub
		Room_type_photoVO room_type_photoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, room_type_photo_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				room_type_photoVO = new Room_type_photoVO();
				room_type_photoVO.setRoom_type_photo_id(rs.getInt("room_type_photo_id"));
				room_type_photoVO.setRoom_type_id(rs.getInt("room_type_id"));
				room_type_photoVO.setRoom_type_photo(rs.getBlob("room_type_photo"));
				
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
		return room_type_photoVO;
	}
	
	@Override
	public List<Room_type_photoVO> getAll() {
		// TODO Auto-generated method stub
		List<Room_type_photoVO> list = new ArrayList<Room_type_photoVO>();

		Room_type_photoVO room_type_photoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				room_type_photoVO = new Room_type_photoVO();
				room_type_photoVO.setRoom_type_photo_id(rs.getInt("room_type_photo_id"));
				room_type_photoVO.setRoom_type_id(rs.getInt("room_type_id"));
				room_type_photoVO.setRoom_type_photo(rs.getBlob("room_type_photo"));
				list.add(room_type_photoVO);
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
	
	public List<Room_type_photoVO> getAllPhoto(Integer room_type_id){
		
		List<Room_type_photoVO> list = new ArrayList<Room_type_photoVO>();

		Room_type_photoVO room_type_photoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_PHOTO);
			
			pstmt.setInt(1, room_type_id);
			
			rs = pstmt.executeQuery();
			
			

			while (rs.next()) {

				room_type_photoVO = new Room_type_photoVO();
				room_type_photoVO.setRoom_type_photo_id(rs.getInt("room_type_photo_id"));
//				room_type_photoVO.setRoom_type_id(rs.getInt("room_type_id"));
				room_type_photoVO.setRoom_type_photo(rs.getBlob("room_type_photo"));
				list.add(room_type_photoVO);
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
	
	@Override
	public List<Room_type_photoVO> getAllPhotoID(Integer room_type_id) {
		List<Room_type_photoVO> list = new ArrayList<Room_type_photoVO>();

		Room_type_photoVO room_type_photoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_PHOTO_ID);
			
			pstmt.setInt(1, room_type_id);
			
			rs = pstmt.executeQuery();
			
			

			while (rs.next()) {

				room_type_photoVO = new Room_type_photoVO();
				room_type_photoVO.setRoom_type_photo_id(rs.getInt("room_type_photo_id"));
//				room_type_photoVO.setRoom_type_id(rs.getInt("room_type_id"));
//				room_type_photoVO.setRoom_type_photo(rs.getBlob("room_type_photo"));
				list.add(room_type_photoVO);
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
	
	
	public static void main(String[]args) throws Exception {
		
		File f1 = new File("/Users/joof456/Desktop/總統房1-3.png");
		FileInputStream fis = new FileInputStream(f1);
		byte[] byteArray = new byte[fis.available()];
		fis.read(byteArray);
		Blob blob = new SerialBlob(byteArray);
		Room_type_photoJDBCDAO rtpJDBC = new Room_type_photoJDBCDAO();
		
		Room_type_photoVO rtp = new Room_type_photoVO();
		rtp.setRoom_type_id(1);
		rtp.setRoom_type_photo(blob);
		rtpJDBC.insert(rtp);
//		
//		Room_type_photoVO rtp1 = new Room_type_photoVO();
//		rtp1.setRoom_type_id(4);
//		rtp1.setRoom_type_photo_id(2);
//		rtpJDBC.update(rtp1);
//		
//		rtpJDBC.delete(2);
//		
//		Room_type_photoVO rtp2 = rtpJDBC.findByPrimaryKey(3);
//		System.out.println(rtp2.getRoom_type_photo_id()+ ",");
//		System.out.println(rtp2.getRoom_type_id()+ ",");
//		System.out.println(rtp2.getRoom_type_photo()+ ",");
//		
//		List<Room_type_photoVO> list = rtpJDBC.getAll();
//		for(Room_type_photoVO rtp3 : list) {
//			System.out.println(rtp3.getRoom_type_photo_id()+ ",");
//			System.out.println(rtp3.getRoom_type_id()+ ",");
//			System.out.println(rtp3.getRoom_type_photo()+ ",");
//	}
//		Room_type_photoJDBCDAO dao = new Room_type_photoJDBCDAO();
//		System.out.println(dao.getAllPhoto(2));
	}

	

	
}
