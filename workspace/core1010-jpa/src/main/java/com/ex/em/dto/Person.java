package com.ex.em.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Person {
   @Id
   @GeneratedValue
   @Column(name = "PERSON_ID")
   private Long id;

   @Column(name = "USERNAME")
   private String name;

   @OneToMany(mappedBy = "person")
   private List<Orders> orderss = new ArrayList<>();
   
   public void addOrder(Orders orders){
      orders.setMember(this);
      this.orderss.add(orders);
   }

   @Embedded
   private Address address;
}
