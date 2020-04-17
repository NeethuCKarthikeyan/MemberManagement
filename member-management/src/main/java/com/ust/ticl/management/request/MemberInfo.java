package com.ust.ticl.management.request;

import com.ust.ticl.management.request.BaseRequest;

import lombok.Data;

@Data
public class MemberInfo extends BaseRequest {
	
	private String email;
	private String password;
	private String name;
	private Integer mob;

}
