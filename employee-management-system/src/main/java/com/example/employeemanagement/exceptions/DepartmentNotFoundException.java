package com.example.employeemanagement.exceptions;

public class DepartmentNotFoundException extends RuntimeException {

	public DepartmentNotFoundException(String msg)
	{
		super(msg);
	}
	
}
