package com.job_authority.model;

import java.util.List;

//import com.emp.model.EmpVO;

public interface Job_AuthorityDAO_interface {
    public void insert(Job_AuthorityVO vOJob_Authority);
    public void update(Job_AuthorityVO vOJob_Authority);
    public void delete(Integer job_id);
    public Job_AuthorityVO findByPrimaryKey(Integer job_id);
    public List<Job_AuthorityVO> getAll();
    
}

