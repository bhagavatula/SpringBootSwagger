package com.emp.dao;

import java.util.List;

import com.emp.entity.Employee;

public interface EmpLookUpDao {
	
//	List<Employee> getAllEmpLastNames(String lastNames) throws Exception;
//	List<Employee> getAllEmpLastNames() throws Exception;
	List<Employee> findallEmp() throws Exception;
	List<Employee> findByid(int empid) throws Exception;

}
