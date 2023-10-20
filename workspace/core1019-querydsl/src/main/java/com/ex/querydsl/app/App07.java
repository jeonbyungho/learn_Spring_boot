package com.ex.querydsl.app;

import com.ex.querydsl.entity.Member;
import com.ex.querydsl.entity.Team;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.ex.querydsl.entity.QMember.*;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
public class App07 {
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
         
         List<Tuple> result1 = queryFactory
            .select(member.username, Expressions.constant("A"))
            .from(member)
            .fetch();

         List<String> result2 = queryFactory
            .select(member.username.concat("_").concat(member.age.stringValue()))
            .from(member)
            .where(member.username.endsWith("1"))
            .fetch();

         tx.commit();
         System.out.println("────────────────────────────────────────────────");
         System.out.println("\nConstant");
         System.out.println(result1.toString());
         System.out.println("\nConcat 문자열 연결");
         System.out.println(result2.toString());
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
