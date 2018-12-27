package com.spdata.oauth2.account.dao;

import com.spdata.entity.Base.BaseInterface;
import com.spdata.entity.Role.Role;
import com.spdata.entity.permission.permission;
import com.spdata.oauth2.account.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface AccountDao extends BaseInterface<Account> {
    Account findByAccount(@Param("username") String username);

    List<Role> findRole(@Param("userid") Integer userid);

    Set<permission> findPermission(@Param("roleid") Set<Integer> roleid);
}
