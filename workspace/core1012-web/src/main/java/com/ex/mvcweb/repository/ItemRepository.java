package com.ex.mvcweb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.mvcweb.entity.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
   
   @Autowired
   private final EntityManager em;

   public Item save(Item item) {
      em.persist(item);
      return item;
   }

   public List<Item> findAll(int page) {
      TypedQuery<Item> query = em.createQuery("select m from Item m order by m.id desc", Item.class)
         .setFirstResult(page*3)
         .setMaxResults(3);
      ArrayList<Item> list = 
         new ArrayList<Item>(query.getResultList());
      return list;
   }
}
