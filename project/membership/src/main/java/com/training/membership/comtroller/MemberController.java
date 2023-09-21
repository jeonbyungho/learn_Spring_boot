package com.training.membership.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.membership.dto.MemberJoinForm;
import com.training.membership.dto.MemberLoginForm;
import com.training.membership.service.MemberService;

@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/join")
	public String getJoinView() {
		return "join";
	}
	
	@GetMapping("/login")
	public String getloginView() {
		return "login";
	}
	
	@PostMapping("/join")
	public String memberJoin(MemberJoinForm form) {
		System.out.println(form.toString());
		memberService.join(form);
		return "redirect:/";
	}
	
	@PostMapping("login")
	public String memberLogin(MemberLoginForm form) {
		System.out.println(form.toString());
		memberService.login(form);
		return "redirect:/";
	}
}
