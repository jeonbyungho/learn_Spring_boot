package com.simple;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain2 {
   public static void main(String[] args) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
      EntityManager em = emf.createEntityManager();
      EntityTransaction tx = em.getTransaction();

      try {
         tx.begin();
         // JPA는 쿼리를 짤 때 테이블을 대상으로 쿼리를 작성하지 않고 Member Varible 객체를 통해서 쿼리를 작성한다.
         List<Member> result = 
            em.createQuery("select m from Member as m", Member.class)
               .setFirstResult(1)
               .setMaxResults(9)
               .getResultList();
         
         for(Member m : result){
            System.out.println(m.toString());
         }

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
