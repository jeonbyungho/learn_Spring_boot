package com.ex.jpql.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Orders")
@Getter @Setter
public class Order {
   @Id
   private Long id;
   private int orderAmount;

   @Embedded
   private Address address;
}
