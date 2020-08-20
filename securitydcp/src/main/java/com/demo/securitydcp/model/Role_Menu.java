package com.demo.securitydcp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther:Lian
 * @Date:2020/8/20 16:24
 * @Description:TODO
 * @version:1.0
 */
@Document(collection = "role_menu")
public class Role_Menu {
    @Id
    private Integer rm_id;
    private Integer role_id;
    private Integer menu_id;

    public Role_Menu() {
    }

    public Role_Menu(Integer rm_id, Integer role_id, Integer menu_id) {
        this.rm_id = rm_id;
        this.role_id = role_id;
        this.menu_id = menu_id;
    }

    public Integer getRm_id() {
        return rm_id;
    }

    public void setRm_id(Integer rm_id) {
        this.rm_id = rm_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }
}
