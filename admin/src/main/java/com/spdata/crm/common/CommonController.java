package com.spdata.crm.common;

import com.spdata.common.base.BaseResul;
import com.spdata.crm.account.service.AccountService;
import com.spdata.crm.menu.dervice.MenuService;
import com.spdata.crm.permission.service.PermissionService;
import com.spdata.crm.role.service.RoleService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/3/14-20:21
 **/
@Api("用户基础API")
@RestController
@RequestMapping(value = "/common")
public class CommonController {
    private Logger logger = LoggerFactory.getLogger(CommonController.class);
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/userinfo")
    public BaseResul CommonAccount() {
        BaseResul resul = new BaseResul();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/menu")
    public BaseResul CommonMenu() {
        BaseResul resul = new BaseResul();
        try {

        } catch (Exception e) {

        }
        return resul;
    }

    @RequestMapping(value = "/role")
    public BaseResul CommonRole() {
        BaseResul resul = new BaseResul();
        try {

        } catch (Exception e) {

        }
        return resul;
    }

    @RequestMapping(value = "/permission")
    public BaseResul CommonPermission() {
        BaseResul resul = new BaseResul();
        try {

        } catch (Exception e) {

        }
        return resul;
    }
}
