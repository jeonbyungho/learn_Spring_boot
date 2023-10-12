package com.ex.mvcweb.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "orders")
@SequenceGenerator(name = "order_seq_generator", sequenceName = "order_seq",
   initialValue = 1, allocationSize = 1)
@Getter @Setter @ToString(exclude = "orderItems")
public class Order {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_generator")
   @Column(name = "order_id")
   private Long id;

   @Enumerated(EnumType.STRING)
   private OrderStatus status;

   @ManyToOne
   @JoinColumn(name="member_id")
   @Setter(value = AccessLevel.NONE)
   private Member member;
   
   private LocalDate orderDate;

   @OneToMany(mappedBy = "order")
   private List<OrderItem> orderItems  = new ArrayList<>();

   public void setMember(Member member) {
      member.addOrder(this);
      this.member = member;
   }
   
   public void addOrderItem(OrderItem orderItem){
      orderItem.setOrder(this);
      this.orderItems.add(orderItem);
   }

}
