package com.authority_function.model;
import java.util.List;

public class Authority_FunctionService {

	private Authority_FunctionDAO_interface dao;
	
	public Authority_FunctionService() {
		dao = new Authority_FunctionJDBCDAO();
	}
	
	public Authority_FunctionVO addAuthority_Function(Integer function_id, String function_name) {
		Authority_FunctionVO authority_FunctionVO = new Authority_FunctionVO();
	
		authority_FunctionVO.setFunction_id(function_id);
		authority_FunctionVO.setFunction_name(function_name);
			
		dao.insert(authority_FunctionVO);
		
		return authority_FunctionVO;
	}
	
	public Authority_FunctionVO updateAuthority_Function(Integer function_id, String function_name) {
		
		Authority_FunctionVO authority_FunctionVO = new Authority_FunctionVO();
		
		authority_FunctionVO.setFunction_id(function_id);
		authority_FunctionVO.setFunction_name(function_name);
		
		dao.update(authority_FunctionVO);
		
		return authority_FunctionVO;
	}
	
	public void deleteAuthority_FunctionVO(Integer function_id) {
		dao.delete(function_id);
	}
	
	public Authority_FunctionVO getOneAuthority_Function(Integer function_id) {
		return dao.findByPrimaryKey(function_id);
	}
	
	public List<Authority_FunctionVO> getAll(){
		return dao.getAll();
	}
}
