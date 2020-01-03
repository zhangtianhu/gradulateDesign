package com.travel.api.service.fallBack;

import com.travel.api.entity.information.icon.IconEntity;
import com.travel.api.service.IconService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName IconFallBack
 * @Author liguangyao
 * @Date 19/8/18 下午11:28
 * @Version 1.0
 **/
@Service("iconService")
public class IconFallBack implements IconService {

    @Override
    public Object save(List<IconEntity> entitys) {
        return null;
    }

    @Override
    public List<IconEntity> list() {
        return null;
    }
}
