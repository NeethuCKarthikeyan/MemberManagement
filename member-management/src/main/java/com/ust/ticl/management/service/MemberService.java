package com.ust.ticl.management.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ust.ticl.management.dto.ResponseDto;
import com.ust.ticl.management.entity.Member;

public interface MemberService {
	
	ResponseDto registerMember(Member member);
	ResponseDto memberLogin(Member member);
	ResponseDto activateMember(List<Integer> id);
	ResponseDto deactivateMember(List<Integer> id);
	ResponseDto modifyMember(Member member);
	ResponseDto removeMember(List<Integer> id);
	ResponseDto restoreMember(List<Integer> id);
	List<Member> getallMembers(String city);

}
