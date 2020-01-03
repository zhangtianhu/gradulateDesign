package com.travel.api.beans.request.user;

import lombok.Data;

/**
 * @ClassName RegisterRequest
 * @Author liguangyao
 * @Date 24/8/18 下午8:02
 * @Version 1.0
 **/
@Data
public class RegisterRequest {
    private String mobile; // 手机号

    private String password; // 密码

    private String code; // 验证码
}
