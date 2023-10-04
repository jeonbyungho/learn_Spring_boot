package com.web.mylogin.domain.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController{

   private final MemberRepository memberRepository;

   @GetMapping("/add")
   public String addPage(@ModelAttribute("member")Member member){
      return "member/addMemberForm";
   }

   @GetMapping("/login")
   public String loginPage(){
      return "member/login";
   }
}