package com.codingbox.core0920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** @Controller
 * 지정한 클래스를 Servlet Controller로 지정하는 어노테이션.
 * Controller 역할을 수행하는 class에 붙여준다. <br>
 * Controller에서 mapping url을 찾아준다.
 */
@Controller
public class HelloController {
	
	/**
	 * @GetMapping
	 * HTTP GET방식의 요청을 매핑하기 위한 어노테이션.
	 * 
	 * @return
	 * 컨트롤러에서 리턴 값으로 String을 반환하면 뷰 리졸버(View Resolver)가 화면을 찾아서 처리한다.
	 * <ul>
	 * 	<li>스프링 부트 템플릿엔진 기본 viewName 매핑</li>
	 * 	<li>resources:templates/ + {viewName} + .html</li>
	 * </ul>
	 */
	@GetMapping("/hello")
	public String hello(Model model) {
		System.out.println("hello 도착");
		model.addAttribute("data", "Hello Model!!");
		// hello.html을 화면을 찾아서 return
		return "hello";
	}
	
	/**
	 * @RequestParam
	 * servlet에서의 request.getParameter("..") <br>
	 * 요청의 파라미터의 값을 불러온다. <br>
	 * 
	 * ▶ Option
	 * <ul>
	 *	<li>value : 파라미터의 명칭
	 * 	<li>required : 파라미터 값 필수 여부, true(default)</li>
	 * 	<li>defaultValue : 파라미터 값이 없을 경우 기본으로 들어갈 값</li>
	 * </ul>
	 */
	@GetMapping("hello-mvc")
	public String helloMvc(
			@RequestParam(
						value="name", 
						required = false, 
						defaultValue = "required test") String username, 
			Model model) {
		System.out.println("RequestParam.name : " + username);
		model.addAttribute("modelvalue", username);
		return "hello-template";
	}
}
