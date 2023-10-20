package com.ex.querydsl.app;

import com.ex.querydsl.entity.Member;
import com.ex.querydsl.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.ex.querydsl.entity.QMember.*;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App04 {
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

         for(int i=0; i < 50; i++){
            Member m = new Member("member" + i, 10 + i , (i%2 == 0) ? teamA : teamB);
            em.persist(m);
         }

         em.flush();
         em.clear();
         System.out.println("────────────────────────────────────────────────");
         List<Member> findByQueryDSL = queryFactory.selectFrom(member)
            .where(member.age.goe(30))
            .orderBy(member.age.desc(), member.username.asc().nullsLast())
            .fetch();
         List<Member> pagingByQueryDSL = queryFactory.selectFrom(member)
            .orderBy(member.username.desc())
            .offset(1)
            .limit(10)
            .fetch();
         tx.commit();
         System.out.println("────────────────────────────────────────────────");
         System.out.println("\nfindByQueryDSL");
         for(Member m : findByQueryDSL){
            System.out.println(m.toString());
         }
         System.out.println("\npagingByQueryDSL");
         for(Member m : pagingByQueryDSL){
            System.out.println(m.toString());
         }
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
