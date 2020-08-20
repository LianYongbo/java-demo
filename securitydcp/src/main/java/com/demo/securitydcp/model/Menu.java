package com.demo.securitydcp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/8/20 16:21
 * @Description:TODO
 * @version:1.0
 */
@Document(collection = "menu")
public class Menu {
    @Id
    private Integer menu_id;
    private String pattern;
    private List<Role> roles;

    public Menu() {
    }

    public Menu(Integer menu_id, String pattern) {
        this.menu_id = menu_id;
        this.pattern = pattern;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
