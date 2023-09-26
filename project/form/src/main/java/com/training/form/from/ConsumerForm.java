package com.training.form.from;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ConsumerForm {
	
	@Size(min=4, max=12)
	private String userid;
	
	@Size(min=4, max=20)
	private String password;
	
	@NotBlank
	private String name;
	
	@NotNull
	@Min(12)
	private Integer age;
	
	private String email;
	
	@Size(max=2)
	private String gender;
}
