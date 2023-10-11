package com.ex.em.manager.ex;

import java.util.List;

import com.ex.em.manager.Manager;
import com.ex.em.relation.Member;
import com.ex.em.relation.Team;

public class Ex03flush extends Manager{

   @Override
   public void execute() {
      try{
         tx.begin();
         // 1팀
         Team team1 = new Team();
         team1.setName("1팀");

         Member member1 = new Member();
         member1.setName("김철수");
         member1.setTeam(team1);

         Member member2 = new Member();
         member2.setName("이영희");
         member2.setTeam(team1);

         // 2팀
         Team team2 = new Team();
         team2.setName("2팀");

         Member member3 = new Member();
         member3.setName("홍길동");
         member3.setTeam(team2);

         Member member4 = new Member();
         member4.setName("이순신");
         member4.setTeam(team2);

         // 영속성 컨텍스트
         em.persist(team1);
         em.persist(team2);
         em.persist(member1);
         em.persist(member2);
         em.persist(member3);
         em.persist(member4);

         em.flush();
         em.clear();
         /* flush를 하지 않을 경우.
          * team이 영속성 컨텍스트에 들어가 있으나, 1차 캐시에 member의 team_id가 할당되지 않는 상태로
          * select 시 team_id가 온전히 조회되지 않는다.
         */
         
         // select * from Team t where t.TEAM_ID=?
         Team findTeam = em.find(Team.class, team2.getId());
         // Team.getMembers() : select * from Member m where m.TEAM_ID=?
         List<Member> members = findTeam.getMembers();

         tx.commit();
         System.out.println("─────Team──────");
         for(Member m : members){
            System.out.println(m.getTeam().getName() + "=" + m.getName());
         }
         System.out.println("───────────────");
         
      }catch(Exception e){
         tx.rollback();
         e.printStackTrace();
      }finally{
         em.close();
      }
      emf.close();
   }

}
