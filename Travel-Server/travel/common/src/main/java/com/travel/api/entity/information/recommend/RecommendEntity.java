package com.travel.api.entity.information.recommend;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @ClassName RecommendEntity
 * @Author zhangtianhu
 **/
public class RecommendEntity {

    private String recommendId;

    private String imgUrl;

    private String title;

    private String desc;

    public String getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
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
