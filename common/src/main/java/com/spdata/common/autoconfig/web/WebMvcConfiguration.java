package com.spdata.common.autoconfig.web;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;

/**
 * @author yangqifang
 * @date 2019/3/17-22:40
 * @deprecated spring mvc 配置
 **/
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    private Logger logger = LoggerFactory.getLogger(WebMvcConfiguration.class);

    @Bean
    HttpMessageConverters fastJsonConfigure() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        logger.info("开始加载FastJson:" + System.currentTimeMillis());
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        converter.setFastJsonConfig(fastJsonConfig);
        logger.info("加载FastJson配置完成:" + System.currentTimeMillis());
        return new HttpMessageConverters(converter);
    }
}
