package com.example.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	public List<Employee> findByName(String name);
	
	public List<Employee> findBySalaryGreaterThan(double salary);
	
	public List<Employee> findBySalaryLessThan(double salary);
	
	public List<Employee> findBySalaryBetween(double minSalary, double maxSalary);
	
	public List<Employee> findByNameContaining(String name);
	
	public List<Employee> findByNameStartingWith(String name);
	
	public List<Employee> findByDepartment_Name(String name);
	
	public List<Employee> findByDepartment_IdOrderBySalaryDesc(long id);
	
	//Find employees whose salary is greater than a given amount.
	@Query("select e from Employee e where e.salary > :salary")
	public List<Employee> findEmployeesWithSalaryGreaterThan(@Param ("salary") double salary);

   //Find employees belonging to a particular department.
	@Query("select e from Employee e where e.department.name = :name")
	public List<Employee> findEmployeesInDepartment(@Param("name") String name);
	
	//Find employees from a department whose salary is greater than a given amount.
	@Query("select e from Employee e where e.department.id= :id and e.salary> :salary")
	public List<Employee> findEmployeesByDepartmentAndMinimumSalary(@Param("id") long id,@Param("salary") double salary);
}
