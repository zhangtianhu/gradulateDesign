package com.travel.api.beans.request.user;

import lombok.Data;
@Data
public class RegisterRequest {
    private String mobile; // 手机号

    private String password; // 密码

    private String code; // 验证码
}
