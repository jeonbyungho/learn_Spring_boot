package com.ex.querydsl.app;

import com.ex.querydsl.entity.Member;
import com.ex.querydsl.entity.MemberDTO;
import com.ex.querydsl.entity.Team;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.ex.querydsl.entity.QMember.*;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
public class App08 {
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

         for(int i=0; i < 8; i++){
            Member m = new Member("member" + i, 10 + i , (i%2 == 0) ? teamA : teamB);
            em.persist(m);
         }

         em.flush();
         em.clear();
         System.out.println("────────────────────────────────────────────────");
         String query = "select new com.ex.querydsl.entity.MemberDTO(m.username, m.age)"
            + "from Member m";
         List<MemberDTO> result1 = em.createQuery(query, MemberDTO.class).getResultList(); 

         // 프로퍼티 접근 JavaBeans(getter, setter)
         /* @param type 반환될 데이터 타입
          * @params exprs value ... value`n
          */
         List<MemberDTO> result2 = queryFactory
            .select(Projections.bean(MemberDTO.class, member.username, member.age))
            .from(member)
            .fetch();
         // 필드 접근 getter, setter 없이 사용 가능
         List<MemberDTO> result3 = queryFactory
            .select(Projections.fields(MemberDTO.class, member.username, member.age))
            .from(member)
            .fetch();
         // 생성자
         List<MemberDTO> result4 = queryFactory
            .select(Projections.constructor(MemberDTO.class, member.username, member.age))
            .from(member)
            .fetch();

         tx.commit();
         System.out.println("────────────────────────────────────────────────");
         for(MemberDTO m: result1){
            System.out.println(m.toString());
         }

         System.out.println("\nQueryDSL Property");
         for(MemberDTO m: result2){
            System.out.println(m.toString());
         }

         System.out.println("\nQueryDSL Field");
         for(MemberDTO m: result3){
            System.out.println(m.toString());
         }

         System.out.println("\nQueryDSL Constructor");
         for(MemberDTO m: result4){
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
