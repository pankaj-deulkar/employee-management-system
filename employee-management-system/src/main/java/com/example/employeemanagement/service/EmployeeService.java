package com.example.employeemanagement.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.DepartmentRepository;
import com.example.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
    
    public EmployeeService(EmployeeRepository employeeRepository,
    		DepartmentRepository departmentRepository)
    {
		this.employeeRepository=employeeRepository;
		this.departmentRepository =departmentRepository ;
    }
	
	public EmployeeResponse createEmployee(EmployeeRequest request)
	{
		 Department department= departmentRepository.findById(request.getDepartmentId())
		                     .orElseThrow(()->new RuntimeException("Department Not Found"));
		
	     Employee e=new Employee();
	     e.setName(request.getName());
	     e.setSalary(request.getSalary());
	     e.setDepartment(department);
	     
	     Employee e1=employeeRepository.save(e);
	     
	     EmployeeResponse response=new EmployeeResponse();
	     response.setId(e1.getId());
	     response.setName(e1.getName());
	     response.setSalary(e1.getSalary());
	     response.setDepartmentId(e1.getDepartment().getId());
	     response.setDepartmentName(e1.getDepartment().getName());
	     response.setLocation(e1.getDepartment().getLocation());
	     return response;
			
	}
	
	public List<EmployeeResponse> getEmployees()
	{  
		 List<Employee> employees= employeeRepository.findAll();
		 
		 
		 
		 return employees.stream()
				         .map(e-> {
				                     EmployeeResponse response=new EmployeeResponse();
				                     response.setId(e.getId());
			                         response.setName(e.getName());
			                         response.setSalary(e.getSalary());
			                         response.setDepartmentId(e.getDepartment().getId());
			                         response.setDepartmentName(e.getDepartment().getName());
			                         response.setLocation(e.getDepartment().getLocation());
			                         return response;
			                         })
		                 .collect(Collectors.toList());
	}
	
	
	public EmployeeResponse getEmployee(Long id)
	{
		Employee employee= employeeRepository.findById(id)
				                 .orElseThrow(()->new RuntimeException("Employee Not Found"));
		
		EmployeeResponse response=new EmployeeResponse();
		response.setId(employee.getId());
		response.setName(employee.getName());
		response.setSalary(employee.getSalary());
		response.setDepartmentId(employee.getDepartment().getId());
		response.setDepartmentName(employee.getDepartment().getName());
		response.setLocation(employee.getDepartment().getLocation());
		return response;
	
	}
	
	public void delete(Long id)
	{
		employeeRepository.findById(id)
				          .orElseThrow(()->new RuntimeException("Employee Not Found"));
		employeeRepository.deleteById(id);
	}
	
	
	public EmployeeResponse update(Long id, EmployeeRequest request)
	{
	     Employee emp= employeeRepository.findById(id)
	     .orElseThrow(()-> new RuntimeException("Employee Not FOund"));	
	     
	     Department department= departmentRepository.findById(request.getDepartmentId())
	    		                .orElseThrow(()->new RuntimeException("Department Not Found"));
	     
	     emp.setName(request.getName());
	     emp.setSalary(request.getSalary());
	     emp.setDepartment(department);
	     employeeRepository.save(emp);
	     
	     EmployeeResponse response=new EmployeeResponse();
	     response.setId(emp.getId());
	     response.setName(emp.getName());
	     response.setSalary(emp.getSalary());
	     response.setDepartmentId(emp.getDepartment().getId());
	     response.setDepartmentName(emp.getDepartment().getName());
	     response.setLocation(emp.getDepartment().getLocation());
	     return response;
	     
	
	}
	
	
	public List<Employee> getByName(String name)
	{
		return employeeRepository.findByName(name);
	}
	
	public List<Employee> getEmployeesByHighSalary(double salary)
	{
		return employeeRepository.findBySalaryGreaterThan(salary);
	}
	
	public List<Employee> getEmployeesWithLessSalary(double salary)
	{
		return employeeRepository.findBySalaryLessThan(salary);
	}
	
	public List<Employee> getEmployeesInSalaryRange(double min,double max)
	{
		return employeeRepository.findBySalaryBetween(min, max);
	}
	
	public List<Employee> getEmployeesWithNameContaining(String name)
	{
		return employeeRepository.findByNameContaining(name);
	}
	
	public List<Employee> getEmployeesByNameStartingWith(String name)
	{
		return employeeRepository.findByNameStartingWith(name);
	}
	
	public List<Employee> getEmployeesByDepartmentName(String name)
	{
		return employeeRepository.findByDepartment_Name(name);
	}
	
	public List<Employee> getEmployeesByDeptIdSortBySalary(long id)
	{
		return employeeRepository.findByDepartment_IdOrderBySalaryDesc(id);
	}
	
	public List<Employee> getEmployeesWithSalaryGreaterThan(double salary)
	{
		return employeeRepository.findEmployeesWithSalaryGreaterThan(salary);
	}
	
	public List<Employee> getEmployeesInDepartment(String name)
	{
		return employeeRepository.findEmployeesInDepartment(name);
	}
	
	public List<Employee> getHighestEarners(long id, double salary)
	{
		return employeeRepository.findEmployeesByDepartmentAndMinimumSalary(id, salary);
	}
}
