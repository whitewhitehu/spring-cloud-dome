package com.yangqifang.crm.biz.permission.dao;

import com.yangqifang.common.base.BaseInterface;
import com.yangqifang.crm.api.permission.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionDao extends BaseInterface<Permission> {
    List<Permission> findRolePermission(@Param(value = "username") String username);

    List<Permission> findRoleIdPermission(@Param(value = "id") Integer id);

    @Override
    boolean save(@Param(value = "permission") Permission permission);

    @Override
    boolean delect(@Param(value = "permission") Permission permission);
    @Override
    boolean update(@Param(value = "permission") Permission permission);

}
