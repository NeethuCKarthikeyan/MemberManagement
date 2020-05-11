package com.ust.ticl.management.service;

import java.util.List;

import javax.validation.Valid;

import com.ust.ticl.management.request.MemberInfo;
import com.ust.ticl.management.response.MemberList;
import com.ust.ticl.management.response.Response;

public interface MemberService {
	
    Response registerMember(MemberInfo memberInfo);
	Response memberLogin(@Valid MemberInfo memberInfo);
	Response activateMember(List<Integer> idList);
	Response deactivateMember(List<Integer> idList);
	Response modifyMember(@Valid MemberInfo memberInfo,Integer id);
	Response removeMember(List<Integer> idList);
	Response restoreMember(List<Integer> idList);
	MemberList getallMembers(String city);
	MemberList getallMembersInTrust(String trustName);

}
