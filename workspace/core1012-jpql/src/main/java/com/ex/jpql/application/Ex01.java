package com.ex.jpql.application;

import java.util.List;

import com.ex.jpql.entity.Member;
import com.ex.jpql.entity.Team;

public class Ex01 extends Manager{

   @Override
   public void execute() {
      try{
         tx.begin();

         Member member1 = new Member();
         member1.setId(1L);
         member1.setName("유저1");


         Member member2 = new Member();
         member2.setId(2L);
         member2.setName("유저2");

         Team team1 = new Team();
         team1.setId(1L);
         team1.setName("1팀");

         team1.addMember(member1);
         team1.addMember(member2);

         em.persist(team1); 
         em.persist(member1); 
         em.persist(member2); 

         Member resultMember1 = 
            em.createQuery("select m from Member m where m.name = :username", Member.class)
               .setParameter("username", "유저1")
               .getSingleResult();

         List<Member> resultList = em.createQuery("select m from Member m", Member.class)
            .getResultList();

         // "select m.team from Member m"
         List<Team> resultTeamList = em.createQuery("select t from Member m join m.team t", Team.class)
            .getResultList(); // 위에 쿼리와 결과는 동일하나 join을 사용될 경우, 쿼리문 안에 join을 명시하는 걸 권장한다.

         tx.commit();
         System.out.println(resultMember1.getName());

         System.out.println("List");
         for(Member m : resultList){
            System.out.println(m.getName());
         }

         System.out.println("TeamList");
         for(Team t : resultTeamList){
            System.out.println(t.getName());
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
