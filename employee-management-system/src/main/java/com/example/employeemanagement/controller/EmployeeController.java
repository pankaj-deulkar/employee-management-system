package com.example.employeemanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
  private final EmployeeService employeeService;
  
  public EmployeeController(EmployeeService employeeService) {
	
	this.employeeService = employeeService;
  }
  
  @PostMapping
  public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest
		  request)
  {
	    EmployeeResponse response= employeeService.createEmployee(request);
	  return ResponseEntity.status(HttpStatus.CREATED)
			               .body(response);
  }
  
  @GetMapping
  public List<Employee> getEmployees()
  {
    return employeeService.getEmployees();
  }
  
  @GetMapping("/{id}")
  public Optional<Employee> getEmployee(@PathVariable int id)
  {
	  return employeeService.getEmployee(id);
  }
  
  @GetMapping("/search")
  public List<Employee> searchEmployees(@RequestParam String name)
  {
	  return employeeService.searchEmployees(name);
  }
  
  @PutMapping("/{id}")
  public Employee updateEmployee(@RequestBody EmployeeRequest request, 
		                        @PathVariable int id)
  {
    return employeeService.updateEmployee(request, id);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable int id)
  {
	  employeeService.deleteEmployee(id);
	  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
  

}
