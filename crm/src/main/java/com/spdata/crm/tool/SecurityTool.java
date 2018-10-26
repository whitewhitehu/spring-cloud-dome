package com.spdata.crm.tool;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 获取授权信息工具类
 */
public class SecurityTool {
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

}
