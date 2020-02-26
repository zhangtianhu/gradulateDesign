package com.travel.api.controller.home;

import com.travel.api.beans.RecommendEntity;
import com.travel.api.service.MongoCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName RecommendController
 * @Author zhangtianhu
 * @Date 19/8/18 下午11:59
 * @Version 1.0
 **/
@RestController
@RequestMapping("information/recommend")
public class RecommendController {

    @Autowired
    private MongoCommonService mongoCommonService;

    @PostMapping("/save")
    public void save(@RequestBody List<RecommendEntity> entitys) {
        mongoCommonService.saveCollection(entitys);
    }

    @GetMapping("/list")
    public List<RecommendEntity> list() {
        return mongoCommonService.selectCollectionByName(RecommendEntity.class, "recommendEntity");
    }

}
