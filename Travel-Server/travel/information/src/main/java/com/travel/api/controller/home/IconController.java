package com.travel.api.controller.home;

import com.travel.api.beans.IconEntity;
import com.travel.api.service.MongoCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName 图标Controller
 * @Author liguangyao
 * @Date 19/8/18 下午11:05
 * @Version 1.0
 **/
@RestController
@RequestMapping("information/icon")
public class IconController {

    @Autowired
    private MongoCommonService mongoCommonService;

    @PostMapping("/save")
    public void save(@RequestBody List<IconEntity> entitys) {
        mongoCommonService.saveCollection(entitys);
    }

    @GetMapping("/list")
    public List<IconEntity> list() {
        return mongoCommonService.selectCollectionByName(IconEntity.class, "iconEntity");
    }
}
