package com.demo.securitydcp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther:Lian
 * @Date:2020/8/20 16:12
 * @Description:TODO
 * @version:1.0
 */
@Document(collection = "role")
public class Role {
    @Id
    private Integer role_id;
    private String role_name;
    private String role_name_Zh;

    public Role() {
    }

    public Role(Integer role_id, String role_name, String role_name_Zh) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.role_name_Zh = role_name_Zh;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
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
}
