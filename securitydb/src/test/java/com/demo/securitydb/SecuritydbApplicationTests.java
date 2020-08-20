package com.demo.securitydb;

import com.demo.securitydb.dao.RoleDao;
import com.demo.securitydb.dao.UserDao;
import com.demo.securitydb.dao.User_RoleDao;
import com.demo.securitydb.model.Role;
import com.demo.securitydb.model.User;
import com.demo.securitydb.model.User_Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SecuritydbApplicationTests {
    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    User_RoleDao user_roleDao;

    @Test
    void contextLoads() {
//        User user1 = new User(1, "lian", new BCryptPasswordEncoder().encode("123"));
//        User user2 = new User(2, "xin", new BCryptPasswordEncoder().encode("abc"));
        User user3 = new User(3, "yue", new BCryptPasswordEncoder().encode("abc"));
//        userDao.saveUser(user1);
//        userDao.saveUser(user2);
        userDao.saveUser(user3);

//        Role role1 = new Role(1, "admin", "管理员");
//        Role role2 = new Role(2, "dba", "数据库管理员");
//        Role role3 = new Role(3, "user", "普通用户");
//        roleDao.saveRole(role1);
//        roleDao.saveRole(role2);
//        roleDao.saveRole(role3);

        User_Role ur = new User_Role(1, 1, 1);
        User_Role ur1 = new User_Role(2, 1, 3);
        User_Role ur2 = new User_Role(3, 2, 2);
        User_Role ur3 = new User_Role(4, 2, 3);
        User_Role ur4 = new User_Role(5, 3, 3);

        user_roleDao.saveRecording(ur);
        user_roleDao.saveRecording(ur1);
        user_roleDao.saveRecording(ur2);
        user_roleDao.saveRecording(ur3);
        user_roleDao.saveRecording(ur4);
    }

}
