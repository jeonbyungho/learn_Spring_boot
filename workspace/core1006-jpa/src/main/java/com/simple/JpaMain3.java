package com.simple;

import com.web.jpa.domain.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain3 {
   public static void main(String[] args) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
      EntityManager em = emf.createEntityManager();
      EntityTransaction tx = em.getTransaction();

      try {
         tx.begin();

         // 비영속 상태
         Member member = new Member();
         member.setId(100L);
         member.setName("Tester");

         // 영속 상태 돌입 : EntityManager안에 있는 영속 컨텍스트에 관리가 된다.
         System.out.println("-------befor-------");
         em.persist(member);
         System.out.println("-------after-------");
         em.detach(member);
         tx.commit();
         System.out.println("-------commit-------");
      } catch (Exception e) {
         e.printStackTrace();
         tx.rollback();
      } finally {
         em.close();
      }
      emf.close();
   }
   
}
