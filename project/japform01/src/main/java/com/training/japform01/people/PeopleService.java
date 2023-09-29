package com.training.japform01.people;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PeopleService {
   
   private final PeopleRepository peopleRepository;

   public People signUp(PeopleForm peopleForm){
      if(peopleForm == null) return null;
      People people = new People();
      people.setUserName(peopleForm.getUserName());
      people.setPassword(peopleForm.getPassword());
      people.setRealName(peopleForm.getRealName());
      people.setAge(peopleForm.getAge());
      people.setEmail(peopleForm.getEmail());
      return peopleRepository.save(people);
   }

   public People signIn(String name, String password){
      return peopleRepository.login(name, password);
   }
}
