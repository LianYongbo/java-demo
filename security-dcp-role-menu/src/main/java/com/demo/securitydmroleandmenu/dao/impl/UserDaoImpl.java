package com.demo.securitydmroleandmenu.dao.impl;

import com.demo.securitydmroleandmenu.dao.UserDao;
import com.demo.securitydmroleandmenu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @Auther:Lian
 * @Date:2020/10/4 17:21
 * @Description:TODO
 * @version:1.0
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public User userSave(User user) {
        return mongoTemplate.insert(user);
    }

    @Override
    public User userUpdate(User user) {
        //返回的是修改前的用户信息
        return mongoTemplate.findAndReplace(new Query(Criteria.where("user_mobile").is(user.getUser_mobile())), user);
    }

    @Override
    public Boolean userDelete(User user) {
        return mongoTemplate.remove(new Query(Criteria.where("user_mobile").is(user.getUser_mobile()))).wasAcknowledged();
    }

    @Override
    public User userFindById(String user_mobile) {
        return mongoTemplate.findById(user_mobile, User.class);
    }
}
