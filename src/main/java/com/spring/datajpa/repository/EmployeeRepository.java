package com.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.datajpa.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	public Employee findByEname(String name);
	public List<Employee> findBySalaryGreaterThan(double salary);
	public List<Employee> findBySalaryLessThan(double salary);
	
	@Query("select e.ename,e.salary from Employee e where e.eid between ?1 and ?2 order by e.ename")
	public List<Object[]> getDetailsBetweenRange(int l,int r);
	
	    @Modifying
	    @Transactional
	    @Query("UPDATE Employee e SET e.ename = :ename, e.salary = :salary WHERE e.eid = 1")
	    public  int cupdateEmployee(@Param("salary") double salary, @Param("ename") String ename);

	
	@Modifying
    @Transactional
    @Query("INSERT INTO Employee (eid, ename, salary) VALUES (:eid, :ename, :salary)")
    public void insertEmployee(@Param("eid") int eid, @Param("ename") String ename, @Param("salary") double salary);


    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e WHERE e.ename = :ename")
    public void deleteEmployeeByName(@Param("ename") String ename);

	
	
}
