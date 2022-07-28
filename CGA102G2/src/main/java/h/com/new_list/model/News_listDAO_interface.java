package h.com.new_list.model;

import java.util.List;

public interface News_listDAO_interface {
	
	public void insert(News_listVO news_listVO);

	public void update(News_listVO news_listVO);

	public void delete(Integer news_id);

	public News_listVO findByPrimaryKey(Integer news_id);

	public List<News_listVO> getAll();

}
