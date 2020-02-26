package com.travel.api.entity.information.swiper;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @ClassName SwiperEntity
 * @Author zhangtianhu
 **/
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
