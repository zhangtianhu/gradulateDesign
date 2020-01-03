package com.travel.api.interceptor;

import com.travel.api.util.NetworkUtil;
import com.travel.api.util.SysContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName 系统拦截器
 * @Author liguangyao
 * @Date 14/8/18 下午4:53
 * @Version 1.0
 **/
@Configuration
public class SystemInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(SystemInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        // 从request请求中获取IP,并存放在Request中
        try {
            String ip = NetworkUtil.getIpAddress(request);
            request.setAttribute("IP", ip);
            logger.info("[系统拦截器]请求IP地址为ip={}",ip);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
