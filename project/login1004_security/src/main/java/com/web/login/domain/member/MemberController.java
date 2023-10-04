package com.web.login.domain.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController{

   private final MemberService memberService;

   @GetMapping("/add")
   public String addPage(@ModelAttribute Member member){
      return "member/addMemberForm";
   }

   @PostMapping("/add")
   public String addMember(@ModelAttribute Member member){
      memberService.add(member);
      return "redirect:/";
   }
}