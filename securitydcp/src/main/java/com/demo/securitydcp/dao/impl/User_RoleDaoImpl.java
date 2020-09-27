package com.demo.securitydcp.dao.impl;

import com.demo.securitydcp.dao.User_RoleDao;
import com.demo.securitydcp.model.User_Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Auther:Lian
 * @Date:2020/8/20 17:04
 * @Description:TODO
 * @version:1.0
 */
@Repository
public class User_RoleDaoImpl implements User_RoleDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveRecording(User_Role ur) {
        mongoTemplate.insert(ur);
    }
}
