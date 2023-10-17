package com.ex.mvcweb.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MemberForm {
   @NotEmpty(message = "이름을 적어주세요.")
   private String name;
   
   private String city;
   
   private String street;
   
   private String zipcode;
}
