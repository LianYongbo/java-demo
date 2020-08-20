package com.demo.securitydcp.dao;

import com.demo.securitydcp.model.Menu;
import com.demo.securitydcp.model.Role;
import com.demo.securitydcp.model.Role_Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/8/21 2:14
 * @Description:TODO
 * @version:1.0
 */
@Repository
public class MenuDaoImpl implements MenuDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveMenu(Menu menu) {
        mongoTemplate.insert(menu);
    }

    @Override
    public List<Menu> findMenuAll() {
        return mongoTemplate.findAll(Menu.class);
    }

    @Override
    public List<Role> findMenuRolesById(int menu_id) {
        List<Role_Menu> rms = mongoTemplate.find(new Query(Criteria.where("menu_id").is(menu_id)), Role_Menu.class);
        List<Role> roles = new ArrayList<>();
        for (Role_Menu rm : rms) {
            roles.add(mongoTemplate.findById(rm.getRole_id(), Role.class));
        }
        return roles;
    }
}
