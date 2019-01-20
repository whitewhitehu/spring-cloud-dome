package com.spdata.crm;

import com.github.pagehelper.PageInfo;
import com.spdata.common.account.Account;
import com.spdata.common.base.PageParameter;
import com.spdata.common.sysdict.SysDict;
import com.spdata.crm.account.service.AccountService;
import com.spdata.crm.menu.dervice.MenuService;
import com.spdata.crm.permission.service.PermissionService;
import com.spdata.crm.role.service.RoleService;
import com.spdata.crm.sysdict.dao.SysDictDao;
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
    @Autowired
    private SysDictDao sysDictDao;

    @Test
    public void dictinsert() {
        SysDict sysDict = new SysDict();
        sysDict.setName("测试");
        sysDict.setType("testtype");
        sysDict.setValue("testvvvvv");
        sysDictDao.insert(sysDict);
    }

    @Test
    public void dictupdate() {
        SysDict sysDict = new SysDict();
        sysDict.setName("测试");
        sysDict.setId(1);
        sysDictDao.update(sysDict);
    }
    @Test
    public void Account_findByPage() {
        PageParameter<Account> parameter=new PageParameter<>();
        PageInfo<Account> accountPageInfo=accountService.findByPage(parameter);
        log.error(accountPageInfo.toString());
    }
}
