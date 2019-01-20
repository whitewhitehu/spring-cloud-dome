package com.spdata.oauth2.account.dao;

import com.spdata.common.base.BaseInterface;
import com.spdata.common.permission.permission;
import com.spdata.common.role.Role;
import com.spdata.oauth2.account.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Mapper
@Repository
public interface AccountDao extends BaseInterface<Account> {
    Account findByAccount(@Param("username") String username);

    List<Role> findRole(@Param("userid") Integer userid);

    Set<permission> findPermission(@Param("roleid") Set<Integer> roleid);
}
