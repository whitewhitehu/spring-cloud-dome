FROM java:8
MAINTAINER yangqifang<1114923161@qq.com>
WORKDIR /open/config/
ADD /target/config-server-0.0.1-SNAPSHOT.jar /open/config/
ENTRYPOINT ["java","-jar","config-server-0.0.1-SNAPSHOT.jar"]
EXPOSE 10001