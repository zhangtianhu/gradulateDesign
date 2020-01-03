package com.travel.api.service.fallBack;

import com.travel.api.entity.information.weekend.WeekendEntity;
import com.travel.api.service.WeekendService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName WeekendFallBack
 * @Author liguangyao
 * @Date 20/8/18 上午12:39
 * @Version 1.0
 **/
@Service("weekendService")
public class WeekendFallBack implements WeekendService {

    @Override
    public Object save(List<WeekendEntity> entitys) {
        return null;
    }

    @Override
    public List<WeekendEntity> list() {
        return null;
    }
}
