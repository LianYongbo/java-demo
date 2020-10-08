package com.demo.securitydmroleandmenu.service.impl;

import com.demo.securitydmroleandmenu.dao.MenuDao;
import com.demo.securitydmroleandmenu.model.Menu;
import com.demo.securitydmroleandmenu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/10/7 10:21
 * @Description:TODO
 * @version:1.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuDao menuDao;

    @Override
    public Object menuCreate(Menu menu) {
        if (menu.getMenu_id() == null || menu.getMenu_id().toString().equals("")) {
            return "菜单编号为空!";
        }
        if (menu.getMenu_type() == null || menu.getMenu_type().toString().equals("")) {
            return "菜单类型为空!";
        }
        if ((menu.getMenu_type() == 1 && (menu.getMenu_routing() == null || menu.getMenu_routing().equals("")))
                || (menu.getMenu_type() == 2 && (menu.getMenu_pattern() == null || menu.getMenu_pattern().equals("")))) {
            return "菜单类型与路由或接口不匹配！";
        }
        if (menu.getMenu_pid() == null || menu.getMenu_pid().toString().equals("")) {
            return "父节点为空!";
        }
        if (menu.getMenu_pid() == 0) {
            menu.setMenu_pids("0");
        } else {
            Menu parentMenu = menuDao.menuFindById(menu.getMenu_pid());
            menu.setMenu_pids(parentMenu.getMenu_pids() + "-" + parentMenu.getMenu_id());
        }
        return menuDao.menuCreate(menu);
    }

    @Override
    public Object menuFindAll() {
        return menuDao.menuFindAll();
    }

    @Override
    public List<Menu> menuFindAll1() {
        return menuDao.menuFindAll();
    }
}
