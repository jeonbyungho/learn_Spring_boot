package com.ex.querydsl.entity;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@SequenceGenerator(name = "team_seq_gen", sequenceName = "team_seq", allocationSize = 1, initialValue = 1)
@Getter @Setter @ToString(exclude = {"members"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
   @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq_gen")
   @Column(name = "team_id")
   private Long id;

   private String name;

   @OneToMany(mappedBy = "team")
   @Setter(AccessLevel.NONE)
   private List<Member> members = new ArrayList<>();
   
   public void addMember(Member member){
      this.members.add(member);
      member.changTeam(this);
   }

   public Team(String name) {
      this.name = name;
   }
   
}
