package com.ust.ticl.management.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.ticl.management.dto.ResponseDto;
import com.ust.ticl.management.entity.Member;
import com.ust.ticl.management.repository.MemberRepository;

@Service
public class MemberServiceImpl implements  MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	

	@Override
	public ResponseDto registerMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDto memberLogin(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDto activateMember(List<Integer> id) {
		
		Timestamp CurrentTimestamp = new Timestamp(System.currentTimeMillis());
		memberRepository.updateMemberAsActive(true, CurrentTimestamp, id);  
		return null;
	}

	@Override
	public ResponseDto deactivateMember(List<Integer> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDto modifyMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDto removeMember(List<Integer> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDto restoreMember(List<Integer> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getallMembers(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	}
