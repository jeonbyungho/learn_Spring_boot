package com.web.core0921.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.core0921.dto.Member;
import com.web.core0921.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Transactional 
@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	// 회원가입
	public int join(Member member) {
		memberRepository.save(member);
		return member.getId();
	}
	// 전체 회원 조회
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
}
