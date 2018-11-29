package com.spdata.crm.role.Dao;

import com.spdata.crm.role.input.RoleInput;
import com.spdata.entity.Base.BaseInterface;
import com.spdata.entity.Role.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleDao extends BaseInterface<Role> {
    List<Role> findAccountRole(@Param("AccountName") String AccountName);

    @Override
    boolean save(@Param(value = "role") Role role);

    @Override
    boolean delect(@Param(value = "role") Role role);

    boolean InsertMenu(@Param(value = "roleInput") RoleInput roleInput);

    boolean InsertPermission(@Param(value = "roleInput") RoleInput roleInput);

    boolean delectRoleMenu(@Param(value = "roleInput") RoleInput roleInput);

    boolean delectRolePermission(@Param(value = "roleInput") RoleInput roleInput);

    @Override
    Role findByid(@Param(value = "role") Role role);

}
