package com.training.membership.repository;

import org.springframework.stereotype.Repository;

import com.training.membership.dto.Member;
import com.training.membership.dto.MemberJoinForm;
import com.training.membership.dto.MemberLoginForm;

@Repository
public class JdbcMemberRepository implements MemberRepository{
	
	@Override
	public Member join(MemberJoinForm form) {
		System.out.println("@Repository" + form.toString());
		return null;
	}

	@Override
	public Member login(MemberLoginForm form) {
		System.out.println("@Repository" + form.toString());
		return null;
	}

}
