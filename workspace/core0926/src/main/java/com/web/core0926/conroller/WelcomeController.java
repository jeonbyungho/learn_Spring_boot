package com.web.core0926.conroller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("now", LocalDate.now());
		return "welcome";
	}
}
