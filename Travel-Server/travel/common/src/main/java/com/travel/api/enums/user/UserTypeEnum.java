package com.travel.api.enums.user;

import lombok.Getter;

@Getter
public enum UserTypeEnum {
    ORDINARY_USER("1", "普通用户"),
    SUPER_USER("2", "超级用户"),
    SUPER_ADMINISTRATOR("3", "超级管理员")
    ;

    private String value;
    private String name;

    UserTypeEnum(String value, String name){
        this.value = value;
        this.name = name;
    }

}
