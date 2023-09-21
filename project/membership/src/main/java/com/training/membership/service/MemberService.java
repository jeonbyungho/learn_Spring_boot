package com.training.membership.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.membership.dto.*;
import com.training.membership.repository.*;

@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public int join(MemberJoinForm form) {
		memberRepository.join(form);
		return 1;
	}
	
	public Member login(MemberLoginForm form) {
		Member member = memberRepository.login(form);
		return member;
	}
}
