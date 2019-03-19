package com.spdata.oauth2.account.service;

import com.spdata.common.base.BaseService;
import com.spdata.common.role.Role;
import com.spdata.oauth2.account.dao.AccountDao;
import com.spdata.oauth2.account.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService extends BaseService<AccountDao, Account> implements UserDetailsService {
    @Autowired
    private AccountDao accountDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account account = accountDao.findByAccount(s);
        if (account == null) {
            throw new UsernameNotFoundException("用户名不存在或密码错误!");
        }
        return account;
    }

    public List<Role> findRole(Integer userid) {
        return accountDao.findRole(userid);
    }

    public com.spdata.common.account.Account findByBaseInfo(String username) {
        return accountDao.findByBaseInfo(username);
    }
}
