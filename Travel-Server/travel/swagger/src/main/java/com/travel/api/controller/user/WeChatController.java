package com.travel.api.controller.user;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName 微信Controller
 * @Author liguangyao
 * @Date 25/8/18 下午2:09
 * @Version 1.0
 **/
@Api(value = "/user/wechat", description = "[微信端]用户相关操作")
@RestController
@RequestMapping("user/wechat")
@CrossOrigin
public class WeChatController {

    // TODO 授权

    // TODO 登录

    // TODO 支付

}
