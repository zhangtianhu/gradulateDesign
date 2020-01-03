package com.travel.api.controller.home;

import com.travel.api.beans.CrunchiesEntity;
import com.travel.api.service.MongoCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CrunchiesController
 * @Author liguangyao
 * @Date 19/8/18 下午11:50
 * @Version 1.0
 **/
@RestController
@RequestMapping("information/crunchies")
public class CrunchiesController {

    @Autowired
    private MongoCommonService mongoCommonService;

    @PostMapping("/save")
    public void save(@RequestBody List<CrunchiesEntity> entitys) {
        mongoCommonService.saveCollection(entitys);
    }

    @GetMapping("/list")
    public List<CrunchiesEntity> list() {
        return mongoCommonService.selectCollectionByName(CrunchiesEntity.class, "crunchiesEntity");
    }

}
