package com.spdata.starter.config;

import com.spdata.starter.config.security.ResourceServerConfigurer;
import com.spdata.starter.config.web.MvcConfiguration;
import com.spdata.starter.config.web.MyGlobalExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/2/2821:22
 **/
@Configuration
@ComponentScan({"com.spdata.starter.config"})
@Import({MvcConfiguration.class, MyGlobalExceptionHandler.class, ResourceServerConfigurer.class})
public class AutoConfiguration {
}
