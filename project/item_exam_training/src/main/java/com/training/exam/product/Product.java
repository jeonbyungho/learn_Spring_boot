package com.training.exam.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class Product {
   
   private Long id;           // 식별 번호
   private String name;       // 상품 이름
   private Integer price;     // 가격
	private Integer quantity;  // 수량
   
}
