package com.demo.securitydcp.dao.impl;

import com.demo.securitydcp.dao.UserDao;
import com.demo.securitydcp.model.Role;
import com.demo.securitydcp.model.User;
import com.demo.securitydcp.model.User_Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/8/20 16:37
 * @Description:TODO
 * @version:1.0
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveUser(User user) {
        mongoTemplate.insert(user);
    }

    @Override
    public User findUserById(int user_id) {
        return mongoTemplate.findById(user_id, User.class);
    }

    @Override
    public List<Role> findUserRolesById(int user_id) {
        List<User_Role> urs = mongoTemplate.find(new Query(Criteria.where("user_id").is(user_id)), User_Role.class);
        List<Role> roles = new ArrayList<>();
        for (User_Role ur : urs) {
            roles.add(mongoTemplate.findById(ur.getRole_id(), Role.class));
        }
        return roles;
    }
}
