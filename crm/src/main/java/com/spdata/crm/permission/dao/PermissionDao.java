package com.spdata.crm.permission.dao;

import com.spdata.entity.Base.BaseInterface;
import com.spdata.entity.permission.permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PermissionDao extends BaseInterface<permission> {
    List<permission> findRolePermission(@Param(value = "username") String username);

    List<permission> findAccountIdPermission(@Param(value = "id") Integer id);

    @Override
    boolean save(@Param(value = "permission") permission permission);

    @Override
    boolean delect(@Param(value = "permission") permission permission);

    boolean update(@Param(value = "permission") permission permission);
}
