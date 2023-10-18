package com.ex;

import java.util.List;

import com.ex.domain.*;
import com.ex.mvc.Service;

public class Problem {
   
   private Service service;

   public Problem(){
      service = new Service();
   }

   public Long p1(int orderCount) {
      // 객체 생성
      Member member = this.service.join("member", "서울", "거꾸로해도 역삼역", "123");

      for(int i = 0; i < orderCount; i++){
         String str = "접수" + i;
         service.order(member, str);
      }
      return member.getId();
   }
   
   public void p1_out(Long id) {
      // 조회 후 출력
      Member findMember = this.service.byId(id);
      System.out.println("Member = " + findMember.toString());
      List<Order> orders = findMember.getOrders();
      for (Order order : orders){
         System.out.println(order.toString());
      }
   }

   public void p2(){
      // 엔티티 객체로부터 임베디드 타입 객체 분리
      Member member = this.service.join("person", "경기", "의정부역", "123");
      long id = member.getId();

      Member findMember = this.service.byId(id);
      Address address = findMember.getAddress(); // 임베디드 타입
      System.out.println("Address = " + address.toString());
   }
}
