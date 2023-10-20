package com.ex.querydsl.app;

import com.ex.querydsl.entity.Member;
import com.ex.querydsl.entity.Team;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.ex.querydsl.entity.QMember.*;
import static com.ex.querydsl.entity.QTeam.*;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
public class App06 {
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
         
         List<Member> result = queryFactory.selectFrom(member)
            .where(member.age.goe(
               JPAExpressions.select(member.age.avg()).from(member)
            ))
            .fetch();
         Double avgAge = queryFactory.select(member.age.avg()).from(member).fetchOne();

         List<Tuple> result2 = queryFactory
            .select(member.username, 
               JPAExpressions
                  .select(member.age.avg())
                  .from(member))
            .from(member)
            .fetch();
         
         List<String> result3 = queryFactory.select(
               member.age
                  .when(10).then("열살")
                  .when(20).then("스무살")
                  .when(30).then("서른살")
                  .otherwise("기타")
            ).from(member)
            .fetch();

         tx.commit();
         System.out.println("────────────────────────────────────────────────");
         System.out.println("\n평균 나이보다 많은 회원들");
         for(Member m : result){
            System.out.println(m.toString());
         }
         System.out.println("평균 나이 : " + avgAge);

         System.out.println("\nselect sub query");
         for(Tuple t : result2){
            System.out.println(t.get(member.username));
            System.out.println("Age : " + t.get(
               JPAExpressions.select(member.age.avg()).from(member)
            ));
         }

         System.out.println(result3.toString());
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
