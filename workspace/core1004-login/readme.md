# Model
- forward

# RedirectAttribute
- redirect 방식
- 전달한 값은 url 뒤에 붙지 않는다. 일회성이라 리프레시할 경우 데이터가 소멸한다.

# jsessionid
http://localhost:8080/;jsessionid=F59911518B921DF62D09F0DF8F83F872
- 로그인을 처음 시도하면 URL이 위와 같이 jsessionid를 포함하고 있는것을 확인할 수 있다.
- 이것은 웹 브라우저가 쿠기를지원하지 않을 때 쿠기 대신 URL을 통해서 세션을 유지하는 방법이다.
- 타임리프 같은 템플릿 엔진을 통해 링크를 걸어두면 jsessionid를 자동으로 URL에 포함시킨다.
- URL 전달 방식을 끄고 항상 내부 로직을 통해서 세션을 유지하고 싶다면 옵션 추가.

# 로그인 상태 유지하기

## Cookie 사용

- 영속 쿠키 : 만료 날짜를 입력하면 해당 날짜까지 유지
- 세션 쿠키 : 만료 날짜를 생략하면 브라우저 종료 시까지만 유지된다.

## Session
- Servlet HttpSession

### Option
- `request.getSession(boolean create)``
   1. `true` (default) : 세션이 있으면 기존 세션을 반환, 아니라면 새로운 새션을 생성한 후 반환한다.
   1. `false` : 세션이 있으면 기존 세션을 반환, 아니라면 새 세션을 생성하지 않고 null로 반환한다.

- `server.servlet.session.timeout=30`
   1. 세션의 유지 시간을 수정할 수 있다. (분단위) `application.properties`에 기입한다.
   1. default 30분