package com.activity_join.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.activity_session.model.ActivitySessionVO;


public interface ActivityJoin_interface { 
    
    public ActivityJoinVO findByPrimaryKey(Integer activityOrderId);  
//=========================================== Fei =========================================
    public List<ActivityJoinVO> getAll();
    
    public void updateActivityOrder(ActivityJoinVO ActivityJoinVO);
    
    public List<ActivityJoinVO> getAll(Map<String, String[]> map);
//=========================================== 結束 =========================================  
    public List<ActivityJoinVO> getJoin(Map<String, String[]> map);
    
    public List<ActivityJoinVO> getactStateZero(Integer member_id); //查詢訂單狀態0
    public List<ActivityJoinVO> getactStateOne(Integer member_id); //查詢訂單狀態1
    public List<ActivityJoinVO> getactStateTwo(Integer member_id); //查詢訂單狀態2
    
    public void update(Integer activityOrderId);
    
    public void insert(ActivityJoinVO activityJoinVO);
    
    public Map<String, Object> findPriceById(Integer activityId);
    
    public Map<String, Object> findDateTimeByIdAndDate(Integer activityId, Timestamp date);
    
    public ActivityJoinVO findOrderById(Integer activityOrderId);
    
}
