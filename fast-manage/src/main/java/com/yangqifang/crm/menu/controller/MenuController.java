package com.yangqifang.crm.menu.controller;

import org.apache.dubbo.config.annotation.Reference;
import com.yangqifang.common.base.BaseResul;
import com.yangqifang.common.base.Basemessage;
import com.yangqifang.crm.api.menu.entity.Menu;
import com.yangqifang.crm.api.menu.service.ICrmMenuService;
import com.yangqifang.crm.api.role.service.ICrmRoleService;
import com.yangqifang.crm.tool.SpringOauth2SecurityTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Reference
    private ICrmMenuService crmMenuService;
    @Reference
    private ICrmRoleService crmRoleService;

    /**
     * 添加菜单接口
     *
     * @param menu
     * @return
     */
    @PostMapping(value = "/save")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public BaseResul save(@RequestBody Menu menu) {
        BaseResul resul = new BaseResul();
        try {
            boolean falg = crmMenuService.save(menu);
            resul.setData(falg);
        } catch (Exception e) {
            log.info(e.getMessage());
            resul.setMessage(Basemessage.error_message);
            resul.setCode(Basemessage.error);
        }
        return resul;
    }

    /**
     * 获取菜单接口
     *
     * @return
     */
    @PostMapping(value = "/menu")
    public BaseResul menu() {
        BaseResul resul = new BaseResul();
        try {
            List<Menu> menus = crmMenuService.TreeMenu(SpringOauth2SecurityTool.getSecurityUserName());
            resul.setData(menus);
        } catch (Exception e) {
            log.info(e.getMessage());
            resul.setMessage(Basemessage.error_message);
            resul.setCode(Basemessage.error);
        }
        return resul;
    }

    /**
     * 删除菜单接口
     *
     * @param menu
     * @return
     */
    @PostMapping(value = "/delect")
    public BaseResul delect(@RequestBody Menu menu) {
        BaseResul resul = new BaseResul();
        try {
            boolean falg = crmMenuService.delect(menu);
            resul.setData(falg);
        } catch (Exception e) {
            log.error(e.getMessage());
            resul.setMessage(Basemessage.error_message);
            resul.setCode(Basemessage.error);
        }
        return resul;
    }

    @PostMapping(value = "/update")
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResul Update(@RequestBody Menu menu) {
        BaseResul resul = new BaseResul();
        try {
            boolean ifUpdateSecurity = crmMenuService.Update(menu);
            resul.setData(ifUpdateSecurity);
        } catch (Exception e) {
            log.error(e.getMessage());
            resul.setMessage(Basemessage.error_message);
            resul.setCode(Basemessage.error);
        }
        return resul;
    }
}
