package com.employee.model;

import java.util.*;

public interface EmployeeDAO_interface {
          public void insert(EmployeeVO employeeVO);
          public void update(EmployeeVO employeeVO);
          public void delete(Integer emp_no);
          public EmployeeVO findByPrimaryKey(Integer emp_no);
          public EmployeeVO findByAccountAndPassword(String account, String password);
          public List<EmployeeVO> getAll();
          //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
