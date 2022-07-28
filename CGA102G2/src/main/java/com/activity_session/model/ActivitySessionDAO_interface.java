package com.activity_session.model;

import java.util.*;

import com.activity.model.ActivityVO;

public interface ActivitySessionDAO_interface {
          public void insert(ActivitySessionVO ActivitySessionVO);
          public void update(ActivitySessionVO ActivitySessionVO);
          public void delete(Integer activity_session_ID);
          // 查詢單筆
          public ActivitySessionVO findByPrimaryKey(Integer activity_session_ID);
          // 查詢全部筆數
          public List<ActivitySessionVO> getAll();
          // 萬用複合查詢(傳入參數型態Map)(回傳 List)
          public List<ActivitySessionVO> getAll(Map<String, String[]> map);
          // 列出為上架狀態之活動場次
          public List<ActivitySessionVO> getActivitySessionsWhereStateIsOne();
}
