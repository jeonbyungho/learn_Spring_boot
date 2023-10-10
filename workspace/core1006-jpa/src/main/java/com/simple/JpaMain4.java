package com.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain4 {
   public static void main(String[] args) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
      EntityManager em = emf.createEntityManager();
      EntityTransaction tx = em.getTransaction();

      try {
         tx.begin();
         Person person1 = new Person();
         person1.setUsername("JPA Student");

         Person person2 = new Person();
         person2.setUsername("Spring Boot");

         em.persist(person1);
         em.persist(person2);
         tx.commit();
      } catch (Exception e) {
         e.printStackTrace();
         tx.rollback();
      } finally {
         em.close();
      }
      emf.close();
   }
}
