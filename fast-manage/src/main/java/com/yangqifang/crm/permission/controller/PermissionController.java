package com.yangqifang.crm.permission.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.yangqifang.common.base.BaseResul;
import com.yangqifang.common.base.Basemessage;
import com.yangqifang.common.base.PageParameter;
import com.yangqifang.crm.api.permission.entity.Permission;
import com.yangqifang.crm.api.permission.service.ICrmPermissionService;
import com.yangqifang.crm.tool.SpringOauth2SecurityTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/Permission")
public class PermissionController {

    @Reference
    private ICrmPermissionService permissionService;

    @PostMapping(value = "/list")
    @PreAuthorize(value = "hasAuthority('ROOT')")
    public BaseResul list(@RequestBody PageParameter<Permission> parameter) {
        BaseResul resul = new BaseResul();
        try {
            PageInfo pageInfo = permissionService.findByPage(parameter);
            resul.setData(pageInfo);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }


    /**
     * 获取当前用户权限
     *
     * @return
     */
    @GetMapping(value = "/get")
    public BaseResul Get() {
        BaseResul resul = new BaseResul();
        try {
            List<Permission> permissions = permissionService.findRolePermission(SpringOauth2SecurityTool.getSecurityUserName());
            resul.setData(permissions);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }

    /**
     * 通过角色ID查询角色权限
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/RoleIdPermission")
    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
    public BaseResul RoleIdPermission(@RequestParam Integer id) {
        BaseResul resul = new BaseResul();
        try {
            List<Permission> permissions = permissionService.findRoleIdPermission(id);
            resul.setData(permissions);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }

    /**
     * 添加权限
     *
     * @param permission 权限对象
     * @return
     */
    @PostMapping(value = "/save")
    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
    public BaseResul save(@RequestBody Permission permission) {
        BaseResul resul = new BaseResul();
        try {
            boolean isSave = permissionService.save(permission);
            resul.setData(isSave);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }

    /**
     * 删除权限
     *
     * @param permission
     * @return
     */
    @PostMapping(value = "/delect")
    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
    public BaseResul delect(@RequestBody Permission permission) {
        BaseResul resul = new BaseResul();
        try {
            boolean isdelect = permissionService.delect(permission);
            resul.setData(isdelect);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }

    @PostMapping(value = "/update")
    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
    public BaseResul update(@RequestBody Permission permission) {
        BaseResul resul = new BaseResul();
        try {
            boolean isupdate = permissionService.update(permission);
            resul.setData(isupdate);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }
}
