package com.travel.api.controller.home;

import com.travel.api.beans.WeekendEntity;
import com.travel.api.service.MongoCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName WeekendCtroller
 * @Author liguangyao
 * @Date 20/8/18 上午12:06
 * @Version 1.0
 **/
@RestController
@RequestMapping("information/weekend")
public class WeekendCtroller {

    @Autowired
    private MongoCommonService mongoCommonService;

    @PostMapping("/save")
    public void save(@RequestBody List<WeekendEntity> entitys) {
        mongoCommonService.saveCollection(entitys);
    }

    @GetMapping("/list")
    public List<WeekendEntity> list() {
        return mongoCommonService.selectCollectionByName(WeekendEntity.class, "weekendEntity");
    }


}
