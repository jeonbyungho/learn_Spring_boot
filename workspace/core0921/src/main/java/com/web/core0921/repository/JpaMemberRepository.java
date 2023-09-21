package com.web.core0921.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.core0921.dto.Member;

import jakarta.persistence.EntityManager;

@Repository
public class JpaMemberRepository implements MemberRepository{
	
	private final EntityManager em;
	
	public JpaMemberRepository(EntityManager em) {
		this.em = em;
		System.out.println(this.em);
	}
	
	@Override
	public Member save(Member member) {
		this.em.persist(member);
		return member;
	}

	@Override
	public List<Member> findAll() {
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}
	
}
