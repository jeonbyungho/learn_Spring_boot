package com.web.core0921.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.core0921.dto.*;
import com.web.core0921.service.*;

// Service는 여러 Controller에서 가져다 쓸 수 있기 때문에 Spring Container에 등록해야 된다.

@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/member/join")
	public String createForm() {
		return "member/createMemberForm";
	}
	
	@PostMapping("/member/join")
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		memberService.join(member);
		
		//redirect 방식으로 "/" 경로로 페이지 이동함.
		return "redirect:/";
	}
	
	@GetMapping("/member/list")
	public String allList(Model model) {
		List<Member> list = memberService.findMembers();
		System.out.println(list.toString());
		model.addAttribute("membersList",list);
		return "member/allMemberList";
	}
}
