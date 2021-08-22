package com.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emp.entity.Employee;


@Repository
public interface EmployeeLkupRepository extends JpaRepository<Employee, String>{	
	 
	@Query(value="SELECT * FROM public.\"Employee\"",nativeQuery = true)
	List<Employee> findallEmp();
	
	@Query(value="SELECT * FROM public.\"Employee\" where emp_id=:empid",nativeQuery = true)
	List<Employee> findByid(int empid);


}
