package com.spdata.crm.configuration;

import com.alibaba.fastjson.JSON;
import com.spdata.entity.Base.BaseResul;
import com.spdata.entity.Base.Basemessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
@ComponentScan(basePackages = "com.spdata")
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {
    @Value("${security.oauth2.client.id}")
    private String ClientID;
    @Value("${security.oauth2.client.client-secret}")
    private String ClientSecret;
    @Value("${security.oauth2.client.authorization.check-token-access}")
    private String CheckTokenAccessURL;
    @Autowired
    OAuth2ClientProperties oAuth2ClientProperties;

    /**
     * JSON WEB TOKEN 服务  设置密钥
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("spdata-yang");
        return converter;
    }

    /**
     * 这个暂时没用 配置还要研究一下
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client")
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
        return new ClientCredentialsResourceDetails();
    }

    /**
     * 远程token服务
     *
     * @return
     */
    @Bean
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        //检查TOKEN的URL
        tokenServices.setCheckTokenEndpointUrl(CheckTokenAccessURL);
        //客户端ID
        tokenServices.setClientId(ClientID);
        //客户端密钥
        tokenServices.setClientSecret(ClientSecret);
        return tokenServices;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(tokenServices());
        resources.authenticationEntryPoint(new AuthenticationEntryPoint() {
            // token 无效时进行的处理
            @Override
            public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                BaseResul baseResul = new BaseResul();
                baseResul.setCode(Basemessage.ParameterError);
                baseResul.setMessage("无效token:" + e.getLocalizedMessage());
                baseResul.setData(null);
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.getWriter().write(JSON.toJSONString(baseResul));
            }
        }).accessDeniedHandler(new AccessDeniedHandler() {
            // 访问被拒绝时 对返回的数据进行定义 PS: 这应该时权限不足时进行的处理
            @Override
            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                BaseResul baseResul = new BaseResul();
                baseResul.setMessage(e.getLocalizedMessage());
                baseResul.setCode(Basemessage.Refuse);
                baseResul.setData(null);
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.getWriter().write(JSON.toJSONString(baseResul));
            }
        });
    }

    /**
     * 不拦截的请求列表
     *
     * @return
     */
    public String[] permitAll() {
        List<String> stringList = new ArrayList<>();
        stringList.add("/admin/webjars/**");
        stringList.add("/admin/swagger-ui.html");
        stringList.add("/admin/swagger-resources/**");
        stringList.add("/admin/v2/api-docs");
        String[] permitAll = new String[stringList.size()];
        stringList.toArray(permitAll);
        return permitAll;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(permitAll()).permitAll();
        super.configure(http);
    }
}
