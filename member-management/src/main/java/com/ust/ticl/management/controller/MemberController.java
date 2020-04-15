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
import com.ust.ticl.management.dto.ResponseDto;
import com.ust.ticl.management.entity.Member;
import com.ust.ticl.management.service.MemberService;


@RestController
@RequestMapping("/api/member-management/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	ResponseDto responseDto;	
	

	@PostMapping(value = "register",produces="application/json")
	public ResponseEntity<ResponseDto> registerMember(@Valid @RequestBody Member member) {
		responseDto=memberService.registerMember(member);
		return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);

	}
	@PostMapping(value = "login",consumes = "application/json",produces="application/json")
	public ResponseEntity<ResponseDto> memberLogin(@Valid @RequestBody Member member) {
		return null;
		
	}
	
	@PutMapping(value = "activate",produces="application/json")
	public ResponseEntity<ResponseDto> activateMember(@Valid @RequestBody Id id) {
		List<Integer> idList=id.getIdList();
		System.out.println("idList"+idList);
		responseDto=memberService.activateMember(idList);
		return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);		
	}
	
	@PutMapping(value = "deactivate",produces="application/json" )
	public ResponseEntity<ResponseDto> deactivateMember(@Valid @RequestBody Id id) {

		return null;
	}
	
	@PutMapping(value = "modifyById/{memberId}",produces="application/json")
	public ResponseEntity<ResponseDto> modifyMember(@PathVariable(value = "memberId") Integer memberId,@Valid @RequestBody Member member) {

		return null;
	}
	
	@PutMapping(value = "removeById",produces="application/json")
	public ResponseEntity<ResponseDto> removeMember(@Valid @RequestBody Id id) {

		return null;
	}

	@PutMapping(value = "restoreById",produces="application/json")
	public ResponseEntity<ResponseDto> restoreMember(@Valid @RequestBody Id id) {

		return null;
	}
	@GetMapping(value = "getAllMembersByCity",produces="application/json")
	public ResponseEntity<List<Member>> getallMembers(@Valid @RequestBody String city) {

		return null;
	}
	
	


}
