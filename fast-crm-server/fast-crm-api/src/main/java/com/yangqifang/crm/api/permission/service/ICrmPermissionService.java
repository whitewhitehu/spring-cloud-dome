package com.yangqifang.crm.api.permission.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yangqifang.common.base.PageParameter;
import com.yangqifang.crm.api.permission.entity.Permission;

import java.util.List;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/28 23:51
 */
public interface ICrmPermissionService {
    List<Permission> findRolePermission(String username);
    boolean update(Permission permission);
    List<Permission> findRoleIdPermission(Integer accountid);
    boolean save(Permission entity);
    PageInfo<Permission> findByPage(PageParameter<Permission> parameter);

    boolean delect(Permission permission);
}
