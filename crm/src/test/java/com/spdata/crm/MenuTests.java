package com.spdata.crm;

import com.spdata.common.menu.Menu;
import com.spdata.crm.dept.entity.DeptTree;
import com.spdata.crm.menu.dao.MenuDao;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/1/2820:53
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuTests {
    @Autowired
    private MenuDao menuDao;

    @Test
    public void getmenu() {
        List<Menu> menus = menuDao.TreeMenu("root");
        int minid = menus.stream().min((o1, o2) -> o1.getSuperior().compareTo(o2.getSuperior())).get().getSuperior();
        menus = test(menus, minid);
        log.error(menus.toString());
    }

    public List<Menu> test(List<Menu> menus, int panrant) {
        //子节点
        List<Menu> children = menus.stream().filter(item -> item.getSuperior() == panrant).collect(Collectors.toList());
        //非子结点
        List<Menu> successor = menus.stream().filter(item -> item.getSuperior() != panrant).collect(Collectors.toList());
        children.forEach(item -> {
            List<Menu> list = test(successor, item.getId());
            for (Menu menu : list) {
                item.getChildren().add(menu);
            }
        });
        return children;
    }
}
