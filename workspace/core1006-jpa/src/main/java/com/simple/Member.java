package com.simple;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Member {
   
   @Id
   private Long id;
   
   @Column(unique = true, length = 10)
   private String name;

   @Column(name = "myage")
   private int age;

   @Temporal(TemporalType.TIMESTAMP)
   private LocalDateTime createDate;

   @Temporal(TemporalType.DATE)
   private LocalDate lastModifiedDate;

   @Transient
   private int temp;
}
