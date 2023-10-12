package com.ex.jpql.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString(exclude = "members")
public class Team {
   @Id
   private Long id;

   @Column(name = "teamname")
   private String name;

   @OneToMany(mappedBy = "team")
   private List<Member> members = new ArrayList<>();
   public void addMember(Member member){
      member.setTeam(this);
      this.members.add(member);
   }

}
