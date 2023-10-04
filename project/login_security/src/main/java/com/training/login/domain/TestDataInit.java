package com.training.login.domain;

import org.springframework.stereotype.Component;

import com.training.login.domain.members.Member;
import com.training.login.domain.members.MemberService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TestDataInit {
   

   private final MemberService memberService;

   @PostConstruct
   public void init(){
      Member member1 = new Member();
      member1.setLoginId("tester");
      member1.setPassword("t1234");
      member1.setName("테스터");
      memberService.add(member1);

      Member member2 = new Member();
      member2.setLoginId("user01");
      member2.setPassword("u1234");
      member2.setName("유저임");
      memberService.add(member2);

      Member member3 = new Member();
      member3.setLoginId("user02");
      member3.setPassword("u1234");
      member3.setName("유저야");
      memberService.add(member3);
   }
}
