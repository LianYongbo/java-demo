package com.demo.securitydmroleandmenu.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/9/27 16:42
 * @Description:TODO
 * @version:1.0
 */
@Document(value = "role_info")
public class Role {
    @Id
    private ObjectId role_id;
    //ObjectId类型的role_id的String类型
    private String role_objectid;
    private String role_name;
    private String role_name_Zh;
    private List<Menu> menus;
    private String role_remark;

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_obejctid='" + role_objectid + '\'' +
                ", role_name='" + role_name + '\'' +
                ", role_name_Zh='" + role_name_Zh + '\'' +
                ", menus=" + menus +
                ", role_remark='" + role_remark + '\'' +
                '}';
    }

    public Role(String role_name, String role_name_Zh, List<Menu> menus, String role_remark) {
        this.role_name = role_name;
        this.role_name_Zh = role_name_Zh;
        this.menus = menus;
        this.role_remark = role_remark;
    }

    public ObjectId getRole_id() {
        return role_id;
    }

    public void setRole_id(ObjectId role_id) {
        this.role_id = role_id;
    }

    public String getRole_objectid() {
        return role_objectid;
    }

    public void setRole_objectid(String role_objectid) {
        this.role_objectid = role_objectid;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_name_Zh() {
        return role_name_Zh;
    }

    public void setRole_name_Zh(String role_name_Zh) {
        this.role_name_Zh = role_name_Zh;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getRole_remark() {
        return role_remark;
    }

    public void setRole_remark(String role_remark) {
        this.role_remark = role_remark;
    }
}
