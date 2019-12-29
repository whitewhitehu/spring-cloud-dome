package com.yangqifang.crm.run;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: yangqifang
 * @mall:
 * @description: 2019/12/28 19:49
 */
@MapperScan("com.yangqifang.crm.biz")
@EnableDubbo(scanBasePackages = "com.yangqifang.crm")
@SpringBootApplication(scanBasePackages = "com.yangqifang.crm")
public class CrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }
}
