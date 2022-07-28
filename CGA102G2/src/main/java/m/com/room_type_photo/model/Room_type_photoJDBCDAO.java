package m.com.room_type_photo.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class Room_type_photoJDBCDAO implements Room_type_photoDAO_interface {

	private static DataSource ds;
	static {
		try {
			Context ctx = new javax.naming.InitialContext();
			try {
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CGA102_2");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CGA102_2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = "insert into room_type_photo(room_type_id, room_type_photo ) "
			+ "value(?, ?);";
	private static final String GET_ALL_STMT = "SELECT room_type_photo_id , room_type_id ,room_type_photo FROM room_type_photo order by room_type_photo_id;";
	private static final String GET_ONE_STMT = "SELECT room_type_photo_id , room_type_id ,room_type_photo FROM room_type_photo where room_type_photo_id =?;";
	private static final String DELETE = "delete from room_type_photo where room_type_photo_id = ?;";
	private static final String UPDATE = "update room_type_photo set room_type_id = ?, room_type_photo = ? where room_type_photo_id = ?;";
	private static final String GET_ALL_PHOTO = "select room_type_photo from room_type_photo where room_type_id = ? ;";
	private static final String GET_ALL_TYPE = "SELECT room_type_photo_id, room_type_id,room_type_photo FROM room_type_photo where room_type_id =?";

	@Override
	public void insert(Room_type_photoVO room_type_photoVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, room_type_photoVO.getRoom_type_id());
			pstmt.setBlob(2, room_type_photoVO.getRoom_type_photo());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		}
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			throw new RuntimeException("A database error occured. " + e.getMessage());
//		} 
		finally {
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
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, room_type_photoVO.getRoom_type_id());
			pstmt.setBlob(2, room_type_photoVO.getRoom_type_photo());
			pstmt.setInt(3, room_type_photoVO.getRoom_type_photo_id());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		}
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			throw new RuntimeException("A database error occured. " + e.getMessage());
//		} 
		finally {
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
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, room_type_photo_id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		}
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			throw new RuntimeException("A database error occured. " + e.getMessage());
//		} 
		finally {
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
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
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
		}
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			throw new RuntimeException("A database error occured. " + e.getMessage());
//		} 
		finally {
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
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				room_type_photoVO = new Room_type_photoVO();
				room_type_photoVO.setRoom_type_photo_id(rs.getInt("room_type_photo_id"));
				room_type_photoVO.setRoom_type_id(rs.getInt("room_type_id"));
				room_type_photoVO.setRoom_type_photo(rs.getBlob("room_type_photo"));
				list.add(room_type_photoVO);
			}

		}
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//
//		} 
		catch (SQLException se) {
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

	public List<Room_type_photoVO> getAllPhoto(Integer room_type_id) {

		List<Room_type_photoVO> list1 = new ArrayList<Room_type_photoVO>();

		Room_type_photoVO room_type_photoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_PHOTO);

			pstmt.setInt(1, room_type_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				room_type_photoVO = new Room_type_photoVO();
//				room_type_photoVO.setRoom_type_photo_id(rs.getInt("room_type_photo_id"));
//				room_type_photoVO.setRoom_type_id(rs.getInt("room_type_id"));
				room_type_photoVO.setRoom_type_photo(rs.getBlob("room_type_photo"));
				list1.add(room_type_photoVO);
			}

		}
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//
//		}
		catch (SQLException se) {
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
		return list1;
	}

	public List<Room_type_photoVO> getAllType(Integer room_type_id) {

		List<Room_type_photoVO> list2 = new ArrayList<Room_type_photoVO>();

		Room_type_photoVO room_type_photoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_TYPE);

			pstmt.setInt(1, room_type_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				room_type_photoVO = new Room_type_photoVO();
				room_type_photoVO.setRoom_type_photo_id(rs.getInt("room_type_photo_id"));
				room_type_photoVO.setRoom_type_id(rs.getInt("room_type_id"));
				room_type_photoVO.setRoom_type_photo(rs.getBlob("room_type_photo"));
				list2.add(room_type_photoVO);
			}

		}
//		catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//
//		} 
		catch (SQLException se) {
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
		return list2;
	}

	public static void main(String[] args) throws Exception {

		File f1 = new File(
				"/Users/mayyu/Desktop/CGA102_WebApp/eclipse_WTP_workspace1/CGA102G2/src/main/webapp/images/back1.gif");
		FileInputStream fis = new FileInputStream(f1);
		byte[] byteArray = new byte[fis.available()];
		fis.read(byteArray);
		Blob blob = new SerialBlob(byteArray);
		Room_type_photoJDBCDAO rtpJDBC = new Room_type_photoJDBCDAO();

		Room_type_photoVO rtp = new Room_type_photoVO();
		rtp.setRoom_type_id(35);
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

		List<Room_type_photoVO> list1 = rtpJDBC.getAllPhoto(1);
		for (Room_type_photoVO rtp4 : list1) {
			System.out.println(rtp4.getRoom_type_photo() + ",");
		}

		List<Room_type_photoVO> list = rtpJDBC.getAllType(1);
		for (Room_type_photoVO rtp5 : list) {
			System.out.println(rtp5.getRoom_type_photo_id() + ",");
			System.out.println(rtp5.getRoom_type_id() + ",");
			System.out.println(rtp5.getRoom_type_photo() + ",");
		}
	}
}
