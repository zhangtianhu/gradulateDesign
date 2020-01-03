package com.travel.api.controller.information.home;

import com.travel.api.entity.information.swiper.SwiperEntity;
import com.travel.api.service.SwiperService;
import com.travel.api.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName 轮播图Controller
 * @Author liguangyao
 * @Date 18/8/18 下午11:19
 * @Version 1.0
 **/
@Api(value = "/information/swiper", description = "Travel首页轮播图组件")
@RestController
@RequestMapping("information/swiper")
@CrossOrigin
public class SwiperController {

    @Autowired
    private SwiperService swiperService;

    @ApiOperation(value = "Travel首页轮播图组件数据保存", httpMethod = "POST", notes = "Travel首页轮播图组件数据保存")
    @PostMapping("/save")
    public Map<String,Object> save(@RequestBody List<SwiperEntity> entitys) {
        return CommonUtil.getSuccessResult(null, swiperService.save(entitys));
    }

    @ApiOperation(value = "获取Travel首页轮播图组件数据集", httpMethod = "GET", notes = "获取Travel首页轮播图组件数据集")
    @GetMapping("/list")
    public Map<String,Object> list() {
        return CommonUtil.getSuccessResult(null, swiperService.list());
    }
}
