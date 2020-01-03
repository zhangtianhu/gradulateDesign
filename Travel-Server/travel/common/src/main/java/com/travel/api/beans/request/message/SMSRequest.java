package com.travel.api.beans.request.message;

import lombok.Data;

/**
 * @ClassName SMSRequest
 * @Author liguangyao
 * @Date 24/8/18 上午12:25
 * @Version 1.0
 **/
@Data
public class SMSRequest {
    private String mobile; // 手机号
    private String code; // 验证码
}
