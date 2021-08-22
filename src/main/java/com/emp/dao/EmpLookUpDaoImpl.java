package com.emp.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Employee;
import com.emp.repository.EmployeeLkupRepository;

//@Component
 @Service
public class EmpLookUpDaoImpl implements EmpLookUpDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmpLookUpDaoImpl.class);

	@Autowired
	private EmployeeLkupRepository empRepo;

//	@Override
////	@Cacheable(cacheNames = "emp_lasttname")
//	public List<Employee> getAllEmpLastNames() throws Exception {
//		return null;
//		
//	}
//
//	@Override
//	public List<Employee> getAllEmpLastNames(String lastNames) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Employee> findallEmp() throws Exception {
		List<Employee> empDetails = null;
		try {
			empDetails = empRepo.findallEmp();
				if (empDetails.isEmpty()) {
					LOGGER.error("received  error null empid's");
				} 
				for (Employee emp:empRepo.findallEmp()) {
					LOGGER.info(emp.toString());
				}
				LOGGER.info("");
		} catch (Exception e) {
			LOGGER.error("received  error null empid's");
			e.printStackTrace();
		}
		return empDetails;
	}

	@Override
	public List<Employee> findByid(int empid) throws Exception {
		List<Employee> empDetails = null;
		try {
			empDetails = empRepo.findByid(empid);
				if (empDetails.isEmpty()) {
					LOGGER.error("received  error null empid's");
				} 
				for (Employee emp:empRepo.findByid(empid)) {
					LOGGER.info(emp.toString());
				}
				LOGGER.info("");
		} catch (Exception e) {
			LOGGER.error("received  error null empid's");
			e.printStackTrace();
		}
		return empDetails;
	}
}
