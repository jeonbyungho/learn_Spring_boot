package com.ex.querydsl.app;

import com.ex.querydsl.entity.Member;
import com.ex.querydsl.entity.MemberDTO;
import com.ex.querydsl.entity.Team;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.ex.querydsl.entity.QMember.*;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
public class App09 {
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

         for(int i=1; i < 10; i++){
            Member m = new Member("member" + i, 10 + i , (i%2 == 0) ? teamA : teamB);
            em.persist(m);
         }

         em.flush();
         em.clear();
         System.out.println("────────────────────────────────────────────────");
         List<String> result1 = queryFactory.select(member.username).from(member).fetch();

         String name = "member5";
         Integer age = 14;
         List<Member> result2 = searchMember(name, age, queryFactory);
         name = null;
         List<Member> result3 = searchMember(name, age, queryFactory);
         age = null;
         List<Member> result4 = searchMember(name, age, queryFactory);
         tx.commit();
         System.out.println("────────────────────────────────────────────────");
         System.out.println("\nString");
         for(String m: result1){
            System.out.println(m.toString());
         }

         System.out.println("\nBooleanBuilder");
         for(Member m: result2){
            System.out.println(m.toString());
         }

         System.out.println("\nBooleanBuilder name is null");
         for(Member m: result3){
            System.out.println(m.toString());
         }

         System.out.println("\nBooleanBuilder name, age is null");
         for(Member m: result4){
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

   private static List<Member> searchMember(String username, Integer age, JPAQueryFactory queryFactory){
      BooleanBuilder booleanBuilder = new BooleanBuilder();
      if( username != null){
         booleanBuilder.and(member.username.eq(username));
      }
      if( age != null){
         booleanBuilder.and(member.age.gt(age));
      }
      System.out.println("BooleanBuilder : " + booleanBuilder.toString());
      return queryFactory.select(member).from(member).where(booleanBuilder).fetch();
   }
}
