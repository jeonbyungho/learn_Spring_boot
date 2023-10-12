package com.ex.mvcweb.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
public class Address {

   private String city;

   private String street;
   
   private String zipcode;
}
