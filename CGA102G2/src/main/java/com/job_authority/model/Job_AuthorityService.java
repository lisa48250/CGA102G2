package com.job_authority.model;

import java.util.List;

public class Job_AuthorityService {
	
	private Job_AuthorityDAO_interface dao;
	
	public Job_AuthorityService() {
		dao = new Job_AuthorityJDBCDAO();
	}
	
	public Job_AuthorityVO addJob_Authority(Integer job_id, Integer function_id) {
		
		Job_AuthorityVO job_authorityVO = new Job_AuthorityVO();

		job_authorityVO.setJob_id(job_id);
		job_authorityVO.setFunction_id(function_id);
		
		dao.insert(job_authorityVO);

		return job_authorityVO;
	}
	
//	public Job_AuthorityVO updateJob_AuthorityVO(Integer job_id, Integer Function_id) {
//		
//		Job_AuthorityVO job_Authority = new Job_AuthorityVO();
//		
//		job_AuthorityVO.setJob_id(job_id);
//		job_AuthorityVO.setFunction_id(function_id);
//		dao.update(job_AuthorityVO);
//		
//		return job_AuthorityVO;
//	}

	public void deleteJob_Authority(Integer job_id) {
		dao.delete(job_id);
	}
	
	public Job_AuthorityVO getOneJob_Authority(Integer job_id) {
		return dao.findByPrimaryKey(job_id);
	}
	
	public List<Job_AuthorityVO> getAll(){
		return dao.getAll();
	}
}
