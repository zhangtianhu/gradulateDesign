package com.travel.api.service;

import com.travel.api.entity.information.recommend.RecommendEntity;
import com.travel.api.service.fallBack.RecommendFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "api-information", fallback = RecommendFallBack.class)
public interface RecommendService {

    @PostMapping("information/recommend/save")
    Object save(@RequestBody List<RecommendEntity> entitys);

    @GetMapping("information/recommend/list")
    List<RecommendEntity> list();

}
