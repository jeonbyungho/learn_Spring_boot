package com.training.jpa01.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.jpa01.dto.People;
import com.training.jpa01.repository.PeopleRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@RequestMapping("/people")
@Controller
public class PeopleController {
	
	private final PeopleRepository peopleRepository;
	private final EntityManager em;
	
	@Autowired
	public PeopleController(PeopleRepository peopleRepository, EntityManager em) {
		this.peopleRepository = peopleRepository;
		this.em = em;
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public @ResponseBody People login(@RequestParam String id, @RequestParam String password) {
		Query query = em.createQuery("select p from person p where p.id = :id and p.password = :password", People.class);
		query.setParameter("id", id);
		query.setParameter("password", password);
		People people = (People) query.getSingleResult();
		return people;
	}
	
	@GetMapping("/join")
	public String joinPage() {
		return "join";
	}
	
	@PostMapping("/join")
	public @ResponseBody People save(@ModelAttribute People people) {
		return peopleRepository.save(people);
	}
	
	@GetMapping("/all")
	public @ResponseBody Iterable<People> findAll() {
		return peopleRepository.findAll();
	}
	
	@GetMapping("/{idx}")
	public @ResponseBody Optional<People> findById(@PathVariable("idx") Long idx) {
		return peopleRepository.findById(idx);
	}
	
	@GetMapping("/count")
	public @ResponseBody long count() {
		return peopleRepository.count();
	}
	
}
