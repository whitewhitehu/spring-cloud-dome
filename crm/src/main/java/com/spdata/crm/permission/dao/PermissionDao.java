package com.spdata.crm.permission.dao;

import com.spdata.common.base.BaseInterface;
import com.spdata.common.permission.permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PermissionDao extends BaseInterface<permission> {
    List<permission> findRolePermission(@Param(value = "username") String username);

    List<permission> findRoleIdPermission(@Param(value = "id") Integer id);

    @Override
    boolean save(@Param(value = "permission") permission permission);

    @Override
    boolean delect(@Param(value = "permission") permission permission);
    @Override
    boolean update(@Param(value = "permission") permission permission);

}
