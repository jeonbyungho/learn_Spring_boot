package com.ex.mvcweb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.mvcweb.dto.OrderForm;
import com.ex.mvcweb.entity.Item;
import com.ex.mvcweb.entity.Member;
import com.ex.mvcweb.entity.Order;
import com.ex.mvcweb.entity.OrderItem;
import com.ex.mvcweb.repository.ItemRepository;
import com.ex.mvcweb.repository.MemberRepository;
import com.ex.mvcweb.repository.OrderRepository;
import com.ex.mvcweb.repository.OrderSearch;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
   private final OrderRepository orderRepository;
   private final MemberRepository memberRepository;
   private final ItemRepository itemRepository;

   @Transactional
   public Long add(OrderForm orderFrom) {
      Member member = memberRepository.findById(orderFrom.getMemberId());
      Item item = itemRepository.finById(orderFrom.getItemId());

      OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), orderFrom.getCount());
      Order order = Order.createOrder(member, orderItem);
      
      orderRepository.save(order);
      return order.getId();
   }
   
   public List<Order> findAll(OrderSearch orderSearch) {
      return orderRepository.findAll(orderSearch);
   }

   @Transactional
   public void cancelOrder(Long orderId) {
      Order order = orderRepository.findOne(orderId);
      /*
       * 주문 취소 시 수량 update, 상태 값 변경에 처리 각각 해줘야 하나
       * 데이터들만 바꿔주면 JPA는 해당 값들을 변경을 하고 (변경 감지, 변경 내용 감지)
       * 변경내역 감지가 변경된 내용들을 다 찾아서 데이터베이스에 업데이트 쿼리가 전송된다.
       * 여기서 Order의 상태 변경 update, Item의 stockQuantity가 변경된다.
       */
      order.cancel();
   }
}