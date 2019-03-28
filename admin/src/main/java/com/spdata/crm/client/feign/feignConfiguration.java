package com.spdata.crm.client.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangqifang
 * @date 2019/3/28-17:40
 * @deprecated :
 **/
@Configuration
public class feignConfiguration {
    @Bean
    Logger.Level feignlog() {
        return Logger.Level.FULL;
    }

}
