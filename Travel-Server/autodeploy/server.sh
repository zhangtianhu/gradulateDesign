#!/usr/bin/env bash
# 开始自动发布
systemctl stop user.service
systemctl stop swagger.service
systemctl stop message.service

echo "开始删除原始安装包"
if [ -f "/opt/travel/tmp/user-0.0.1-SNAPSHOT.jar" ];then

rm -rf /opt/travel/production/user-0.0.1-SNAPSHOT.jar
cd /opt/travel/production/
cp -a /opt/travel/tmp/user-0.0.1-SNAPSHOT.jar /opt/travel/production/
fi

if [ -f "/opt/travel/tmp/swagger-0.0.1-SNAPSHOT.jar" ];then
rm -rf /opt/travel/production/swagger-0.0.1-SNAPSHOT.jar
cp -a /opt/travel/tmp/swagger-0.0.1-SNAPSHOT.jar /opt/travel/production/
fi

if [ -f "/opt/travel/tmp/message-0.0.1-SNAPSHOT.jar" ];then
rm -rf /opt/travel/production/message-0.0.1-SNAPSHOT.jar
cp -a /opt/travel/tmp/message-0.0.1-SNAPSHOT.jar /opt/travel/production/
fi

echo "开始启动安装包"
systemctl start user.service
systemctl start swagger.service
systemctl start message.service

echo "开始删除临时目录安装包"
rm -rf /opt/travel/tmp/user-0.0.1-SNAPSHOT.jar
rm -rf /opt/travel/tmp/swagger-0.0.1-SNAPSHOT.jar
rm -rf /opt/travel/tmp/message-0.0.1-SNAPSHOT.jar




