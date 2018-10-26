package com.spdata.crm.permission.Controller;

import com.spdata.crm.permission.service.PermissionService;
import com.spdata.entity.Base.BaseResul;
import com.spdata.entity.Base.Basemessage;
import com.spdata.entity.permission.permission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/Permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping(value = "/get")
    public BaseResul Get() {
        BaseResul resul = new BaseResul();
        try {
            List<permission> permissions = permissionService.findRolePermission();
            resul.setData(permissions);
        } catch (Exception e) {
            log.warn(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_message + e.getMessage());
        }
        return resul;
    }

    @PostMapping(value = "/save")
    public BaseResul save(@RequestBody permission permission) {
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

    @PostMapping(value = "/delect")
    public BaseResul delect(@RequestBody permission permission) {
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
    public BaseResul update(@RequestBody permission permission) {
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
