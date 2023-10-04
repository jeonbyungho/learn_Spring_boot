package com.web.mylogin.domain.login;

import org.springframework.stereotype.Service;

import com.web.mylogin.domain.member.*;

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
