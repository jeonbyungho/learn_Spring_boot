package com.ex.mvcweb.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.mvcweb.entity.Order;
import com.ex.mvcweb.entity.OrderStatus;
import com.ex.mvcweb.entity.QMember;
import com.ex.mvcweb.entity.QOrder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

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
      String query = "select o from orders o join o.member m "
         + "where o.status = :status "
         + "and m.name like :name ";
      return em.createQuery(query, Order.class)
         .setParameter("status", orderSearch.getOrderStatus())
         .setParameter("name", orderSearch.getMemberName())
         .setFirstResult(1)
         .setMaxResults(10)
         .getResultList();
   }

   public List<Order> findAll(OrderSearch orderSearch) {
      JPAQueryFactory query = new JPAQueryFactory(em);
      QOrder order = QOrder.order;
      QMember member = QMember.member;
      return query.selectFrom(order)
         .leftJoin(order.member, member).fetchJoin()
         .where(statusEq(orderSearch.getOrderStatus()),
               nameLike(orderSearch.getMemberName()))
         .fetch();
   }
   
   private BooleanExpression statusEq(OrderStatus orderStatus) {
      if(orderStatus == null) return null;
      return QOrder.order.status.eq(orderStatus);
   }

   private BooleanExpression nameLike(String memberName){
      if(memberName == null || memberName.equals("")){
         return null;
      }
      return QMember.member.name.contains(memberName);
   }

   public Order findOne(Long orderId) {
      return em.find(Order.class, orderId);
   }
}
