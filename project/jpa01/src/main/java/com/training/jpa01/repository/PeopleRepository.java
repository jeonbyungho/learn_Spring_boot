package com.training.jpa01.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.jpa01.dto.People;

public interface PeopleRepository extends CrudRepository<People, Long>{
	
}
