package com.travel.api.beans;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName RecommendEntity
 * @Author liguangyao
 * @Date 19/8/18 下午11:56
 * @Version 1.0
 **/
@Document
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
