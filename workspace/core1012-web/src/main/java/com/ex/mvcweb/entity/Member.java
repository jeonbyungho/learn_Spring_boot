package com.ex.mvcweb.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq",
   initialValue = 1, allocationSize = 1)
@Getter @Setter @ToString(exclude = "orders")
public class Member {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
   @Column(name = "member_id")
   private Long id;

   private String name;
   
   @Embedded
   private Address address;

   @OneToMany(mappedBy = "member")
   private List<Order> orders = new ArrayList<>();
   
   public void addOrder(Order order){
      order.setMember(this);
      this.orders.add(order);
   }
}
