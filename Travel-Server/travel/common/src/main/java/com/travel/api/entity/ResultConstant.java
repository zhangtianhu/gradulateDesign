package com.travel.api.entity;

public class ResultConstant {
    /**
     * 请求成功后的返回
     */
    public static final Integer SUCCESS_RESULT_CODE = 200;

    /**
     * 请求失败后的返回
     */
    public static final Integer FAIL_RESULT_CODE = -1;

    /**
     * 返回登录
     */
    public static final Integer RETURN_LOGIN_CODE = 401;

    /**
     * 账号或密码错误
     */
    public static final Integer USERNAME_OR_PASSWORD_EOOR = 69999;


    /**
     * 账号不存在
     */
    public static final Integer USERNAME_NOT_FOUND = 70000;

    /**
     * 用户注册失败
     */
    public static final Integer USER_REGISTER_ERROR = 80000;

    /**
     * 手机号已被使用
     */
    public static final Integer MOBILE_ALREADY_REGISTER = 80001;

    /**
     * 短信请求次数过多
     */
    public static final Integer SMS_TOO_MANY = 100000;

    /**
     * 短信1分钟内只能请求一次
     */
    public static final Integer SMS_ALREADY = 100001;

    /**
     * 短信验证码超时
     */
    public static final Integer SMS_TIMEOUT = 100002;

    /**
     * 短信验证码验证不正确
     */
    public static final Integer SMS_VALIDATION_NO = 100003;

    /**
     * 邮箱验证码超时
     */
    public static final Integer EMAIL_TIMEOUT = 100004;

    /**
     * 邮箱验证码验证不正确
     */
    public static final Integer EMAIL_VALIDATION_NO = 100005;

    /**
     * 邮箱不存在
     */
    public static final Integer EMAIL_NOT_FOUND = 100006;
}
