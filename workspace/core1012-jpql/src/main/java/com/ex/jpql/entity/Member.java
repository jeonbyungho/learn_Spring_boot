package com.ex.jpql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Member {
   @Id
   private Long id;

   @Column(name = "username")
   private String name;
   private int age;

   @ManyToOne
   @JoinColumn(name = "team_id")
   private Team team;
   
   public void changeTeam(Team team){
      team.addMember(this);
      this.team = team;
   }
}
