package com.demo.securityjwt.dao;

import com.demo.securityjwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Auther:Lian
 * @Date:2020/8/27 13:48
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
    public User findUserById(Integer user_id) {
        return mongoTemplate.findById(user_id, User.class);
    }
}
