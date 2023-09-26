package com.training.jpa01.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.jpa01.dto.People;

@Repository
public interface PeopleRepository {
	
	@Query("select * from person p where p.idx = :idx")
	public People findByIdx(@Param("idx") Integer idx);
}
