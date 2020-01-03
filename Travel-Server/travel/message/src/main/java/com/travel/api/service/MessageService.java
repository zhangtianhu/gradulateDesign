package com.travel.api.service;

import java.util.Map;

/**
 * @ClassName 消息Service
 * @Author liguangyao
 * @Date 23/8/18 下午2:48
 * @Version 1.0
 **/
public interface MessageService {

    /**
     * 短信发送
     * @param mobile 手机号
     * @param code 验证码
     * @return
     */
    String sendSMS(String mobile, String code);

    /**
     * 邮箱发送
     * @param email 邮箱
     * @param code 验证码
     * @return
     */
    void sendEmail(String email, String code);

}
