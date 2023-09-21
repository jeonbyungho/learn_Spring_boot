package com.web.core0921.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.web.core0921.dto.Member;

@Repository
public class MemoryMemberRepository implements MemberRepository{
	
	// 메모리 저장소
	private static Map<Integer, Member> store = new HashMap<>();
	private static int sequence = 0;
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(sequence, member);
		return member;
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}
	
}
