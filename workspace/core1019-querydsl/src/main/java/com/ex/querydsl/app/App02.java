package com.ex.querydsl.app;

import com.ex.querydsl.entity.Member;
import com.ex.querydsl.entity.QMember;
import com.ex.querydsl.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App02 {
   public static void main(String[] args) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
      EntityManager em = emf.createEntityManager();
      EntityTransaction tx = em.getTransaction();
      JPAQueryFactory queryFactory = new JPAQueryFactory(em);

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
         
         String jpqlString = "select m from Member m where m.username = :username";
         Member findByJpql = em.createQuery(jpqlString, Member.class)
            .setParameter("username", "member01")
            .getSingleResult();
         System.out.println("findByJpql Member : " + findByJpql);

         QMember m = new QMember("m"); // QMember의 별칭 지정.
         Member findByQueryDSL = queryFactory.select(m).from(m).where(m.username.eq("member01")).fetchOne();
         System.out.println("findByDSL Member : " + findByQueryDSL);
         
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
