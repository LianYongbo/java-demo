package com.demo.securitydb.dao;

import com.demo.securitydb.model.User_Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Auther:Lian
 * @Date:2020/8/20 15:10
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
