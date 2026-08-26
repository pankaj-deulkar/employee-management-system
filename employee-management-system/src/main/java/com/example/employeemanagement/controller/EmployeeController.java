package com.example.employeemanagement.controller;

import java.util.List;

import javax.validation.Valid;

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
  public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeRequest
		  request)
  {
	  EmployeeResponse response= employeeService.createEmployee(request);
	  return ResponseEntity.status(HttpStatus.CREATED)
			               .body(response);
  }
  
  @GetMapping
  public List<EmployeeResponse> getEmployees()
  {
    return employeeService.getEmployees();
  }
  
  @GetMapping("/{id}")
  public EmployeeResponse getEmployee(@PathVariable Long id)
  {
	  return employeeService.getEmployee(id);
  }
  
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id)
  {
	  employeeService.delete(id);
	 
  }
  
  @PutMapping("/{id}")
  public EmployeeResponse update(@PathVariable Long id, @Valid @RequestBody EmployeeRequest request)
  {
	 return employeeService.update(id, request); 
  }
  
  @GetMapping("/name/{name}")
  public List<Employee> getByName(@PathVariable String name)
  {
	  return employeeService.getByName(name);
  }
  
  @GetMapping("/salary/greater/{salary}")
  public List<Employee> getEmployeesByHighSalary(@PathVariable double salary)
  {
      return employeeService.getEmployeesByHighSalary(salary);
  }
  
  @GetMapping("/salary/less/{salary}")
  public List<Employee> getEmployeesWithLessSalary(@PathVariable double salary)
  {
	  return employeeService.getEmployeesWithLessSalary(salary);
  }
  
  @GetMapping("salary/range")
  public List<Employee> getEmployeesInSalaryRange(@RequestParam double min,@RequestParam double max)
  {
	return  employeeService.getEmployeesInSalaryRange(min, max);
  }
  
  @GetMapping("/search")
  public List<Employee> getEmployeesWithNameContaining(@RequestParam String name)
  {
	  return employeeService.getEmployeesWithNameContaining(name);
  }
  
  @GetMapping("/name/startwith")
  public List<Employee> getEmployeesByNameStartingWith(@RequestParam String name)
  {
	  return employeeService.getEmployeesByNameStartingWith(name);
  }
  
  @GetMapping("/department/{name}")
  public List<Employee> getEmployeesByDepartmentName(@PathVariable String name)
  {
	  return employeeService.getEmployeesByDepartmentName(name);
  }
  
  @GetMapping("/departmentId/{id}")
  public List<Employee> getEmployeesByDeptIdSortBySalary(@PathVariable long id)
  {
	  return employeeService.getEmployeesByDeptIdSortBySalary(id);
  }
  
  @GetMapping("/salary/greaterthan/{salary}")
  public List<Employee> getEmployeesWithSalaryGreaterThan(@PathVariable double salary)
  {
	  return employeeService.getEmployeesWithSalaryGreaterThan(salary);
  }
  
  @GetMapping("/dept/{name}")
  public List<Employee> getEmployeesInDepartment(@PathVariable String name)
  {
	  return employeeService.getEmployeesInDepartment(name);
  }
  
  @GetMapping("/department/{deptId}/highest-earners")
  public List<Employee> getHighestEarners(@PathVariable("deptId") long id,
		                            @RequestParam double salary)
  {
	  return employeeService.getHighestEarners(id, salary);
  }
}
