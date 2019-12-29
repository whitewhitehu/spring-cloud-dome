package com.yangqifang.crm.biz.account.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangqifang.common.base.BaseService;
import com.yangqifang.common.base.PageParameter;
import com.yangqifang.crm.api.account.dto.AccountDto;
import com.yangqifang.crm.api.account.entity.AbstractAccount;
import com.yangqifang.crm.api.role.entity.Role;
import com.yangqifang.crm.biz.account.dao.AccountDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yangqifang
 */
@Slf4j
@Service
public class AccountService extends BaseService<AccountDao, AccountDto> {
    @Autowired
    private AccountDao accountDao;

    /**
     * 修改密码
     *
     * @param account
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updatePassword(AbstractAccount account) {
        return accountDao.updatePassword(account);
    }

    /**
     * 通过username查询账户信息
     *
     * @param username
     * @return
     */
    public AbstractAccount findAccount(String username) {
        return accountDao.findAccountByUsername(username);
    }

    /**
     * 添加账户信息=>1.保存基础信息 2.保存账户余角色的关联关系
     *
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean save(AccountDto entity) {
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
     * @param avatar:头像
     * @param username:账户名
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateAvatar(String avatar, String username) {
        return accountDao.updateAvatar(avatar, username);
    }

    /**
     * 修改用户信息
     *
     * @param account
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateAccount(AccountDto account) {
        List<Role> roles = account.getRoles();
        boolean falg = false;
        falg = accountDao.update(account);
        if (roles != null) {
            //删除角色用户关系
            falg = accountDao.delectAccountRoleRelation(account.getId());
            //保存角色用户关系
            falg = accountDao.saveRole(account.getId(), account.getRoles());
        }
        return falg;
    }

    /**
     * 分页查询 当前部门(包含子部门)的下的账户信息
     *
     * @param pageParameter
     * @return
     */
    @Override
    public PageInfo<AccountDto> findByPage(PageParameter<AccountDto> pageParameter) {
        /**
         * 如果部门ID为空 则根据当前账户的部门进行查询
         */
        if (pageParameter.getParament() == null || pageParameter.getParament().getDeptId() == null) {
            AbstractAccount account = accountDao.findAccountByUsername(pageParameter.getParament().getUsername());
            String json = JSON.toJSONString(account);
            AccountDto accountVO = JSON.parseObject(json, AccountDto.class);
            pageParameter.setParament(accountVO);
        }
        PageHelper.startPage(pageParameter.getPagenum(), pageParameter.getPagesize());
        PageInfo<AccountDto> pageInfo = new PageInfo<>(accountDao.findByPage(pageParameter.getParament()));
        return pageInfo;
    }
}
