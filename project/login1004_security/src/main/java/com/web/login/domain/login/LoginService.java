package com.web.login.domain.login;

import org.springframework.stereotype.Service;

import com.web.login.domain.member.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

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
}
