# 📌 Framework와 Library

## 🪶 프레임워크 (Framework)
- 뼈대나 근간을 이루는 코드들의 묶음이다.
- 프로그램의 기본 흐름이나 구조를 정하고, 이 구조에 자신의 코드를 추가하는 방식으로 개발할 수 있도록 하는 프로그래밍의 기본 틀을 의미한다.
- 개발에 필요한 구조가 제공되고, 여기에 필요한 부분을 조립하는 형태로 개발이 진행된다.

## 🪶 라이브러리 (Library)
- 자주 사용되는 로직을 재사용하기 편리하도록 잘 정리한 일련의 코드드의 집합이다.

## 🪶 프레임워크와 라이브러리의 차이
- 프레임워크는 자동차의 프레임, 즉 기본적으로 구성하고 있는 *뼈대*를 말한다.
    - 한 번 정해진 프레임은 바꿀 수 없다.
- 라이브러리는 자동차의 기능을 하는 *부품*을 의미한다.
    - 비교적 다른 종류로 쉽게 바꿀 수 있다.

# 📌 Spring Framework
- 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임워크이다.
- 동적인 웹 사이트르 개발하기 위한 여러가지 서비스를 제공하고 있다.
- [🌿 Spring 웹 사이트](https://spring.io/)

## 🪶 Spring과 Spring boot의 차이
> Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run". [*Spring boot OVERVIEW*](https://spring.io/projects/spring-boot#overview)

> Spring와 Spring boot의 차이는 초기 세팅의 시간과 난이도로 보임.

## 🪶 Spring Boot 설정

### Embed Tomat
- 스프링 부트는 *내장형 톰캣*을 가지고 있기 때문에 별도의 톰캣을 설정할 필요가 없다. 그렇기 때문에 독립적으로 실행 가능한 jar로 쉽게 배포가 가능하다.

> 리눅스 서버에 배포하는데 있어 이전보다 훨씬 수월해졌다고 한다.

### AutoConfgurator
- 공통적으로 필요한 DispatcherServlet과 같은 설정을 어노테이션을 이용하여 대신할 수 있도록 해준다.
- 스프링 부트의 `main` 메서드는 `@SpringBootApplication`을 가지고 있는데, 이것은 `@ComponentScan` + `@Configuration` + `@EnableAutoConfiguration`을 합친 어노테이션이라고 불 수 있다.
   > `@SpringBootApplication` = `@ComponentScan` + `@Configuration` + `@EnableAutoConfiguration`

# 📌 Spring Tools 4 환경설정

## 🪶 STStool 설치
1. [🌿 Spring 다운로드 - Spring Tools 4 for Eclipse : WINDOWS X86_64](https://spring.io/tools)
1. `spring-tool-suite-4{version}.jar`압축을 풀고 그 안에 있는 `contents.zip` 압축을 푼다.
1. 실행 파일 `/spring-tool-suite-4.{version}self-extracting/sts-4.{version}.RELEASE/SpringToolSuite4.exe`
1. 이클립스와 똑같이 인코딩 설정을 한다. `UTF-8`

## 🪶 프로젝트 세팅

### [🌿 spring initializr](https://start.spring.io/)
1. Project
    - ✔️ Gradle - Groovy
    - Gradle - Kotlin
    - Maven
1. Language
    - ✔️ Java
    - Kotlin
    - Groovy
1. Spring Boot
    - ✔️ 3.1.3
1. Project Metadata
    - ⌨️ Group : com.codingbox
    - ⌨️ Artifact : core
    - Name : core
    - Description : Demo project for Spring Boot
    - Package name : com.codingbox.core
    - ✔️ Packaging : Jar
    - ✔️ Java : 
        - 장기지원(LTS) 버전인 자바들만 있음.

### Project : Gradle, Maven

- 프로젝트에 필요한 의존성을 관리하고 **빌드의 라이프사이클을 관리**해주는 툴이다.
    > 과거에는 Maven을 주로 사용했고, 최근에는 Gradle을 사용하는 추세이다.

    > 의존성의 예시 특정 라이브러리에 해당 프로젝트에 의존하고 있다. Gradle와 Maven이 외부 라이브러리의 buildpath를 대신 해준다.

### Spring Boot : 버전 선택
- `SNAPSHOT` : 현재 개발중인 버전
- `M(minor)` : 정식 릴리즈 되지 않는 버전
- 아무런 키워드에 없는 경우 : 정식 릴리즈된 버전

### Long Term Support (LTS)
- 오랜 기간 지원될 버전을 뜻한다.