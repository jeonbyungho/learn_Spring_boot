package com.web.core0921.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/test")
	public String getPage() {
		System.out.println("컨트롤러 작성함");
		return "test";
	}
}
