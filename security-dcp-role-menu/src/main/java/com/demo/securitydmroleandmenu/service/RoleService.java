package com.demo.securitydmroleandmenu.service;

import com.demo.securitydmroleandmenu.model.Menu;
import com.demo.securitydmroleandmenu.model.Role;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/10/7 9:31
 * @Description:TODO
 * @version:1.0
 */
public interface RoleService {
    Object roleCreate(Role role);

    Object roleUpdate(Role role);

    Object roleDelete(Role role);

    Object roleFindByName(Role role);

    //动态权限用：利用菜单查找出具有访问该菜单的角色
    List<Role> roleFindByMenu(Menu menu);
}
