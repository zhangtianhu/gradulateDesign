package com.travel.api.service;

import java.util.List;

/**
 * Mongodb公共方法
 */
public interface MongoCommonService {

    /** 数据集保存 */
    void saveCollection(List objects);

    /** 通过名字查询数据集 */
    List selectCollectionByName(Class cla, String name);

}
