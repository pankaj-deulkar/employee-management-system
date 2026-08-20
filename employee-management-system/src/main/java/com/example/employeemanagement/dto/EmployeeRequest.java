package com.example.employeemanagement.dto;

import com.example.employeemanagement.entity.Department;

public class EmployeeRequest {

	
	private String name;
	private double salary;
	private Long departmentId;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	
	
	
}
