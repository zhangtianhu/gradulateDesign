package com.travel.api.beans;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName CityEntity
 * @Author zhangtianhu
 * @Date 20/8/18 下午11:38
 * @Version 1.0
 **/
@Document
public class CityEntity {

    private Integer cityId;

    private String spell;

    private String name;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
