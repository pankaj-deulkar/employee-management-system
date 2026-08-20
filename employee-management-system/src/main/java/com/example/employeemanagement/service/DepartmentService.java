package com.example.employeemanagement.service;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.dto.DepartmentRequest;
import com.example.employeemanagement.dto.DepartmentResponse;
import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private final DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		
		this.departmentRepository = departmentRepository;
	}
	
	
	public DepartmentResponse createDepartment(DepartmentRequest request)
	{
		Department department=new Department();
		department.setName(request.getName());
		department.setLocation(request.getLocation());
		departmentRepository.save(department);
		
		DepartmentResponse response=new DepartmentResponse();
		response.setId(department.getId());
		response.setName(department.getName());
		response.setLocation(department.getLocation());
		return response;
	}
	
}
