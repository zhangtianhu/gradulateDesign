#!/usr/bin/env bash

gitPath=/opt/auto_deploy/Travel-Server/
serverAddress=root@47.99.76.180

cd ${gitPath}
# git pull

# 开始编译common模块
cd ${gitPath}/travel/common
mvn clean install -Dmaven.test.skip=true


# 开始编译发布user模块
cd ${gitPath}/travel/user
mvn clean package -Dmaven.test.skip=true
jar=${gitPath}/travel/user/target/user-0.0.1-SNAPSHOT.jar
echo "开始上传user模块"
echo ${jar}
scp -P 5188 ${jar} ${serverAddress}:/opt/travel/tmp

# 开始编译发布swagger模块
cd ${gitPath}/travel/swagger
mvn clean package -Dmaven.test.skip=true
jar=${gitPath}/travel/swagger/target/swagger-0.0.1-SNAPSHOT.jar
echo "开始上传swagger模块"
echo ${jar}
scp -P 5188 ${jar} root@47.99.76.180:/opt/travel/tmp

# 开始编译发布risk模块
cd ${gitPath}/travel/risk
mvn clean package -Dmaven.test.skip=true
jar=${gitPath}/travel/risk/target/risk-0.0.1-SNAPSHOT.jar
echo "开始上传risk模块"
echo ${jar}
scp -P 5188 ${jar} root@47.99.76.180:/opt/travel/tmp

# 开始编译发布message模块
cd ${gitPath}/travel/message
mvn clean package -Dmaven.test.skip=true
jar=${gitPath}/travel/message/target/message-0.0.1-SNAPSHOT.jar
echo "开始上传message模块"
echo ${jar}
scp -P 5188 ${jar} root@47.99.76.180:/opt/travel/tmp

ssh -oPort=5188 root@47.99.76.180 "sh /root/server.sh"










