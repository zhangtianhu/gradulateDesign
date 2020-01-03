package com.travel.api.entity.information.weekend;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @ClassName WeekendEntity
 * @Author liguangyao
 * @Date 20/8/18 上午12:03
 * @Version 1.0
 **/
public class WeekendEntity {

    private String weekendId;

    private String imgUrl;

    private String title;

    private String desc;

    public String getWeekendId() {
        return weekendId;
    }

    public void setWeekendId(String weekendId) {
        this.weekendId = weekendId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
