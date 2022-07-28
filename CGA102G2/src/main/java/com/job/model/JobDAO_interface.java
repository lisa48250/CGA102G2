package com.job.model;

import java.util.*;

public interface JobDAO_interface {
          public void insert(JobVO VOJob);
          public void update(JobVO VOJob);
          public void delete(Integer job_id);
          public JobVO findByPrimaryKey(Integer job_id);
          public List<JobVO> getAll();
          //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}