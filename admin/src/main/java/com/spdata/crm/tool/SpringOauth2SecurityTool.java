package com.spdata.crm.tool;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.Collection;

/**
 * 获取授权信息工具类
 *
 * @author yangqifang
 */
public class SpringOauth2SecurityTool {
    
    /**
     * 授权信息
     *
     * @return
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前授权的用户名称
     *
     * @return
     */
    public static String getSecurityUserName() {
        Authentication authentication = getAuthentication();
        return (String) authentication.getPrincipal();
    }

    /**
     * 获取Token 值
     *
     * @return
     */
    public static String getTokenValue() {
        OAuth2Authentication auth2Authentication = (OAuth2Authentication) getAuthentication();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) auth2Authentication.getDetails();
        return details.getTokenValue();
    }

    /**
     * 获取权限
     *
     * @return
     */
    public Collection<?> authorities() {
        return getAuthentication().getAuthorities();
    }
}
