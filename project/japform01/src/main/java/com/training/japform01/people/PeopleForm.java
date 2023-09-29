package com.training.japform01.people;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @ToString
public class PeopleForm {

   @NotBlank(message = "아이디를 입력해주세요!")
   private String userName;

   @NotBlank(message = "비밀번호를 입력해주세요!")
   @Size(min = 4, max = 20, message = "비밀번호를 4 ~ 20 사이로 입력해주세요.")
   private String password;

   @NotBlank(message = "성함을 적어주세요.")
   private String realName;

   @NotNull
   @Min(value = 12, message = "12세 이상만 이용 가능합니다.")
   private Integer age;
   
   @NotNull
   @Email
   private String email;
}
