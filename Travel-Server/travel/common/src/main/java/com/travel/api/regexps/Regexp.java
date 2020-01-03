package com.travel.api.regexps;

/**
 * @ClassName 正则表达
 * @Author liguangyao
 * @Version 1.0
 **/
public class Regexp {

    //身份正则表达验证
    public static final String ID_CARD = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx])|([1−9]\\d5\\d2((0[1−9])|(10|11|12))(([0−2][1−9])|10|20|30|31)\\d2[0−9Xx])";

    //手机号正则表达验证
    public static final String MOBILE = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";

    //银行卡号验证
    public static final String BANK_CARD = "/^([1-9]{1})(\\d{14}|\\d{18})$/";
}
