package com.emp.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.emp.dao.EmpLookUpDaoImpl;
import com.emp.entity.Employee;

@RestController
public class empcontroller {
	
//	@Autowired
//	private EmployeeLkupRepository	emprepo;
	@Autowired
	private EmpLookUpDaoImpl empservice;

	@GetMapping(value = "/AllEmpDetails")
	public List<Employee> getAllEmpDetails() throws Exception{
		return empservice.findallEmp();
		
	}
	
	@GetMapping(value = "/employee/{empid}")
	public List<Employee> getbyId(@PathVariable int empid) throws Exception{
		return empservice.findByid(empid);
		
	}
	 
}
