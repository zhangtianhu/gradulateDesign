package com.travel.api.controller;

import com.travel.api.beans.request.message.EmailRequest;
import com.travel.api.beans.request.message.SMSRequest;
import com.travel.api.entity.ResultConstant;
import com.travel.api.service.MessageService;
import com.travel.api.util.CommonUtil;
import com.travel.api.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("message")
@Slf4j
public class MessageController{
    private String SMS_NUMBER_PREFIX = "SMS::NUMBER::PREFIX::"; // SMS请求次数REDIS KEY前缀
    private String SMS_VALIDATION_PREFIX = "SMS::VALIDATION::PREFIX::"; // 验证码REDIS KEY前缀
    private String EMAIL_NUMBER_PREFIX = "EMAIL::NUMBER::PREFIX::"; // EMAIL请求次数REDIS KEY前缀

    @Autowired
    private MessageService messageService;

    /**
     * 短信发送
     * @return
     */
    @GetMapping("/sendSMS")
    public Map<String, Object> sendSMS(@RequestParam("mobile") String mobile) {
        // 先判断请求次数是否超过5次
        String redisNumber = RedisUtil.get(SMS_NUMBER_PREFIX + mobile);
        Integer number = 0;
        if(!StringUtils.isEmpty(redisNumber)) {
            number = Integer.parseInt(redisNumber);
            if (number >5) {
                return CommonUtil.getFailResult(ResultConstant.SMS_TOO_MANY, "今天的短信请求次数达到上限");
            }
        }
        // 再判断该手机号在1分钟内是否已经发送验证码
        String redisCode = RedisUtil.get(SMS_VALIDATION_PREFIX + mobile);
        if(!StringUtils.isEmpty(redisCode)) {
            return CommonUtil.getFailResult(ResultConstant.SMS_ALREADY, "短信验证码1分钟内只能发送一次");
        }

        String code = String.valueOf(CommonUtil.randomNo(4)); // 验证码
        // 次数和验证码存入Redis中 次数Key存活时间为1天 验证码Key上限为1分钟
        RedisUtil.setValue(SMS_NUMBER_PREFIX + mobile, String.valueOf(number + 1), 60 * 60 * 24);
        RedisUtil.setValue(SMS_VALIDATION_PREFIX + mobile, code, 60);
        // 发送验证码
        // messageService.sendSMS(mobile, code); // TODO 接口已经调通需要调用的打开注释就行, 测试暂时不调用发送接口次数伤不起
        log.info("[短信发送]手机号[{}], 验证码[{}]", mobile, code);
        return CommonUtil.getSuccessResult();
    }

    /**
     * 短信验证码验证
     * @param request
     * @return
     */
    @PostMapping("/validationSMS")
    public Map<String, Object> validationSMS(@RequestBody SMSRequest request) {
        String validation = RedisUtil.get(SMS_VALIDATION_PREFIX + request.getMobile()); // REDIS存储的验证码
        if(StringUtils.isEmpty(validation)) {
            return CommonUtil.getFailResult(ResultConstant.SMS_TIMEOUT, "验证码已失效,请重新发送");
        }
        if(validation.equals(request.getCode())) {
            return CommonUtil.getSuccessResult("短信验证码正确",null);
        }
        return CommonUtil.getFailResult(ResultConstant.SMS_VALIDATION_NO,"短信验证码不正确");
    }

    /**
     * 邮箱发送
     * @return
     */
    @GetMapping("/sendEmail")
    public Map<String, Object> sendEmail(@RequestParam("email") String email) {
        String code = String.valueOf(CommonUtil.randomNo(4)); // 验证码
        // 这里只将验证码存入REDIS中即可, 设置有效时间为1天
        RedisUtil.setValue(EMAIL_NUMBER_PREFIX + email, code, 60 * 60 * 24);
        messageService.sendEmail(email, code);
        return CommonUtil.getSuccessResult();
    }

    /**
     * 邮箱验证码验证
     * @return
     */
    @PostMapping("/validationEmail")
    public Map<String, Object> validationEmail(@RequestBody EmailRequest request) {
        String code = RedisUtil.get(EMAIL_NUMBER_PREFIX + request.getEmail());
        if(StringUtils.isEmpty(code)) {
            return CommonUtil.getFailResult(ResultConstant.EMAIL_TIMEOUT, "验证码已失效,请重新发送");
        }
        if(code.equals(request.getCode())) {
            return CommonUtil.getSuccessResult();
        }
        return CommonUtil.getFailResult(ResultConstant.EMAIL_VALIDATION_NO, "邮箱验证码不正确");
    }
}
