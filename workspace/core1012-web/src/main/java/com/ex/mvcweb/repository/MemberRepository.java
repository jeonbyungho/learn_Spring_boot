package com.ex.mvcweb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.mvcweb.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
   
   /* spring이 EntityManager를 만들어 주입해주는 어노테이션
    * @PersistenceContext가 표준 EntityManager 주입을 해준다.
    * 그러나, @Autowired가 주입이 되도록 이러한 지원을 해준다.
    */
   //@PersistenceContext
   @Autowired
   private EntityManager em;
   
   public void save(Member member) {
      em.persist(member);
   }

   public List<Member> findAll(int page) {
      TypedQuery<Member> query = em.createQuery("select m from Member m order by m.id desc", Member.class)
         .setFirstResult(page*3)
         .setMaxResults(3);
      ArrayList<Member> list = 
         new ArrayList<Member>(query.getResultList());
      return list;
   }

   public List<Member> findByName(String name) {
      List<Member> list = em
         .createQuery("select m from Member m where m.name = :name", Member.class)
         .setParameter("name", name)
         .getResultList();
      return list;
   }
}
