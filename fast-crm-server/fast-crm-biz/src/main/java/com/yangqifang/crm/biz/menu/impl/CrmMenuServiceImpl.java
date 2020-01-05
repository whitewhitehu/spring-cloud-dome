package com.yangqifang.crm.biz.menu.impl;

import org.apache.dubbo.config.annotation.Service;
import com.yangqifang.crm.api.menu.entity.Menu;
import com.yangqifang.crm.api.menu.service.ICrmMenuService;
import com.yangqifang.crm.biz.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/28 23:19
 */
@Service
@Component
public class CrmMenuServiceImpl implements ICrmMenuService {
    @Autowired
    private MenuService menuService;

    @Override
    public boolean Update(Menu menu) {
        return menuService.Update(menu);
    }

    @Override
    public List<Menu> TreeMenu(String username) {
        return menuService.TreeMenu(username);
    }

    @Override
    public List<Menu> MenuGroup(List<Menu> menus, int panrant) {
        return menuService.MenuGroup(menus, panrant);
    }

    @Override
    public boolean save(Menu menu) {
        return menuService.save(menu);
    }

    @Override
    public boolean delect(Menu menu) {
        return menuService.delect(menu);
    }
}
