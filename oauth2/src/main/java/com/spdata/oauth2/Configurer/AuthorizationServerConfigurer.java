package com.spdata.oauth2.Configurer;

import com.spdata.entity.Base.BaseResul;
import com.spdata.entity.Base.Basemessage;
import com.spdata.oauth2.Account.Service.AccountService;
import com.spdata.oauth2.Configurer.Converter.SpDataTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;

/**
 * 授权服务器--配置
 */
@Configuration
@ComponentScan(basePackages = {"com.spdata"})
@EnableAuthorizationServer
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {
    /**
     * 注入认证管理器
     */
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AccountService accountService;

    /**
     * token保存在数据库中
     *
     * @return
     */
    @Bean
    public JdbcTokenStore jdbcTokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    /**
     * token保存在内存里
     *
     * @return
     */
    @Bean
    public TokenStore InMemorytokenStore() {
        InMemoryTokenStore tokenStore = new InMemoryTokenStore();
        return tokenStore;
    }

    /**
     * 注入token增强器
     */
    @Autowired
    private SpDataTokenEnhancer spDataTokenEnhancer;

    /**
     * json web token
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("spdata-yang");
        return converter;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                //检查token接口 全部人可以访问
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    /**
     * clien 配置
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // 使用in-memory存储
                .withClient("spdata") // client_id
                .secret("secret") // client_secret
                .authorizedGrantTypes("authorization_code", "password") // 该client允许的授权类型
                .scopes("all"); // 允许的授权范围
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
                .tokenEnhancer(spDataTokenEnhancer)
                .tokenStore(InMemorytokenStore())
                .exceptionTranslator(new DefaultWebResponseExceptionTranslator() {
                    @Override
                    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
                        ResponseEntity responseEntity = super.translate(e);
                        BaseResul baseResul = new BaseResul();
                        if (e instanceof InvalidGrantException) {
                            baseResul.setCode(Basemessage.ParameterError);
                            baseResul.setMessage(e.getLocalizedMessage());
                        }
                        ResponseEntity resulEntity = new ResponseEntity(baseResul, responseEntity.getHeaders(), responseEntity.getStatusCode());
                        return resulEntity;
                    }
                })
                .authenticationManager(authenticationManager);
    }
}
