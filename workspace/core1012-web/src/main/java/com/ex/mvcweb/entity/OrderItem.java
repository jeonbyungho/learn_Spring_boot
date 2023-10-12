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

   private Integer count;
   
   private Integer orderPrice;

   @ManyToOne
   @JoinColumn(name = "item_id")
   private Item item;

   @ManyToOne
   @JoinColumn(name = "order_id")
   private Order order;

}
