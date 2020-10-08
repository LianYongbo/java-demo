package com.demo.securitydmroleandmenu.dao;

import com.demo.securitydmroleandmenu.model.Menu;
import com.demo.securitydmroleandmenu.model.Role;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/10/4 17:48
 * @Description:TODO
 * @version:1.0
 */
public interface RoleDao {
    Role roleCreate(Role role);

    Role roleUpdate(Role role);

    Boolean roleDelete(Role role);

    List<Role> roleFindByName(String role_name_Zh);

    Role roleFindById(ObjectId role_id);

    List<Role> roleFindByMenu(Menu menu);
}
