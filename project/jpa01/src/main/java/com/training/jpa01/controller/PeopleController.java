package com.training.jpa01.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.jpa01.dto.People;
import com.training.jpa01.repository.PeopleRepository;

@RequestMapping("/people")
@Controller
public class PeopleController {
	
	private final PeopleRepository peopleRepository;
	
	@Autowired
	public PeopleController(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}
	
	@GetMapping("/all")
	public @ResponseBody Iterable<People> findAll() {
		return peopleRepository.findAll();
	}
	
	@GetMapping("/{idx}")
	public @ResponseBody Optional<People> findById(@PathVariable("idx") Long idx) {
		return peopleRepository.findById(idx);
	}
}
