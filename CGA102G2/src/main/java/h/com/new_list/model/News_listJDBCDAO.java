package h.com.new_list.model;


import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class News_listJDBCDAO implements News_listDAO_interface {

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

	private static final String INSERT_STMT = "insert into news_list(news_id_title , news_id_description , news_id_date , news_id_photo) "
			+ "value(? , ? , ? ,?);";
	private static final String GET_ALL_STMT = "SELECT NEWS_ID , NEWS_ID_TITLE ,NEWS_ID_DESCRIPTION , NEWS_ID_DATE   FROM  news_list order by  news_id_date desc;";
	private static final String GET_ONE_STMT = "SELECT NEWS_ID , NEWS_ID_TITLE ,NEWS_ID_DESCRIPTION , NEWS_ID_DATE , NEWS_ID_PHOTO  FROM news_list where NEWS_ID = ?;";
	private static final String DELETE = "delete from news_list where news_id =?;";
	private static final String UPDATE = "update news_list set news_id_title = ?, news_id_description = ? , news_id_date = ? , news_id_photo = ? where news_id = ?;";

	public News_listJDBCDAO() {

	};

	@Override
	public void insert(News_listVO news_listVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, news_listVO.getNews_id_title());
			pstmt.setString(2, news_listVO.getNews_id_description());
			pstmt.setDate(3, news_listVO.getNews_id_date());
			pstmt.setBytes(4,news_listVO.getNews_id_photo());
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
	public void update(News_listVO news_listVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, news_listVO.getNews_id_title());
			pstmt.setString(2, news_listVO.getNews_id_description());
			pstmt.setDate(3, news_listVO.getNews_id_date());
			pstmt.setBytes(4,news_listVO.getNews_id_photo());
			pstmt.setInt(5, news_listVO.getNews_id());

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
	public void delete(Integer news_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, news_id);

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
	public News_listVO findByPrimaryKey(Integer news_id) {
		// TODO Auto-generated method stub
		News_listVO news_listVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, news_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				news_listVO = new News_listVO();
				news_listVO.setNews_id(rs.getInt("news_id"));
				news_listVO.setNews_id_title(rs.getString("news_id_title"));
				news_listVO.setNews_id_description(rs.getString("news_id_description"));
				news_listVO.setNews_id_date(rs.getDate("news_id_date"));
				news_listVO.setNews_id_photo(rs.getBytes("news_id_photo"));

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
		return news_listVO;
	}

	@Override
	public List<News_listVO> getAll() {
		// TODO Auto-generated method stub
		List<News_listVO> list = new ArrayList<News_listVO>();

		News_listVO news_listVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				news_listVO = new News_listVO();
				news_listVO.setNews_id(rs.getInt("news_id"));
				news_listVO.setNews_id_title(rs.getString("news_id_title"));
				news_listVO.setNews_id_description(rs.getString("news_id_description"));
				news_listVO.setNews_id_date(rs.getDate("news_id_date"));
				list.add(news_listVO);
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

//	public static byte[] getPictureByteArray(String path) throws IOException {
//		FileInputStream fis = new FileInputStream(path);
//		byte[] buffer = new byte[fis.available()];
//		fis.read(buffer);
//		fis.close();
//		return buffer;
//	}
//
//	private byte[] InputStreamToByte(InputStream is) throws IOException {
//		ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
//		int ch;
//		while ((ch = is.read()) != -1) {
//			bytestream.write(ch);
//		}
//		byte imgdata[] = bytestream.toByteArray();
//		bytestream.close();
//		return imgdata;
//	}

	public static void main(String[] args) throws IOException {
		News_listJDBCDAO nljdbc = new News_listJDBCDAO();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		News_listVO nl = new News_listVO();
//		nl.setNews_id_title("2022年平假日定義");
//		nl.setNews_id_description("2022年平假日定義一覽表:<br> "
//				+ "						旺季定義:10月~3月、淡季定義:4月~9月<br> "
//				+ "						旺季平日定義:週日~週四 ; 旺季假日定義:週五~週六、國定假日。<br> "
//				+ "						淡季平日定義:週日~週五 ; 淡季假日定義:週六、國定假日。<br> "
//				+ "						特殊節日:<br> "
//				+ "						元旦1/1(六)<br> "
//				+ "						農曆春節除夕1/31(一)~2/5初五(六)<br> "
//				+ "						西洋情人節 2/14(一)<br> "
//				+ "						母親節 5/8(日)<br> "
//				+ "						耶誕夜12/24(六)/聖誕節12/25(日)<br> "
//				+ "						跨年夜12/31(六)");
//		nl.setNews_id_date(java.sql.Timestamp.valueOf(LocalDateTime.now()));
//		
//		byte[] pic = getPictureByteArray("/Users/joof456/Desktop/專題/最新消息/new2.jpg");
//		nl.setNews_id_photo( pic);
//		nljdbc.insert(nl);

//		News_listVO nl1= new News_listVO();
//		nl1.setNews_id_title("五");
//		nl1.setNews_id_description("消息五");
//		nl1.setNews_id_date(java.sql.Timestamp.valueOf("2002-05-05"));
//		nl1.setNews_id(3);
//		nljdbc.update(nl1);

//		nljdbc.delete(3);

//		News_listVO nl2 = nljdbc.findByPrimaryKey(2);
//		System.out.println(nl2.getNews_id()+ ",");
//		System.out.println(nl2.getNews_id_title()+ ",");
//		System.out.println(nl2.getNews_id_description()+ ",");
//		System.out.println(simpledateformat.format(nl2.getNews_id_date()));
//		System.out.println(nl2.getNews_id_photo()+ ",");

//	
//		List<News_listVO> list = nljdbc.getAll();
//		for(News_listVO nl3 : list) {
//			System.out.println(nl3.getNews_id()+ ",");
//			System.out.println(nl3.getNews_id_title()+ ",");
//			System.out.println(nl3.getNews_id_description()+ ",");
//			System.out.println(simpledateformat.format(nl3.getNews_id_date())+ ",");
//			System.out.println(nl3.getNews_id_photo() );
//		}
	}
}
