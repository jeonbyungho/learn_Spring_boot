package com.ex.em.dto.relation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
@SequenceGenerator(name = "TEAM_SEQ_GENERATOR", 
                  sequenceName = "TEAM_SEQ", 
                  initialValue = 1, allocationSize = 1)
public class Team {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE
                  ,generator = "TEAM_SEQ_GENERATOR")
   @Column(name = "TEAM_ID")
   private Long id;

   @Column(name = "TEAMNAME")
   private String name;
}
