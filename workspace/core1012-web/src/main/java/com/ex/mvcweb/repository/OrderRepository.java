package com.ex.mvcweb.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.mvcweb.entity.Order;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

   @Autowired
   private EntityManager em;

   public void save(Order order) {
      em.persist(order);
   }

   /**
    * 다수의 where 조건문을 처리하는 데 곤란한 방식이다.
    */
   @Deprecated
   public List<Order> _findAll(OrderSearch orderSearch) {
      String query = "select o from orders o fetch join o.member m "
         + "where o.status = :status "
         + "and m.name like :name ";
      return em.createQuery(query, Order.class)
         .setParameter("status", orderSearch.getOrderStatus())
         .setParameter("name", orderSearch.getMemberName())
         .setFirstResult(100)
         .setMaxResults(10)
         .getResultList();
   }

   public List<Order> findAll(OrderSearch orderSearch) { 
      return null;
   }
   
}
