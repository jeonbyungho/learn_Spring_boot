package com.ex.querydsl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@SequenceGenerator(name = "member_seq_gen", sequenceName = "member_seq", allocationSize = 1, initialValue = 1)
@Getter @Setter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
   @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
   @Column(name = "member_id")
   private Long id;

   private String username;

   private int age;

   @ManyToOne @JoinColumn(name = "team_id")
   @Setter(AccessLevel.NONE)
   private Team team;

   public void changTeam(Team team){
      this.team = team;
   }

   public Member(String username, int age, Team team) {
      this.username = username;
      this.age = age;
      this.team = team;
      if(team != null) changTeam(team);
   }

   public Member(String username, int age) {
      this(username, age, null);
   }

   public Member(String username) {
      this(username, 0);
   }
   
}
