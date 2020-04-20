package com.ust.ticl.management.domain;

import java.util.List;

import com.ust.ticl.management.model.Member;


public interface MemberDomain {
	public boolean registerMember(Member member);

	 public int memberLogin(Member member);
	 public int activateMember(List<Integer> idList);
	 public int deactivateMember(List<Integer> idList);
	 public int modifyMember(Member member,Integer id);
	 public int removeMember(List<Integer> idList);
	 public int restoreMember(List<Integer> idList);
	 public List<Member> getAllMembersInCity(String city);
	 }
