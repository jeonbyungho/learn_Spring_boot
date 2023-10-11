package com.ex.em.manager.ex;

import javax.persistence.Transient;

import com.ex.em.manager.Manager;
import com.ex.em.relation.Member;
import com.ex.em.relation.Team;

public class Ex02 extends Manager{

   @Transient
   @Override
   public void execute() {
      Team team = new Team();
      team.setName("1팀");
      em.persist(team);

      Member member1 = new Member();
      member1.setName("김철수");
      member1.setTeam(team);

      Member member2 = new Member();
      member2.setName("이영희");
      member2.setTeam(team);

      em.persist(member1);
      em.persist(member2);

      Member findMember = em.find(Member.class, 1L);
      
      System.out.println("Find Member : " + findMember.toString());
      emf.close();
   }

}
