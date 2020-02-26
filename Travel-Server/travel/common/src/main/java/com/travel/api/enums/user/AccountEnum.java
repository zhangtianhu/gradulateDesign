package com.travel.api.enums.user;

import lombok.Getter;

@Getter
public enum  AccountEnum {

    NO_LOGIN("0","不可以登录"),
    YES_LOGIN("1","可以登录"),
    LOCK_LOGIN("2","登录已锁")
    ;

    private String value;
    private String name;

    AccountEnum(String value, String name) {
     this.value = value;
     this.name = name;
    }

}
