package com.web.core0922.controller.request;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class RequestParmController {
	
	@GetMapping("/input")
	public String inputPage() {
		return "input";
	}
	
	/** 
	 * 반환 타입(void)을 정하지 않으면서 <br>
	 * 응답(response.getWriter())에 값을 직접 넣으면, view를 조회하지 않는다. <br>
	 * /request-param-v1?username=user&age=20
	 * 
	 * <ul>
	 * <li>┌─username : user</li>
	 * <li>└─age : 20</li>
	 * </ul>
	 * */
	@RequestMapping("/request-param-v1")
	public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println("┌─username : " + username);
		System.out.println("└─age : " + age);
		response.getWriter().write("ok1");
	}
	
	/**
	 * @RequestParam
	 * 파라미터 이름으로 바인딩
	 * 
	 * @param username
	 * <ul>
	 * 	<li><code>@RequestParam("username") String username</code></li>
	 * 	<li><code>String username = request.getParameter("username")</code></li>
	 * </ul>
	 * @param age
	 * <ul>
	 * 	<li><code>@RequestParam("age") int age</code></li>
	 * 	<li><code>int age = Integer.parseInt(request.getParameter("age"))</code></li>
	 * </ul>
	 * 
	 * @ResponseBody
	 * <code>response.getWriter().write()</code>와 유사하게 작동되게 하는 어노테이션이다.
	 * view 조회를 무시하고 Http Message body에 직접 내용을 입력할 수 있다.
	 */
	@ResponseBody
	@RequestMapping("/request-param-v2")
	public String requestParamV2(
				@RequestParam("username") String username
			,	@RequestParam("age") int age) {
		
		System.out.println("┌─username : " + username);
		System.out.println("└─age : " + age);
		return "ok2";
	}
	
	/**
	 * @RequestParam
	 * HTTP 파라미터 이름이 변수 이름과 같으면 @RequestParam(name="{..}") 생략이 가능하다.
	 */
	@ResponseBody
	@RequestMapping("/request-param-v3")
	public String requestParamV3(
				@RequestParam String username
			,	@RequestParam int age) {
		
		System.out.println("┌─username : " + username);
		System.out.println("└─age : " + age);
		return "ok3";
	}
}
