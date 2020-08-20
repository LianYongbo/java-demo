package com.demo.securitydb.dao;

import com.demo.securitydb.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Auther:Lian
 * @Date:2020/8/19 18:28
 * @Description:TODO
 * @version:1.0
 */
@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveRole(Role role) {
        mongoTemplate.insert(role);
    }
}
