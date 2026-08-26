package com.example.employeemanagement.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.employeemanagement.entity.Department;

public class EmployeeRequest {

	@NotBlank(message="Name Is Required")
	private String name;
	
	@NotNull(message = "Salary Is required")
	@Positive(message= "Salary must be greater than 0")
	private Double salary;
	
	@NotNull(message = "Department Id is required")
	private Long departmentId;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	
	
	
}
