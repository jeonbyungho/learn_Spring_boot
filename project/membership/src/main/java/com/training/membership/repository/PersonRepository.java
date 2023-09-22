package com.training.membership.repository;

import java.util.List;

import com.training.membership.dto.Person;
import com.training.membership.dto.PersonJoinForm;

public interface PersonRepository {
	public int join(PersonJoinForm form);
	public Person login(String id, String password);
	public List<String> searchId(String email);
}
