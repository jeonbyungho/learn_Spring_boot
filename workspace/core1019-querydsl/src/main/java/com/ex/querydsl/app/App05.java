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
public class App05 {
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

         for(int i=0; i < 20; i++){
            Member m = new Member("member" + i, 10 + i , (i%2 == 0) ? teamA : teamB);
            em.persist(m);
         }

         em.flush();
         em.clear();
         System.out.println("────────────────────────────────────────────────");
         Tuple result = queryFactory.select(
            member.count(), member.age.sum(), member.age.avg(), member.age.max(), member.age.min())
            .from(member).fetchOne();
         
         List<Tuple> result2 = queryFactory.select(team.name, member.age.avg())
            .from(member)
            .join(member.team, team)
            .groupBy(team.name)
            .fetch();

         List<Tuple> result3 = queryFactory.select(team.name, member.age.avg())
            .from(member)
            .leftJoin(member.team, team)
            .groupBy(team.name)
            .having(member.age.avg().gt(19))
            .fetch();
         
         List<Tuple> result4 = queryFactory.select(member, team)
            .from(member)
            .join(member.team, team).on(team.name.eq("teamA"))
            .fetch();

         List<Tuple> result5 = queryFactory.select(member, team)
            .from(member)
            .join(member.team, team)
            .where(team.name.eq("teamA"))
            .fetch();
         
         List<Member> result6 = queryFactory.selectFrom(member)
            .where(member.age.eq(
               JPAExpressions.select(member.age.max()).from(member)
            ))
            .fetch();

         tx.commit();
         System.out.println("────────────────────────────────────────────────");
         System.out.println("\n집계 함수");
         System.out.println("count : " + result.get(member.count()));
         System.out.println("age.sum : " + result.get(member.age.sum()));
         System.out.println("age.avg : " + result.get(member.age.avg()));
         System.out.println("age.max : " + result.get(member.age.max()));
         System.out.println("age.min : " + result.get(member.age.min()));

         System.out.println("\ngroupBy");
         for(Tuple tuple : result2){
            System.out.println(tuple.toString());
         }

         System.out.println("\ngroupBy having avg().gt(19)");
         for(Tuple tuple : result3){
            System.out.println(tuple.toString());
         }

         System.out.println("\njoin on");
         for(Tuple tuple : result4){
            System.out.println(tuple.toString());
         }

         System.out.println("\njoin where");
         for(Tuple tuple : result5){
            System.out.println(tuple.toString());
         }

         System.out.println("\nSebQuery");
         for(Member m : result6){
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
