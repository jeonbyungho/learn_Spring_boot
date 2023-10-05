package com.web.mylogin.domain.login;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.web.mylogin.domain.member.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService implements InitializingBean, DisposableBean{

   private final MemberRepository memberRepository;

   public Member login(String loginId, String password){
      Member member = memberRepository.findByLoginId(loginId, password);
      if(member != null 
      && member.getLoginId().equals(loginId)
      && member.getPassword().equals(password)){
         return member;
      }
      return null;
   }

   @Override
   public void afterPropertiesSet() throws Exception {
      System.out.println("LoginService 빈 객체 탄생!");
   }

   @Override
   public void destroy() throws Exception {
      System.out.println("LoginService 빈 객체 죽음");
   }

   
}
