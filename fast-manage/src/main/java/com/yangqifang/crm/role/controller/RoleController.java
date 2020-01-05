package com.yangqifang.crm.role.controller;

import org.apache.dubbo.config.annotation.Reference;
import com.yangqifang.common.base.BaseResul;
import com.yangqifang.common.base.Basemessage;
import com.yangqifang.crm.api.role.entity.Role;
import com.yangqifang.crm.api.role.parm.RoleInput;
import com.yangqifang.crm.api.role.service.ICrmRoleService;
import com.yangqifang.crm.tool.SpringOauth2SecurityTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author yangqifang
 */
@Slf4j
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Reference
    private ICrmRoleService roleService;

    /**
     * 添加角色接口
     *
     * @param role
     * @return
     */
    @PostMapping(value = "/save")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public BaseResul save(@RequestBody Role role) {
        BaseResul resul = new BaseResul();
        try {
            boolean ifSaveSucceed = roleService.save(role);
            resul.setData(ifSaveSucceed);
        } catch (Exception e) {
            e.getMessage();
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message);
        }
        return resul;
    }

    /**
     * 删除角色接口
     *
     * @param role
     * @return
     */
    @PostMapping(value = "/delect")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public BaseResul delect(@RequestBody Role role) {
        BaseResul resul = new BaseResul();
        try {
            boolean ifUpdate = roleService.delect(role);
            resul.setData(ifUpdate);
        } catch (Exception e) {
            e.getMessage();
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }

    @PostMapping(value = "/list")
    public BaseResul list() {
        BaseResul resul = new BaseResul();
        try {
            List<Role> roles = roleService.findAccountRole(SpringOauth2SecurityTool.getSecurityUserName());
            resul.setData(roles);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return null;
    }

    /**
     * 为角色更新菜单数据==>接口
     *
     * @param roleInput
     * @return
     */
    @PostMapping(value = "/UpdateMenu")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public BaseResul insertMenu(@RequestBody RoleInput roleInput) {
        BaseResul resul = new BaseResul();
        try {
            boolean ifInsert = roleService.InsertMenu(roleInput);
            resul.setData(ifInsert);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }

    /**
     * 为角色更新权限
     *
     * @param roleInput
     * @return
     */
    @PostMapping(value = "/UpdatePermission")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public BaseResul insertPermission(@RequestBody RoleInput roleInput) {
        BaseResul resul = new BaseResul();
        try {
            boolean ifInsert = roleService.insertPermission(roleInput);
            resul.setData(ifInsert);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }

    /**
     * 获取角色对应的菜单
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/rolemenu")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public BaseResul rolemenu(@RequestParam(value = "id") Integer id) {
        BaseResul resul = new BaseResul();
        try {
            List<Integer> menuids = roleService.findRoleMenu(id);
            resul.setData(menuids);
        } catch (Exception e) {
            log.error(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }
}
