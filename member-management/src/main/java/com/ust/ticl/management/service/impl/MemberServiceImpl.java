package com.ust.ticl.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.ticl.management.domain.MemberDomain;
import com.ust.ticl.management.dto.MemberListDto;
import com.ust.ticl.management.dto.ResponseDto;
import com.ust.ticl.management.model.Member;
import com.ust.ticl.management.repository.MemberRepository;
import com.ust.ticl.management.request.MemberInfo;
import com.ust.ticl.management.response.Response;
import com.ust.ticl.management.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDomain memberDomain;
	
	@Autowired
	private MemberRepository memberRepository;
	
	Response response = new Response();
	ResponseDto responseDto = new ResponseDto();
	Member member = new Member();

	@Override
	public Response registerMember(MemberInfo memberInfo) {
		member.setEmailId(memberInfo.getEmail());
		member.setPassword(memberInfo.getEmail());
		member.setName(memberInfo.getName());
		member.setMobNum(memberInfo.getMob());
		boolean result = memberDomain.registerMember(member);
		if (result == true) {
			response.setStatus("success");
			response.setMessage("Member registered successfully");
		} else {
			response.setStatus("failed");
			response.setMessage("Member registration failed");
		}

		return response;
	}

	@Override
	public ResponseDto memberLogin(Member memberIn) {

		int row = memberRepository.findMember(memberIn.getEmailId(), memberIn.getPassword());
		if (row == 1) {
			responseDto.setStatus("success");
			responseDto.setMessage("Login successfull");
		} else {
			responseDto.setStatus("failed");
			responseDto.setMessage("Invalid credentials");
		}

		return responseDto;
	}

	@Override
	public ResponseDto activateMember(List<Integer> idList) {
		int response = memberRepository.updateMemberAsActiveOrInactive(true, idList);
		if (response == 2) {
			responseDto.setStatus("success");
			responseDto.setMessage("Member/s Activated successfully");
		} else {
			responseDto.setStatus("failed");
			responseDto.setMessage("Member/s activation failed");

		}
		return responseDto;
	}

	@Override
	public ResponseDto deactivateMember(List<Integer> idList) {

		int response = memberRepository.updateMemberAsActiveOrInactive(false, idList);
		if (response == 2) {
			responseDto.setStatus("success");
			responseDto.setMessage("Member/s Deactivated successfully");
		} else {
			responseDto.setStatus("failed");
			responseDto.setMessage("Member/s Detivation failed");
		}
		return responseDto;
	}

	@Override
	public ResponseDto modifyMember(Member member, Integer id) {
		int response = memberRepository.updateMember(member.getGender(), member.getAddress(), member.getCity(),
				member.getState(), member.getCountry(), member.getPinNum(), id);
		if (response == 1) {
			responseDto.setStatus("success");
			responseDto.setMessage("Member details updated successfully");
		} else {
			responseDto.setStatus("failed");
			responseDto.setMessage("Member updation failed");

		}
		return responseDto;
	}

	@Override
	public ResponseDto removeMember(List<Integer> idList) {

		int response = memberRepository.removeOrRestoreMember(true, idList);
		if (response == 2) {
			responseDto.setStatus("success");
			responseDto.setMessage("Member/s Removed successfully");
		} else {
			responseDto.setStatus("failed");
			responseDto.setMessage("Unable to remove Member");

		}
		return responseDto;
	}

	@Override
	public ResponseDto restoreMember(List<Integer> idList) {

		int response = memberRepository.removeOrRestoreMember(false, idList);
		if (response == 2) {
			responseDto.setStatus("success");
			responseDto.setMessage("Member/s Restored successfully");
		} else {
			responseDto.setStatus("failed");
			responseDto.setMessage("Unable to restore Member/s ");

		}
		return responseDto;
	}

	@Override
	public MemberListDto getallMembers(String city) {
		MemberListDto memberList = new MemberListDto();
		List<Member> mList = memberRepository.findAllMembersInCity(city);
		memberList.setMember(mList);
		return memberList;
	}

}
