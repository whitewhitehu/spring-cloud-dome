FROM java:8
MAINTAINER yangqifang<1114923161@qq.com>
WORKDIR /open/eureka/

COPY /target/eurekaserver-0.0.1-SNAPSHOT.jar /open/eureka/

ENTRYPOINT ["java","-jar","eurekaserver-0.0.1-SNAPSHOT.jar"]
EXPOSE 8761