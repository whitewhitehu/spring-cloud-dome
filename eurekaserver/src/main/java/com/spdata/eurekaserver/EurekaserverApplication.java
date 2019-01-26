package com.spdata.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @author yangqifang
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaserverApplication {


    public static void main(String[] args) {
        SpringApplication.run(EurekaserverApplication.class, args);
    }

}
