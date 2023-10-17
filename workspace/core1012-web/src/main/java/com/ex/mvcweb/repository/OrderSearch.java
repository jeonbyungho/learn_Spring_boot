package com.ex.mvcweb.repository;

import com.ex.mvcweb.entity.OrderStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class OrderSearch {
   /** 회원 이름 */
   private String memberName;
   /** 주문 상태(ORDER, CANCLE) */
   private OrderStatus orderStatus;
}
