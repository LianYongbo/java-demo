package com.demo.securityjwt.dao;

import com.demo.securityjwt.model.User;

/**
 * @Auther:Lian
 * @Date:2020/8/27 13:46
 * @Description:TODO
 * @version:1.0
 */
public interface UserDao {
    void saveUser(User user);

    User findUserById(Integer user_id);
}
