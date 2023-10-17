package com.ex.mvcweb.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
   private Member member;
   
   private LocalDate orderDate;

   @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
   @Setter(AccessLevel.NONE)
   private List<OrderItem> orderItems  = new ArrayList<>();

   private void addOrderItem(OrderItem orderItem) {
      this.orderItems.add(orderItem);
      orderItem.setOrder(this);
   }

   // public static Order createOrder(Member member, OrderItem orderItem) {
   //    Order order = new Order();
   //    order.setMember(member);
   //    order.addOrderItem(orderItem);
   //    order.setStatus(OrderStatus.ORDER);
   //    order.setOrderDate(LocalDate.now());
   //    return order;
   // }

   public static Order createOrder(Member member, OrderItem... orderItems) {
      Order order = new Order();
      order.setMember(member);
      for(OrderItem orderItem :orderItems){
         order.addOrderItem(orderItem);
      }
      order.setStatus(OrderStatus.ORDER);
      order.setOrderDate(LocalDate.now());
      return order;
   }

}
