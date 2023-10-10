package com.simple;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@SequenceGenerator(name = "PERSON_SEQ_GENERATOR", 
                  sequenceName = "PERSON_SEQ", 
                  initialValue = 1, allocationSize = 1)
public class Person {
   
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ_GENERATOR")
   private Long id;

   @Column(name="name", nullable = false, length = 15)
   private String username;
}
