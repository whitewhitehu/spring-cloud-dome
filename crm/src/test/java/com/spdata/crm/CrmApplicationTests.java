package com.spdata.crm;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.spdata.crm.Account.Dao.AccountDao;
import com.spdata.crm.Account.Service.AccountService;
import com.spdata.crm.Menu.Dao.MenuDao;
import com.spdata.crm.Menu.Service.MenuService;
import com.spdata.crm.Role.Service.RoleService;
import com.spdata.crm.Role.input.RoleInput;
import com.spdata.crm.permission.dao.PermissionDao;
import com.spdata.entity.Account.Account;
import com.spdata.entity.Base.PageParameter;
import com.spdata.entity.Menu.Menu;
import com.spdata.entity.Role.Role;
import com.spdata.entity.permission.permission;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
