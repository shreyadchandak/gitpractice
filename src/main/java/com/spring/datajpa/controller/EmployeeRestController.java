package com.spring.datajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.datajpa.entity.Employee;
import com.spring.datajpa.exception.EmployeeNotFound;
import com.spring.datajpa.service.IEmployeeservice;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeRestController {

	@Autowired
	IEmployeeservice service;
	
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		
		return service.addEmployee(emp);
	}
	
	@GetMapping("/getbyid/{id}")
	public Employee getById(@PathVariable int eid) throws EmployeeNotFound {
		return service.getById(eid);
	}
	
	@PutMapping("/update")
	public Employee update(@RequestBody Employee emp) {
		return service.update(emp);
	}
	
	@GetMapping("/getall")
	public List<Employee> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getbyname/{ename}")
	public Employee getByName(@PathVariable String ename) throws EmployeeNotFound {
		return service.getByEname(ename);
	}
	
	@DeleteMapping("/delete/{eid}")
	public void deleteById(@PathVariable int eid) throws EmployeeNotFound {
		 service.deletebyId(eid);
	}
	
	@GetMapping("/gtsalary/{salary}")
	public List<Employee> greaterThanSalary(@PathVariable double salary){
		return service.findBySalaryGreaterThan(salary); 
	}
	@GetMapping("/ltsalary/{salary}")
	public List<Employee> lessThanSalary(@PathVariable double salary){
		return service.findBySalaryLessThan(salary); 
	}

	@GetMapping("/ascsalary")
	public List<Employee> ascSalary(){
		return service.getAllAscSalary();
	}
	@GetMapping("/descsalary")
	public List<Employee> descSalary(){
		return service.getAllDescSalary();
	}
	
	@GetMapping("range/{l}/{r}")
	public List<Object[]> getInRange(@PathVariable int l, @PathVariable int r){
		return service.getDetailsBetweenRange(l, r);
	}
	@PutMapping("/cupdate/{ename}/{salary}")
	public int cupdateEmployee( @PathVariable double salary, @PathVariable String ename) {
		// TODO Auto-generated method stub
		return service.cupdateEmployee( salary, ename);
	}
	

	@PostMapping("/insert/{eid}/{ename}/{salary}")
	public void insertEmployee(@PathVariable int eid, @PathVariable String ename, @PathVariable double salary) {
		// TODO Auto-generated method stub
		 service.insertEmployee(eid, ename, salary);
	}

	@DeleteMapping("/deletebyname/{ename}")
	public void deleteEmployeeByName(@PathVariable String ename) {
		// TODO Auto-generated method stub
		service.deleteEmployeeByName(ename);
	}
}
