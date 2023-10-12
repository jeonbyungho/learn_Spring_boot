package com.ex.jpql.application;

import java.util.List;

import com.ex.jpql.entity.Member;
import com.ex.jpql.entity.Team;


public class Ex04 extends Manager{

   @Override
   public void execute() {
      try{
         tx.begin();

         Team team1 = new Team();
         team1.setId(1L);
         team1.setName("1팀");
         em.persist(team1);
         for(int i = 1; i <= 100; i++){
            Member member = new Member();
            member.setId((long) i);
            member.setAge((int) (Math.random()*100));
            member.setName("유저"+i);
            team1.addMember(member);
            em.persist(member);
         }

         String jpql = "select m from Member m order by m.age desc";
         List<Member> resultList = em.createQuery(jpql, Member.class)
            .setFirstResult(1)
            .setMaxResults(20)
            .getResultList();

         tx.commit();

         for(Member m :resultList){
            System.out.println(m.toString());
         }
      } catch (Exception e){
         e.printStackTrace();
         tx.rollback();
      } finally {
         em.close();
         emf.close();
      }
   }
}
