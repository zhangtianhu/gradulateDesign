package com.travel.api.beans;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class SysUser {
    @Id // 必须要声明, 且必须要是javax.persistence.Id
    private String id;
    private String mobile;    //  手机号
    private String email;     //  邮箱
    private String userType;  //  用户类型      1.默认普通用户,2.超级用户,3.超级管理员
    private String password;  //  密码         需要加盐处理MD510次加密
    private String name;      //  姓名
    private String photo;     //  用户头像      1.用户头像有OSS存入OSS,2.存入本地Nginx图片服务器3.第三方登录则直接获取
    private String loginIp;   //  登录IP
    private Date   loginDate; //  登录时间
    private String loginFlag; //  是否可登录    0.不可登录,1.默认可登录,2.锁住
    private String createBy;  //  创建者       和第一次创建的账号一致
    private Date   createDate;//  创建时间
    private String updateBy;  //  更新者       和当前登录的账号一致
    private Date   updateDate;//  更新时间
    private String remarks;   //  备注信息
    private String url;       //  可访问的URL   用,分割如/usr/login,/usr/register
    private String delFlag;   //  删除标记      0.未注销,1.注销
}