package com.news_post.model;
import java.util.List;

public class NewsPostService {

		private NewsPostDAO_interface dao;

		public NewsPostService() {
//			dao = new NewsPostJDBCDAO();
			dao = new NewsPostDAO();
		}
			//回傳NewsPostVO物件,AI newsPostId不需要
		public NewsPostVO addNewsPost(byte[] newsPhotoFile, String title,
				String summary, String content, Integer newsStatus, java.sql.Date newsPostDate, String postComeFrom) {

			NewsPostVO newspostVO = new NewsPostVO(); //主任把傳送進來的資料集合起來

			
			newspostVO.setNewsPhotoFile(newsPhotoFile);
			newspostVO.setTitle(title);
			newspostVO.setSummary(summary);
			newspostVO.setContent(content);
			newspostVO.setNewsStatus(newsStatus);
			newspostVO.setNewsPostDate(newsPostDate);
			newspostVO.setPostComeFrom(postComeFrom);
			dao.insert(newspostVO);  //成功到資料庫後

			return newspostVO;
		}

		public NewsPostVO updateEmp(Integer newsPostId, byte[] newsPhotoFile, String title,
				String summary, String content, Integer newsStatus, java.sql.Date newsPostDate, String postComeFrom) 
		{

			NewsPostVO newspostVO = new NewsPostVO();
			
			newspostVO.setNewsPostId(newsPostId);
			newspostVO.setNewsPhotoFile(newsPhotoFile);
			newspostVO.setTitle(title);
			newspostVO.setSummary(summary);
			newspostVO.setContent(content);
			newspostVO.setNewsStatus(newsStatus);
			newspostVO.setNewsPostDate(newsPostDate);
			newspostVO.setPostComeFrom(postComeFrom);
			dao.update(newspostVO);

			return newspostVO;
		}

		public void deleteNewsPost(Integer newsPostId) {
			dao.delete(newsPostId);
		}

		public NewsPostVO getOneNewsPost(Integer newsPostId) {
			return dao.findByPrimaryKey(newsPostId);
		}

		public List<NewsPostVO> getAll() {
			return dao.getAll();
		}
		
		public List<NewsPostVO> getStatus(Integer newsStatus) {
			return dao.getstatus(newsStatus);
		}
		
		public List<NewsPostVO> getStatusOne() {
			return dao.getStatusOne();
		}
	}

