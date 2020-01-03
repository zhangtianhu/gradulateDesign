package com.travel.api.controller.home;

import com.travel.api.beans.SwiperEntity;
import com.travel.api.service.MongoCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SwiperController
 * @Author liguangyao
 * @Date 18/8/18 下午9:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("information/swiper")
public class SwiperController {

    @Autowired
    private MongoCommonService mongoCommonService;

    @PostMapping("/save")
    public void save(@RequestBody List<SwiperEntity> entitys) {
        mongoCommonService.saveCollection(entitys);
    }

    @GetMapping("/list")
    public List<SwiperEntity> list() {
        return mongoCommonService.selectCollectionByName(SwiperEntity.class, "swiperEntity");
    }

}
