package com.demo.securitydcp;

import com.demo.securitydcp.dao.*;
import com.demo.securitydcp.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SecuritydcpApplicationTests {
    //    @Autowired
//    UserDao userDao;
//    @Autowired
//    RoleDao roleDao;
//    @Autowired
//    User_RoleDao urDao;
//    @Autowired
//    MenuDao menuDao;
    @Autowired
    Role_MenuDao rmDao;

    @Test
    void contextLoads() {
//        User user = new User(1, "lian", new BCryptPasswordEncoder().encode("123"));
//        User user1 = new User(2, "xin", new BCryptPasswordEncoder().encode("abc"));
//        User user2 = new User(3, "yue", new BCryptPasswordEncoder().encode("abc"));
//
//        userDao.saveUser(user);
//        userDao.saveUser(user1);
//        userDao.saveUser(user2);

//        Role role = new Role(1, "admin", "管理员");
//        Role role1 = new Role(2, "dba", "数据库管理员");
//        Role role2 = new Role(3, "user", "普通用户");
//
//        roleDao.saveRole(role);
//        roleDao.saveRole(role1);
//        roleDao.saveRole(role2);

//        User_Role ur = new User_Role(1, 1, 1);
//        User_Role ur1 = new User_Role(2, 1, 3);
//        User_Role ur2 = new User_Role(3, 2, 2);
//        User_Role ur3 = new User_Role(4, 2, 3);
//        User_Role ur4 = new User_Role(5, 1, 3);
//
//        urDao.saveRecording(ur);
//        urDao.saveRecording(ur1);
//        urDao.saveRecording(ur2);
//        urDao.saveRecording(ur3);
//        urDao.saveRecording(ur4);

//        Menu menu = new Menu(1, "/admin/**");
//        Menu menu1 = new Menu(2, "/dba/**");
//        Menu menu2 = new Menu(3, "/user/**");
//
//        menuDao.saveMenu(menu);
//        menuDao.saveMenu(menu1);
//        menuDao.saveMenu(menu2);

        Role_Menu role_menu = new Role_Menu(1,1,1);
        Role_Menu role_menu1 = new Role_Menu(2,1,3);
        Role_Menu role_menu2 = new Role_Menu(3,2,2);
        Role_Menu role_menu3 = new Role_Menu(4,2,3);
        Role_Menu role_menu4 = new Role_Menu(5,3,3);

        rmDao.saveRecording(role_menu);
        rmDao.saveRecording(role_menu1);
        rmDao.saveRecording(role_menu2);
        rmDao.saveRecording(role_menu3);
        rmDao.saveRecording(role_menu4);
    }

}
