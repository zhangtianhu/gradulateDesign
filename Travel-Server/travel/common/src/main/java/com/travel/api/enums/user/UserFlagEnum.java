package com.travel.api.enums.user;

import lombok.Getter;

@Getter
public enum UserFlagEnum {
    NO_CANCEL("0", "未注销"),
    YES_CANCEL("1", "已经注销"),
    ;

    private String value;
    private String name;

    UserFlagEnum(String value, String name){
        this.value = value;
        this.name = name;
    }
}
