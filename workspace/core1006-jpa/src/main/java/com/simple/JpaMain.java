package com.simple;

import com.web.jpa.domain.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
   public static void main(String[] args) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
      EntityManager em = emf.createEntityManager();
      EntityTransaction tx = em.getTransaction();

      Member member1 = new Member();
      member1.setId(4L);
      member1.setName("Tester");
      member1.setAge(22);

      Member member2 = new Member();
      member2.setId(5L);
      member2.setName("User01");
      member2.setAge(31);
      try {
         tx.begin();
         // insert
         em.persist(member1);
         em.persist(member2);

         //select
         Member findMember = em.find(Member.class, 1);
         System.out.println("───[Result] "  + findMember.toString());

         //update
         findMember.setAge(55);
         findMember.setName("updateUser");
         em.persist(findMember);

         //delete
         em.remove(member1);
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
