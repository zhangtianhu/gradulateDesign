package com.travel.api.beans;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

/**
 * @ClassName 轮播图实体类
 * @Author zhangtianhu
 * @Date 18/8/18 下午9:42
 * @Version 1.0
 **/
@Document
public class SwiperEntity {

    private String swiperId;

    private String imgUrl;

    public String getSwiperId() {
        return swiperId;
    }

    public void setSwiperId(String swiperId) {
        this.swiperId = swiperId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
