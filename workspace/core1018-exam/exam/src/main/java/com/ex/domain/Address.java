package com.ex.domain;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Address {
   private String city;
   private String street;
   private String zipcode;
}