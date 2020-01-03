package com.travel.api.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
    /**
     * 添加了拦截器到auth下做个案例
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(new SystemInterceptor())
                .addPathPatterns("/**");
    }

}
