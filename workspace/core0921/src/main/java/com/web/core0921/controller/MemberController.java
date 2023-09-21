package com.web.core0921.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.web.core0921.service.MemberService;

// Service는 여러 Controller에서 가져다 쓸 수 있기 때문에 Spring Container에 등록해야 된다.

@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
}
