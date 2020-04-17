package com.ust.ticl.management.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseResponse implements Serializable {
	
	private String appName="Member Management Applicatiom";
	private String version="Version 1.0";
}
