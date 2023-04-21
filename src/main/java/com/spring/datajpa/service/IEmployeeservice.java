package com.spring.datajpa.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.spring.datajpa.entity.Employee;
import com.spring.datajpa.exception.EmployeeNotFound;

public interface IEmployeeservice {

	public Employee addEmployee(Employee employee);
	
	public Employee getById(int eid) throws EmployeeNotFound;
	public Employee update(Employee emp);
	public List<Employee> getAll();
	public Employee getByEname(String name) throws EmployeeNotFound;
	public void deletebyId(int id) throws EmployeeNotFound;
	public List<Employee> getAllDescSalary();
	public List<Employee> getAllAscSalary();
	public List<Object[]> getDetailsBetweenRange(int l,int r);
	public List<Employee> findBySalaryGreaterThan(double salary);
	public List<Employee> findBySalaryLessThan(double salary);
	public int cupdateEmployee( double salary,String ename);
	public void insertEmployee(int eid, String ename, double salary);
	public void deleteEmployeeByName(String ename);
	
}
