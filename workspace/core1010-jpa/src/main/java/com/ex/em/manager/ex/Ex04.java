package com.ex.em.manager.ex;

import java.time.LocalDateTime;

import com.ex.em.dto.Person;
import com.ex.em.dto.emb.Address;
import com.ex.em.dto.emb.Period;
import com.ex.em.manager.Manager;

public class Ex04 extends Manager{

   @Override
   public void execute() {
      try{
         tx.begin();

         Address address1 = new Address("서울", "노원", "123-456");
         Person person1 = new Person();
         person1.setName("user01");
         person1.setAddress(address1);
         person1.setWorkAddress(new Address("서울", "강남", null));
         person1.setPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));

         Address address2 = new Address("경기", "의정부", "123-456");
         Person person2 = new Person();
         person2.setName("user02");
         person2.setAddress(address2);
         person2.setPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));

         em.persist(person1);
         em.persist(person2);

         person2.setAddress(new Address("서울", "잠실", "321-654"));
         tx.commit();
      }catch(Exception e){
         tx.rollback();
         e.printStackTrace();
      }finally{
         em.close();
      }
      emf.close();

   }
   
}
