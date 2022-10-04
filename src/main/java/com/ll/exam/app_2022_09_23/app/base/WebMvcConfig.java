package com.ll.exam.app_2022_09_23.app.base;

import com.ll.exam.app_2022_09_23.app.interceptor.BeforeActionInterceptor;
import com.ll.exam.app_2022_09_23.app.interceptor.NeedToAdminInterceptor;
import com.ll.exam.app_2022_09_23.app.interceptor.NeedToLoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
    private final BeforeActionInterceptor beforeActionInterceptor;
    private final NeedToLoginInterceptor needToLoginInterceptor;
    private final NeedToAdminInterceptor needToAdminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir;

        ir = registry.addInterceptor(beforeActionInterceptor); // registry에 넣어서 학습을 시킨다.
        ir.addPathPatterns("/**"); // 추가
        ir.excludePathPatterns("/favicon.ico"); // 제외
        ir.excludePathPatterns("/resource/**"); // 제외
        ir.excludePathPatterns("/gen/**"); // 제외
        ir.excludePathPatterns("/error"); // 제외

        ir = registry.addInterceptor(needToLoginInterceptor);
        // "/article/write"로 들어가면 interceptor가 두개 작동한다.
        // beforeActionInterceptor 실행 후 needToLoginInterceptor이 실행된다.
        // 즉 먼저 등록된 것을 먼저 실행한다.
        ir.addPathPatterns("/article/write");
        ir.addPathPatterns("/member/me");

        ir = registry.addInterceptor(needToAdminInterceptor);
        ir.addPathPatterns("/adm/**");
    }
}
