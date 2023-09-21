package com.web.core0921.repository;

import java.util.List;

import com.web.core0921.dto.Member;

public interface MemberRepository {
	
	/** 회원 저장*/
	Member save(Member member);
	/** 회원 전체 조회*/
	List<Member> findAll();
}
