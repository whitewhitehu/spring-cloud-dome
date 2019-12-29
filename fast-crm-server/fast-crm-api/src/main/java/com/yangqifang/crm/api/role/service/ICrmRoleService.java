package com.yangqifang.crm.api.role.service;

import com.yangqifang.crm.api.role.entity.Role;
import com.yangqifang.crm.api.role.parm.RoleInput;

import java.util.List;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/29 1:35
 */
public interface ICrmRoleService {
    List<Role> findAccountRole(String username);
    boolean InsertMenu(RoleInput roleInput);
    boolean insertPermission(RoleInput roleInput);
    boolean delectRoleMenu(RoleInput roleInput);
    boolean delectRolePermission(RoleInput roleInput);
    List<Integer> findRoleMenu(Integer roleid);
    boolean delect(Role role);

    boolean save(Role role);
}
