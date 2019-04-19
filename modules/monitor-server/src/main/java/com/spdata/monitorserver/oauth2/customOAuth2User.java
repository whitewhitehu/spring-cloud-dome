package com.spdata.monitorserver.oauth2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.io.Serializable;
import java.util.*;

/**
 * @author yangqifang
 * @date 2019/4/17-22:41
 * @模块:superior
 * @描述:
 **/
@Getter
@Setter
public class customOAuth2User implements OAuth2User, Serializable {
    private static final long serialVersionUID = 500L;
    private Map<String, Object> Attributes;
    private Integer code;
    private Map<String, Object> data;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }


    @Override
    public Map<String, Object> getAttributes() {
        return this.data;
    }

    @Override
    public String getName() {
        return (String) this.getData().get("givename");
    }
}
