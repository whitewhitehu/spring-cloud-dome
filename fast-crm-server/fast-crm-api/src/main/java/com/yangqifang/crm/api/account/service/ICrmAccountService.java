package com.yangqifang.crm.api.account.service;

import com.github.pagehelper.PageInfo;
import com.yangqifang.common.base.PageParameter;
import com.yangqifang.crm.api.account.dto.AccountDto;
import com.yangqifang.crm.api.account.entity.AbstractAccount;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/28 22:54
 */
public interface ICrmAccountService {
    boolean updatePassword(AbstractAccount account);

    AbstractAccount findAccount(String username);

    boolean save(AccountDto entity);

    /**
     * 修改头像
     *
     * @param avatar:头像
     * @param username:账户名
     * @return
     */
    boolean updateAvatar(String avatar, String username);

    boolean updateAccount(AccountDto account);

    PageInfo<AccountDto> findByPage(PageParameter<AccountDto> pageParameter);
    AccountDto findById(AccountDto accountDto);
    boolean delect(AccountDto accountDto);
}
