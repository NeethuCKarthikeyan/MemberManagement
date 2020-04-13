package com.ust.ticl.management.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseDto {
	private String status;
	private String message;
	

}
