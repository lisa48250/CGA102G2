package com.news_post.model;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.io.IOException;
import java.sql.*;

public class NewsPostDAO implements NewsPostDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CGA102_2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = // 宣告變數INSERT_STMT，自動編號不用加
			"INSERT INTO NEWS_POST (NEWS_PHOTO_FILE, TITLE, SUMMARY,CONTENT,NEWS_STATUS,NEWS_POST_DATE,POST_COME_FROM) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT NEWS_POST_ID, NEWS_PHOTO_FILE, TITLE, SUMMARY,CONTENT,NEWS_STATUS,NEWS_POST_DATE,POST_COME_FROM FROM NEWS_POST order by NEWS_POST_ID";
	private static final String GET_ONE_STMT = 
			"SELECT NEWS_POST_ID, NEWS_PHOTO_FILE, TITLE, SUMMARY,CONTENT,NEWS_STATUS, NEWS_POST_DATE, POST_COME_FROM FROM NEWS_POST where NEWS_POST_ID = ?";
	private static final String GET_STATUS_STMT = 
			"SELECT NEWS_POST_ID, NEWS_PHOTO_FILE, TITLE, SUMMARY,CONTENT,NEWS_STATUS, NEWS_POST_DATE, POST_COME_FROM FROM NEWS_POST where NEWS_STATUS = ?";
	private static final String DELETE = 
			"DELETE FROM NEWS_POST where NEWS_POST_ID = ?";
	private static final String UPDATE = 
			"UPDATE NEWS_POST set NEWS_PHOTO_FILE=?, TITLE=?, SUMMARY=?, CONTENT=?, NEWS_STATUS=?, NEWS_POST_DATE =?, POST_COME_FROM =? where NEWS_POST_ID = ?";
	private static final String GET_STATUS = 
			"SELECT NEWS_POST_ID, NEWS_PHOTO_FILE, TITLE, SUMMARY,CONTENT,NEWS_STATUS,NEWS_POST_DATE,POST_COME_FROM FROM NEWS_POST where NEWS_STATUS = 1 order by NEWS_POST_ID";

	

	@Override
	public void insert(NewsPostVO newsPostVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT); // INSERT_STMT變數帶入，等於下面這行code的意思


			pstmt.setBytes(1, newsPostVO.getNewsPhotoFile());
			pstmt.setString(2, newsPostVO.getTitle());
			pstmt.setString(3, newsPostVO.getSummary());
			pstmt.setString(4, newsPostVO.getContent());
			pstmt.setInt(5, newsPostVO.getNewsStatus());
			pstmt.setDate(6, newsPostVO.getNewsPostDate());
			pstmt.setString(7, newsPostVO.getPostComeFrom());

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
	public void update(NewsPostVO newsPostVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setBytes(1, newsPostVO.getNewsPhotoFile());
			pstmt.setString(2, newsPostVO.getTitle());
			pstmt.setString(3, newsPostVO.getSummary());
			pstmt.setString(4, newsPostVO.getContent());
			pstmt.setInt(5, newsPostVO.getNewsStatus());
			pstmt.setDate(6, newsPostVO.getNewsPostDate());
			pstmt.setString(7, newsPostVO.getPostComeFrom());
			pstmt.setInt(8, newsPostVO.getNewsPostId());


			pstmt.executeUpdate();

			// Handle any driver errors
		}catch (SQLException se) {
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
	public void delete(Integer newsPostId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, newsPostId);

			pstmt.executeUpdate();

			// Handle any driver errors
		}catch (SQLException se) {
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
			if (con != null) { // 資料庫連線一定要關
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public NewsPostVO findByPrimaryKey(Integer newsPostId) {

		NewsPostVO newspostVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, newsPostId);

			rs = pstmt.executeQuery();

			// ----------------------------------單一查詢----------------------------------
//			rs.next();
//			
//			newspostVO = new NewsPostVO();
//			newspostVO.setNewsPostId(rs.getInt("NEWS_POST_ID"));
//			newspostVO.setNewsPhotoFile(rs.getBytes("newsPhotoFile")); 
//			newspostVO.setTitle(rs.getString("title"));
//			newspostVO.setSummary(rs.getString("summary"));
//			newspostVO.setContent(rs.getString("content"));
//			newspostVO.setNewsStatus(rs.getInt("newsStatus"));
//			newspostVO.setNewsPostDate(rs.getDate("newsPostDate"));
//			newspostVO.setPostComeFrom(rs.getString("postComeFrom"));
	
			// ----------------------------------全部查詢--------------------------------------
			while (rs.next()) {

				newspostVO = new NewsPostVO();
				newspostVO.setNewsPostId(rs.getInt("NEWS_POST_ID"));
				newspostVO.setNewsPhotoFile(rs.getBytes("NEWS_PHOTO_FILE"));
				newspostVO.setTitle(rs.getString("TITLE"));
				newspostVO.setSummary(rs.getString("SUMMARY"));
				newspostVO.setContent(rs.getString("CONTENT"));
				newspostVO.setNewsStatus(rs.getInt("NEWS_STATUS"));
				newspostVO.setNewsPostDate(rs.getDate("NEWS_POST_DATE"));
				newspostVO.setPostComeFrom(rs.getString("POST_COME_FROM"));

			}

			// Handle any driver errors
		}catch (SQLException se) {
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
		return newspostVO;
	}

	@Override
	public List<NewsPostVO> getAll() {
		List<NewsPostVO> list = new ArrayList<NewsPostVO>();
		NewsPostVO newspostVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				newspostVO = new NewsPostVO();
				newspostVO.setNewsPostId(rs.getInt("NEWS_POST_ID"));
				newspostVO.setNewsPhotoFile(rs.getBytes("NEWS_PHOTO_FILE"));
				newspostVO.setTitle(rs.getString("TITLE"));
				newspostVO.setSummary(rs.getString("SUMMARY"));
				newspostVO.setContent(rs.getString("CONTENT"));
				newspostVO.setNewsStatus(rs.getInt("NEWS_STATUS"));
				newspostVO.setNewsPostDate(rs.getDate("NEWS_POST_DATE"));
				newspostVO.setPostComeFrom(rs.getString("POST_COME_FROM"));
				list.add(newspostVO); // Store the row in the list
			}

			// Handle any driver errors
		}catch (SQLException se) {
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
	public List<NewsPostVO> getstatus(Integer newsStatus) {
		List<NewsPostVO> list = new ArrayList<NewsPostVO>();
		NewsPostVO newspostVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_STATUS_STMT);

			pstmt.setInt(1, newsStatus);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				newspostVO = new NewsPostVO();
				newspostVO.setNewsPostId(rs.getInt("NEWS_POST_ID"));
				newspostVO.setNewsPhotoFile(rs.getBytes("NEWS_PHOTO_FILE"));
				newspostVO.setTitle(rs.getString("TITLE"));
				newspostVO.setSummary(rs.getString("SUMMARY"));
				newspostVO.setContent(rs.getString("CONTENT"));
				newspostVO.setNewsStatus(rs.getInt("NEWS_STATUS"));
				newspostVO.setNewsPostDate(rs.getDate("NEWS_POST_DATE"));
				newspostVO.setPostComeFrom(rs.getString("POST_COME_FROM"));
				list.add(newspostVO); // Store the row in the list
			}

			// Handle any driver errors
		}catch (SQLException se) {
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
	public List<NewsPostVO> getStatusOne() {
		List<NewsPostVO> list = new ArrayList<NewsPostVO>();
		NewsPostVO newspostVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_STATUS);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				newspostVO = new NewsPostVO();
				newspostVO.setNewsPostId(rs.getInt("NEWS_POST_ID"));
				newspostVO.setNewsPhotoFile(rs.getBytes("NEWS_PHOTO_FILE"));
				newspostVO.setTitle(rs.getString("TITLE"));
				newspostVO.setSummary(rs.getString("SUMMARY"));
				newspostVO.setContent(rs.getString("CONTENT"));
				newspostVO.setNewsStatus(rs.getInt("NEWS_STATUS"));
				newspostVO.setNewsPostDate(rs.getDate("NEWS_POST_DATE"));
				newspostVO.setPostComeFrom(rs.getString("POST_COME_FROM"));
				list.add(newspostVO); // Store the row in the list
			}

			// Handle any driver errors
		}catch (SQLException se) {
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

	
	
	
	public static void main(String[] args) throws IOException {

		NewsPostDAO dao = new NewsPostDAO();

		// 新增
//		NewsPostVO newsPostVO1 = new NewsPostVO();
//		//byte[] bytes = Files.readAllBytes(Paths.get("C:\\Users\\User\\OneDrive\\桌面\\圖庫\\飯店風格\\49689852886_c524d733cc_b.jpg"));
//		byte[] bytes = Files.readAllBytes(Paths.get("C:\\Users\\User\\OneDrive\\桌面\\圖庫\\飯店風格\\News_Post\\北投5月瘋賞螢.jpg"));
//		newsPostVO1.setNewsPhotoFile(bytes);
//		newsPostVO1.setTitle("北投5月瘋賞螢 住宿享母親節活動");
//		newsPostVO1.setSummary("雲淡風輕溫泉酒店推出北投賞螢火蟲紓壓之旅");
//		newsPostVO1.setContent("即將邁入5月，一年一度的母親節又到了，想要寵媽卻沒想法嗎？不妨來趟宜蘭賞螢火蟲孝親紓壓之旅，晚上探尋螢火蟲的蹤影後，再入住雲淡風輕溫泉飯店，讓媽咪泡溫泉沖SPA洗去疲勞、吃在地精選美食吃到飽，享受備受寵愛的幸福親子之旅。 "
//				+ "雲淡風輕溫泉飯店以特色溫泉湯池受到在地民眾喜愛。也因應母親節舉辦許多特色專案，包含享享點星廚手作蛋糕預購及此次馨花怒放專案最低折扣至原價52折， 一泊二食提供的享享自助百匯採用吃到飽形式，更是雲淡風輕溫泉飯店吃到飽首選，讓民眾有不同的新鮮用餐體驗。 "
//				+ "北投區政府於賞螢活動期間(4/15~5/31期間)，提供宜蘭住宿合法旅宿的旅客可憑住宿憑證(收據或發票)免費參加，限量1000名，經由解說老師專業的導覽解說延伸到北投的夜間豐富生態，規畫六大賞螢行程，包含: 頭城農場、小礁溪匏崙村、枕頭山休閒農業區、天山農場、香格里拉農場以及英士部落，讓每位參加的旅客更能認識夜晚生態的魅力。");
//		newsPostVO1.setNewsStatus(1);
//		newsPostVO1.setNewsPostDate(java.sql.Date.valueOf("2021-03-11"));
//		newsPostVO1.setPostComeFrom("東森新聞報導");
//			dao.insert(newsPostVO1);

		// 修改
//		NewsPostVO newsPostVO2 = new NewsPostVO();
//		newsPostVO2.setNewsPostId(10);
//		byte[] bytes = Files
//				.readAllBytes(Paths.get("C:\\Users\\User\\OneDrive\\桌面\\圖庫\\飯店風格\\49689852886_c524d733cc_b.jpg"));
//		newsPostVO2.setNewsPhotoFile(bytes);
//		newsPostVO2.setTitle("修改過的標題");
//		newsPostVO2.setSummary("修改過的");
//		newsPostVO2.setContent("修改過的內容");
//		newsPostVO2.setNewsStatus(0);
//		newsPostVO2.setNewsPostDate(java.sql.Date.valueOf("2020-01-07"));
//		newsPostVO2.setPostComeFrom("東森新聞報導");
//		dao.update(newsPostVO2);

		// 刪除
		//	dao.delete(6);
		//
			
		// 單一查詢
//		NewsPostVO newsPostVO3 = dao.findByPrimaryKey(38);
//		System.out.print(newsPostVO3.getNewsPhotoFile() + ",");
//		System.out.print(newsPostVO3.getTitle() + ",");
//		System.out.print(newsPostVO3.getSummary() + ",");
//		System.out.print(newsPostVO3.getContent() + ",");
//		System.out.print(newsPostVO3.getNewsStatus() + ",");
//		System.out.print(newsPostVO3.getNewsPostDate() + ",");
//		System.out.println(newsPostVO3.getPostComeFrom());
//		System.out.println("---------------------");
		
		// 查詢狀態
			List<NewsPostVO> list = dao.getstatus(0);
			for (NewsPostVO news : list) {
	
		System.out.print(news.getNewsPhotoFile() + ",");
		System.out.print(news.getTitle() + ",");
		System.out.print(news.getSummary() + ",");
		System.out.print(news.getContent() + ",");
		System.out.print(news.getNewsStatus() + ",");
		System.out.print(news.getNewsPostDate() + ",");
		System.out.println(news.getPostComeFrom());
		System.out.println("---------------------");
			}
		// 查詢全部
//			List<NewsPostVO> list = dao.getAll();
//			for (NewsPostVO aEmp : list) {
//				System.out.print(aEmp.getNewsPostId() + ",");
//				System.out.print(aEmp.getNewsPhotoFile() + ",");
//				System.out.print(aEmp.getTitle() + ",");
//				System.out.print(aEmp.getSummary() + ",");
//				System.out.print(aEmp.getContent() + ",");
//				System.out.print(aEmp.getNewsStatus() + ",");
//				System.out.print(aEmp.getNewsPostDate());
//				System.out.print(aEmp.getPostComeFrom());
//				System.out.println();
//			}

	}
}
