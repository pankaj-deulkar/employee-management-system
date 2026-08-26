package com.example.employeemanagement.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex)
	{
		ErrorResponse error=new ErrorResponse();
		error.setStatus(404);
		error.setMessage(ex.getMessage());
		error.setTimeStamp(LocalDateTime.now().toString());
		
       return ResponseEntity.status(HttpStatus.NOT_FOUND)
    		                .body(error);
	}
	
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDepartmentNotFoundException(DepartmentNotFoundException ex)
	{
		ErrorResponse error=new ErrorResponse();
		error.setStatus(404);
		error.setMessage(ex.getMessage());
		error.setTimeStamp(LocalDateTime.now().toString());
		
       return ResponseEntity.status(HttpStatus.NOT_FOUND)
    		                .body(error);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex)
	{
		ErrorResponse error=new ErrorResponse();
		error.setStatus(500);
		error.setMessage("Internal Server Error");
		error.setTimeStamp(LocalDateTime.now().toString());
		
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    		                .body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex)
	{
		ErrorResponse error=new ErrorResponse();
		error.setStatus(400);
		error.setMessage("Validation Failed");
		error.setTimeStamp(LocalDateTime.now().toString());
		
       return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    		                .body(error);
		
	}
	
	
}
