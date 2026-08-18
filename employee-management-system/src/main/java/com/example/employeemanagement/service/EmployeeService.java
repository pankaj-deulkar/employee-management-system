package com.example.employeemanagement.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
	
    
    public EmployeeService(EmployeeRepository employeeRepository)
    {
		this.employeeRepository=employeeRepository;
    }
	
	public EmployeeResponse createEmployee(EmployeeRequest request)
	{
	     Employee e=new Employee();
	     e.setName(request.getName());
	     e.setSalary(request.getSalary());
	     Employee e1=employeeRepository.save(e);
	     
	     EmployeeResponse response=new EmployeeResponse();
	     response.setId(e1.getId());
	     response.setName(e1.getName());
	     response.setSalary(e1.getSalary());
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
		return response;
	
	}
	
	public void delete(Long id)
	{
		employeeRepository.deleteById(id);
	}
	
	
	public EmployeeResponse update(Long id, EmployeeRequest request)
	{
	    Employee emp= employeeRepository.findById(id)
	     .orElseThrow(()-> new RuntimeException("Employee Not FOund"));	
	     
	     emp.setName(request.getName());
	     emp.setSalary(request.getSalary());
	     employeeRepository.save(emp);
	     
	     EmployeeResponse response=new EmployeeResponse();
	     response.setId(emp.getId());
	     response.setName(emp.getName());
	     response.setSalary(emp.getSalary());
	     return response;
	     
	
	}
	
}
