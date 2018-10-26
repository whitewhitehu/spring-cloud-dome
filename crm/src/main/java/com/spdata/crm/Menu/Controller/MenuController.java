package com.spdata.crm.Menu.Controller;

import com.spdata.crm.Menu.Service.MenuService;
import com.spdata.crm.Role.Service.RoleService;
import com.spdata.entity.Base.BaseResul;
import com.spdata.entity.Base.Basemessage;
import com.spdata.entity.Menu.Menu;
import com.spdata.entity.Role.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;

    /**
     * 添加菜单接口
     *
     * @param menu
     * @return
     */
    @PostMapping(value = "/save")
    public BaseResul save(@RequestBody Menu menu) {
        BaseResul resul = new BaseResul();
        try {
            boolean falg = menuService.save(menu);
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
            List<Role> roles = roleService.findAccountRole();
            List<Integer> roleid = new ArrayList<>();
            roles.forEach(item -> {
                roleid.add(item.getId());
            });
            List<Menu> menus = menuService.TreeMenu();
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
            boolean falg = menuService.delect(menu);
            resul.setData(falg);
        } catch (Exception e) {
            log.error(e.getMessage());
            resul.setMessage(Basemessage.error_message);
            resul.setCode(Basemessage.error);
        }
        return resul;
    }

    @PostMapping(value = "/update")
    public BaseResul Update(@RequestBody Menu menu) {
        BaseResul resul = new BaseResul();
        try {
            boolean ifUpdateSecurity = menuService.Update(menu);
            resul.setData(ifUpdateSecurity);
        } catch (Exception e) {
            log.error(e.getMessage());
            resul.setMessage(Basemessage.error_message);
            resul.setCode(Basemessage.error);
        }
        return resul;
    }
}
