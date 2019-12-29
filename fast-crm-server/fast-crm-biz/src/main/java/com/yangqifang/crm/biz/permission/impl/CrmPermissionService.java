package com.yangqifang.crm.biz.permission.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yangqifang.common.base.PageParameter;
import com.yangqifang.crm.api.permission.entity.Permission;
import com.yangqifang.crm.api.permission.service.ICrmPermissionService;
import com.yangqifang.crm.biz.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/29 1:29
 */
@Service
@Component
public class CrmPermissionService implements ICrmPermissionService {
    @Autowired
    private PermissionService permissionService;

    @Override
    public List<Permission> findRolePermission(String username) {
        return null;
    }

    @Override
    public boolean update(Permission permission) {
        return false;
    }

    @Override
    public List<Permission> findRoleIdPermission(Integer accountid) {
        return null;
    }

    @Override
    public boolean save(Permission entity) {
        return false;
    }

    @Override
    public PageInfo<Permission> findByPage(PageParameter<Permission> parameter) {
        return permissionService.findByPage(parameter);
    }

    @Override
    public boolean delect(Permission permission) {
        return permissionService.delect(permission);
    }
}
