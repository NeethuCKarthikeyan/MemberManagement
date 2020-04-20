package com.ust.ticl.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ust.ticl.management.model.Member;
import com.ust.ticl.management.request.Id;
import com.ust.ticl.management.request.MemberInfo;
import com.ust.ticl.management.response.MemberList;
import com.ust.ticl.management.response.Response;
import com.ust.ticl.management.service.MemberService;


@RestController
@RequestMapping("/api/member-management/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
		
	

	@PostMapping(value = "register",produces="application/json")
	public ResponseEntity<Response> registerMember(@Valid @RequestBody MemberInfo memberInfo) {
		return new ResponseEntity<Response>(memberService.registerMember(memberInfo),HttpStatus.OK);

	}
	@PostMapping(value = "login",consumes = "application/json",produces="application/json")
	public ResponseEntity<Response> memberLogin(@Valid @RequestBody MemberInfo memberInfo) {
		return new ResponseEntity<Response>(memberService.memberLogin(memberInfo),HttpStatus.OK);
		
	}
	
	@PutMapping(value = "activate",produces="application/json")
	public ResponseEntity<Response> activateMember(@Valid @RequestBody Id id) {
		List<Integer> idList=id.getIdList();
		return new ResponseEntity<Response>(memberService.activateMember(idList),HttpStatus.OK);		
	}
	
	@PutMapping(value = "deactivate",produces="application/json" )
	public ResponseEntity<Response> deactivateMember(@Valid @RequestBody Id id) {
		List<Integer> idList=id.getIdList();
		return new ResponseEntity<Response>(memberService.deactivateMember(idList),HttpStatus.OK);		
	}
	
	@PutMapping(value = "modifyById/{memberId}",produces="application/json")
	public ResponseEntity<Response> modifyMember(@PathVariable(value = "memberId") Integer memberId,@Valid @RequestBody MemberInfo memberInfo) {
		return new ResponseEntity<Response>(memberService.modifyMember(memberInfo, memberId),HttpStatus.OK);
	}
	
	@PutMapping(value = "removeById",produces="application/json")
	public ResponseEntity<Response> removeMember(@Valid @RequestBody Id id) {
		List<Integer> idList=id.getIdList();
		return new ResponseEntity<Response>(memberService.removeMember(idList),HttpStatus.OK);		
	}

	@PutMapping(value = "restoreById",produces="application/json")
	public ResponseEntity<Response> restoreMember(@Valid @RequestBody Id id) {
		List<Integer> idList=id.getIdList();
		return new ResponseEntity<Response>(memberService.restoreMember(idList),HttpStatus.OK);		
		}
	@GetMapping(value = "getAllMembersByCity",produces="application/json")
	public ResponseEntity<MemberList> getallMembers(@Valid @RequestBody Member member) {
		return new ResponseEntity<MemberList>(memberService.getallMembers(member.getCity()),HttpStatus.OK);

	}
	
	


}
