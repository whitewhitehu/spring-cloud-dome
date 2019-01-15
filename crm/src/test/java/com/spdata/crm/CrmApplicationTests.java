package com.spdata.crm;

import com.spdata.crm.account.service.AccountService;
import com.spdata.crm.menu.dervice.MenuService;
import com.spdata.crm.permission.service.PermissionService;
import com.spdata.crm.role.service.RoleService;
import com.spdata.crm.permission.dao.PermissionDao;
import com.spdata.entity.Account.Account;
import com.spdata.entity.Base.PageParameter;
import com.spdata.entity.Role.Role;
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
    private PermissionService permissionService;
    @Autowired
    private MenuService menuService;

    @Test
    public void testSaveRole() {
        Role role = new Role();
        role.setName("测试角色");
        roleService.save(role);
    }

    @Test
    public void findAccount() {
        Account account = accountService.findAccount("root");
        System.out.println(account.getUsername());
    }

    @Test
    public void AccountServicefindByPage() {
        PageParameter pageParameter = new PageParameter();
        pageParameter.setParament(new Account());
        accountService.findByPage(pageParameter);
    }

    @Test
    public void PermissionSave() {
        permissionService.save(null);
    }
}
