package com.ust.ticl.management.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.ticl.management.domain.MemberDomain;
import com.ust.ticl.management.model.Member;
import com.ust.ticl.management.repository.MemberRepository;

@Component
public class MemberDomainImpl implements MemberDomain{
	
	@Autowired
	MemberRepository memberRepository;

	@Override
	public boolean registerMember(Member member) {
		try {
			memberRepository.insertMember(member.getName(), member.getEmailId(), member.getPassword(), member.getMobNum());
			return true;	
		}catch (Exception e) {
			return false;
		}
	}

}
