package com.travel.api.beans.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.api.entity.information.crunchies.CrunchiesEntity;
import com.travel.api.entity.information.icon.IconEntity;
import com.travel.api.entity.information.recommend.RecommendEntity;
import com.travel.api.entity.information.swiper.SwiperEntity;
import com.travel.api.entity.information.weekend.WeekendEntity;

import java.util.List;

/**
 * @ClassName 首页数据返回实体类
 * @Author liguangyao
 * @Date 20/8/18 下午1:14
 * @Version 1.0
 **/
public class HomeResponse {

    @JsonProperty("crunchiesList")
    private List<CrunchiesEntity> crunchiesEntity;

    @JsonProperty("iconList")
    private List<IconEntity> iconEntity;

    @JsonProperty("recommendList")
    private List<RecommendEntity> recommendEntity;

    @JsonProperty("swiperList")
    private List<SwiperEntity> swiperEntity;

    @JsonProperty("weekendList")
    private List<WeekendEntity> weekendEntity;

    public List<CrunchiesEntity> getCrunchiesEntity() {
        return crunchiesEntity;
    }

    public void setCrunchiesEntity(List<CrunchiesEntity> crunchiesEntity) {
        this.crunchiesEntity = crunchiesEntity;
    }

    public List<IconEntity> getIconEntity() {
        return iconEntity;
    }

    public void setIconEntity(List<IconEntity> iconEntity) {
        this.iconEntity = iconEntity;
    }

    public List<RecommendEntity> getRecommendEntity() {
        return recommendEntity;
    }

    public void setRecommendEntity(List<RecommendEntity> recommendEntity) {
        this.recommendEntity = recommendEntity;
    }

    public List<SwiperEntity> getSwiperEntity() {
        return swiperEntity;
    }

    public void setSwiperEntity(List<SwiperEntity> swiperEntity) {
        this.swiperEntity = swiperEntity;
    }

    public List<WeekendEntity> getWeekendEntity() {
        return weekendEntity;
    }

    public void setWeekendEntity(List<WeekendEntity> weekendEntity) {
        this.weekendEntity = weekendEntity;
    }

    public HomeResponse(List<CrunchiesEntity> crunchiesEntity, List<IconEntity> iconEntity, List<RecommendEntity> recommendEntity, List<SwiperEntity> swiperEntity, List<WeekendEntity> weekendEntity) {
        this.crunchiesEntity = crunchiesEntity;
        this.iconEntity = iconEntity;
        this.recommendEntity = recommendEntity;
        this.swiperEntity = swiperEntity;
        this.weekendEntity = weekendEntity;
    }

}
