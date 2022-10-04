## 🏷️MyBatis

* 보통 MyBatis를 쓰면 JPA를 쓰지 않는다.
* MyBatis는 엔티티라는 개념이 없다.

<br>

## 🏷️Interceptor
* 스프링부트의 필터역할이라고 생각하면 된다.
* 인터셉터는 학습을 시켜야한다.
* 모든요청은 들어올 때와 나갈 때 두번 인터셉터를 통과한다.
* 들어오는 시점에는 preHandle, 나갈때는 postHandle이 작동한다.
* 컨트롤러(Controller)의 '핸들러(Handler)'를 호출하기 전과 후에 요청과 응답을 참조하거나 가공할수 있는 일종의 필터이다.
* interceptr 란 단어는 '낚아채다'라는 의미이다. 해당 단어의 의미와 같이 사용자 요청에 의해 서버에 들어온
Request 객체를 컨트롤러의 핸들러(사용자가 요청한 url에 따라 실행되어야 할 메서드, 이하 핸들러)로
도달하기전에 낚아채서 개발자가 원하는 추가적인 작업을 한 후 핸들러로 보낼수 있도록 해준다.

<br>

## 🏷️HandlerInterceptor 메소드
* preHandle(request, response, handler)
  - 지정된 컨트롤러의 동작 이전에 수행할 동작 (사전제어).
* postHandle(request, response, handler, modelAndView)
    - 지정된 컨트롤러의 동작 이후에 처리할 동작 (사후 제어).
    - Spring MVC의 Dispatcher Servlet이 화면을 처리하기 전에 동작.
* afterCompletion(request, response, handler, exception)
  - Dispatcher Servlet의 화면 처리가 완료된 이후 처리할 동작.

<br>

## 🏷️Bean Scope
* 스코프(Scope)는 영어 뜻 그대로 범위인데 해석한 그대로 빈이 관리되는 범위를 뜻한다.
<br>

##### 🔻스코프의 종류

| Scope      | Description                                                                                                                                    |
|------------|------------------------------------------------------------------------------------------------------------------------------------------------|
|singleton| 하나의 Bean 정의에 대해서 Spring IoC Container 내에 단 하나의 객체만 존재한다.                                                                                       |
|prototype| 하나의 Bean 정의에 대해서 다수의 객체가 존재할 수 있다.                                                                                                             |
|request| 하나의 Bean 정의에 대해서 하나의 HTTP request의 생명주기 안에 단 하나의 객체만 존재한다. 즉, 각각의 HTTP request는 자신만의 객체를 가진다. Web-aware SpringApplicationContext 안에서만 유효하다.    |
|session| 하나의 Bean 정의에 대해서 하나의 HTTP Session의 생명주기 안에 단 하나의 객체만 존재한다. Web-aware Spring ApplicationContext 안에서만 유효하다.                                      |
|global session| 하나의 Bean 정의에 대해서 하나의 global HTTP Session의 생명주기 안에 단 하나의 객체만 존재한다. 일반적으로 portlet context 안에서 유효하다. Web-aware SpringApplicationContext안에서만 유효하다. |