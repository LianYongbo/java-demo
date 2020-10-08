package com.demo.securitydmroleandmenu.dao;

import com.demo.securitydmroleandmenu.model.Menu;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/10/7 10:11
 * @Description:TODO
 * @version:1.0
 */
public interface MenuDao {
    Menu menuCreate(Menu menu);

    Menu menuUpdate(Menu menu);

    Boolean menuDelete(Menu menu);

    List<Menu> menuFindAll();

    Menu menuFindById(Integer menu_id);
}
