package com.ust.ticl.management.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ust.ticl.management.entity.Member;
import com.ust.ticl.management.wrapper.City;
import com.ust.ticl.management.wrapper.Id;

@RestController
@RequestMapping("/api/member-management/member")
public class MemberController {

	@PostMapping(value = "register")
	public ResponseEntity<?> registerMember(@Valid @RequestBody Member member) {

		return null;

	}
	@PostMapping(value = "login")
	public ResponseEntity<?> memberLogin(@Valid @RequestBody Member member) {

		return null;

	}
	
	@PutMapping(value = "activate")
	public ResponseEntity<?> activateMember(@Valid @RequestBody Id id) {

		return null;
	}
	
	@PutMapping(value = "deactivate")
	public ResponseEntity<?> deactivateMember(@Valid @RequestBody Id id) {

		return null;
	}
	
	@PutMapping(value = "modifyById/{memberId}")
	public ResponseEntity<?> modifyMember(@Valid @RequestBody Member member) {

		return null;
	}
	
	@PutMapping(value = "removeById")
	public ResponseEntity<?> removeMember(@Valid @RequestBody Id id) {

		return null;
	}

	@PutMapping(value = "restoreById")
	public ResponseEntity<?> restoreMember(@Valid @RequestBody Id id) {

		return null;
	}
	@GetMapping(value = "getAllMembersByCity")
	public ResponseEntity<?> restoreMember(@Valid @RequestBody City city) {

		return null;
	}
	
	


}
