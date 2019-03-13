package com.spdata.monitorserver;

import de.codecentric.boot.admin.server.web.client.InstanceExchangeFilterFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/3/11-16:33
 **/
@Configuration
public class ServerIntercept {
    Logger logger = LoggerFactory.getLogger(ServerIntercept.class);

    /**
     * spring boot admin server 健康检查请求拦截器
     *
     * @return
     */
    @Bean
    public InstanceExchangeFilterFunction auditLog() {
        return (instance, request, next) -> {
            logger.error(instance.getRegistration().getName());
            return next.exchange(request);
        };
    }
}
