package com.travel.api.beans.request.message;

import lombok.Data;

@Data
public class SMSRequest {
    private String mobile; // 手机号
    private String code; // 验证码
}
