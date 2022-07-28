package com.activity_category.model;

import java.util.*;

import com.activity.model.ActivityVO;


public interface ActivityCategoryDAO_interface {
          public void insert(ActivityCategoryVO ActivityCategoryVO);
          public void update(ActivityCategoryVO ActivityCategoryVO);
          public void delete(Integer activity_category_ID);
          // 查詢單筆
          public ActivityCategoryVO findByPrimaryKey(Integer activity_category_ID);
          // 查詢全部筆數
          public List<ActivityCategoryVO> getAll();
          // 查詢某活動種類的活動(一對多)(回傳 Set)
	      public Set<ActivityVO> getActivitiesByActivity_category_ID(Integer activity_category_ID);
          // 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<ActivityCategoryVO> getAll(Map<String, String[]> map); 
          
}
