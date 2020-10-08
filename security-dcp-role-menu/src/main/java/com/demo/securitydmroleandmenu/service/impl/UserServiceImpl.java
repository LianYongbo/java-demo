package com.demo.securitydmroleandmenu.service.impl;

import com.demo.securitydmroleandmenu.dao.UserDao;
import com.demo.securitydmroleandmenu.model.Role;
import com.demo.securitydmroleandmenu.model.User;
import com.demo.securitydmroleandmenu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Auther:Lian
 * @Date:2020/10/4 17:33
 * @Description:TODO
 * @version:1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public Object userSave(User user) {
        if (user.getUser_mobile() == null || user.getUser_mobile().equals("")) {
            return "用户手机号为空！";
        }
        if (userDao.userFindById(user.getUser_mobile()) != null) {
            return "该手机号已被注册！";
        }
        if (user.getPassword() == null || user.getPassword().equals("")) {
            return "密码为空！";
        }
        if (user.getUser_name() == null || user.getUser_name().equals("")) {
            return "用户姓名为空!";
        }
//        if (user.getRoles().size() != 1) {
//            return "角色集合元素个数有误！";
//        }
//        if (!user.getRoles().get(0).getRole_name().equals("普通用户")) {
//            return "当前只能设置普通角色！";
//        }
        user.setUser_password(new BCryptPasswordEncoder().encode(user.getUser_password()));
        return userDao.userSave(user);
    }

    @Override
    public Object userUpdate(User user) {
        if (user.getUser_mobile() == null || user.getUser_mobile().equals("")) {
            return "用户手机号为空！";
        }
        if (user.getUser_name() == null || user.getUser_name().equals("")) {
            return "用户姓名为空！";
        }
        if (user.getRoles().isEmpty()) {
            return "未设置用户角色！";
        }
        for (Role role : user.getRoles()) {
            if (role == null) {
                return "用户角色存在坏数据！";
            }
        }
        User oldUser = userDao.userFindById(user.getUser_mobile());
        oldUser.setUser_name(user.getUser_name());
        oldUser.setRoles(user.getRoles());
        return userDao.userUpdate(oldUser);
    }

    @Override
    public Object userDelete(User user) {
        if (user.getUser_mobile() == null || user.getUser_mobile().equals("")) {
            return "用户手机号为空！";
        }
        if (userDao.userFindById(user.getUser_mobile()) == null) {
            return "该用户不存在!";
        }
        return userDao.userDelete(user);
    }

    @Override
    public Object userFindById(User user) {
        if (user.getUser_mobile() == null || user.getUser_mobile().equals("")) {
            return "用户手机号为空";
        }
        return userDao.userFindById(user.getUser_mobile());
    }
}
