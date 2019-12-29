package com.yangqifang.crm.biz.role.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yangqifang.crm.api.role.entity.Role;
import com.yangqifang.crm.api.role.parm.RoleInput;
import com.yangqifang.crm.api.role.service.ICrmRoleService;
import com.yangqifang.crm.biz.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/29 1:37
 */
@Service
@Component
public class CrmRoleService implements ICrmRoleService {
    @Autowired
    private RoleService roleService;

    @Override
    public List<Role> findAccountRole(String username) {
        return roleService.findAccountRole(username);
    }

    @Override
    public boolean InsertMenu(RoleInput roleInput) {
        return roleService.InsertMenu(roleInput);
    }

    @Override
    public boolean insertPermission(RoleInput roleInput) {
        return roleService.insertPermission(roleInput);
    }

    @Override
    public boolean delectRoleMenu(RoleInput roleInput) {
        return roleService.delectRoleMenu(roleInput);
    }

    @Override
    public boolean delectRolePermission(RoleInput roleInput) {
        return roleService.delectRolePermission(roleInput);
    }

    @Override
    public List<Integer> findRoleMenu(Integer roleid) {
        return roleService.findRoleMenu(roleid);
    }

    @Override
    public boolean delect(Role role) {
        return roleService.delect(role);
    }

    @Override
    public boolean save(Role role) {
        return roleService.save(role);
    }
}
