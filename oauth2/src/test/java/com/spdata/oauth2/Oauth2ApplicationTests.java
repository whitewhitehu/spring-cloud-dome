package com.spdata.oauth2;

import com.spdata.entity.Role.Role;
import com.spdata.entity.permission.permission;
import com.spdata.oauth2.Account.Dao.AccountDao;
import com.spdata.oauth2.Account.Service.AccountService;
import com.spdata.oauth2.Account.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Oauth2ApplicationTests {
    @Autowired
    AccountService accountService;
    @Autowired
    private AccountDao dao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void contextLoads() {
        Set<Integer> integer=new HashSet<>();
        integer.add(1);
        integer.add(2);
        Set<permission> permissions=  dao.findPermission(integer);
        log.info(permissions.toString());
    }

}
