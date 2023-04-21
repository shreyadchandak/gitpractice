package com.spring.datajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.datajpa.entity.Employee;
import com.spring.datajpa.exception.EmployeeNotFound;
import com.spring.datajpa.repository.EmployeeRepository;



@Service
public class EmployeeServiceImp implements IEmployeeservice {

	@Autowired
	EmployeeRepository repo;
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repo.save(employee);
	}

	@Override
	public Employee getById(int eid) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		Employee emp=repo.findById(eid).orElse(null);
		if(emp==null) {
			throw new EmployeeNotFound();
		}
		return emp;
	}

	@Override
	public Employee update(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee getByEname(String name) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		Employee emp= repo.findByEname(name);
		if(emp==null) {
			throw new EmployeeNotFound();
		}
		return emp;
	}

	@Override
	public void deletebyId(int id) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		if(!repo.existsById(id)) {
			throw new EmployeeNotFound();
		}
		repo.deleteById(id);
	}

	@Override
	public List<Employee> getAllDescSalary() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by(Sort.Direction.DESC,"salary"));
	}

	@Override
	public List<Employee> getAllAscSalary() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by("salary"));
	}

	@Override
	public List<Object[]> getDetailsBetweenRange(int l, int r) {
		// TODO Auto-generated method stub
		return repo.getDetailsBetweenRange(l, r);
	}

	@Override
	public List<Employee> findBySalaryGreaterThan(double salary) {
		// TODO Auto-generated method stub
		return repo.findBySalaryGreaterThan(salary);
	}

	@Override
	public List<Employee> findBySalaryLessThan(double salary) {
		// TODO Auto-generated method stub
		return repo.findBySalaryLessThan(salary);
	}

	

	@Override
	@Transactional
	public void insertEmployee(int eid, String ename, double salary) {
		// TODO Auto-generated method stub
		 repo.insertEmployee(eid, ename, salary);
	}

	@Override
	@Transactional
	public void deleteEmployeeByName(String ename) {
		// TODO Auto-generated method stub
		repo.deleteEmployeeByName(ename);
	}

	@Override
	@Transactional
	public int cupdateEmployee(double salary, String ename) {
		// TODO Auto-generated method stub
		return repo.cupdateEmployee(salary, ename);
	}
	
	

}
