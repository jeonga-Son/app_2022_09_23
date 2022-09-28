package com.ll.exam.app_2022_09_23.app.interceptor;

import com.ll.exam.app_2022_09_23.app.base.rq.Rq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
// @Slf4j는 로깅에 대한 추상 레이어를 제공하는 인터페이스의 모음이다. (로깅 Facade)
//인터페이스를 사용하여 로깅을 구현하게 되면 좋은 점은 추후에 필요로 의해 로깅 라이브러리를 변경할 때 코드의 변경 없이 가능하다는 점이다.
@Slf4j
@RequiredArgsConstructor
// BeforeActionInterceptor 모든 액션을 실행하기 전에 실행하는 것.
// HandlerInterceptor는 특정한 URI 호출을 '가로채는' 역할을 한다. 이를 이용하여 기존 컨트롤러의 로직을 수정하지 않고도, 사전이나 사후 제어가 가능하다.
public class BeforeActionInterceptor implements HandlerInterceptor {

    private final Rq rq;
    @Override
    // HttpServletRequest는 클라이언트가 서버에 보내는 요청정보를 처리하는 객체이다. HttpServletRequest를 사용하면, 값을 받아올 수가 있는데
    // 만약 정보를 컨트롤러로 보냈을 때 HttpServletRequest 객체 안에 모든 데이터들이 들어가게 된다.
    // 원하는 데이터를 꺼낼때는 HttpServletRequest의 객체 안의 메소드인 getParameter()를 이용하면 된다.
    // HttpServletResponse는 서버가 클라이언트로 보내는 응답정보를 처리하는 객체이다.
    // preHandle(request, response, handler) : 지정된 컨트롤러의 동작 이전에 수행할 동작 (사전 제어).
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // @Slf4j 어노테이션을 썼기 때문에 사용가능하다.
        log.debug("BeforeActionInterceptor::preHandle 실행됨");

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
