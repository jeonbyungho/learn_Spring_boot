package com.web.core0922.controller.request;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.core0922.basic.HelloData;

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
		response.getWriter().write("username : " + username + ", age : " + age);
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
	
	/**
	 * @RequestParam
	 * @RequestParam의 값이 기본 데이터형또는 String이라면 어노테이션을 생략 가능하다.
	 * 해당 어노테이션이 있으면 명확하게 명시함으로써, 요청 파라미터에서 데이터를 읽는다는 것을 알 수 있다.(개발자가 소스코드를 보는 입장에서..)
	 */
	@ResponseBody
	@RequestMapping("/request-param-v4")
	public String requestParamV4(
				String username
			,	int age) {
		
		System.out.println("┌─username : " + username);
		System.out.println("└─age : " + age);
		return "ok4";
	}
	
	/**
	 * required=true 이면 반드시 파라미터 값이 들어와야 한다. (default : false)
	 * 
	 * @param username required = true <br>
	 * 해당 요청 파라미터에 아무런 값이 아래와 같은 에러가 발생한다.<br>
	 * Resolved [MissingServletRequestParameterException: 
	 * Required request parameter 'username' for method parameter type String is not present]
	 * 
	 * @param age
	 * 요청 파라미터에 아무런 값이 없을 경우, null로 담기는데 int와 같은 기본 데이터형은 null이 될 수 없다.
	 * 따라서 기본 데이터형인 경우, Integer와 같은 wrapper로 선언하여 null또한 담을 수 있게 하는 것이 좋다.
	 */
	@ResponseBody
	@RequestMapping("/request-param-required")
	public String requestParamRequired(
				@RequestParam(required = true) String username
			,	@RequestParam(required = false) Integer age) {
		
		System.out.println("┌─username : " + username);
		System.out.println("└─age : " + age);
		return "username : " + username + ", age : " + age;
	}
	
	/**
	 * defaultValue 빈 문자열인 경우, 대입한 값으로 대체된다. 해당 옵션이 사용된 경우, required 옵션은 의미가 없어진다.
	 */
	@ResponseBody
	@RequestMapping("/request-param-default")
	public String requestParamDefault(
				@RequestParam(required = true, defaultValue = "guest") String username
			,	@RequestParam(required = false, defaultValue = "-1") Integer age) {
		
		System.out.println("┌─default");
		System.out.println("├─username : " + username);
		System.out.println("└─age : " + age);
		return "username : " + username + ", age : " + age;
	}
	
	/**
	 * 파라미터를 Map<key, value>으로 조회한다.
	 */
	@ResponseBody
	@RequestMapping("/request-param-map")
	public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
		String username = (String) paramMap.get("username");
		int age = Integer.parseInt((String) paramMap.get("age"));
		System.out.println("┌─map");
		System.out.println("├─username : " + username);
		System.out.println("└─age : " + age);
		return "username : " + username + ", age : " + age;
	}
	
	@ResponseBody
	@RequestMapping("/request-attribute-v1")
	public String requestAttributeV1(
				@RequestParam String username
			,	@RequestParam int age) {
		
		HelloData helloData = new HelloData();
		helloData.setUsername(username);
		helloData.setAge(age);
		
		System.out.println("┌─attribute1");
		System.out.println("└─" + helloData.toString());
		return "username : " + helloData.getUsername() + ", age : " + helloData.getAge();
	}
	
	/**
	 * @ModelAttribute
	 * model.addAttribute(helloData)까지 포함되어 있다.
	 * 요청 파라미터 이름으로 HelloData 개체의 프로퍼티를 찾는다.
	 * 그리고 해당 프로퍼티의 setter를 호출해서 파라미터의 값을 입력(바인딩)한다.
	 * */
	@ResponseBody
	@RequestMapping("/request-attribute-v2")
	public String requestAttributeV2(
				@ModelAttribute HelloData helloData) {
		
		System.out.println("┌─attribute2");
		System.out.println("└─ " + helloData.toString());
		return "username : " + helloData.getUsername() + ", age : " + helloData.getAge();
	}
	
	/**
	 * int형과 같은 기본 데이터형, String 타입은 @RequestParam
	 * 객체로 파라미터로 넘어왔을 때는 @ModelAttribute
	 */
	@ResponseBody
	@RequestMapping("/request-attribute-v3")
	public String requestAttributeV3(HelloData helloData) {
		
		System.out.println("┌─attribute3");
		System.out.println("└─ " + helloData.toString());
		return "username : " + helloData.getUsername() + ", age : " + helloData.getAge();
	}
}
