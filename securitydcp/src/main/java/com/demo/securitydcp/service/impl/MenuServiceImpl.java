package com.demo.securitydcp.service.impl;

import com.demo.securitydcp.dao.MenuDao;
import com.demo.securitydcp.model.Menu;
import com.demo.securitydcp.model.Role;
import com.demo.securitydcp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/8/21 2:22
 * @Description:TODO
 * @version:1.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuDao menuDao;

    @Override
    public List<Menu> findMenuAll() {
        return menuDao.findMenuAll();
    }

    @Override
    public List<Role> findMenuRolesById(int menu_id) {
        return menuDao.findMenuRolesById(menu_id);
    }
}
