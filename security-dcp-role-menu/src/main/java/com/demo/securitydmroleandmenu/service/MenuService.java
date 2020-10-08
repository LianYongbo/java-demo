package com.demo.securitydmroleandmenu.service;

import com.demo.securitydmroleandmenu.model.Menu;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/10/7 10:20
 * @Description:TODO
 * @version:1.0
 */
public interface MenuService {
    Object menuCreate(Menu menu);

    Object menuFindAll();

    //动态权限用
    List<Menu> menuFindAll1();
}
