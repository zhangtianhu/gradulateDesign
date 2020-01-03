package com.travel.api.controller.information.home;

import com.travel.api.entity.information.recommend.RecommendEntity;
import com.travel.api.service.RecommendService;
import com.travel.api.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName RecommendController
 * @Author liguangyao
 * @Date 19/8/18 下午11:59
 * @Version 1.0
 **/
@Api(value = "/information/recommend", description = "Travel首页产品推荐组件")
@RestController
@RequestMapping("information/recommend")
@CrossOrigin
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    @PostMapping("/save")
    @ApiOperation(value = "Travel首页产品推荐组件数据保存", httpMethod = "POST", notes = "首页产品推荐组件保存")
    public Map<String, Object> save(@RequestBody List<RecommendEntity> entitys) {
        return CommonUtil.getSuccessResult(null, recommendService.save(entitys));
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取Travel首页产品推荐组件数据集", httpMethod = "GET", notes = "获取首页产品推荐组件数据集")
    public List<RecommendEntity> list() {
        return recommendService.list();
    }

}
