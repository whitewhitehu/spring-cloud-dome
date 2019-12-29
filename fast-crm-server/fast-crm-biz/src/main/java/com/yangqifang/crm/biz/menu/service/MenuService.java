package com.yangqifang.crm.biz.menu.service;

import com.yangqifang.common.base.BaseService;
import com.yangqifang.crm.api.menu.entity.Menu;
import com.yangqifang.crm.biz.menu.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService extends BaseService<MenuDao, Menu> {
    @Autowired
    private MenuDao menuDao;


    public boolean Update(Menu menu) {
        return menuDao.update(menu);
    }

    /**
     * 获取当前用户的菜单信息
     *
     * @return
     */
    public List<Menu> TreeMenu(String username) {
        List<Menu> menus = menuDao.TreeMenu(username);
        int minid = menus.stream().min((o1, o2) -> o1.getPid().compareTo(o2.getPid())).get().getPid();
        menus = MenuGroup(menus, minid);
        return menus;
    }

    public List<Menu> MenuGroup(List<Menu> menus, int panrant) {
        //子节点
        List<Menu> children = menus.stream().filter(item -> item.getPid() == panrant).collect(Collectors.toList());
        //非子结点
        List<Menu> successor = menus.stream().filter(item -> item.getPid() != panrant).collect(Collectors.toList());
        children.forEach(item -> {
            List<Menu> list = MenuGroup(successor, item.getId());
            for (Menu menu : list) {
                item.getChildren().add(menu);
            }
        });
        return children;
    }

}
