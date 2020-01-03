package com.travel.api.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * Created by Administrator on 2018-01-19.
 */
public interface Mapper<T> {

    int countByExample(Object example);

    int deleteByExample(Object example);

    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(Object example);

    T selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);

    int updateByExample(@Param("record") T record, @Param("example") Object example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}