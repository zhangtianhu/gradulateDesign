package com.travel.api.beans.request.message;

import lombok.Data;

/**
 * @ClassName EmailRequest
 * @Author liguangyao
 * @Date 24/8/18 上午1:17
 * @Version 1.0
 **/
@Data
public class EmailRequest {
    private String email; // 接收人邮箱
    private String code; // 验证码
}
