package com.example.employeemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.entity.Employee;

@Service
public class EmployeeService {

    List<Employee> employees=new ArrayList<>();
	
    
    public EmployeeService()
    {

		Employee e1=new Employee();
		e1.setId(1);
		e1.setName("Pankaj");
		e1.setSalary(5000);
		
		Employee e2=new Employee();
		e2.setId(2);
		e2.setName("Ankita");
		e2.setSalary(6000);
		
		employees.add(e1);
		employees.add(e2);
    }
	
	public EmployeeResponse createEmployee(EmployeeRequest request)
	{
	   
		Employee e=new Employee();
		e.setId(request.getId());
		e.setName(request.getName());
		e.setSalary(request.getSalary());
		
		
			employees.add(e);
			EmployeeResponse response=new EmployeeResponse();
			response.setId(e.getId());
			response.setName(e.getName());
			response.setSalary(e.getSalary());
			return response;
			
	}
	
	public List<Employee> getEmployees()
	{  
		return employees;
	}
	
	
	public Optional<Employee> getEmployee(int id)
	{
		return employees.stream()
		         .filter(e->e.getId()==id)
		         .findFirst();
	
	}
	
	public List<Employee> searchEmployees(String name)
	{
		return employees.stream()
		         .filter(e->e.getName().equals(name))
		         .collect(Collectors.toList());
		
	 }
	
	public Employee updateEmployee(EmployeeRequest request, int id)
	{
		Optional<Employee> existingEmployee= employees.stream()
		                                     .filter(e->e.getId()==id)
		                                     .findFirst();
		
		if(existingEmployee.isPresent())
		{
			Employee employee=existingEmployee.get();
			employee.setName(request.getName());
			employee.setSalary(request.getSalary());
			return employee;
		}
		else
		{
			throw new RuntimeException("Employee not Found With Id :"+id);
		}
		                                     
	}
	
	public void deleteEmployee(int id)
	{
		boolean removed= employees.removeIf(emp->emp.getId()==id);
		
		if(!removed)
		{
			throw new RuntimeException("Employee not Found With Id :" + id);
		}
		
	   
		         
	}
	
}
