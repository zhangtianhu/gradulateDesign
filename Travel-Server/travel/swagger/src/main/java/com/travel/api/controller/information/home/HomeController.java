package com.travel.api.controller.information.home;

import com.travel.api.beans.response.HomeResponse;
import com.travel.api.entity.information.crunchies.CrunchiesEntity;
import com.travel.api.entity.information.icon.IconEntity;
import com.travel.api.entity.information.recommend.RecommendEntity;
import com.travel.api.entity.information.swiper.SwiperEntity;
import com.travel.api.entity.information.weekend.WeekendEntity;
import com.travel.api.service.*;
import com.travel.api.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Travel首页Controller
 * @Author liguangyao
 * @Date 13/8/18 下午1:41
 * @Version 1.0
 **/
@Api(value = "/information/home", description = "Travel首页")
@RestController
@RequestMapping("information/home")
@CrossOrigin
public class HomeController {

    @Autowired
    private CrunchiesService crunchiesService;

    @Autowired
    private IconService iconService;

    @Autowired
    private RecommendService recommendService;

    @Autowired
    private SwiperService swiperService;

    @Autowired
    private WeekendService weekendService;

    @ApiOperation(value = "Travel首页数据信息数据集", httpMethod = "GET", notes = "Travel首页数据信息数据集")
    @GetMapping("/list")
    public Map<String, Object> indexList() {

        List<CrunchiesEntity> crunchiesList = crunchiesService.list();
        List<IconEntity> iconList = iconService.list();
        List<RecommendEntity> recommendList = recommendService.list();
        List<SwiperEntity> swiperList = swiperService.list();
        List<WeekendEntity> weekendList = weekendService.list();

        HomeResponse homeResponse = new HomeResponse(
                crunchiesList,
                iconList,
                recommendList,
                swiperList,
                weekendList
        );
        return CommonUtil.getSuccessResult(null, homeResponse);
    }

}
