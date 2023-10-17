package com.ex.mvcweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@SequenceGenerator(name = "order_item_seq_generator", sequenceName = "order_item_seq",
   initialValue = 1, allocationSize = 1)
@Getter @Setter @ToString
public class OrderItem {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_seq_generator")
   @Column(name = "order_item_id")
   private Long id;

   private int count;
   
   private int orderPrice;

   @ManyToOne
   @JoinColumn(name = "item_id")
   private Item item;

   @ManyToOne
   @JoinColumn(name = "order_id")
   private Order order;

   public static OrderItem createOrderItem(Item item, int price, int count){
      // ━━▶ price는 할인, 쿠폰 등 가격에 변동이 생겼을 때 비지니스 로직 작성 필요함.
      OrderItem orderItem = new OrderItem();
      orderItem.setItem(item);
      orderItem.setOrderPrice(price);
      orderItem.setCount(count);
      // ━━▶ 주문한 만큼 재고 조정해야 됨.
      item.removeStook(count);
      
      return orderItem;
   }

   public void cancel() {
      getItem().addStock(count);
   }

}
