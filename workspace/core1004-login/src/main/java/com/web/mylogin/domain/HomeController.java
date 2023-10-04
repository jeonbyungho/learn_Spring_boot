package com.web.mylogin.domain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.mylogin.domain.member.Member;
import com.web.mylogin.domain.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
   
   private final MemberRepository memberRepository;

   @Deprecated
   //@GetMapping("/")
   public String home(){
      return "home";
   }

   /*
    * name = memberId -> 쿠키의 Key값으로 Get 매핑을 한다.
    * required = false -> memberId가 필수 값이 아니므로, 로그인 안한 상태로 접속이 가능하다.
    */
   @GetMapping("/")
   public String homeLogin(
         @CookieValue(name = "memberId", required = false)Long memberId,
         Model model){
      // 로그인 상태가 아니라면 home으로 return.
      if(memberId == null) return "home";

      // DB 조회 한 후, 사용자가 없으면 null 처리하고 home을 return.
      Member loginMember = memberRepository.findById(memberId);
      if(loginMember == null) return "home";

      // 로그인 성공 loginHome을 return.
      model.addAttribute("member", loginMember);
      return "loginHome";
   }
}
