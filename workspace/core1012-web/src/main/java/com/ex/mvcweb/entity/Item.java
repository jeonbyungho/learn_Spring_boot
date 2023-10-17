package com.ex.mvcweb.entity;

import org.hibernate.annotations.DynamicUpdate;

import com.ex.mvcweb.exception.NotEnoughStockException;

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

   public void removeStook(int count) {
      int restStock = this.stockQuantity - count;
      // 재고가 부족할 경우..
      if(restStock < 0){
         throw new NotEnoughStockException("Not more Stock");
      }
      this.stockQuantity = restStock;
   }

   public void addStock(int count){
      this.stockQuantity += count;
   }
}
