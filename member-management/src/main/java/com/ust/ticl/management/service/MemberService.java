package com.ust.ticl.management.service;

import java.util.List;

import com.ust.ticl.management.dto.MemberListDto;
import com.ust.ticl.management.dto.ResponseDto;
import com.ust.ticl.management.model.Member;
import com.ust.ticl.management.request.MemberInfo;
import com.ust.ticl.management.response.Response;

public interface MemberService {
	
    Response registerMember(MemberInfo memberInfo);
	ResponseDto memberLogin(Member member);
	ResponseDto activateMember(List<Integer> idList);
	ResponseDto deactivateMember(List<Integer> idList);
	ResponseDto modifyMember(Member member,Integer id);
	ResponseDto removeMember(List<Integer> idList);
	ResponseDto restoreMember(List<Integer> idList);
	MemberListDto getallMembers(String city);

}
