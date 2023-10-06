package com.codingbox.exam.student;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class StudentForm {
   
   private Long id;

   @NotBlank(message = "이름은 꼭 적어주세요.")
   @Size(min = 2,max = 5)
   private String name;

   @NotNull(message = "나이를 적어주세요.")
   @Min(value = 12, message = "12세 이상이어야 합니다.")
   private Integer age;

   @NotNull(message = "과목 수를 적어주세요.")
	@Min(2)
   @Max(10)
   private Integer subject;

   @NotBlank(message = "연락처를 입력해주세요.")
   private String phone;
   
   @NotBlank(message = "주소를 적어주세요.")
   private String addr;
}
