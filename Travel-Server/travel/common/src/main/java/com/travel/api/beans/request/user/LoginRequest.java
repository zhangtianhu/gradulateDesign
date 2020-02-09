package com.travel.api.beans.request.user;

import lombok.Data;
@Data
public class LoginRequest {

    private String username; // 账号 手机或者邮箱
    private String password; // 密码

}
