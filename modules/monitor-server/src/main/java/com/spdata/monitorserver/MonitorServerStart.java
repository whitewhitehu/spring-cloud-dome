package com.spdata.monitorserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yangqifang
 */
@EnableEurekaClient
@EnableAdminServer
@SpringBootApplication
public class MonitorServerStart {

    public static void main(String[] args) {
        SpringApplication.run(MonitorServerStart.class, args);
    }
}

