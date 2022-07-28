package com.activity.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.activity_photo.model.ActivityPhotoVO;
import com.activity_session.model.ActivitySessionVO;

public interface ActivityDAO_interface {
          public void insert(ActivityVO ActivityVO);
          public void update(ActivityVO ActivityVO);
          public void delete(Integer activity_ID);
          // 查詢單筆
          public ActivityVO findByPrimaryKey(Integer activity_ID);
          // 查詢全部筆數
          public List<ActivityVO> getAll();
          // 查詢某活動的活動場次(一對多)(回傳 Set)
	      public Set<ActivitySessionVO> getActivitySessionsByActivity_ID(Integer activity_ID);
          // 查詢某活動的活動圖片(一對多)(回傳 Set)
	      public Set<ActivityPhotoVO> getActivityPhotosByActivity_ID(Integer activity_ID);
          // 萬用複合查詢(傳入參數型態Map)(回傳 List)
          public List<ActivityVO> getAll(Map<String, String[]> map);
          // 列出為上架狀態之活動
          public List<ActivityVO> getActivitiesWhereStateIsOne();
}
