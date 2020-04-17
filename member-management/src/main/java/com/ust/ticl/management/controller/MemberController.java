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


import com.ust.ticl.management.dto.Id;
import com.ust.ticl.management.dto.MemberListDto;
import com.ust.ticl.management.dto.ResponseDto;
import com.ust.ticl.management.model.Member;
import com.ust.ticl.management.request.MemberInfo;
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
	public ResponseEntity<ResponseDto> memberLogin(@Valid @RequestBody Member member) {
		return new ResponseEntity<ResponseDto>(memberService.memberLogin(member),HttpStatus.OK);
		
	}
	
	@PutMapping(value = "activate",produces="application/json")
	public ResponseEntity<ResponseDto> activateMember(@Valid @RequestBody Id id) {
		List<Integer> idList=id.getIdList();
        System.out.println("idList"+idList);
		return new ResponseEntity<ResponseDto>(memberService.activateMember(idList),HttpStatus.OK);		
	}
	
	@PutMapping(value = "deactivate",produces="application/json" )
	public ResponseEntity<ResponseDto> deactivateMember(@Valid @RequestBody Id id) {
		List<Integer> idList=id.getIdList();
		return new ResponseEntity<ResponseDto>(memberService.deactivateMember(idList),HttpStatus.OK);		
	}
	
	@PutMapping(value = "modifyById/{memberId}",produces="application/json")
	public ResponseEntity<ResponseDto> modifyMember(@PathVariable(value = "memberId") Integer memberId,@Valid @RequestBody Member member) {
		
		return new ResponseEntity<ResponseDto>(memberService.modifyMember(member, memberId),HttpStatus.OK);
	}
	
	@PutMapping(value = "removeById",produces="application/json")
	public ResponseEntity<ResponseDto> removeMember(@Valid @RequestBody Id id) {
		List<Integer> idList=id.getIdList();
		return new ResponseEntity<ResponseDto>(memberService.removeMember(idList),HttpStatus.OK);		
	}

	@PutMapping(value = "restoreById",produces="application/json")
	public ResponseEntity<ResponseDto> restoreMember(@Valid @RequestBody Id id) {
		List<Integer> idList=id.getIdList();
		return new ResponseEntity<ResponseDto>(memberService.restoreMember(idList),HttpStatus.OK);		
		}
	@GetMapping(value = "getAllMembersByCity",produces="application/json")
	public ResponseEntity<MemberListDto> getallMembers(@Valid @RequestBody Member member) {
		return new ResponseEntity<MemberListDto>(memberService.getallMembers(member.getCity()),HttpStatus.OK);

	}
	
	


}
