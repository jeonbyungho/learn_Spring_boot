package com.ex.mvcweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.mvcweb.dto.MemberForm;
import com.ex.mvcweb.entity.Member;
import com.ex.mvcweb.entity.Address;
import com.ex.mvcweb.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

   private final MemberService memberService;
   
   @GetMapping("/new")
   public String createMember(@ModelAttribute MemberForm memberFrom){
      return "createMemberForm";
   }

   // @Valid 다음에 BindingResult기 있으면, error를 바인딩한다.
   @PostMapping("/new")
   public String createMember(@Valid MemberForm memberFrom, BindingResult bindingResult) 
         throws IllegalAccessException {
      if(bindingResult.hasErrors()) {
         log.info("유효성 검사 \n" + bindingResult.getAllErrors().toString());
         return "createMemberForm";
      }

      Address address = new Address(memberFrom.getCity(), memberFrom.getStreet(), memberFrom.getZipcode());
      Member member = new Member();
      member.setName(memberFrom.getName());
      member.setAddress(address);
      memberService.join(member);
      return "redirect:/";
   }

   @GetMapping
   public String memberList(
         @RequestParam(defaultValue = "1", required = false) Integer page, 
         Model model){
      log.info("━━page : " + page);
      List<Member> members = memberService.findAll(page);
      model.addAttribute("members", members);
      model.addAttribute("currentPage", page);
      log.info("━━size : " + members.size());
      return "memberList";
   }
}
