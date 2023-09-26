package com.web.item.domain.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("basic/items")
public class BasicItemController {
	
	@GetMapping
	public String items() {
		return "basic/items";
	}
}
