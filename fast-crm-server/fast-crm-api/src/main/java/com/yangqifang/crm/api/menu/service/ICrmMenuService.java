package com.yangqifang.crm.api.menu.service;

import com.yangqifang.crm.api.menu.entity.Menu;

import java.util.List;

/**
 * @author: yangqifang
 * @mall:yangqifang@baoku.com
 * @description: 2019/12/28 23:18
 */
public interface ICrmMenuService {
    public boolean Update(Menu menu);
    public List<Menu> TreeMenu(String username);
    public List<Menu> MenuGroup(List<Menu> menus, int panrant);

    boolean save(Menu menu);

    boolean delect(Menu menu);
}
