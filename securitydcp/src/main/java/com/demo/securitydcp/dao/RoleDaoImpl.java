package com.demo.securitydcp.dao;

import com.demo.securitydcp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Auther:Lian
 * @Date:2020/8/20 16:44
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
