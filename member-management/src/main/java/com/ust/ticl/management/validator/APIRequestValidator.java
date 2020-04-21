package com.ust.ticl.management.validator;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ust.ticl.management.request.MemberInfo;

@Component
public class APIRequestValidator {
	public boolean validateRegiserRequest(MemberInfo memberInfo) {
		if (memberInfo.getEmail() != null && memberInfo.getPassword() != null && memberInfo.getName() != null
				&& memberInfo.getMob() != null)
			return true;
		else
			return false;
	}

	public boolean validateLoginRequest(MemberInfo memberInfo) {
		if (memberInfo.getEmail() != null && memberInfo.getPassword() != null)
			return true;
		else
			return false;

	}
	public boolean validateIdlist(List<Integer> idList) {
		if(idList.size()>0)
			return true;
		else
			return false;

	}
	public boolean validateCity(MemberInfo memberInfo) {
		if(memberInfo.getCity()!=null)
			return true;
		else
			return false;

	}


}
