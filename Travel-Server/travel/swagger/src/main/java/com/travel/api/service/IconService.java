package com.travel.api.service;

import com.travel.api.entity.information.icon.IconEntity;
import com.travel.api.service.fallBack.IconFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @ClassName IconService
 * @Author liguangyao
 * @Date 19/8/18 下午11:27
 * @Version 1.0
 **/
@FeignClient(name = "api-information", fallback = IconFallBack.class)
public interface IconService {

    @PostMapping("information/icon/save")
    Object save(@RequestBody List<IconEntity> entitys);

    @GetMapping("information/icon/list")
    List<IconEntity> list();
}
