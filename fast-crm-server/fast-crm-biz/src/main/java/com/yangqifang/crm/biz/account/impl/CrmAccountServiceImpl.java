package com.yangqifang.crm.biz.account.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.yangqifang.common.base.PageParameter;
import com.yangqifang.crm.api.account.dto.AccountDto;
import com.yangqifang.crm.api.account.entity.AbstractAccount;
import com.yangqifang.crm.api.account.service.ICrmAccountService;
import com.yangqifang.crm.biz.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/28 22:57
 */
@Service
public class CrmAccountServiceImpl implements ICrmAccountService {
    @Autowired
    private AccountService accountService;

    @Override
    public boolean updatePassword(AbstractAccount account) {
        return accountService.updatePassword(account);
    }

    @Override
    public AbstractAccount findAccount(String username) {
        return accountService.findAccount(username);
    }

    @Override
    public boolean save(AccountDto entity) {
        return accountService.save(entity);
    }

    @Override
    public boolean updateAvatar(String avatar, String username) {
        return accountService.updateAvatar(avatar, username);
    }

    @Override
    public boolean updateAccount(AccountDto account) {
        return accountService.updateAccount(account);
    }

    @Override
    public PageInfo<AccountDto> findByPage(PageParameter<AccountDto> pageParameter) {
        return accountService.findByPage(pageParameter);
    }

    @Override
    public AccountDto findById(AccountDto accountDto) {
        return accountService.findById(accountDto);
    }

    @Override
    public boolean delect(AccountDto accountDto) {
        return accountService.delect(accountDto);
    }
}
