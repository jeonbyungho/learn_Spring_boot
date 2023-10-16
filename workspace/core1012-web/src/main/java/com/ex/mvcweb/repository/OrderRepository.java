package com.ex.mvcweb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.mvcweb.entity.Order;
import com.ex.mvcweb.entity.OrderItem;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

   @Autowired
   private EntityManager em;

   public void save(Order order, OrderItem orderItem) {
      em.persist(orderItem);
      em.persist(order);
   }
   
}
