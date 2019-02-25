package com.spdata.crm.menu.dervice;

import com.spdata.common.base.BaseService;
import com.spdata.common.menu.Menu;
import com.spdata.crm.menu.dao.MenuDao;
import com.spdata.crm.tool.SecurityTool;
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
    public List<Menu> TreeMenu() {
        List<Menu> menus = menuDao.TreeMenu(SecurityTool.getSecurityUserName());
        int minid = menus.stream().min((o1, o2) -> o1.getSuperior().compareTo(o2.getSuperior())).get().getSuperior();
        menus = MenuGroup(menus, minid);
        return menus;
    }

    public List<Menu> MenuGroup(List<Menu> menus, int panrant) {
        //子节点
        List<Menu> children = menus.stream().filter(item -> item.getSuperior() == panrant).collect(Collectors.toList());
        //非子结点
        List<Menu> successor = menus.stream().filter(item -> item.getSuperior() != panrant).collect(Collectors.toList());
        children.forEach(item -> {
            List<Menu> list = MenuGroup(successor, item.getId());
            for (Menu menu : list) {
                item.getChildren().add(menu);
            }
        });
        return children;
    }

}
