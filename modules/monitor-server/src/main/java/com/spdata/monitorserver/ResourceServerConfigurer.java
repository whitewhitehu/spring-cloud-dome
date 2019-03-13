package com.spdata.monitorserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.endpoint.NimbusAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/1/2617:16
 **/
@Configuration
@EnableConfigurationProperties(OAuth2ClientProperties.class)
@EnableWebSecurity
public class ResourceServerConfigurer extends WebSecurityConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(ResourceServerConfigurer.class);
    @Autowired
    private OAuth2ClientProperties oAuth2ClientProperties;
    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    private OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient() {
        return new NimbusAuthorizationCodeTokenResponseClient();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().oauth2Login()
                .clientRegistrationRepository(clientRegistrationRepository).tokenEndpoint()
                .accessTokenResponseClient(accessTokenResponseClient());
        http.httpBasic().and().csrf().disable();
    }
}
