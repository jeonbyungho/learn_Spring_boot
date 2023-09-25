package com.web.core0925.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.core0925.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller()
@RequestMapping("/basic")
public class BasicController {
	@GetMapping("/object")
	public String basicObject(HttpSession session) {
		session.setAttribute("sessionData", "세션 값");
		return "basic/object";
	}
	
	@GetMapping("/date_now")
	public String date(Model model) {
		model.addAttribute("localDateTime", LocalDateTime.now());
		return "basic/date";
	}
	
	@GetMapping("/link")
	public String link(Model model) {
		model.addAttribute("param1", "data1");
		model.addAttribute("param2", "data2");
		return "basic/link";
	}
	
	@GetMapping("/literal")
	public String literal(Model model) {
		model.addAttribute("data", "spring");
		return "basic/literal";
	}
	
	@GetMapping("/operation")
	public String operation(Model model) {
		model.addAttribute("nullData", null);
		model.addAttribute("data", "spring");
		return "basic/operation";
	}
	
	@GetMapping("/attribute")
	public String attribute() {
		return "basic/attribute";
	}
	
	@GetMapping("/foreach")
	public String each(Model model) {
		addUser(model);
		return "basic/each";
	}
	
	@GetMapping("/condition")
	public String condition(Model model) {
		addUser(model);
		return "basic/condition";
	}
	
	@GetMapping("/comments")
	public String comments(Model model) {
		model.addAttribute("data", "spring");
		return "basic/comments";
	}
	
	@GetMapping("/block")
	public String block(Model model) {
		addUser(model);
		return "basic/block";
	}
	
	@GetMapping("/js")
	public String javascript(Model model) {
		model.addAttribute("user", new User("userOther", 15));
		addUser(model);
		return "basic/inline_js";
	}
	
	private void addUser(Model model) {
		List<User> list = new ArrayList<User>();
		list.add(new User("userOne", 10));
		list.add(new User("userTwo", 22));
		list.add(new User("userThree", 34));
		list.add(new User("userFour", 45));
		list.add(new User("userFive", 57));
		list.add(new User("userSix", 66));
		model.addAttribute("userList",list);
	}
}
