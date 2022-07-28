package com.news_post.model;

import java.sql.Date;

public class NewsPostVO implements java.io.Serializable{
	
	private Integer newsPostId;  //NEWS_POST_ID;
	private byte[] newsPhotoFile; //NEWS_PHOTO_FILE; byte[]
	private String title; //TITLE;
	private String summary; //
	private String content;  //CONTENT;
	private Integer newsStatus;  //NEWS_STATUS; 
	private Date newsPostDate;  //NEWS_POST_DATE;
	private String postComeFrom;  //POST_COME_FROM;
	private String newsPhotoFileStr;
	
	public Integer getNewsPostId() {
		return newsPostId;
	}
	public String getNewsPhotoFileStr() {
		return newsPhotoFileStr;
	}
	public void setNewsPhotoFileStr(String newsPhotoFileStr) {
		this.newsPhotoFileStr = newsPhotoFileStr;
	}
	public void setNewsPostId(Integer newsPostId) {
		this.newsPostId = newsPostId;
	}
	public byte[] getNewsPhotoFile() {
		return newsPhotoFile;
	}
	public void setNewsPhotoFile(byte[] newsPhotoFile) {
		this.newsPhotoFile = newsPhotoFile;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getNewsStatus() {
		return newsStatus;
	}
	public void setNewsStatus(Integer newsStatus) {
		this.newsStatus = newsStatus;
	}
	public Date getNewsPostDate() {
		return newsPostDate;
	}
	public void setNewsPostDate(Date newsPostDate) {
		this.newsPostDate = newsPostDate;
	}
	public String getPostComeFrom() {
		return postComeFrom;
	}
	public void setPostComeFrom(String postComeFrom) {
		this.postComeFrom = postComeFrom;
	}
	
	
}
