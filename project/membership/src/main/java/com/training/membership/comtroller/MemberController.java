package com.training.membership.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("/join")
	public String getJoin() {
		return "join";
	}
	
	@RequestMapping("/login")
	public String getlogin() {
		return "login";
	}
}
