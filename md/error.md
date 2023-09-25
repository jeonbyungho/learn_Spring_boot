# Request Parameter ERROR
```log
DefaultHandlerExceptionResolver
MissingServletRequestParameterException
Required request parameter 'parameter name' for method parameter type String is not present
```

Request에서 온 parameter에 아무런 값이 없는 경우 발생한다.

# LoggingFailureAnalysisReporter ERROR
```log
Description:
Parameter 0 of constructor in Controller.class required a bean of type 'Service.class' that could not be found
Action:
Consider defining a bean of type 'Service' in your configuration.
```

Controller 클래스에서 컨테이너에 필요한 bean이 없을 때 발생한다.
Service 클래스에 어노테이션을 집어넣어 컨테이너에 bean으로 등록해주면 해결된다.

# Unresolved compilation problem
- STS 툴 project - Clean
- `settings.gradle`설정 파일에서 `rootProject.name`의 값이 프로젝트 이름과 같아야 된다.
   - `rootProject.name = 'project name'`

# cannot reliably process 'persist' call
```log
jakarta.persistence.TransactionRequiredException: No EntityManager with actual transaction available for current thread - cannot reliably process 'persist' call
```
Service 클래스에 `@Transactional`를 추가해야 한다.

# Cannot load driver class: com.mysql.cj.jdbc.Driver
```log
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'dataSource' defined in class path resource [org/springframework/boot/autoconfigure/jdbc/DataSourceConfiguration$Hikari.class]: Failed to instantiate [com.zaxxer.hikari.HikariDataSource]: Factory method 'dataSource' threw exception with message: Cannot load driver class: com.mysql.cj.jdbc.Driver
```

mysql jdbc Driver가 존재하지 않아 발생하는 런타임 에러이다.

# 오류: 기본 클래스 com.domain.core.coreApplication을(를) 찾거나 로드할 수 없습니다.
원인: java.lang.NoClassDefFoundError: com.domain.core.coreApplication (wrong name: com/domain/core/coreApplication을)
[출처](https://velog.io/@y_dragonrise/Error-%EC%98%A4%EB%A5%98-%EA%B8%B0%EB%B3%B8-%ED%81%B4%EB%9E%98%EC%8A%A4%EC%9D%84%EB%A5%BC-%EC%B0%BE%EA%B1%B0%EB%82%98-%EB%A1%9C%EB%93%9C%ED%95%A0-%EC%88%98-%EC%97%86%EC%8A%B5%EB%8B%88%EB%8B%A4)

1. 🖱️project - 🖱️properties - 🖱️Run/Debug Settings
1. 기존 `*Application` Delecte
1. 🖱️New - 🖱️Spring boot App - 🖱️Search - 삭제했던 `*Application`을 선택하여 Main type을 생성
1. 🖱️Apply

# org.thymeleaf.exceptions.TemplateProcessingException: Could not parse as expression: "hello world" (template: "basic/literal" - line 12, col 10)
html 타임 리프 th 안에 parsing 문제로 에러가 난다. ''로 감싸거 띄어쓰기를 인식 시키거나 파싱이 잘 되도록 띄어쓰기를 없애고, 문장끼리 + 연산자를 이용해 이어 붙여 조치를 취하면 된다.