package com.ex.jpql.application;

import java.util.List;

import com.ex.jpql.entity.Member;
import com.ex.jpql.entity.Team;

public class Ex05 extends Manager{

   @Override
   public void execute() {
      try{
         tx.begin();

         Member member1 = new Member();
         member1.setId(1L);
         member1.setName("member1");
         member1.setAge(10);

         Member member2 = new Member();
         member2.setId(2L);
         member2.setName("유저2");
         member2.setAge(22);

         Team team1 = new Team();
         team1.setId(1L);
         team1.setName("1팀");

         team1.addMember(member1);
         team1.addMember(member2);

         em.persist(team1); 
         em.persist(member1); 
         em.persist(member2); 

         Team team2 = new Team();
         team2.setId(2L);
         team2.setName("2팀");
         em.persist(team2); 
         
         member1.changeTeam(team2);

         List<Member> resultObjList = 
            em.createQuery("select m from Member m join m.team t", Member.class)
            .getResultList();

         Member resultMember = em.createQuery("select m from Member m" +
            " where m.age > (select avg(sm.age) from Member sm)"
            , Member.class).getSingleResult();
         tx.commit();

         System.out.println("────result────\n" + resultObjList.toString());
         System.out.println("────result────\n" + resultMember.toString());

      } catch (Exception e){
         e.printStackTrace();
         tx.rollback();
      } finally {
         em.close();
         emf.close();
      }
   }
}
