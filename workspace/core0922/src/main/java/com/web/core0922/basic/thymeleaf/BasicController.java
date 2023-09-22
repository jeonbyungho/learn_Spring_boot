package com.web.core0922.basic.thymeleaf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.core0922.basic.User;

@Controller
@RequestMapping("/basic")
public class BasicController {
	
	@GetMapping("/text-basic")
	public String textBasic(Model model) {
		model.addAttribute("data", "Hello Spring");
		return "basic/text-basic";
	}
	
	@GetMapping("/text-unescaped")
	public String textUnescaped(Model model) {
		model.addAttribute("data", "<b>Hello Spring</b>");
		return "basic/text-unescaped";
	}
	
	@GetMapping("/text-inline")
	public String textInline(Model model) {
		model.addAttribute("data", "<b>Hello Spring</b>");
		return "basic/text-inline";
	}
	
	@GetMapping("/variable")
	public String variable(Model model) {
		User userA = new User("UserA", 12);
		User userB = new User("UserB", 18);
		
		List<User> list = new ArrayList<>();
		list.add(userA);
		list.add(userB);
		
		Map<String, User> map = new HashMap<>();
		map.put(userA.getUsername(), userA);
		map.put(userB.getUsername(), userB);
		
		model.addAttribute("user", userA);
		model.addAttribute("usersList", list);
		model.addAttribute("usersMap", map);
		
		return "basic/variable";
	}
}
