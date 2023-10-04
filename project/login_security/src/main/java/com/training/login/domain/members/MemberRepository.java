package com.training.login.domain.members;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
   private static Map<Long, Member> store = new HashMap<Long, Member>();
   private static Long sequence = 0L;

   public Member save(Member member){
      member.setId(++sequence);
      store.put(member.getId(), member);
      System.out.println("New "+ member.toString());
      return member;
   }

   public Member findById(Long id){
      return store.get(id);
   }

   public List<Member> findAll(){
      return new ArrayList<Member>(store.values());
   }

   public Member findByLoginId(String loginId, String password){
      List<Member> all = findAll();
      for(Member member : all) {
         if(member.getLoginId().equals(loginId)
         && member.getPassword().equals(password)){
            System.out.println("Login " + member.toString());
            return member;
         }
      }
      return null;
   }
}
