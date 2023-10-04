package com.web.mylogin.domain;

import org.springframework.stereotype.Component;

import com.web.mylogin.domain.member.*;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TestDataInit {
   
   private final MemberRepository memberRepository;

   @PostConstruct
   public void init(){
      Member member = new Member();
      member.setLoginId("tester");
      member.setPassword("t1234");
      member.setName("테스터");
      memberRepository.save(member);
   }
}
