# 패키지 구조
```
└─📦com
    └─📦web
        └─📦core0921
            │ 🗒️Core0921Application.java
            │
            ├─📦controller
            │     🗒️MemberController.java
            │
            ├─📦dto
            │     🗒️MemberDTO.java
            │
            ├─📦repository
            │     🗒️MemberRepository.java
            │
            └─📦service
                    🗒️MemberService.java
```

# 📌 스프링 MVC 답지 않는 방식

```java
@Controller
public class MemberController {
	
	MemberService memberService = new MemberService();
}
```

```java
public class MemberService {
	
	MemberRepository memberRepository = new MemberRepository();
	
}
```

```java
public class MemberRepository {
	.. 특정 한 DB 커넥션 로직 ...
}

```
해당 방식은 계층, 클래스간 의존성 관계가 형성되어 로직이나 DB의 종류를 변경 시 높은 의존성으로 인해 힘들어질 수 있다.  

# 📌 Contructor Injection 방식
⭐*이런 문제를 해결하기 위해 계층마다 알맞은 어노테이션을 등록해준다. 개발자가 아닌 스프링이 클래스간 의존 관계를 관리해준다.*
> Service는 여러 Controller에서 쓸 수 있게끔 Spring Container에 등록해야 된다.

```java
@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.MemberService = memberService;
	}
}
```

```java
@Service
public class MemberService {
	...
}
```

```java
@Repository
public class MemberRepository {
	...
}
```

- 스프링은 일단 기본 패키지(📦`com.web.core0921`)안에서만 의존성 관계를 등록이 가능하다.
- 기본 패키지밖에 있는 클래스를 의존성 관계를 등록하려면 `@Component` 어노테이션을 활용해야 된다.