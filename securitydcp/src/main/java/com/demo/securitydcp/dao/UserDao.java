package com.demo.securitydcp.dao;

import com.demo.securitydcp.model.Role;
import com.demo.securitydcp.model.User;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/8/20 16:35
 * @Description:TODO
 * @version:1.0
 */
public interface UserDao {
    void saveUser(User user);

    User findUserById(int user_id);

    List<Role> findUserRolesById(int user_id);
}
