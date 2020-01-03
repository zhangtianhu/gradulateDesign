package com.travel.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.api.beans.SysUser;
import com.travel.api.beans.request.BaseRequest;
import com.travel.api.beans.request.user.LoginRequest;
import com.travel.api.beans.request.user.RegisterRequest;
import com.travel.api.entity.ResultConstant;
import com.travel.api.enums.user.AccountEnum;
import com.travel.api.enums.user.UserFlagEnum;
import com.travel.api.enums.user.UserTypeEnum;
import com.travel.api.interfaces.SysUserMapper;
import com.travel.api.service.UserService;
import com.travel.api.util.CommonUtil;
import com.travel.api.util.MD5Util;
import com.travel.api.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Author liguangyao
 * @Date 13/8/18 下午3:21
 * @Version 1.0
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private static final String TOKEN_PREFIX = "TOKEN::PREFIX::";

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public PageInfo list(BaseRequest request) {
        PageHelper.startPage(request.getPageNo(), request.getPageSize());
        List<SysUser> userList = sysUserMapper.selectAll();
        PageInfo pageInfo = new PageInfo(userList);
        return pageInfo;
    }

    @Override
    @Transactional
    public Map<String, Object> register(RegisterRequest request) {
        SysUser sysUser = new SysUser();
        sysUser.setMobile(request.getMobile());
        List<SysUser> sysUserList = sysUserMapper.select(sysUser);
        if(!sysUserList.isEmpty()){
            // 判断手机号是否已经注册, 若已经注册则返回账号已经注册
            return CommonUtil.getFailResult(ResultConstant
                    .MOBILE_ALREADY_REGISTER, "手机号已被使用");
        }
        sysUser.setId(CommonUtil.getId());
        sysUser.setUserType(UserTypeEnum.ORDINARY_USER.getValue()); // 普通用户类型
        sysUser.setPassword(MD5Util.generate(request.getPassword())); // 密码加盐
        sysUser.setName(request.getMobile()); // 默认使用手机号
        sysUser.setLoginFlag(AccountEnum.YES_LOGIN.getValue());
        sysUser.setCreateBy(request.getMobile());
        sysUser.setCreateDate(new Date());
        sysUser.setUpdateBy(request.getMobile());
        sysUser.setUpdateDate(new Date());
        sysUser.setDelFlag(UserFlagEnum.NO_CANCEL.getValue());
        log.info("[用户注册]SysUser: {}", sysUser);
        int register = sysUserMapper.insert(sysUser);
        return register == 1? CommonUtil.getSuccessResult() : CommonUtil
                .getFailResult(ResultConstant.USER_REGISTER_ERROR, "用户注册失败");
    }

    @Override
    public Map<String, Object> login(LoginRequest request, HttpServletRequest servletRequest) {
        SysUser sysUser = new SysUser();
        // 判断是手机号登录还是邮箱登录
        String username = request.getUsername();
        List<SysUser> sysUserList = null;
        if(username.contains("@")) { // 邮箱登录
            sysUser.setEmail(request.getUsername());
            sysUserList = sysUserMapper.select(sysUser);
            if(sysUserList.isEmpty()) {
                return CommonUtil.getFailResult(ResultConstant.USERNAME_OR_PASSWORD_EOOR, "账号或密码错误");
            }
        }else{
            sysUser.setMobile(request.getUsername()); // 手机号登录
            sysUserList = sysUserMapper.select(sysUser);
            if(sysUserList.isEmpty()) {
                return CommonUtil.getFailResult(ResultConstant.USERNAME_OR_PASSWORD_EOOR, "账号或密码错误");
            }
        }
        // 判断密码是否正确
        SysUser sqlSysUser = sysUserList.get(0);
        String md5Password = sqlSysUser.getPassword();
        if (!MD5Util.verify(request.getPassword(), md5Password)) {
            return CommonUtil.getFailResult(ResultConstant.USERNAME_OR_PASSWORD_EOOR, "账号或密码错误");
        }

        sqlSysUser.setLoginIp(servletRequest.getAttribute("IP").toString());
        sqlSysUser.setLoginDate(new Date());
        sqlSysUser.setUpdateDate(new Date());
        int update = sysUserMapper.updateByPrimaryKeySelective(sqlSysUser);
        // 创建Token 存入Redis中有效时间1小时并返回
        String token = CommonUtil.getId();
        RedisUtil.setValue(TOKEN_PREFIX + token, sqlSysUser.getMobile(), 60 * 60);
        // 返回前端Token值
        log.info("[用户登录]账号:{},Token:{}",request.getUsername(), token);
        return CommonUtil.getSuccessResult("登录成功", token);
    }

    @Override
    public boolean judgeToken(String token) {
        String reToken = RedisUtil.get(TOKEN_PREFIX + token);
        return StringUtils.isEmpty(reToken);
    }
}
