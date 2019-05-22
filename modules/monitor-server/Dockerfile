FROM java:8
MAINTAINER yangqifang<1114923161@qq.com>
WORKDIR /open/monitor/
ADD /target/monitor-server-0.0.1-SNAPSHOT.jar /open/monitor/
ENTRYPOINT ["java","-jar","monitor-server-0.0.1-SNAPSHOT.jar"]
EXPOSE 9000