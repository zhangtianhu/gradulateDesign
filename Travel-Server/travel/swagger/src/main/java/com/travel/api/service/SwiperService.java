package com.travel.api.service;

import com.travel.api.entity.information.swiper.SwiperEntity;
import com.travel.api.service.fallBack.SwiperFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "api-information", fallback = SwiperFallBack.class)
public interface SwiperService {

    @PostMapping("information/swiper/save")
    Object save(@RequestBody List<SwiperEntity> entitys);

    @GetMapping("information/swiper/list")
    List<SwiperEntity> list();
}
