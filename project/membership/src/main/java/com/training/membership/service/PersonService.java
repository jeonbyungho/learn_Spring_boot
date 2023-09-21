package com.training.membership.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.membership.dto.*;
import com.training.membership.repository.*;

@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public int join(PersonJoinForm form) {
		return personRepository.join(form);
	}
	
	public Person login(PersonLoginForm form) {
		Person person = personRepository.login(form);
		return person;
	}
}
