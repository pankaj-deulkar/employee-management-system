package com.example.employeemanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.dto.DepartmentRequest;
import com.example.employeemanagement.dto.DepartmentResponse;
import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		
		this.departmentService = departmentService;
	}
	
	
	@PostMapping
	public DepartmentResponse createDepartment(@RequestBody DepartmentRequest request)
	{
		return departmentService.createDepartment(request);
	}
	
	
	
}
