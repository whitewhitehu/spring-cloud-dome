package com.spdata.common.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.spdata.common.autoconfig.web.webConfig;

/**
 * @author yangqifang
 * @描述: 自动配置
 * @data 2019/3/17-22:37
 **/
@Configuration
@Import(value = {webConfig.class})
@ComponentScan("com.spdata.common.autoconfig")
@ConditionalOnProperty(prefix = "spdata.autoconfig",value = "enable",havingValue = "true")
public class SpdataAutoConfig {
}
