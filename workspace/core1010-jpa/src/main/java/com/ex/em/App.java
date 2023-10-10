package com.ex.em;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ex.em.relation.Member;
import com.ex.em.relation.Team;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try{
            tx.begin();

            Team team = new Team();
            team.setName("자바팀");
            em.persist(team);

            Member member = new Member();
            member.setName("사람");
            member.setTeam(team);
            em.persist(member);
            
            tx.commit();
        } catch (Exception e){
            //tx.rollback();
            e.printStackTrace();
            
        } finally{
            em.close();
        }
        emf.close();
    }
}