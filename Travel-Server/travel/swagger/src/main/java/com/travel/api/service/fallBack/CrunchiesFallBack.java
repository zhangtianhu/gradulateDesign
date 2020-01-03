package com.travel.api.service.fallBack;

import com.travel.api.entity.information.crunchies.CrunchiesEntity;
import com.travel.api.service.CrunchiesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CrunchiesFallBack
 * @Author liguangyao
 * @Date 20/8/18 上午12:53
 * @Version 1.0
 **/
@Service("crunchiesService")
public class CrunchiesFallBack implements CrunchiesService {

    @Override
    public Object save(List<CrunchiesEntity> entitys) {
        return null;
    }

    @Override
    public List<CrunchiesEntity> list() {
        return null;
    }
}
