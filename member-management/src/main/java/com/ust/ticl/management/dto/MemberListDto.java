package com.ust.ticl.management.dto;

import java.util.List;

import com.ust.ticl.management.model.Member;

import lombok.Data;
@Data
public class MemberListDto {
	private List<Member> member;

}
