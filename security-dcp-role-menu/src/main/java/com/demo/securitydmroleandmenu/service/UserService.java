package com.demo.securitydmroleandmenu.service;

import com.demo.securitydmroleandmenu.model.User;

/**
 * @Auther:Lian
 * @Date:2020/10/4 17:31
 * @Description:TODO
 * @version:1.0
 */
public interface UserService {
    Object userSave(User user);

    Object userUpdate(User user);

    Object userDelete(User user);

    Object userFindById(User user);
}
