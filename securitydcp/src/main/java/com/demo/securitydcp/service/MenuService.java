package com.demo.securitydcp.service;

import com.demo.securitydcp.model.Menu;
import com.demo.securitydcp.model.Role;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/8/21 2:21
 * @Description:TODO
 * @version:1.0
 */
public interface MenuService {
    List<Menu> findMenuAll();

    List<Role> findMenuRolesById(int menu_id);
}
