package com.ex.mvcweb.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ItemForm {
   private Long id;
   
   @NotEmpty(message = "상품명을 적어주세요.")
   private String name;

   private Integer price;

   private Integer stockQuantity;
}
