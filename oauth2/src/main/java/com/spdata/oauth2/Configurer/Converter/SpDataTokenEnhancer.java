package com.spdata.oauth2.Configurer.Converter;


import com.spdata.oauth2.Account.entity.Account;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SpDataTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        DefaultOAuth2AccessToken defaultOAuth2AccessToken = (DefaultOAuth2AccessToken) oAuth2AccessToken;
        Map<String, Object> addresul = new HashMap<>();
        Account account = (Account) oAuth2Authentication.getPrincipal();
        addresul.put("code", 2000);
        Collection<GrantedAuthority> grantedAuthorities = oAuth2Authentication.getAuthorities();
        List<String> Permission = new ArrayList<>();
        grantedAuthorities.forEach(item -> {
            Permission.add(item.getAuthority());
        });
        addresul.put("Permission", Permission);
        defaultOAuth2AccessToken.setAdditionalInformation(addresul);
        return defaultOAuth2AccessToken;
    }
}
