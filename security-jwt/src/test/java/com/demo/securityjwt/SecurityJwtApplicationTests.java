package com.demo.securityjwt;

import com.demo.securityjwt.dao.RoleDao;
import com.demo.securityjwt.dao.UserDao;
import com.demo.securityjwt.model.Role;
import com.demo.securityjwt.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SecurityJwtApplicationTests {
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;

    @Test
    void contextLoads() {
//        Role role1 = new Role(1, "admin", "管理员");
//        Role role2 = new Role(2, "user", "普通用户");
//
//        List<Role> roles1 = new ArrayList<>();
//        roles1.add(role1);
//        roles1.add(role2);
//        List<Role> roles2 = new ArrayList<>();
//        roles2.add(role2);
//
//        roleDao.saveRole(role1);
//        roleDao.saveRole(role2);
//
//        User user1 = new User(1, "lian", new BCryptPasswordEncoder().encode("000000"), roles1);
//        User user2 = new User(2, "xin", new BCryptPasswordEncoder().encode("000000"), roles2);
//
//        userDao.saveUser(user1);
//        userDao.saveUser(user2);
    }

}
