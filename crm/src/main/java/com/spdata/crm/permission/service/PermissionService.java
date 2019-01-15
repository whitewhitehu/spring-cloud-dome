package com.spdata.crm.permission.service;

import com.spdata.crm.aspect.retry.Retry;
import com.spdata.crm.permission.dao.PermissionDao;
import com.spdata.crm.tool.SecurityTool;
import com.spdata.entity.Base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spdata.entity.permission.permission;

import java.util.List;

@Service
public class PermissionService extends BaseService<PermissionDao, permission> {
    @Autowired
    private PermissionDao permissionDao;

    public List<permission> findRolePermission() {
        return permissionDao.findRolePermission(SecurityTool.getSecurityUserName());
    }

    public boolean update(permission permission) {
        return permissionDao.update(permission);
    }

    public List<permission> findRoleIdPermission(Integer accountid) {
        return permissionDao.findRoleIdPermission(accountid);
    }

    @Override
    public boolean save(permission entity) {
        return permissionDao.save(entity);
    }
}
