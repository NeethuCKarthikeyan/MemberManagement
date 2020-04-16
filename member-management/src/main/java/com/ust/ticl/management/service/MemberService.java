package com.ust.ticl.management.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ust.ticl.management.dto.ResponseDto;
import com.ust.ticl.management.entity.Member;

public interface MemberService {
	
	ResponseDto registerMember(Member member);
	ResponseDto memberLogin(Member member);
	ResponseDto activateMember(List<Integer> idList);
	ResponseDto deactivateMember(List<Integer> idList);
	ResponseDto modifyMember(Member member,Integer id);
	ResponseDto removeMember(List<Integer> idList);
	ResponseDto restoreMember(List<Integer> idList);
	List<Member> getallMembers(String city);

}
