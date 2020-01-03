package com.travel.api.service;

import com.github.pagehelper.PageInfo;
import com.travel.api.beans.request.BaseRequest;
import com.travel.api.beans.request.user.LoginRequest;
import com.travel.api.beans.request.user.RegisterRequest;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName 用户Service
 * @Author liguangyao
 * @Date 13/8/18 下午3:20
 * @Version 1.0
 **/
public interface UserService {

    /**
     * 用户详情列表
     */
    PageInfo list(BaseRequest request);

    /**
     * 用户注册
     */
    public Map<String, Object> register(RegisterRequest request);

    /**
     * 用户登录
     * @param request
     * @return
     */
    Map<String, Object> login(LoginRequest request, HttpServletRequest servletRequest);

    /**
     * 检查Token有效性
     * @param token
     * @return
     */
    boolean judgeToken(@RequestHeader("token") String token);
}
