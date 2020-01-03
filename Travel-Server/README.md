# Travel-Server

#### 项目介绍

[mysql]存放mysql数据<br>
--- travel 父工程<br>
--- eureka 服务注册中心模块<br>
--- common 公共模块 <br>
--- gateway 网关模块<br>
--- message 消息模块<br>
--- swagger Swagger API 模块<br>
--- user 用户模块<br>
--- information 产品信息模块<br>

#### 软件架构

SpringCloud+Docker

#### 使用说明

1. 打开IDEA最右边Maven Projects添加travel的pom文件
2. 先运行Eureka模块，这是服务注册中心必须先运行不然各个模块无法注册
3. 运行其他模块
4. 打开localhost:8080 可以看到服务注册中心的界面
5. 打开localhost:10000/swagger-ui.html 可以看到Swagger API 界面
6. 打开localhost:80801/swagger/swagger-ui.html 网关启用
7. http://www.travelproject.top:8081/nexus/#welcome 线上Maven私服 账号:admin 密码:admin123