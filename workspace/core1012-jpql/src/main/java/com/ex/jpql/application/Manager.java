package com.ex.jpql.application;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public abstract class Manager {
   protected EntityManagerFactory emf;
   protected EntityManager em;
   protected EntityTransaction tx;

   public Manager(String name){
      emf = Persistence.createEntityManagerFactory(name);
      em = emf.createEntityManager();
      tx = em.getTransaction();
   }
   public Manager(){
      this("student");
   }

   public abstract void execute();
}
