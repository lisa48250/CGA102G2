package com.news_post.model;
import java.util.*;

public interface NewsPostDAO_interface {
	
    public void insert(NewsPostVO newspostVO);  
    public void update(NewsPostVO newspostVO);
    
    public void delete(Integer newsPostId);
    
    public NewsPostVO findByPrimaryKey(Integer newsPostId); 
    
    public List<NewsPostVO> getAll();	
    
    public List<NewsPostVO> getstatus(Integer newsStatus);
    
    public List<NewsPostVO> getStatusOne();
    
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
