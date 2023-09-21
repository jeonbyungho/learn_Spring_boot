package com.web.core0921.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	/**
	 * WelcomePageHandlerMapping : Adding welcome page: class path resource [static/index.html]
	 * 에 다른 templates/*.html 을 추가하고 우선 순위를 올림.
	 */
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
}
