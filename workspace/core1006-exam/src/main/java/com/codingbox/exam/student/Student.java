package com.codingbox.exam.student;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class Student {
   
   private Long id;
   private String name;
   private Integer age;
   private Integer subject;
   private String phone;
   private String addr;
}
