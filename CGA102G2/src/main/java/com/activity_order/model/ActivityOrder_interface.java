package com.activity_order.model;

import java.util.List;


public interface ActivityOrder_interface {

	
    public void insert(ActivityOrderVO activityoderVO);  
    public void update(ActivityOrderVO activityoderVO);	
    
//    public void delete(Integer activityoderId);	
    
    public ActivityOrderVO findByPrimaryKey(Integer newsPostId);  
    
    public List<ActivityOrderVO> getAll();		
    
//    public List<ActivityOrderVO> getJoin();

}
