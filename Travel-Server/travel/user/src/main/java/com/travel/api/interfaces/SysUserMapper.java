package com.travel.api.interfaces;

import com.travel.api.beans.SysUser;

import com.travel.api.mappers.CommonMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserMapper extends CommonMapper<SysUser> {



}