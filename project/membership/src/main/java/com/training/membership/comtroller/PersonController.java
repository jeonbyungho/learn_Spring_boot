package com.training.membership.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String getLoginView() {
		return "login";
	}
	
	@GetMapping("/search")
	public String getSearchView() {
		return "search";
	}
	
	@PostMapping("/join")
	public String personJoin(PersonJoinForm form, Model model) {
		System.out.println(form.toString());
		int idx = personService.join(form);
		System.out.println("회원가입 : " + idx);
		return "redirect:/";
	}
	
	@PostMapping("login")
	public String personLogin(Model model,
			@RequestParam String userid,
			@RequestParam String userpwd) {
		System.out.println("id : "+userid + "password : "+userpwd);
		Person person = personService.login(userid, userpwd);
		model.addAttribute("person", person);
		return "main";
	}
	
	@PostMapping("/search")
	public String personSearchId(@RequestParam String email, Model model) {
		List<String> personIdList = personService.serachId(email);
		model.addAttribute("personIdList", personIdList);
		return "search";
	}
}
