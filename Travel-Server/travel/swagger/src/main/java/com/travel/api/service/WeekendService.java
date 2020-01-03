package com.travel.api.service;

import com.travel.api.entity.information.weekend.WeekendEntity;
import com.travel.api.service.fallBack.WeekendFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "api-information", fallback = WeekendFallBack.class)
public interface WeekendService {

    @PostMapping("information/weekend/save")
    Object save(@RequestBody List<WeekendEntity> entitys);

    @GetMapping("information/weekend/list")
    List<WeekendEntity> list();


}
