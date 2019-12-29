package com.yangqifang.crm.common;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yangqifang.common.base.BaseResul;
import com.yangqifang.crm.api.account.service.ICrmAccountService;
import com.yangqifang.crm.api.menu.service.ICrmMenuService;
import com.yangqifang.crm.api.permission.service.ICrmPermissionService;
import com.yangqifang.crm.api.role.service.ICrmRoleService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @Reference
    private ICrmMenuService crmMenuService;
    @Reference
    private ICrmRoleService crmRoleService;
    @Reference
    private ICrmPermissionService crmPermissionService;
    @Reference
    private ICrmAccountService crmAccountService;

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
