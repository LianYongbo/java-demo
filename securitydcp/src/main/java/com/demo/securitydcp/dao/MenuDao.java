package com.demo.securitydcp.dao;

import com.demo.securitydcp.model.Menu;
import com.demo.securitydcp.model.Role;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/8/21 2:13
 * @Description:TODO
 * @version:1.0
 */
public interface MenuDao {
    void saveMenu(Menu menu);

    List<Menu> findMenuAll();

    List<Role> findMenuRolesById(int menu_id);
}
