package com.demo.securitydcp.dao;

import com.demo.securitydcp.model.Menu;
import com.demo.securitydcp.model.Role_Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Auther:Lian
 * @Date:2020/8/21 3:05
 * @Description:TODO
 * @version:1.0
 */
@Repository
public class Role_MenuDaoImpl implements Role_MenuDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveRecording(Role_Menu rm) {
        mongoTemplate.insert(rm);
    }
}
