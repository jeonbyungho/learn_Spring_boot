package com.ex.em.relation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Member {
   @Id
   @GeneratedValue
   @Column(name = "MEMBER_ID")
   private Long id;

   @Column(name = "USERNAME")
   private String name;

   @ManyToOne
   @JoinColumn(name = "TEAM_ID")
   @Setter(AccessLevel.NONE)
   private Team team;
   
   public void setTeam(Team team){
      team.getMembers().add(this);
      this.team = team;
   }
}
