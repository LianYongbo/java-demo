package com.demo.securitydmroleandmenu.dao.impl;

import com.demo.securitydmroleandmenu.dao.MenuDao;
import com.demo.securitydmroleandmenu.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/10/7 10:13
 * @Description:TODO
 * @version:1.0
 */
@Repository
public class MenuDaoImpl implements MenuDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Menu menuCreate(Menu menu) {
        return mongoTemplate.insert(menu);
    }

    @Override
    public Menu menuUpdate(Menu menu) {
        return mongoTemplate.findAndReplace(new Query(Criteria.where("menu_id").is(menu.getMenu_id())), menu);
    }

    @Override
    public Boolean menuDelete(Menu menu) {
        return mongoTemplate.remove(new Query(Criteria.where("menu_id").is(menu.getMenu_id()))).wasAcknowledged();
    }

    @Override
    public List<Menu> menuFindAll() {
        return mongoTemplate.findAll(Menu.class);
    }

    @Override
    public Menu menuFindById(Integer menu_id) {
        return mongoTemplate.findById(menu_id, Menu.class);
    }
}
