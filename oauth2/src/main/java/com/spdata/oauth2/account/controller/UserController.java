package com.spdata.oauth2.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {
    @GetMapping("/oauth/user/info")
    public Principal user(Principal user) {
        return user;
    }
}
