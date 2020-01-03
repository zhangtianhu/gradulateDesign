package com.travel.api.service;

import com.travel.api.entity.information.crunchies.CrunchiesEntity;
import com.travel.api.entity.information.icon.IconEntity;
import com.travel.api.service.fallBack.CrunchiesFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "api-information", fallback = CrunchiesFallBack.class)
public interface CrunchiesService {

    @PostMapping("information/crunchies/save")
    Object save(@RequestBody List<CrunchiesEntity> entitys);

    @GetMapping("information/crunchies/list")
    List<CrunchiesEntity> list();

}
