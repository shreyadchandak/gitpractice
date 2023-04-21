package com.spring.datajpa.handlingexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.datajpa.exception.EmployeeNotFound;

@RestControllerAdvice
public class HandlingException {

	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<String> handleExp(EmployeeNotFound emp){
		return new ResponseEntity<String>(emp.getMessage(),HttpStatus.BAD_REQUEST);
}
}
