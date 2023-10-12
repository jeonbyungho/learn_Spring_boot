package com.ex.jpql.application;

import com.ex.jpql.entity.Address;
import com.ex.jpql.entity.Order;

public class Ex02 extends Manager{

   @Override
   public void execute() {
      try{
         tx.begin();

         Order order = new Order();
         order.setId(1L);
         order.setAddress(new Address("서울", "강남", "123"));

         em.persist(order);

         Address address = em.createQuery("select o.address from Order o", Address.class)
            .getSingleResult();
         tx.commit();

         System.out.println(address.getCity());
         System.out.println(address.getStreet());
         System.out.println(address.getZipcode());
      } catch (Exception e){
         e.printStackTrace();
         tx.rollback();
      } finally {
         em.close();
         emf.close();
      }
   }
}
