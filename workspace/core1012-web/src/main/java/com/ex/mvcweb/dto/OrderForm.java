package com.ex.mvcweb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class OrderForm {
   private Long memberId;
   private Long itemId;
   private Integer count;
}
