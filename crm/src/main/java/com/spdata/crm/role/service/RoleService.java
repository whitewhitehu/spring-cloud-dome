package com.spdata.crm.role.service;

import com.spdata.common.base.BaseService;
import com.spdata.common.role.Role;
import com.spdata.crm.role.dao.RoleDao;
import com.spdata.crm.role.input.RoleInput;
import com.spdata.crm.tool.SecurityTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService extends BaseService<RoleDao, Role> {
    @Autowired
    private RoleDao roleDao;

    /**
     * 查询当前用户的角色信息
     *
     * @return
     */
    public List<Role> findAccountRole() {
        return roleDao.findAccountRole(SecurityTool.getSecurityUserName());
    }

    /**
     * 插入角色与菜单的对应关系
     *
     * @param roleInput
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean InsertMenu(RoleInput roleInput) {
        return roleDao.InsertMenu(roleInput);
    }

    /**
     * 插入角色与权限的对应关系
     *
     * @param roleInput
     * @return
     */
    @Transactional
    public boolean insertPermission(RoleInput roleInput) {
        return roleDao.insertPermission(roleInput);
    }

    /**
     * 删除角色角色与菜单的对应关系
     *
     * @param roleInput
     * @return
     */
    @Transactional
    public boolean delectRoleMenu(RoleInput roleInput) {
        return roleDao.delectRoleMenu(roleInput);
    }

    /**
     * 删除角色与权限的对应关系
     *
     * @param roleInput
     * @return
     */
    @Transactional
    public boolean delectRolePermission(RoleInput roleInput) {
        return roleDao.delectRolePermission(roleInput);
    }

    public List<Integer> findRoleMenu(Integer roleid) {
        return roleDao.findRoleMenu(roleid);
    }

}
