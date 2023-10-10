package com.ex.em.dto.relation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", 
                  sequenceName = "MEMBER_SEQ", 
                  initialValue = 1, allocationSize = 1)
@Getter @Setter @ToString
public class Member {
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE
                  ,generator = "MEMBER_SEQ_GENERATOR")
   private Long id;

   @ManyToOne
   @JoinColumn(name = "TEAM_ID")
   private Team team;

   @Column(name = "USERNAME")
   private String name;
}
