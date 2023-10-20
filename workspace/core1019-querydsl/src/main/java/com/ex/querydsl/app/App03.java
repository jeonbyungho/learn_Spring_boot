package com.ex.querydsl.app;

import com.ex.querydsl.entity.Member;
import com.ex.querydsl.entity.QMember;
import com.ex.querydsl.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.ex.querydsl.entity.QMember.*;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App03 {
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
         System.out.println("────────────────────────────────────────────────");
         QMember m = member;
         List<Member> findByQueryDSL = queryFactory.selectFrom(m)
            .where(m.username.startsWith("member"), m.age.between(20, 30))
            .fetch();
         Member findByQueryDSL2 = queryFactory.selectFrom(m).where(m.username.eq("member04")).fetchOne();
         Member findByQueryDSL3 = queryFactory.selectFrom(m).fetchFirst();
         Member findByQueryDSL4 = queryFactory.selectFrom(m).limit(1).fetchOne();
         Long countQueryDSL = queryFactory.select(m.count()).from(m).fetchOne();
         tx.commit();
         System.out.println("────────────────────────────────────────────────");
         System.out.println("fetch : " + findByQueryDSL.toString());
         System.out.println("fetchOne : " + findByQueryDSL2.toString());
         System.out.println("fetchFirst : " + findByQueryDSL3.toString());
         System.out.println("limit(1) fetchOne : " + findByQueryDSL4.toString());
         System.out.println("count : " + countQueryDSL);
         System.out.println("────────────────────────────────────────────────");
      } catch (Exception e){
         tx.rollback();
         e.printStackTrace();
      } finally {
         em.close();
         emf.close();
      }

   }
}
