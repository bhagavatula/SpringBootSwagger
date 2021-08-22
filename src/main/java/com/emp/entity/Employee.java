package com.emp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Employee",schema = "public")
//@NamedQuery(name="Employee.findall" , query = "SELECT emp_id from Employee")
public class Employee implements Serializable {
	private static final long serivalVersionUID = 1L;
	
	public Employee(){}
	
	@Id
	@Column(name="emp_id")
	private Integer empId;
	
	@Column(name ="emp_firstname")
	private String empfirstNme;
	
	@Column(name ="emp_lasttname")
	private String emplastname;
	
	@Column(name="emp_dob")
	private Date empdob;
	
	public Integer getempId() {return this.empId;}
	
	public void setempdid(Integer empId) {this.empId = empId;}
	
	public String getempfirstname() {return this.empfirstNme;}
	
	public void setempfirstname(String empfirstNme) {this.empfirstNme=empfirstNme;}
	
	public String getlastname() {return this.emplastname;}
	
	public void setemplastname (String emplastname) {this.emplastname =emplastname;}
	
	public Date getempdob() {return this.empdob;}
	
	public void setempdob(Date empdob) {this.empdob= empdob;}
	

}
