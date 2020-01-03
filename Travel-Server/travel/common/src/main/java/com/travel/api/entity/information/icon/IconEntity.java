package com.travel.api.entity.information.icon;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @ClassName IconEntity
 * @Author liguangyao
 * @Date 19/8/18 下午11:17
 * @Version 1.0
 **/
public class IconEntity {

    private String iconId;

    private String imgUrl;

    private String desc;

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
