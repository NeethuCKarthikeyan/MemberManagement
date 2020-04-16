package com.ust.ticl.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.ticl.management.dto.ResponseDto;
import com.ust.ticl.management.entity.Member;
import com.ust.ticl.management.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;
	ResponseDto responseDto = new ResponseDto();
	Member member=new Member();

	@Override
	public ResponseDto registerMember(Member member) {
		memberRepository.insertMember(member.getName(), member.getEmailId(), member.getPassword(), member.getMobNum());
		responseDto.setStatus("success");
		responseDto.setMessage("Member/s registered successfully");
		return responseDto;
	}

	@Override
	public ResponseDto memberLogin(Member memberIn) {
		
		int row =memberRepository.findMember(memberIn.getEmailId(), memberIn.getPassword());
		if(row==1) {
			responseDto.setStatus("success");
			responseDto.setMessage("Login successfull");						
		}
		else {
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
	public ResponseDto modifyMember(Member member,Integer id) {
		int response=memberRepository.updateMember(member.getGender(), member.getAddress(), member.getCity(), member.getState(), member.getCountry(), member.getPinNum(), id);
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
	public List<Member> getallMembers(String city) {
		List<Member> memberList=memberRepository.findAllMembersInCity(city);
		return memberList;
	}

}
