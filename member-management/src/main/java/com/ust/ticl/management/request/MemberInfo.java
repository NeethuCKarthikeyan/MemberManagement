package com.ust.ticl.management.request;

import java.util.List;

import com.ust.ticl.management.request.BaseRequest;

import lombok.Data;

@Data
public class MemberInfo extends BaseRequest {
	private String email;
	private String password;
	private String name;
	private Integer mob;
	private List<String> trustList;
	private String gender;
	private String address;
	private String city;
	private String state;
	private String country;
	private Integer pin; 
	

}
