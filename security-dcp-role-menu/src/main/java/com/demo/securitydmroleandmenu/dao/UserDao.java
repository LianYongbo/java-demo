package com.demo.securitydmroleandmenu.dao;

import com.demo.securitydmroleandmenu.model.User;

/**
 * @Auther:Lian
 * @Date:2020/10/4 17:16
 * @Description:TODO
 * @version:1.0
 */
public interface UserDao {
    User userSave(User user);

    User userUpdate(User user);

    Boolean userDelete(User user);

    User userFindById(String user_mobile);
}
