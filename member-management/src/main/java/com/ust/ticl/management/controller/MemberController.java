package com.ust.ticl.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.ticl.management.exception.DataNotFoundException;
import com.ust.ticl.management.exception.MemberManangementBusinessException;
import com.ust.ticl.management.model.Member;
import com.ust.ticl.management.request.Id;
import com.ust.ticl.management.request.MemberInfo;
import com.ust.ticl.management.response.MemberList;
import com.ust.ticl.management.response.Response;
import com.ust.ticl.management.service.MemberService;
import com.ust.ticl.management.validator.APIRequestValidator;

@RestController
@RequestMapping("/api/member-management/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	APIRequestValidator apiRequestValidator;

	@PostMapping(value = "register", produces = "application/json")
	public ResponseEntity<Response> registerMember(@Valid @RequestBody MemberInfo memberInfo)
			throws MemberManangementBusinessException {
		boolean validator = apiRequestValidator.validateRegiserRequest(memberInfo);
		if (validator == true)
			return new ResponseEntity<Response>(memberService.registerMember(memberInfo), HttpStatus.OK);
		else
			throw new MemberManangementBusinessException("Enter all required Information in the Request");
	}

	@PostMapping(value = "login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Response> memberLogin(@Valid @RequestBody MemberInfo memberInfo)
			throws MemberManangementBusinessException {
		boolean validator = apiRequestValidator.validateLoginRequest(memberInfo);
		if (validator == true)
			return new ResponseEntity<Response>(memberService.memberLogin(memberInfo), HttpStatus.OK);
		else
			throw new MemberManangementBusinessException("Enter EmailId and Password to Login");

	}

	@PutMapping(value = "activate", produces = "application/json")
	public ResponseEntity<Response> activateMember(@Valid @RequestBody Id id)
			throws MemberManangementBusinessException {
		List<Integer> idList = id.getIdList();
		boolean validator = apiRequestValidator.validateIdlist(idList);
		if (validator == true)
			return new ResponseEntity<Response>(memberService.activateMember(idList), HttpStatus.OK);
		else
			throw new MemberManangementBusinessException("Enter id in Request");
	}

	@PutMapping(value = "deactivate", produces = "application/json")
	public ResponseEntity<Response> deactivateMember(@Valid @RequestBody Id id)
			throws MemberManangementBusinessException {
		List<Integer> idList = id.getIdList();
		boolean validator = apiRequestValidator.validateIdlist(idList);
		if (validator == true)
			return new ResponseEntity<Response>(memberService.deactivateMember(idList), HttpStatus.OK);
		else
			throw new MemberManangementBusinessException("Enter id in Request");

	}

	@PutMapping(value = "modifyById/{memberId}", produces = "application/json")
	public ResponseEntity<Response> modifyMember(@PathVariable(value = "memberId") Integer memberId,
			@Valid @RequestBody MemberInfo memberInfo) {
		return new ResponseEntity<Response>(memberService.modifyMember(memberInfo, memberId), HttpStatus.OK);
	}

	@PutMapping(value = "removeById", produces = "application/json")
	public ResponseEntity<Response> removeMember(@Valid @RequestBody Id id) throws MemberManangementBusinessException {
		List<Integer> idList = id.getIdList();
		boolean validator = apiRequestValidator.validateIdlist(idList);
		if (validator == true)
			return new ResponseEntity<Response>(memberService.removeMember(idList), HttpStatus.OK);
		else
			throw new MemberManangementBusinessException("Enter id in Request");
	}

	@PutMapping(value = "restoreById", produces = "application/json")
	public ResponseEntity<Response> restoreMember(@Valid @RequestBody Id id) throws MemberManangementBusinessException {
		List<Integer> idList = id.getIdList();
		boolean validator = apiRequestValidator.validateIdlist(idList);
		if (validator == true)
			return new ResponseEntity<Response>(memberService.restoreMember(idList), HttpStatus.OK);
		else
			throw new MemberManangementBusinessException("Enter id in Request");
	}

	@GetMapping(value = "getAllMembersByCity", produces = "application/json")
	public ResponseEntity<MemberList> getallMembers(@Valid @RequestBody MemberInfo memberInfo)
			throws MemberManangementBusinessException, DataNotFoundException {
		MemberList memberList = null;
		boolean validator = apiRequestValidator.validateCity(memberInfo);
		if (validator == true) {
			memberList = memberService.getallMembers(memberInfo.getCity());
			if (!CollectionUtils.isEmpty(memberList.getMember()))
				return new ResponseEntity<MemberList>(memberList, HttpStatus.OK);
			else
				throw new DataNotFoundException("No members found in city : "+memberInfo.getCity());
		} else
			throw new MemberManangementBusinessException("Enter the city in Request");

	}

}
