package com.web.core0922.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		LocalDate now = LocalDate.now();
		model.addAttribute("data", now);
		return "home";
	}
	
	
}