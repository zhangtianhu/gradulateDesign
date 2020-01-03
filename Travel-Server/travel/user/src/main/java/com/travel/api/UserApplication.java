package com.travel.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@EnableFeignClients
@EnableDiscoveryClient
/**
 *	@MapperScan仅扫描业务接口包，不能扫描本地通用Mapper接口包，
 *	否则报java.lang.ClassCastException: sun.reflect.generics.reflectiveObjects.TypeVariableImpl
 *	cannot be cast to java.lang.Class异常
 */
@MapperScan(basePackages="com.travel.api.interfaces")
@SpringBootApplication
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
