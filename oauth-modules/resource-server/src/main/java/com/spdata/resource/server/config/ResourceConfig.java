package com.spdata.resource.server.config;

import com.spdata.common.autoconfig.oauth.SpdataAccessDeniedHandler;
import com.spdata.common.autoconfig.oauth.SpdataAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @author yangqifang
 * @date : 2019/3/17-21:00
 **/
@Configuration
public class ResourceConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private SpdataAuthenticationEntryPoint entryPoint;
    @Autowired
    private SpdataAccessDeniedHandler deniedHandler;
    @Autowired
    private DataSource dataSource;

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Bean
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        return tokenServices;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.authenticationEntryPoint(entryPoint).accessDeniedHandler(deniedHandler);
        resources.tokenServices(defaultTokenServices());
        resources.resourceId(null);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/actuator/**").permitAll().anyRequest().authenticated();
    }
}
