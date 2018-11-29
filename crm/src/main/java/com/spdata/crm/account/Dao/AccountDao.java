package com.spdata.crm.account.Dao;

import com.spdata.entity.Account.Account;
import com.spdata.entity.Base.BaseInterface;
import com.spdata.entity.Role.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AccountDao extends BaseInterface<Account> {


    @Override
    boolean save(@Param(value = "account") Account account);

    @Override
    Account findByid(@Param(value = "account") Account account);

    @Override
    boolean delect(@Param("account") Account account);

    @Override
    List<Account> findByPage(@Param("account") Account account);

    boolean updatePassword(@Param("account") Account account);

    Account findAccount(@Param(value = "username") String username);

    boolean saveRole(@Param(value = "account_id") Integer account_id, @Param(value = "roles") List<Role> roleList);

    boolean UpdateAvatar(@Param(value = "Avatar") String Avatar, @Param(value = "username") String username);
}
