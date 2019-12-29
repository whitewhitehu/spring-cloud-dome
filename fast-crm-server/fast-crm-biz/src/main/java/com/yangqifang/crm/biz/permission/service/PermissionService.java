package com.yangqifang.crm.biz.permission.service;

import com.yangqifang.common.base.BaseService;
import com.yangqifang.crm.api.permission.entity.Permission;
import com.yangqifang.crm.biz.permission.dao.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService extends BaseService<PermissionDao, Permission> {
    @Autowired
    private PermissionDao permissionDao;

    public List<Permission> findRolePermission(String username) {
        return permissionDao.findRolePermission(username);
    }

    public boolean update(Permission permission) {
        return permissionDao.update(permission);
    }

    public List<Permission> findRoleIdPermission(Integer accountid) {
        return permissionDao.findRoleIdPermission(accountid);
    }

    @Override
    public boolean save(Permission entity) {
        return permissionDao.save(entity);
    }

}
