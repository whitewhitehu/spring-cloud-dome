package com.spdata.crm.permission.service;

import com.spdata.common.base.BaseService;
import com.spdata.common.permission.permission;
import com.spdata.crm.permission.dao.PermissionDao;
import com.spdata.crm.tool.SpringOauth2SecurityTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService extends BaseService<PermissionDao, permission> {
    @Autowired
    private PermissionDao permissionDao;

    public List<permission> findRolePermission() {
        return permissionDao.findRolePermission(SpringOauth2SecurityTool.getSecurityUserName());
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
