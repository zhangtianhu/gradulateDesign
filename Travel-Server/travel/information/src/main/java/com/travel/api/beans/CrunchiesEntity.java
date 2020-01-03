package com.travel.api.beans;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName CrunchiesEntity
 * @Author liguangyao
 * @Date 19/8/18 下午11:51
 * @Version 1.0
 **/
@Document
public class CrunchiesEntity {

    private String crunchiesId;

    private String imgUrl;

    private String title;

    private Integer price;

    public String getCrunchiesId() {
        return crunchiesId;
    }

    public void setCrunchiesId(String crunchiesId) {
        this.crunchiesId = crunchiesId;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
