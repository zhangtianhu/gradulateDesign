package com.travel.api.controller.information.home;

import com.travel.api.entity.information.icon.IconEntity;
import com.travel.api.service.IconService;
import com.travel.api.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IconController
 * @Author liguangyao
 * @Date 19/8/18 下午11:24
 * @Version 1.0
 **/
@Api(value = "/information/icon", description = "Travel首页图标组件")
@RestController
@RequestMapping("information/icon")
@CrossOrigin
public class IconController {

    @Autowired
    private IconService iconService;

    @ApiOperation(value = "Travel首页图标组件数据保存", httpMethod = "POST", notes = "Travel首页图标组件数据保存")
    @PostMapping("/save")
    public Map<String,Object> save(@RequestBody List<IconEntity> entitys) {
        return CommonUtil.getSuccessResult(null, iconService.save(entitys));
    }

    @ApiOperation(value = "获取Travel首页图标组件数据集", httpMethod = "GET", notes = "获取Travel首页图标组件数据集")
    @GetMapping("/list")
    public Map<String,Object> list() {
        return CommonUtil.getSuccessResult(null, iconService.list());
    }


}
