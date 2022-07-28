package h.com.new_list.model;

import java.sql.Date;
import java.util.List;

public class News_listService {
	private News_listDAO_interface dao;

	public News_listService() {
		dao = new News_listJDBCDAO();
	}

	public  News_listVO insertNews( String news_id_title , String news_id_description , Date news_id_date , byte[] news_id_photo) {
		News_listVO nlvo = new News_listVO();
		nlvo.setNews_id_title(news_id_title);
		nlvo.setNews_id_description(news_id_description);
		nlvo.setNews_id_date(news_id_date);
		nlvo.setNews_id_photo(news_id_photo);
		dao.insert(nlvo);
		System.out.println("g");
		return nlvo;
	}

	public   News_listVO  updateNews(String news_id_title , String news_id_description , Date news_id_date , byte[] news_id_photo , Integer news_id) {
		News_listVO nlvo = new News_listVO();
		nlvo.setNews_id_title(news_id_title);
		nlvo.setNews_id_description(news_id_description);
		nlvo.setNews_id_date(news_id_date);
		nlvo.setNews_id_photo(news_id_photo);
		nlvo.setNews_id(news_id);
		dao.update(nlvo);
		return nlvo;
	}

	

	public  void deleteNews(Integer news_id) {
		dao.delete(news_id);
	}

	public News_listVO findByPrimaryKeyNews(Integer news_id) {
		return dao.findByPrimaryKey(news_id);
	}

	public List<News_listVO> getAll() {
		return dao.getAll();
	}
}
