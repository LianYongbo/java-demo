package com.demo.securityjwt.service;

import com.demo.securityjwt.dao.UserDao;
import com.demo.securityjwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Auther:Lian
 * @Date:2020/8/27 13:56
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
            throw new UsernameNotFoundException("用户不存在!");
        }
        return user;
    }
}
