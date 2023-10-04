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

}
