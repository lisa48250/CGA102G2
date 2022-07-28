package h.com.new_list.model;



import java.sql.Date;


public class News_listVO implements java.io.Serializable{

	private Integer news_id;
	private String news_id_title;
	private String news_id_description;
	private Date news_id_date;
	private byte[] news_id_photo; 
	public Integer getNews_id() {
		return news_id;
	}
	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}
	public String getNews_id_title() {
		return news_id_title;
	}
	public void setNews_id_title(String news_id_title) {
		this.news_id_title = news_id_title;
	}
	public String getNews_id_description() {
		return news_id_description;
	}
	public void setNews_id_description(String news_id_description) {
		this.news_id_description = news_id_description;
	}
	public Date getNews_id_date() {
		return news_id_date;
	}
	public void setNews_id_date(Date news_id_date) {
		this.news_id_date = news_id_date;
	}
	public byte[]  getNews_id_photo() {
		return news_id_photo;
	}
	public void setNews_id_photo(byte[] news_id_photo) {
		this.news_id_photo = news_id_photo ;
	}
	
	}
	

