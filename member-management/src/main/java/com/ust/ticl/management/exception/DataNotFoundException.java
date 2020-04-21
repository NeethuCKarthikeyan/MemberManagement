package com.ust.ticl.management.exception;

import org.springframework.stereotype.Component;

@Component
public class DataNotFoundException extends Exception{
	
	public DataNotFoundException() {
	}
	public DataNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);

	}

}
