package com.spdata.oauth2.configurer;

import com.spdata.oauth2.CodeAuthenticationProvider;
import com.spdata.oauth2.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 安全配置
 *
 * @author yangqifang
 */
@Configuration
@EnableWebSecurity
@Order(value = Integer.MAX_VALUE)
public class WEBSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private CodeAuthenticationProvider codeAuthenticationProvider;
    @Autowired
    private AccountService accountService;


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 密码加密器 暂定不对密码进行加密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return charSequence.toString().equals(s);
            }
        };
        return passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService);
        super.configure(auth);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                formLogin().loginPage("/oauth2/login").failureUrl("/oauth2/login?error=true").permitAll()
                .and()
                .csrf().disable()
                .authorizeRequests().antMatchers("/actuator/**", "/assets/**").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
        super.configure(http);
    }
}

