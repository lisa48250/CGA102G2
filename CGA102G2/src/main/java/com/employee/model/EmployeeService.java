package com.employee.model;

import java.util.List;

public class EmployeeService {
	
	private EmployeeDAO_interface dao;
	
	public EmployeeService() {
		dao = new EmployeeJDBCDAO();
	}
	
	public EmployeeVO addEmployee (Integer job_id, String emp_name, Integer emp_status, 
			String emp_password, String emp_account) {
		
		EmployeeVO employeeVO = new EmployeeVO();
		
		employeeVO.setJob_id(job_id);
		employeeVO.setEmp_name(emp_name);
		employeeVO.setEmp_status(emp_status);
		employeeVO.setEmp_password(emp_password);
		employeeVO.setEmp_account(emp_account);
		dao.insert(employeeVO);
		
		return employeeVO;
	}

	public EmployeeVO updateEmployee(Integer emp_no, Integer job_id, String emp_name, Integer emp_status,
			 String emp_password, String emp_account) {
		
		EmployeeVO employeeVO = new EmployeeVO();
		
		employeeVO.setEmp_no(emp_no);
		employeeVO.setJob_id(job_id);
		employeeVO.setEmp_name(emp_name);
		employeeVO.setEmp_status(emp_status);
		employeeVO.setEmp_password(emp_password);
		employeeVO.setEmp_account(emp_account);
		
		dao.update(employeeVO);
		
		return employeeVO;
	}
	
	public void deleteEmployee(Integer emp_no) {
		dao.delete(emp_no);
	}
	
	public EmployeeVO getOneEmployee(Integer emp_no) {
		return dao.findByPrimaryKey(emp_no);
	}
	
	public EmployeeVO  getfindByAccountAndPassword(String account, String password) {
		return dao.findByAccountAndPassword(account, password);
	}
	
	public List<EmployeeVO> getAll() {
		return dao.getAll();
	}
}
