package com.travel.api.service.fallBack;

import com.travel.api.entity.information.recommend.RecommendEntity;
import com.travel.api.service.RecommendService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RecommendFallBack
 * @Author liguangyao
 * @Date 20/8/18 上午12:14
 * @Version 1.0
 **/
@Service("recommendService")
public class RecommendFallBack implements RecommendService {

    @Override
    public Object save(List<RecommendEntity> entitys) {
        return null;
    }

    @Override
    public List<RecommendEntity> list() {
        return null;
    }
}
