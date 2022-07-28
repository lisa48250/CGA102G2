package com.authority_function.model;

import java.util.*;


public interface Authority_FunctionDAO_interface {
	
    public void insert(Authority_FunctionVO vOFunction);
    public void update(Authority_FunctionVO vOFunction);
    public void delete(Integer function_id);
    public Authority_FunctionVO findByPrimaryKey(Integer function_id);
    public List<Authority_FunctionVO> getAll();
    //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}


