package com.ex.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "orders")
@SequenceGenerator(
   name = "order_seq_generator", sequenceName = "order_seq",
   initialValue = 1, allocationSize = 1)
@Getter @Setter @ToString(exclude = "member")
public class Order {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_generator")
   @Column(name = "order_id")
   private Long id;

   private LocalDateTime orderdate;

   private String status;

   @ManyToOne
   @JoinColumn(name = "member_id")
   private Member member;
   
}
