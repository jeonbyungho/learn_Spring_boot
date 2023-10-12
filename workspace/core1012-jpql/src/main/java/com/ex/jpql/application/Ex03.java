package com.ex.jpql.application;

import java.util.List;

import com.ex.jpql.dto.MemberDTO;
import com.ex.jpql.entity.Member;
import com.ex.jpql.entity.Team;

public class Ex03 extends Manager{

   @Override
   public void execute() {
      try{
         tx.begin();

         Member member1 = new Member();
         member1.setId(1L);
         member1.setName("유저1");
         member1.setAge(25);

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

         tx.commit();

         System.out.println("resultObjList");
         List<Object[]> resultObjList = em.createQuery("select m.name, m.age from Member m", Object[].class).getResultList();
         for(Object[] o : resultObjList){
            System.out.println("──> " + o[0] + " : " + o[1]);
         }

         System.out.println("resultDTOList");
         List<MemberDTO> resultDTOList = em.createQuery("select new com.ex.jpql.dto.MemberDTO(m.name, m.age) from Member m", MemberDTO.class).getResultList();
         for (MemberDTO m : resultDTOList) {
            System.out.println("──> " + m.toString());
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
