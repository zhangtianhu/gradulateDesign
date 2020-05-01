package com.travel.api.controller;


import com.github.pagehelper.PageInfo;
import com.travel.api.beans.SysUser;
import com.travel.api.beans.request.BaseRequest;
import com.travel.api.beans.request.user.LoginRequest;
import com.travel.api.beans.request.user.RegisterRequest;
import com.travel.api.entity.ResultConstant;
import com.travel.api.service.UserService;
import com.travel.api.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName 用户操作
 * @Author liguangyao
 * @Date 24/8/18 下午10:33
 * @Version 1.0
 **/
@RestController
@RequestMapping("user/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 用户详情列表
     */
    @PostMapping("/list")
    public PageInfo list(@RequestBody BaseRequest request) {
        // TODO 数据需要过滤, 例如密码等敏感信息
        PageInfo pageInfo = userService.list(request);
        return pageInfo;
    }

    /**
     * 用户登录
     */
        @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request, HttpServletRequest servletRequest) {
        return userService.login(request, servletRequest);
    }

    /**
     * 自动登录
     */
    @GetMapping("/automaticLogin")
    public void automaticLogin() {
        // TODO 获取请求头数据Token


    }

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }


    /**
     * 用户信息
     */
    @GetMapping("/userInfo")
    public void userInfo() {
        // TODO 获取请求头数据Token, 根据Token获取用户数据


    }

    /**
     * 用户信息修改
     */
    @PostMapping("/userInfoUpdate")
    public void userInfoUpdate() {
        // TODO 获取请求头数据Token



    }

    /**
     * 找回密码
     */
    @GetMapping("/userInfoUpdate")
    public void passwordFound() {

    }

    /**
     * 检查Token有效性 true 为已经失效 false 为未失效
     * @return
     */
    @GetMapping("/judgeToken")
    public boolean judgeToken(@RequestParam("token") String token) {
        return userService.judgeToken(token);
    }
}
