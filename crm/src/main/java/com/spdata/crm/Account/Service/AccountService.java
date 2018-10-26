package com.spdata.crm.Account.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spdata.crm.Account.Dao.AccountDao;
import com.spdata.entity.Account.Account;
import com.spdata.entity.Base.BaseService;
import com.spdata.entity.Base.PageParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class AccountService extends BaseService<AccountDao, Account> {
    @Autowired
    private AccountDao accountDao;

    /**
     * 修改密码
     *
     * @param account
     * @return
     */
    @Transactional
    public boolean updatePassword(Account account) {
        return accountDao.updatePassword(account);
    }

    /**
     * 通过username查询账户信息
     *
     * @param username
     * @return
     */
    public Account findAccount(String username) {
        return accountDao.findAccount(username);
    }

    /**
     * 添加账户信息=>1.保存基础信息 2.保存账户余角色的关联关系
     *
     * @param entity
     * @return
     */
    @Transactional
    @Override
    public boolean save(Account entity) {
        try {
            accountDao.save(entity);
            accountDao.saveRole(entity.getId(), entity.getRoles());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 修改头像
     *
     * @param Avatar:头像
     * @param UserName:账户名
     * @return
     */
    @Transactional
    public boolean UpdateAvatar(String Avatar, String UserName) {
        return accountDao.UpdateAvatar(Avatar, UserName);
    }
}
