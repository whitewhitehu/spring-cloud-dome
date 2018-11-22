package com.spdata.crm;

import com.spdata.crm.account.Service.AccountService;
import com.spdata.crm.menu.Service.MenuService;
import com.spdata.crm.role.Service.RoleService;
import com.spdata.crm.permission.dao.PermissionDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CrmApplicationTests {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private MenuService menuService;

    @Test
    public void contextLoads() {

    }

}
