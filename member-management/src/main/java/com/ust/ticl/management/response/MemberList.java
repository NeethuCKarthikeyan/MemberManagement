package com.ust.ticl.management.response;

import java.util.List;

import com.ust.ticl.management.model.Member;

import lombok.Data;
@Data
public class MemberList extends BaseResponse{
	private List<Member> member;

}
