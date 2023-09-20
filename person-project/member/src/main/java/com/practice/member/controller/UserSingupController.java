package com.practice.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserSingupController {
	
	@GetMapping("/singup")
	public String getSingupPage(Model model) {
		System.out.println("singup 페이지");
		return "singup";
	}
}
