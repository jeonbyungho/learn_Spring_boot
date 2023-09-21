package com.training.membership.repository;

import com.training.membership.dto.Person;
import com.training.membership.dto.PersonJoinForm;
import com.training.membership.dto.PersonLoginForm;

public interface PersonRepository {
	public int join(PersonJoinForm form);
	public Person login(PersonLoginForm form);
}
