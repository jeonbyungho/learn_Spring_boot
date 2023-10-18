package com.ex.mvc;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import com.ex.domain.*;

public class Service {
   private Repository repository;

   public Service(){
      repository = new Repository();
   }

   @Transactional
   public Member join(String name, String city, String street, String zipcode){
      Member member = new Member();
      member.setName(name);
      member.setAddress(new Address(city, street, zipcode));
      return repository.save(member);
   }

   @Transactional
   public Member byId(Long id){
      return repository.findById(id);
   }

   @Transactional
   public Order order(Member member, String status){
      Order order = new Order();
      order.setStatus(status);
      order.setOrderdate(LocalDateTime.now());
      order.setMember(member);
      member.getOrders().add(order);
      return repository.order(order);
   }
}
