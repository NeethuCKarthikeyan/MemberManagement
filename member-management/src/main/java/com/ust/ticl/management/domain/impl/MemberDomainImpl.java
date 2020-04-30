package com.ust.ticl.management.domain.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ust.ticl.management.domain.MemberDomain;
import com.ust.ticl.management.model.Member;
import com.ust.ticl.management.model.Trust;
import com.ust.ticl.management.repository.MemberRepository;
import com.ust.ticl.management.repository.TrustRepository;

@Component
public class MemberDomainImpl implements MemberDomain {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	TrustRepository trustRepository;

	@Override
	public boolean registerMember(Member member) {
		try {
			memberRepository.insertMember(member.getName(), member.getEmailId(), member.getPassword(),
					member.getMobNum());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int memberLogin(Member member) {
		try {
			int result = memberRepository.findMember(member.getEmailId(), member.getPassword());
			return result;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int activateMember(List<Integer> idList) {

		try {
			int result = memberRepository.updateMemberAsActiveOrInactive(true, idList);
			return result;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int deactivateMember(List<Integer> idList) {
		try {
			int result = memberRepository.updateMemberAsActiveOrInactive(false, idList);
			return result;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int modifyMember(Member member, Integer id) {
		try {
			int result = memberRepository.updateMember(member.getGender(), member.getAddress(), member.getCity(),
					member.getState(), member.getCountry(), member.getPinNum(), id);
			return result;
		} catch (Exception e) {
			return -1;
		}

	}

	@Override
	public int removeMember(List<Integer> idList) {
		try {
			int result = memberRepository.removeOrRestoreMember(true, idList);
			return result;
		} catch (Exception e) {
			return -1;
		}

	}

	@Override
	public int restoreMember(List<Integer> idList) {
		try {
			int result = memberRepository.removeOrRestoreMember(false, idList);
			return result;
		} catch (Exception e) {
			return -1;
		}

	}

	@Override
	public List<Member> getAllMembersInCity(String city) {

		try {
			List<Member> mList = memberRepository.findAllMembersInCity(city);
			for (Member member : mList) {
				member.setPassword("******");

			}
			return mList;
		} catch (Exception e) {
			return null;

		}
	}

	@Override
	public boolean addMembeerToTrust(List<Trust> tList) {
		try {
			trustRepository.saveAll(tList);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
