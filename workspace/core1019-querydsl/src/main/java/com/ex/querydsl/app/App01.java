package com.ex.querydsl.app;

import com.ex.querydsl.entity.Member;
import com.ex.querydsl.entity.Team;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App01 {
   public static void main(String[] args) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
      EntityManager em = emf.createEntityManager();
      EntityTransaction tx = em.getTransaction();

      tx.begin();
      try {
         Team teamA = new Team("teamA");
         Team teamB = new Team("teamB");
         em.persist(teamA);
         em.persist(teamB);

         Member member1 = new Member("member01", 10, teamA);
         Member member2 = new Member("member02", 20, teamB);
         Member member3 = new Member("member03", 30, teamA);
         Member member4 = new Member("member04", 40, teamB);

         em.persist(member1);
         em.persist(member2);
         em.persist(member3);
         em.persist(member4);

         em.flush();
         em.clear();
         
         List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

         for(Member m : members){
            System.out.println(m.toString());
         }
         tx.commit();
         
      } catch (Exception e){
         tx.rollback();
         e.printStackTrace();
      } finally {
         em.close();
         emf.close();
      }

   }
}
