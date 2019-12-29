package com.yangqifang.oauth2.configurer;

import com.yangqifang.oauth2.account.service.AccountService;
import com.yangqifang.oauth2.configurer.enhancer.CTokenEnhancer;
import com.yangqifang.oauth2.configurer.exceptiontranslator.WebResponseExceptionTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * 授权服务器--配置
 *
 * @author yangqifang
 */
@Configuration
@ComponentScan(basePackages = {"com.yangqifang.common.base"})
@EnableAuthorizationServer
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(AuthorizationServerConfigurer.class);
    /**
     * 注入认证管理器
     */
    @Autowired
    private AuthenticationManager authenticationManager;
    /**
     * 注入token增强器
     */
    @Autowired
    private CTokenEnhancer CTokenEnhancer;
    @Autowired
    private WebResponseExceptionTranslator translator;
    @Autowired
    private AccountService accountService;

    /**
     * token保存在内存里
     *
     * @return
     */
    @Bean(name = "InMemorytokenStore")
    public TokenStore InMemorytokenStore() {
        InMemoryTokenStore tokenStore = new InMemoryTokenStore();
        return tokenStore;
    }

    @Bean
    public DefaultTokenServices tokenServices() {
        logger.warn("加载tokenServices");
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(InMemorytokenStore());
        tokenServices.setTokenEnhancer(CTokenEnhancer);
        tokenServices.setAuthenticationManager(authenticationManager);
        return tokenServices;
    }


    /**
     * json web token
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("5e6374c3-2cf9-4b08-a251-e7706b03cece");
        return converter;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                //检查token接口 全部人可以访问
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }



    /**
     * 端点设置
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .pathMapping("/oauth/confirm_access", "/oauth2/confirm_access")
                .tokenServices(tokenServices())
                .tokenEnhancer(CTokenEnhancer)
                .userDetailsService(accountService)
                .exceptionTranslator(translator)
                .authenticationManager(authenticationManager);
    }

}
