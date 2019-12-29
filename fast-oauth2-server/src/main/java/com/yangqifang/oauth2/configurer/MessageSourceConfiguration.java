package com.yangqifang.oauth2.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/2/2221:15
 **/
@Configuration
public class MessageSourceConfiguration {
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages_zh_CN");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
