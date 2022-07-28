package com.activity_photo.model;

import java.util.*;

public interface ActivityPhotoDAO_interface {
          public void insert(ActivityPhotoVO ActivityPhotoVO);
          public void update(ActivityPhotoVO ActivityPhotoVO);
          public void delete(Integer activity_photo_ID);
          // 查詢單筆
          public ActivityPhotoVO findByPrimaryKey(Integer activity_photo_ID);
          // 查詢全部筆數
          public List<ActivityPhotoVO> getAll();
          // 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<ActivityPhotoVO> getAll(Map<String, String[]> map); 
}
