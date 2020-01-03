package com.travel.api.interceptor;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Component
public class AuthorityInterceptor implements HandlerInterceptor {

    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    public Boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler, HttpSession session) throws Exception {
        String token = request.getHeader("token");
        String url = request.getRequestURI();
        logger.info("拦截器前置生效打印");
        logger.error(token);
        logger.error(url);

        return true;
    }
}
