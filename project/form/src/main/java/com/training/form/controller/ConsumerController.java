package com.training.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.form.from.ConsumerForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/consumer")
public class ConsumerController {
	
	@GetMapping
	public String showConsumer(ConsumerForm consumerForm) {
		return "consumer";
	}
	
	@GetMapping("/success")
	public String showSuccess() {
		return "result";
	}
	
	/** 
	 * @Valid validation 어노테이션이 설정된 멤버 변수들 유효성(Validation) 검사를 실시한다.
	 * 만약 유효성에 맞지 않는 멤버 변수가 발견이 될 경우, 경고 예외를 발생 시킵니다.
	 */
	@PostMapping
	public String checkConsumerInfo(
			@Valid  ConsumerForm consumerForm, BindingResult bindingResult) {
		
		System.out.println(consumerForm.toString());
		System.out.println(bindingResult.hasErrors());
		if(bindingResult.hasErrors()) {
			System.out.println("Error!");
			return "consumer";
		}
		return "redirect:/consumer/success";
	}
}
