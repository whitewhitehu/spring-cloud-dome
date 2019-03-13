package com.spdata.oauth2.account.controller;

import com.spdata.common.account.Account;
import com.spdata.oauth2.account.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @author yangqifang
 */
@Controller
public class UserFrameworkEndpoint {
    Logger logger = LoggerFactory.getLogger(UserFrameworkEndpoint.class);
    @Autowired
    private AccountService accountService;

    @GetMapping("/oauth/user/info")
    @ResponseBody
    public Account user(Principal user) {
        Account account = null;
        try {
            account = accountService.findByBaseInfo(user.getName());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(System.currentTimeMillis() + "出现异常:" + this.getClass().getName());
            logger.error(e.getLocalizedMessage());
        }
        return account;
    }
}
