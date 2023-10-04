package com.web.mylogin.domain.member;

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

   private final MemberRepository memberRepository;

   @GetMapping("/add")
   public String addPage(@ModelAttribute Member member){
      return "member/addMemberForm";
   }

   @PostMapping("/add")
   public String addMember(@ModelAttribute Member member){
      memberRepository.save(member);
      return "redirect:/";
   }
}