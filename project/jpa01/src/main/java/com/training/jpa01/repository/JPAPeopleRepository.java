package com.training.jpa01.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.jpa01.dto.People;

import jakarta.persistence.EntityManager;

public class JPAPeopleRepository implements PeopleRepository{
	
private final EntityManager em;
	
	@Autowired
	public JPAPeopleRepository(EntityManager em) {
		this.em = em;
	}
}
