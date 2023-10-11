package com.ex.em.dto;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Address {
   private String zipCode;
   private String address;
   private String addressDetail;
}
