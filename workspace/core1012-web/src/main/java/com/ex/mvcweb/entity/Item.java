package com.ex.mvcweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@SequenceGenerator(name = "item_seq_generator", sequenceName = "item_seq",
   initialValue = 1, allocationSize = 1)
@Getter @Setter @ToString
public class Item {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq_generator")
   @Column(name = "item_id")
   private Long id;

   private String name;

   private Integer price;

   private Integer stockQuantity;

   // 양방향 매핑은 선택사항이다.
   /*
   @OneToMany(mappedBy = "item")
   private List<OrderItem> orderItems = new ArrayList<>();
   public void addOrderItem(OrderItem orderItem){
      orderItem.setItem(this);
      this.orderItems.add(orderItem);
   }
   */
}
