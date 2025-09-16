package com.sparta.springauth.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j(topic = "LoggingFilter")  // 로그를 남길 때 구분하기 위해서 topic 설정
//@Component
@Order(1)  // Filter 가 여러 개일 때, 순서 지정 (낮은 숫자가 먼저 실행됨)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 전처리
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();  //url 정보
        log.info(url);

        chain.doFilter(request, response); // 다음 Filter 로 이동

        // 로직이 끝난 후 응답이 전송되기 직전 후처리
        log.info("비즈니스 로직 완료");
    }
}
