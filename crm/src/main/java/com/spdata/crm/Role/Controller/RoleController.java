package com.spdata.crm.Role.Controller;

import com.spdata.crm.Role.Service.RoleService;
import com.spdata.crm.Role.input.RoleInput;
import com.spdata.entity.Base.BaseResul;
import com.spdata.entity.Base.Basemessage;
import com.spdata.entity.Role.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 添加角色接口
     *
     * @param role
     * @return
     */
    @PostMapping(value = "/save")
    public BaseResul save(@RequestBody Role role) {
        BaseResul resul = new BaseResul();
        try {
            boolean ifSave = roleService.save(role);
            resul.setData(ifSave);
        } catch (Exception e) {
            log.warn(e.getMessage());
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
    public BaseResul delect(@RequestBody Role role) {
        BaseResul resul = new BaseResul();
        try {
            boolean ifUpdate = roleService.delect(role);
            resul.setData(ifUpdate);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }

    /**
     * 为角色插入菜单数据==>接口
     *
     * @param roleInput
     * @return
     */
    @PostMapping(value = "/InsertMenu")
    public BaseResul InsertMenu(@RequestBody RoleInput roleInput) {
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
     * 为角色插入权限
     *
     * @param roleInput
     * @return
     */
    @PostMapping(value = "/InsertPermission")
    public BaseResul InsertPermission(@RequestBody RoleInput roleInput) {
        BaseResul resul = new BaseResul();
        try {
            boolean ifInsert = roleService.InsertPermission(roleInput);
            resul.setData(ifInsert);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }

    /**
     * 删除角色对应菜单===>接口
     *
     * @param roleInput
     * @return
     */
    @PostMapping(value = "/delectRoleMenu")
    public BaseResul delectRoleMenu(@RequestBody RoleInput roleInput) {
        BaseResul resul = new BaseResul();
        try {
            boolean ifInsert = roleService.delectRoleMenu(roleInput);
            resul.setData(ifInsert);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }

    /**
     * 删除角色对应权限===>接口
     *
     * @param roleInput
     * @return
     */
    @PostMapping(value = "/delectRolePermission")
    public BaseResul delectRolePermission(@RequestBody RoleInput roleInput) {
        BaseResul resul = new BaseResul();
        try {
            boolean ifInsert = roleService.delectRolePermission(roleInput);
            resul.setData(ifInsert);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }

    @PostMapping(value = "/list")
    public BaseResul list() {
        BaseResul resul = new BaseResul();
        try {
            List<Role> roles = roleService.findAccountRole();
            resul.setData(roles);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return null;
    }
}
