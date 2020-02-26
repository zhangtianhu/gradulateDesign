package com.travel.api.controller.message;

import com.travel.api.beans.request.message.EmailRequest;
import com.travel.api.beans.request.message.SMSRequest;
import com.travel.api.controller.BaseController;
import com.travel.api.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName 消息Controller
 * @Author zhangtianhu
 * @Date 24/8/18 下午7:44
 * @Version 1.0
 **/
@Api(value = "/message", description = "消息")
@RestController
@RequestMapping("message")
@CrossOrigin
public class MessageController extends BaseController {

    @Autowired
    private MessageService messageService;

    @ApiOperation(value = "短信发送", httpMethod = "GET", notes = "短信发送")
    @GetMapping("/sendSMS")
    public Map<String, Object> sendSMS(@RequestParam String mobile) {
        return messageService.sendSMS(mobile);
    }

    @ApiOperation(value = "短信验证码验证", httpMethod = "POST", notes = "短信验证码验证")
    @PostMapping("/validationSMS")
    Map<String, Object> validationSMS(@RequestBody SMSRequest request) {
        return messageService.validationSMS(request);
    }

    @ApiOperation(value = "邮箱发送", httpMethod = "GET", notes = "邮箱发送")
    @GetMapping("/sendEmail")
    Map<String, Object> sendEmail(@RequestParam String email){
        return messageService.sendEmail(email);
    }

    @ApiOperation(value = "邮箱验证码验证", httpMethod = "POST", notes = "邮箱验证码验证")
    @PostMapping("/validationEmail")
    Map<String, Object> validationEmail(@RequestBody EmailRequest request){
        return messageService.validationEmail(request);
    }

}
