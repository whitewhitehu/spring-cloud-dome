package com.yangqifang.oauth2.account.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.yangqifang.crm.api.account.entity.AbstractAccount;
import com.yangqifang.crm.api.account.service.ICrmAccountService;
import com.yangqifang.crm.api.permission.entity.Permission;
import com.yangqifang.crm.api.permission.service.ICrmPermissionService;
import com.yangqifang.oauth2.account.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements UserDetailsService {
    @Reference
    private ICrmAccountService crmAccountService;
    @Reference
    private ICrmPermissionService crmPermissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AbstractAccount abstractAccount = crmAccountService.findAccount(s);
        if (ObjectUtil.isNull(abstractAccount)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        Account account = new Account();
        BeanUtil.copyProperties(abstractAccount, account);
        List<Permission> permission = crmPermissionService.findRolePermission(s);
        account.setPermissions(permission);
        return account;
    }
}
