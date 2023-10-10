package com.ex.em.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class Manager {
   
   protected EntityManagerFactory emf;
   protected EntityManager em;
   protected EntityTransaction tx;
   
   public Manager(String unitName){
      emf = Persistence.createEntityManagerFactory(unitName);
      em = emf.createEntityManager();
      tx = em.getTransaction();
   }

   public Manager(){
      this("hello");
   }

   public abstract void execute();
}
