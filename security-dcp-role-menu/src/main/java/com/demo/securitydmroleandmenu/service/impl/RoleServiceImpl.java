package com.demo.securitydmroleandmenu.service.impl;

import com.demo.securitydmroleandmenu.dao.RoleDao;
import com.demo.securitydmroleandmenu.model.Menu;
import com.demo.securitydmroleandmenu.model.Role;
import com.demo.securitydmroleandmenu.service.RoleService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/10/7 9:32
 * @Description:TODO
 * @version:1.0
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public Object roleCreate(Role role) {
        if (role.getRole_name() == null || role.getRole_name().equals("") ||
                role.getRole_name_Zh() == null || role.getRole_name_Zh().equals("")) {
            return "角色名称为空！";
        }
        role = roleDao.roleCreate(role);
        role.setRole_objectid(role.getRole_id().toString());
        return roleDao.roleUpdate(role);
    }

    @Override
    public Object roleUpdate(Role role) {
        if (role.getRole_objectid() == null || role.getRole_objectid().equals("")) {
            return "角色编号为空！";
        }
        if (role.getRole_name() == null || role.getRole_name().equals("") ||
                role.getRole_name_Zh() == null || role.getRole_name_Zh().equals("")) {
            return "角色名称为空！";
        }
        role.setRole_id(new ObjectId(role.getRole_objectid()));
        Role oldRole = roleDao.roleFindById(role.getRole_id());
        oldRole.setRole_name(role.getRole_name());
        oldRole.setRole_name_Zh(role.getRole_name_Zh());
        oldRole.setMenus(role.getMenus());
        oldRole.setRole_remark(role.getRole_remark());
        return roleDao.roleUpdate(oldRole);
    }

    @Override
    public Object roleDelete(Role role) {
        if (role.getRole_objectid() == null || role.getRole_objectid().equals("")) {
            return "角色编号为空！";
        }
        role.setRole_id(new ObjectId(role.getRole_objectid()));
        if (roleDao.roleFindById(role.getRole_id()) == null) {
            return "该角色不存在！";
        }
        return roleDao.roleDelete(role);
    }

    @Override
    public Object roleFindByName(Role role) {
        if (role.getRole_name_Zh() == null || role.getRole_name_Zh().equals("")) {
            return "角色名称为空！";
        }
        return roleDao.roleFindByName(role.getRole_name_Zh());
    }

    @Override
    public List<Role> roleFindByMenu(Menu menu) {
        return roleDao.roleFindByMenu(menu);
    }
}
