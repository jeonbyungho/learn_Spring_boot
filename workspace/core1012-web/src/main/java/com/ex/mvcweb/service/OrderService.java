package com.ex.mvcweb.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.mvcweb.dto.OrderFrom;
import com.ex.mvcweb.entity.Item;
import com.ex.mvcweb.entity.Member;
import com.ex.mvcweb.entity.Order;
import com.ex.mvcweb.entity.OrderItem;
import com.ex.mvcweb.repository.ItemRepository;
import com.ex.mvcweb.repository.MemberRepository;
import com.ex.mvcweb.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
   private final OrderRepository orderRepository;
   private final MemberRepository memberRepository;
   private final ItemRepository itemRepository;

   @Transactional
   public Long add(OrderFrom orderFrom) {
      Member member = memberRepository.findById(orderFrom.getMemberId());
      Item item = itemRepository.finById(orderFrom.getItemId());

      OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), orderFrom.getCount());
      Order order = Order.createOrder(member, orderItem);
      
      orderRepository.save(order, orderItem);
      return order.getId();
   }
}