package com.spdata.oauth2.account.entity;

import com.spdata.common.permission.permission;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yangqifang
 */
@Getter
@Slf4j
@Setter
public class Account extends com.spdata.common.account.Account implements UserDetails {
    private List<permission> permissions;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        try {
            this.getPermissions().forEach(item -> {
                grantedAuthorities.add(new SimpleGrantedAuthority(item.getValue()));
            });
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
