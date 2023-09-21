package com.training.membership.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.membership.dto.*;
import com.training.membership.service.*;

@Controller
public class PersonController {
	
	private final PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
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
	public String personJoin(PersonJoinForm form, Model model) {
		System.out.println(form.toString());
		int idx = personService.join(form);
		System.out.println("회원가입 : " + idx);
		return "redirect:/";
	}
	
	@PostMapping("login")
	public String personLogin(PersonLoginForm form, Model model) {
		System.out.println(form.toString());
		Person person = personService.login(form);
		model.addAttribute("person", person);
		return "main";
	}
}
