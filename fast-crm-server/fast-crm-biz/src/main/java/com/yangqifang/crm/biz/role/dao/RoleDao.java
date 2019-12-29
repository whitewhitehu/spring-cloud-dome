package com.yangqifang.crm.biz.role.dao;

import com.yangqifang.common.base.BaseDaoInterface;
import com.yangqifang.crm.api.role.entity.Role;
import com.yangqifang.crm.api.role.parm.RoleInput;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleDao extends BaseDaoInterface<Role> {
    List<Role> findAccountRole(@Param("AccountName") String AccountName);

    @Override
    boolean save(@Param(value = "role") Role role);

    @Override
    boolean delect(@Param(value = "role") Role role);

    boolean InsertMenu(@Param(value = "roleInput") RoleInput roleInput);

    boolean insertPermission(@Param(value = "roleInput") RoleInput roleInput);

    boolean delectRoleMenu(@Param(value = "roleInput") RoleInput roleInput);

    boolean delectRolePermission(@Param(value = "roleInput") RoleInput roleInput);

    @Override
    Role findByid(@Param(value = "role") Role role);

    List<Integer> findRoleMenu(@Param(value = "roleid") Integer roleid);

}
