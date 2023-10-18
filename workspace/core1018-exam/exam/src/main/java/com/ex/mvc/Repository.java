package com.ex.mvc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ex.domain.*;

public class Repository {
   
   protected EntityManagerFactory emf;
   protected EntityManager em;
   
   public Repository(String unitName){
      emf = Persistence.createEntityManagerFactory(unitName);
      em = emf.createEntityManager();
   }

   public Repository(){
      this("hello");
   }

   public Member save(Member member){
      em.persist(member);
      return member;
   }

   public Member findById(Long id) {
      Member member = em.find(Member.class, id);
      return member;
   }

   public Order order(Order order) {
      em.persist(order);
      return order;
   }

}
