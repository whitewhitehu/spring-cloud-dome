package com.spdata.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yangqifang
 * @date 2019年3月7日
 * @deprecated 配置服务
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerStart {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerStart.class, args);
    }

}
