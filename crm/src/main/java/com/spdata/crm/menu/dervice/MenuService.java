package com.spdata.crm.menu.dervice;

import com.spdata.crm.menu.dao.MenuDao;
import com.spdata.crm.tool.SecurityTool;
import com.spdata.entity.Base.BaseService;
import com.spdata.entity.Menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService extends BaseService<MenuDao, Menu> {
    @Autowired
    private MenuDao menuDao;


    public boolean Update(Menu menu) {
        return menuDao.update(menu);
    }

    /**
     * 加缓存解决性能问题
     *
     * @return
     */
    public List<Menu> TreeMenu() {
        List<Menu> menus = menuDao.TreeMenu(SecurityTool.getSecurityUserName());
        RecursiveChildren(menus);
        return menus;
    }

    public List<Menu> RecursiveChildren(List<Menu> menus) {
        menus.forEach(item -> {
            List<Menu> menuList = menuDao.TreeChildren(item.getId(), SecurityTool.getSecurityUserName());
            if (menuList.size() > 0) {
                RecursiveChildren(menuList);
            }
            item.setChildren(menuList);
        });
        return menus;
    }


}
