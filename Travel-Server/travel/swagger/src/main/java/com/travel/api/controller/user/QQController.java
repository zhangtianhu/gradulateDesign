package com.travel.api.controller.user;

/**
 * @ClassName QQController
 * @Author liguangyao
 * @Date 25/8/18 下午2:09
 * @Version 1.0
 **/

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(value = "/user/qq", description = "[QQ端]用户相关操作")
@RestController
@RequestMapping("user/qq")
@CrossOrigin
public class QQController {

    // TODO 授权

    // TODO 登录

    // TODO 支付

}
