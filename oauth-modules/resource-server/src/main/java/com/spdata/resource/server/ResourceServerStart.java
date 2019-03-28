package com.spdata.resource.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author yangqifang
 * @date 2019/3/17-20:55
 * @deprecated :
 **/
@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
@EnableResourceServer
@EnableEurekaClient
public class ResourceServerStart {
    public static void main(String[] args) {
        SpringApplication.run(ResourceServerStart.class, args);
    }
}
