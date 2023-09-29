package com.training.japform01.people;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends CrudRepository<People, Long>{
   
   @Query("select p from people p where p.userName = :userName and p.password = :password")
   public People login(@Param("userName") String name, @Param("password") String password);
}
