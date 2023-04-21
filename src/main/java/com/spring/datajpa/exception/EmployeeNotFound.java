package com.spring.datajpa.exception;

public class EmployeeNotFound extends Exception{


	@Override
	public String getMessage() {
		return "Employee not Found";
	}
}
