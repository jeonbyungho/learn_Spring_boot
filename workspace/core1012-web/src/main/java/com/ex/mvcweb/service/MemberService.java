package com.ex.mvcweb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.mvcweb.entity.Member;
import com.ex.mvcweb.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 클래스 단위로 Transactional를 적용
public class MemberService {
   
   private final MemberRepository memberRepository;

   /* @Transactional
    * DB와 관련된, 트랜잭션이 필요한 서비스 클래스 혹은 메서드에 해당 어노테이션을 추가한다.
    * 일련의 작업들을 묶어서 하나의 단위(트랜잭션)로 처리한다.
    * readOnly = true or false
    *    true : 읽기 전용. 조회 기능만 실행된 트랜잭션일 경우, 성능이 더 좋아진다.
    */
   @Transactional
   public Long join(Member member) throws IllegalAccessException {
      validationMemberCheck(member);
      memberRepository.save(member);
      log.info("━━Join " + member.toString());
      return member.getId();
   }

   /**
    * 중복회원 검증
    * @param member
    * @throws IllegalAccessException
    */
   private void validationMemberCheck(Member member) throws IllegalAccessException {
      List<Member> findMembers = 
         memberRepository.findByName(member.getName());
      if(!findMembers.isEmpty()) throw new IllegalAccessException("이미 존재하는 회원 입니다.");
      
   }

   public List<Member> findAll(int page) {
      return memberRepository.findAll(page - 1);
   }

   public List<Member> findAll() {
      return memberRepository.findAll();
   }
}
