package com.travel.api.controller.user;

import com.travel.api.beans.request.BaseRequest;
import com.travel.api.beans.request.message.SMSRequest;
import com.travel.api.beans.request.user.LoginRequest;
import com.travel.api.beans.request.user.RegisterRequest;
import com.travel.api.entity.ResultConstant;
import com.travel.api.service.MessageService;
import com.travel.api.service.UserService;
import com.travel.api.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName 用户Controller
 * @Author liguangyao
 * @Date 13/8/18 下午1:41
 * @Version 1.0
 **/
@Api(value = "/user/user", description = "用户")
@RestController
@RequestMapping("user/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @ApiOperation(value = "用户数据列表", httpMethod = "POST", notes = "用户数据列表")
    @PostMapping("/list")
    public Map<String,Object> list(@RequestBody BaseRequest request) {
        Object pageInfo = userService.list(request);
        return CommonUtil.getSuccessResult(null,pageInfo);
    }

    @ApiOperation(value = "用户登录", httpMethod = "POST", notes = "用户登录")
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @ApiOperation(value = "用户注册", httpMethod = "POST", notes = "验证码正确并用户注册")
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody RegisterRequest request) {
        SMSRequest emailRequest = new SMSRequest();
        emailRequest.setMobile(request.getMobile());
        emailRequest.setCode(request.getCode());
        Map<String, Object> result = messageService.validationSMS(emailRequest);
        // 验证正确
        if(!StringUtils.isEmpty(result) && result.get("code").toString()
                .equals(ResultConstant.SUCCESS_RESULT_CODE.toString())) {
            // 调用用户注册接口
            return userService.register(request);
        }
        return result;
    }

    @ApiOperation(value = "用户信息", httpMethod = "GET", notes = "用户信息")
    @GetMapping("/userInfo")
    public Map<String, Object> userInfo(@RequestHeader("token") String token) {
        // 根据token获取用户信息

        // 用户信息需要进行过滤


        return null;
    }

    @ApiOperation(value = "检查Token有效性", httpMethod = "GET", notes = "检查Token有效性 true 为已经失效 false 为未失效")
    @GetMapping("/judgeToken")
    public boolean judgeToken(@RequestHeader("token") String token) {
        return userService.judgeToken(token);
    }
}
