package com.spdata.oauth2;

import com.spdata.oauth2.account.entity.Account;
import com.spdata.oauth2.account.service.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @描述:
 * @auther yangqifang
 * @data 2019/1/914:25
 **/
@Log4j2
@Service
public class CodeAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        Account account = (Account) accountService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, account.getPassword())) {
            throw new BadCredentialsException("密码错误!");
        }
        authentication = new UsernamePasswordAuthenticationToken(username, password, account.getAuthorities());
        return authentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
