package com.ex.mvcweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.mvcweb.entity.Member;
import com.ex.mvcweb.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
   
   private final MemberRepository memberRepository;

   public Long join(Member member) {
      memberRepository.save(member);
      log.info("━━Join " + member.toString());
      return member.getId();
   }

   public List<Member> findAll(int page) {
      return memberRepository.findAll(page - 1);
   }
}
