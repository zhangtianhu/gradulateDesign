package com.travel.api.service.impl;

import com.travel.api.service.MongoCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MongoCommonServiceImpl
 * @Author liguangyao
 * @Date 19/8/18 下午5:59
 * @Version 1.0
 **/
@Service
public class MongoCommonServiceImpl implements MongoCommonService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveCollection(List objects) {
        mongoTemplate.insertAll(objects);
    }

    @Override
    public List selectCollectionByName(Class cla, String name) {
        return mongoTemplate.findAll(cla, name);
    }
}
