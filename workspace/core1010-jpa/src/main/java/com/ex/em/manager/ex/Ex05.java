package com.ex.em.manager.ex;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Transient;

import com.ex.em.dto.Person;
import com.ex.em.dto.emb.Address;
import com.ex.em.dto.emb.Period;
import com.ex.em.manager.Manager;

public class Ex05 extends Manager{

   @Override
   public void execute() {
      try{
         tx.begin();

         Address address1 = new Address("서울", "노원", "123-456");
         Person person1 = new Person();
         person1.setName("철수");
         person1.setAddress(address1);
         person1.setWorkAddress(new Address("서울", "강남", null));
         person1.setPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));

         Address address2 = new Address("경기", "의정부", "123-456");
         Person person2 = new Person();
         person2.setName("영희");
         person2.setAddress(address2);
         person2.setPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));

         Person person3 = new Person();
         person3.setName("길동");
         person3.setAddress(new Address("서울", "영등포", "123-456"));
         person3.setPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));

         em.persist(person1);
         em.persist(person2);
         em.persist(person3);
         
         List<Person> results = em.createQuery("select p from Person p where p.address.city like '%서울%'").getResultList();

         tx.commit();
         System.out.println("Person Size -> " + results.size() + "명");
         for(Person p : results){
            System.out.println(p.getName());
         }
      }catch(Exception e){
         tx.rollback();
         e.printStackTrace();
      }finally{
         em.close();
      }
      emf.close();

   }
   
}
