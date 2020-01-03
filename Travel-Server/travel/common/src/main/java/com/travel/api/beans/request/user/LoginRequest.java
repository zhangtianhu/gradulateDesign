package com.travel.api.beans.request.user;

import lombok.Data;

/**
 * @ClassName LoginRequest
 * @Author liguangyao
 * @Date 22/8/18 下午4:50
 * @Version 1.0
 **/
@Data
public class LoginRequest {

    private String username; // 账号 手机或者邮箱
    private String password; // 密码

}
