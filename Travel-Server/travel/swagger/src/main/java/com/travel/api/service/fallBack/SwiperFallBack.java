package com.travel.api.service.fallBack;

import com.travel.api.entity.information.swiper.SwiperEntity;
import com.travel.api.service.SwiperService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SwiperFallBack
 * @Author liguangyao
 * @Date 18/8/18 下午11:25
 * @Version 1.0
 **/
@Service("swiperService")
public class SwiperFallBack implements SwiperService {

    @Override
    public Object save(List<SwiperEntity> entitys) {
        return null;
    }

    @Override
    public List<SwiperEntity> list() {
        return null;
    }
}
