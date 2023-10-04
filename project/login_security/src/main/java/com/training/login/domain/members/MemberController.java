package com.training.login.domain.members;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

   private final MemberService memberService;

   // home 페이지
   @GetMapping("/")
   public String homePage(){
      return "home";
   }

   // 로그인 페이지
   // 참고로 실제 로그인을 진행하는 @PostMapping 방식의 메서드는 스프링 시큐리티가 대신 처리하므로 직접 구현할 필요가 없다.
   @GetMapping("/login")
   public String joinPage(){
      return "login";
   }

   // 회원가입 페이지
   @GetMapping("/join")
   public String joinPage(@ModelAttribute Member member){
      return "join";
   }

   // 회원가입
   @PostMapping("/join")
   public String join(@ModelAttribute Member member){
      memberService.join(member);
      return "redirect:/";
   }
}
