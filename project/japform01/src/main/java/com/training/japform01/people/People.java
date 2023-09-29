package com.training.japform01.people;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "people")
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class People{

   @Id
   @GeneratedValue
   private Long id;

   @Column(unique = true, nullable = false)
   private String userName;

   @Column(nullable = false)
   private String password;

   @Column(nullable = false)
   private String realName;

   private Integer age;

   private String email;
}