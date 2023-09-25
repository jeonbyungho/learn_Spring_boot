package com.web.core0925.thymeleaf.bean;

import org.springframework.stereotype.Component;

/**
 * @Component
 * 스프링 컨테이너에 등록한다.
 */
@Component("helloBean")
public class HelloBean {
	
	public String hello(String data) {
		return "Hello" + data;
	}
}
