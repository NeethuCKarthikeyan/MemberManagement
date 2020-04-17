package com.ust.ticl.management.request;

import java.io.Serializable;

import lombok.Data;
@Data
public class BaseRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String appName="Member Management Applicatiom";
	private String version="Version 1.0";

}
