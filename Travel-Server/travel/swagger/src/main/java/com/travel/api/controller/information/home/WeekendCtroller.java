package com.travel.api.controller.information.home;

import com.travel.api.entity.information.weekend.WeekendEntity;
import com.travel.api.service.WeekendService;
import com.travel.api.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName WeekendCtroller
 * @Author liguangyao
 * @Date 20/8/18 上午12:06
 * @Version 1.0
 **/
@Api(value = "/user/weekend", description = "Travel首页周末组件")
@RestController
@RequestMapping("user/weekend")
@CrossOrigin
public class WeekendCtroller {

    @Autowired
    private WeekendService weekendService;

    @PostMapping("/save")
    @ApiOperation(value = "Travel首页周末组件数据保存", httpMethod = "POST", notes = "Travel首页周末组件数据保存")
    public Map<String,Object> save(@RequestBody List<WeekendEntity> entitys) {
        return CommonUtil.getSuccessResult(null, weekendService.save(entitys));
    }

    @ApiOperation(value = "Travel首页周末组件数据集", httpMethod = "GET", notes = "Travel首页周末组件数据集")
    @GetMapping("/list")
    public Map<String,Object> list() {
        return CommonUtil.getSuccessResult(null, weekendService.list());
    }


}
