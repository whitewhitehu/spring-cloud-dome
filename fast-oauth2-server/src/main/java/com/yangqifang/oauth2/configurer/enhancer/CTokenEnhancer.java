package com.yangqifang.oauth2.configurer.enhancer;


import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * token 增强器  可以自定义登陆成功是返回的数据格式
 * @author yangqifang
 */
@Component
public class CTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        DefaultOAuth2AccessToken defaultOAuth2AccessToken = (DefaultOAuth2AccessToken) oAuth2AccessToken;
        Map<String, Object> addresul = new HashMap<>(16);
        addresul.put("code", 2000);
        defaultOAuth2AccessToken.setAdditionalInformation(addresul);
        return defaultOAuth2AccessToken;
    }
}
