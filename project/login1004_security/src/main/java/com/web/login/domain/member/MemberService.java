package com.web.login.domain.member;

import org.springframework.boot.security
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
   
   private final MemberRepository memberRepository;
   private final PasswordEncoder passwordEncoder;

   /**
    * 보안을 위해 BCryptPasswordEncoder 클래스를 사용하여 암호화하여 비밀번호를 저장했다.
    */
   public Member add(Member member){
      String encodingPassword = passwordEncoder.encode(member.getPassword());
      member.setPassword(encodingPassword);
      System.out.println("Add " + member.toString());
      return memberRepository.save(member);
   }
}
