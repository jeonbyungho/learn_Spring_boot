package com.training.jpa01.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.jpa01.dto.People;

public interface PeopleRepository extends CrudRepository<People, Long>{
	
	@Query("select p "
			+ "from person p "
			+ "where p.id = :id and p.password = :password")
	public People login(
			@Param("id") String id, @Param("password") String password);
}
