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