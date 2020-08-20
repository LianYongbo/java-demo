package com.demo.securitydb.dao;

import com.demo.securitydb.model.Role;
import com.demo.securitydb.model.User;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/8/19 18:05
 * @Description:TODO
 * @version:1.0
 */
public interface UserDao {
    void saveUser(User user);

    User findUserById(int user_id);

    List<Role> findUserRolesById(int user_id);
}
