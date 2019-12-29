package com.yangqifang.crm.biz.role.service;

import com.yangqifang.common.base.BaseService;
import com.yangqifang.crm.api.role.entity.Role;
import com.yangqifang.crm.api.role.parm.RoleInput;
import com.yangqifang.crm.biz.menu.dao.MenuDao;
import com.yangqifang.crm.biz.permission.dao.PermissionDao;
import com.yangqifang.crm.biz.role.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService extends BaseService<RoleDao, Role> {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private MenuDao menuDao;

    /**
     * 查询当前用户的角色信息
     *
     * @return
     */
    public List<Role> findAccountRole(String username) {
        return roleDao.findAccountRole(username);
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
    @Transactional(rollbackFor = Exception.class)
    public boolean insertPermission(RoleInput roleInput) {
        return roleDao.insertPermission(roleInput);
    }

    /**
     * 删除角色角色与菜单的对应关系
     *
     * @param roleInput
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean delectRoleMenu(RoleInput roleInput) {
        return roleDao.delectRoleMenu(roleInput);
    }

    /**
     * 删除角色与权限的对应关系
     *
     * @param roleInput
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean delectRolePermission(RoleInput roleInput) {
        return roleDao.delectRolePermission(roleInput);
    }

    public List<Integer> findRoleMenu(Integer roleid) {
        return roleDao.findRoleMenu(roleid);
    }

    /**
     * 删除角色
     *
     * @param role
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delect(Role role) {
        if (role.getId() != 1) {
//            RoleInput roleInput = new RoleInput();
//            roleInput.setRoleId(role.getId());
//            this.delectRolePermission(roleInput);
//            this.delectRoleMenu(roleInput);
            return roleDao.delect(role);
        }
        return false;
    }
}
