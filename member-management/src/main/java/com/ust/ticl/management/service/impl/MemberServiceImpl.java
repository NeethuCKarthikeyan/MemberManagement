package com.ust.ticl.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.ticl.management.domain.MemberDomain;
import com.ust.ticl.management.model.Member;
import com.ust.ticl.management.repository.MemberRepository;
import com.ust.ticl.management.request.MemberInfo;
import com.ust.ticl.management.response.MemberList;
import com.ust.ticl.management.response.Response;
import com.ust.ticl.management.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDomain memberDomain;

	@Autowired
	private MemberRepository memberRepository;

	Response response = new Response();
	
	Member member = new Member();

	@Override
	public Response registerMember(MemberInfo memberInfo) {
		member.setEmailId(memberInfo.getEmail());
		member.setPassword(memberInfo.getPassword());
		member.setName(memberInfo.getName());
		member.setMobNum(memberInfo.getMob());
		boolean result = memberDomain.registerMember(member);
		if (result == true) {
			response.setStatus("success");
			response.setMessage("Member registered successfully");
		} else {
			response.setStatus("failed");
			response.setMessage("Entered Exception while registering member!!!");
		}

		return response;
	}

	@Override
	public Response memberLogin(MemberInfo memberInfo) {

		member.setEmailId(memberInfo.getEmail());
		member.setPassword(memberInfo.getPassword());

		int result = memberDomain.memberLogin(member);
		if (result == -1) {
			response.setStatus("failed");
			response.setMessage("Entered Exception while Login!!!");
		} else {
			if (result == 0) {
				response.setStatus("failed");
				response.setMessage("Invalid credentials");
			} else {
				response.setStatus("success");
				response.setMessage("Login Successfull");

			}

		}

		return response;
	}

	@Override
	public Response activateMember(List<Integer> idList) {
		int result = memberDomain.activateMember(idList);
		if (result == -1) {
			response.setStatus("failed");
			response.setMessage("Entered Exception while activating member!!!");
		} else {
			if (result == idList.size()) {
				response.setStatus("success");
				response.setMessage(idList.size()+" Member/s Activated successfully");
			} else {
				response.setStatus("failed");
				response.setMessage("Member/s activation failed");

			}
		}
		return response;
	}

	@Override
	public Response deactivateMember(List<Integer> idList) {

		int result = memberDomain.deactivateMember(idList);
		if (result == -1) {
			response.setStatus("failed");
			response.setMessage("Entered Exception while deactivating member!!!");
		} else {
			if (result == idList.size()) {
				response.setStatus("success");
				response.setMessage(idList.size()+" Member/s dectivated successfully");
			} else {
				response.setStatus("failed");
				response.setMessage("Member/s deactivation failed");

			}
		}
		

		return response;
	}

	@Override
	public Response modifyMember(MemberInfo memberInfo, Integer id) {
		Member member=new Member();
		member.setGender(memberInfo.getGender());
		member.setAddress(memberInfo.getAddress());
		member.setCity(memberInfo.getCity());
		member.setState(memberInfo.getState());
		member.setCountry(memberInfo.getCountry());
		member.setPinNum(memberInfo.getPin());
		System.out.println("id from service impl"+id);
		int result = memberDomain.modifyMember(member,id);
				if (result == -1) {
			response.setStatus("failed");
			response.setMessage("Entered Exception while modifying member!!!");
		} else {
			if (result == 1) {
				response.setStatus("success");
				response.setMessage("Member updated successfully");
			} else {
				response.setStatus("failed");
				response.setMessage("Member updation failed");

			}
		}
		return response;
	}

	@Override
	public Response removeMember(List<Integer> idList) {

		int result = memberDomain.removeMember(idList);
		if (result == -1) {
			response.setStatus("failed");
			response.setMessage("Entered Exception while removing member!!!");
		} else {
			if (result == idList.size()) {
				response.setStatus("success");
				response.setMessage("Member/s Removed successfully");
			} else {
				response.setStatus("failed");
				response.setMessage("Member/s Removal failed");

			}
		}
		return response;
	}

	@Override
	public Response restoreMember(List<Integer> idList) {

		int result = memberDomain.restoreMember(idList);
		if (result == -1) {
			response.setStatus("failed");
			response.setMessage("Entered Exception while Restoring member!!!");
		} else {
			if (result == idList.size()) {
				response.setStatus("success");
				response.setMessage("Member/s Restored successfully");
			} else {
				response.setStatus("failed");
				response.setMessage("Member/s Restore failed");

			}
		}
		return response;
	}

	@Override
	public MemberList getallMembers(String city) {
		MemberList memberList = new MemberList();
		List<Member> result = memberDomain.getAllMembersInCity(city);
	    memberList.setMember(result);
	    if(result!=null) 
	    {
			return memberList;	
	    }
	    else
	    	return null;
	}

}
