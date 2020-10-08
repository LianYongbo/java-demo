package com.demo.securitydmroleandmenu.service.impl;

import com.demo.securitydmroleandmenu.dao.UserDao;
import com.demo.securitydmroleandmenu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Auther:Lian
 * @Date:2020/10/7 17:47
 * @Description:TODO
 * @version:1.0
 */
@Service
public class SecurityServiceImpl implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.userFindById(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        return user;
    }
}
