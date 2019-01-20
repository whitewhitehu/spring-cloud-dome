package com.spdata.crm.account.dao;

import com.spdata.common.account.Account;
import com.spdata.common.base.BaseInterface;
import com.spdata.common.role.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yangqifang
 */
@Mapper
@Component
public interface AccountDao extends BaseInterface<Account> {
    @Override
    boolean update(@Param(value = "account") Account account);

    @Override
    boolean save(@Param(value = "account") Account account);

    @Override
    Account findByid(@Param(value = "account") Account account);

    @Override
    boolean delect(@Param("account") Account account);

    @Override
    List<Account> findByPage(@Param("account") Account account);

    List<Role> findRolesByAccountID(@Param("id") int id);

    boolean updatePassword(@Param("account") Account account);

    Account findAccount(String username);

    boolean saveRole(@Param(value = "account_id") Integer account_id, @Param(value = "roles") List<Role> roleList);

    boolean updateAvatar(@Param(value = "Avatar") String Avatar, @Param(value = "username") String username);

    boolean delectAccountRoleRelation(@Param(value = "id") int id);
}
