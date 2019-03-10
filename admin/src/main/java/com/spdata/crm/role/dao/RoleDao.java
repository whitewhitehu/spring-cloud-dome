package com.spdata.crm.role.dao;

import com.spdata.common.base.BaseInterface;
import com.spdata.common.role.Role;
import com.spdata.crm.role.input.RoleInput;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleDao extends BaseInterface<Role> {
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
