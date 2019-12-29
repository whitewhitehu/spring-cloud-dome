package com.yangqifang.crm.biz.account.dao;

import com.yangqifang.common.base.BaseDaoInterface;
import com.yangqifang.crm.api.account.dto.AccountDto;
import com.yangqifang.crm.api.account.entity.AbstractAccount;
import com.yangqifang.crm.api.role.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangqifang
 */
@Mapper
public interface AccountDao extends BaseDaoInterface<AccountDto> {
    @Override
    boolean update(@Param(value = "account") AccountDto account);

    @Override
    boolean save(@Param(value = "account") AccountDto account);

    @Override
    AccountDto findByid(@Param(value = "account") AccountDto account);

    @Override
    boolean delect(@Param("account") AccountDto account);

    @Override
    List<AccountDto> findByPage(@Param("account") AccountDto account);

    List<Role> findRolesByAccountID(@Param("id") int id);

    boolean updatePassword(@Param("account") AbstractAccount account);

    AbstractAccount findAccountByUsername(@Param("username") String username);

    boolean saveRole(@Param(value = "account_id") Integer account_id, @Param(value = "roles") List<Role> roleList);

    boolean updateAvatar(@Param(value = "Avatar") String Avatar, @Param(value = "username") String username);

    boolean delectAccountRoleRelation(@Param(value = "id") int id);
}
