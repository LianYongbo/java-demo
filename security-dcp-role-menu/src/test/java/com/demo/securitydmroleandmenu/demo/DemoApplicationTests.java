package com.demo.securitydmroleandmenu.demo;

import com.demo.securitydmroleandmenu.dao.RoleDao;
import com.demo.securitydmroleandmenu.model.Menu;
import com.demo.securitydmroleandmenu.model.Role;
import com.demo.securitydmroleandmenu.model.User;
import com.demo.securitydmroleandmenu.service.MenuService;
import com.demo.securitydmroleandmenu.service.RoleService;
import com.demo.securitydmroleandmenu.service.UserService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    MenuService menuService;
    @Autowired
    RoleService roleService;
    @Autowired
    RoleDao roleDao;
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        Menu menu1 = new Menu(1, 1, "/Authority-route", "", 0, "权限管理模块");
        Menu menu2 = new Menu(2, 1, "/User-route", "", 0, "用户管理模块");

        Menu menu3 = new Menu(11, 2, "", "/role/create", 1, "创建角色");
        Menu menu4 = new Menu(12, 2, "", "/role/update", 1, "修改角色");
        Menu menu5 = new Menu(13, 2, "", "/role/delete", 1, "删除角色");
        Menu menu6 = new Menu(14, 2, "", "/role/findByName", 1, "根据名称查找角色");

        Menu menu7 = new Menu(15, 2, "", "/menu/findAll", 1, "查找所有菜单");
//
        Menu menu8 = new Menu(21, 2, "", "/user/create", 2, "创建用户");
        Menu menu9 = new Menu(22, 2, "", "/user/update", 2, "修改用户");
        Menu menu10 = new Menu(23, 2, "", "/user/delete", 2, "删除用户");
        Menu menu11 = new Menu(24, 2, "", "/user/findById", 2, "根据编号查找用户");
//
//        System.out.println(menuService.menuCreate(menu1));
//        System.out.println(menuService.menuCreate(menu2));
//        System.out.println(menuService.menuCreate(menu3));
//        System.out.println(menuService.menuCreate(menu4));
//        System.out.println(menuService.menuCreate(menu5));
//        System.out.println(menuService.menuCreate(menu6));
//        System.out.println(menuService.menuCreate(menu7));
//        System.out.println(menuService.menuCreate(menu8));
//        System.out.println(menuService.menuCreate(menu9));
//        System.out.println(menuService.menuCreate(menu10));
//        System.out.println(menuService.menuCreate(menu11));

        List<Menu> menus = menuService.menuFindAll1();
        List<Menu> menus1 = new ArrayList<>();
        List<Menu> menus2 = new ArrayList<>();

        for (Menu menu : menus) {
            if (menu.getMenu_id() == 2 || menu.getMenu_id() == 21 || menu.getMenu_id() == 22 || menu.getMenu_id() == 23 || menu.getMenu_id() == 24) {
                menus1.add(menu);
            }
            if (menu.getMenu_id() == 1 || menu.getMenu_id() == 11 || menu.getMenu_id() == 12 || menu.getMenu_id() == 13 || menu.getMenu_id() == 14 || menu.getMenu_id() == 15) {
                menus2.add(menu);
            }
        }

        Role role1 = new Role("Role_userAdmin", "用户管理员", menus1, "对用户信息进行管理");
        Role role2 = new Role("Role_authAdmin", "权限管理员", menus2, "对权限信息进行管理");

//        roleService.roleCreate(role1);
//        roleService.roleCreate(role2);

        role1.setRole_id((new ObjectId("5f7db9b9ab70c4572c238765")));
        role2.setRole_id(new ObjectId("5f7db9b9ab70c4572c238766"));

        List<Role> roles1 = new ArrayList<>();
        roles1.add(role1);

        List<Role> roles2 = new ArrayList<>();
        roles2.add(role2);

        List<Role> roles3 = new ArrayList<>();
        roles3.add(role1);
        roles3.add(role2);

        User user1 = new User("1", "lian", "123", roles1);
        User user2 = new User("2", "xin", "123", roles2);
        User user3 = new User("3", "sysAdmin", "123", roles3);

//        System.out.println(userService.userSave(user1));
//        System.out.println(userService.userSave(user2));
//        System.out.println(userService.userSave(user3));

//        System.out.println(roleDao.roleFindById(new ObjectId("5f7d9b5eda8c5843ea4d788d")));
    }
}

