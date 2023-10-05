package com.web.jpa.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
   public static void main(String[] args) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
      EntityManager em = emf.createEntityManager();
      EntityTransaction tx = em.getTransaction();

      Member member = new Member();
      member.setId(3L);
      member.setName("Tester");
      
      try {
         tx.begin();
         em.persist(member);
         tx.commit();
      } catch (Exception e) {
         tx.rollback();
      } finally {
         em.close();
      }
      emf.close();
   }
   
}
