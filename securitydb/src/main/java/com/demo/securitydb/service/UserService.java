package com.demo.securitydb.service;

import com.demo.securitydb.dao.UserDao;
import com.demo.securitydb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Auther:Lian
 * @Date:2020/8/20 14:05
 * @Description:TODO
 * @version:1.0
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserById(Integer.parseInt(username));
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        user.setRoles(userDao.findUserRolesById(Integer.parseInt(username)));
        return user;
    }
}
