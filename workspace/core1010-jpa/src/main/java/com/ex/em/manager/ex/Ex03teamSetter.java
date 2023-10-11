package com.ex.em.manager.ex;

import java.util.List;

import javax.persistence.Transient;

import com.ex.em.manager.Manager;
import com.ex.em.relation.Member;
import com.ex.em.relation.Team;

public class Ex03teamSetter extends Manager{

   @Transient
   @Override
   public void execute() {
      // Team
      Team team1 = new Team();
      team1.setName("1팀");
      Team team2 = new Team();
      team2.setName("2팀");

      // Member
      Member member1 = new Member();
      member1.setName("김철수");
      Member member2 = new Member();
      member2.setName("이영희");
      Member member3 = new Member();
      member3.setName("홍길동");
      Member member4 = new Member();
      member4.setName("이순신");

      team1.addMember(member1);
      team1.addMember(member2);

      team2.addMember(member3);
      team2.addMember(member4);

      // 영속성 컨텍스트
      em.persist(team1);
      em.persist(member1);
      em.persist(member2);

      em.persist(team2);
      em.persist(member3);
      em.persist(member4);
      
      System.out.println("──────Team──────");
      // select * from Team t where t.TEAM_ID=?
      Team findTeam = em.find(Team.class, team1.getId());
      // Team.getMembers() : select * from Member m where m.TEAM_ID=?
      List<Member> members = findTeam.getMembers();
      
      System.out.println(members.size());
      for(Member m : members){
         System.out.println(m.getTeam().getName() + "=" + m.getName());
      }

      System.out.println("───────────────");
      
      emf.close();
   }

}
