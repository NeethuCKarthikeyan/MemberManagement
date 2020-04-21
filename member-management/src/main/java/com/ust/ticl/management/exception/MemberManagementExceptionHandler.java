package com.ust.ticl.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ust.ticl.management.response.ErrorResponse;

@ControllerAdvice
public class MemberManagementExceptionHandler {
	
	@ExceptionHandler(MemberManangementBusinessException.class)
	public ResponseEntity<ErrorResponse> handleRequestFailures(MemberManangementBusinessException ex){
		ErrorResponse error = new ErrorResponse("Bad Request", ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmptyData(DataNotFoundException ex){
		ErrorResponse error = new ErrorResponse("No data Found", ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);	
	}
	
	

}
