package com.demo.securitydmroleandmenu.dao.impl;

import com.demo.securitydmroleandmenu.dao.RoleDao;
import com.demo.securitydmroleandmenu.model.Menu;
import com.demo.securitydmroleandmenu.model.Role;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @Auther:Lian
 * @Date:2020/10/7 9:22
 * @Description:TODO
 * @version:1.0
 */
@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Role roleCreate(Role role) {
        return mongoTemplate.insert(role);
    }

    @Override
    public Role roleUpdate(Role role) {
        return mongoTemplate.findAndReplace(new Query(Criteria.where("role_id").is(role.getRole_id())), role);
    }

    @Override
    public Boolean roleDelete(Role role) {
        return mongoTemplate.remove(new Query(Criteria.where("role_id").is(role.getRole_id()))).wasAcknowledged();
    }

    @Override
    public List<Role> roleFindByName(String role_name_Zh) {
        Pattern pattern = Pattern.compile("^.*" + role_name_Zh + ".*$", Pattern.CASE_INSENSITIVE);
        return mongoTemplate.find(new Query(Criteria.where("role_name_Zh").regex(pattern)), Role.class);
    }

    @Override
    public Role roleFindById(ObjectId role_id) {
        return mongoTemplate.findById(role_id, Role.class);
    }

    @Override
    public List<Role> roleFindByMenu(Menu menu) {
        return mongoTemplate.find(new Query(Criteria.where("menus").elemMatch(Criteria.where("menu_id").is(menu.getMenu_id()))), Role.class);
    }
}
