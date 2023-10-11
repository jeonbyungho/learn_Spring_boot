package com.ex.em.relation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Team {
   @Id
   @GeneratedValue
   @Column(name = "TEAM_ID")
   private Long id;

   @Column(name = "TEAMNAME")
   private String name;

   @OneToMany(mappedBy = "team")
   private List<Member> members = new ArrayList<>();
   
   public void addMember(Member member){
      member.setTeam(this);
      this.members.add(member);
   }
}
