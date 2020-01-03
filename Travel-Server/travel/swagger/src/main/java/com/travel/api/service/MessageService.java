package com.travel.api.service;

import com.travel.api.beans.request.message.EmailRequest;
import com.travel.api.beans.request.message.SMSRequest;
import com.travel.api.service.fallBack.MessageFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "api-message", fallback = MessageFallBack.class)
public interface MessageService {

    /**
     * 短信发送
     * @param mobile
     * @return
     */
    @GetMapping("message/sendSMS")
    Map<String, Object> sendSMS(@RequestParam("mobile") String mobile);

    /**
     * 短信验证码验证
     * @param request
     * @return
     */
    @PostMapping("message/validationSMS")
    Map<String, Object> validationSMS(@RequestBody SMSRequest request);

    /**
     * 邮箱发送
     * @param email
     * @return
     */
    @GetMapping("message/sendEmail")
    Map<String, Object> sendEmail(@RequestParam("email") String email);

    /**
     * 邮箱验证码验证
     * @param request
     * @return
     */
    @PostMapping("message/validationEmail")
    Map<String, Object> validationEmail(@RequestBody EmailRequest request);
}
