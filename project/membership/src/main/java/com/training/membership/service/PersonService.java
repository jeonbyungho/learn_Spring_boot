package com.training.membership.service;

import java.util.List;

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
	
	public Person login(String userid, String userpwd) {
		Person person = personRepository.login(userid, userpwd);
		return person;
	}
	
	public List<String> serachId(String email){
		return personRepository.searchId(email);
	}
}
