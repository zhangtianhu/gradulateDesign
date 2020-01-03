package com.travel.api.service;


import com.travel.api.beans.request.BaseRequest;
import com.travel.api.beans.request.user.LoginRequest;
import com.travel.api.beans.request.user.RegisterRequest;
import com.travel.api.service.fallBack.UserFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @FeignClient 是一个HTTP请求服务注解
 *   name 是服务调用被注册的服务模块名字
 *   fallback 是当服务调用失败进行服务降级处理
 */
@FeignClient(name = "api-user",fallback = UserFallBack.class)
public interface UserService {

    /**
     * 用户数据列表
     * @param request
     * @return
     */
    @PostMapping("user/user/list")
    Object list(@RequestBody BaseRequest request);

    /**
     * 用户注册
     * @param request
     * @return
     */
    @PostMapping("user/user/register")
    Map<String, Object> register(@RequestBody RegisterRequest request);

    /**
     * 用户登录
     */
    @PostMapping("user/user/login")
    Map<String, Object> login(@RequestBody LoginRequest request);

    /**
     * 检查Token有效性 true 为已经失效 false 为未失效
     * @param token
     * @return
     */
    @GetMapping("user/user/judgeToken")
    boolean judgeToken(@RequestParam("token") String token);

}
