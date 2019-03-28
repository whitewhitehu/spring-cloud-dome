package com.spdata.crm.client.feignconfig;

import com.spdata.crm.tool.SpringOauth2SecurityTool;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

/**
 * @author yangqifang
 * @date 2019/3/28-14:26
 * @deprecated : openfeign 拦截器
 **/
@Component
public class FeignRequestInterceptor implements RequestInterceptor {
    Logger logger = LoggerFactory.getLogger(FeignRequestInterceptor.class);

    /**
     * 拦截feign client发出的请求 并在请求头上加入token
     *
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        logger.info(requestTemplate.url());
        requestTemplate.header(HttpHeaders.AUTHORIZATION, "bearer " + SpringOauth2SecurityTool.getTokenValue());
    }
}
