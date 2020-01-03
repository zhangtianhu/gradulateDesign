package com.travel.api.controller.information.home;

import com.travel.api.entity.information.crunchies.CrunchiesEntity;
import com.travel.api.service.CrunchiesService;
import com.travel.api.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CrunchiesController
 * @Author liguangyao
 * @Date 19/8/18 下午11:50
 * @Version 1.0
 **/
@Api(value = "/information/crunchies", description = "Travel首页热榜组件")
@RestController
@RequestMapping("information/crunchies")
@CrossOrigin
public class CrunchiesController {

    @Autowired
    private CrunchiesService crunchiesService;

    @PostMapping("/save")
    @ApiOperation(value = "Travel首页热榜组件数据保存", httpMethod = "POST", notes = "Travel首页热榜组件数据保存")
    public Map<String, Object> save(@RequestBody List<CrunchiesEntity> entitys) {
        return CommonUtil.getSuccessResult(null, crunchiesService.save(entitys));
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取Travel首页热榜组件数据集", httpMethod = "GET", notes = "获取Travel首页热榜组件数据集")
    public Map<String, Object> list() {
        return CommonUtil.getSuccessResult(null, crunchiesService.list());
    }

}
