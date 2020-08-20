package com.demo.securitydb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther:Lian
 * @Date:2020/8/19 17:45
 * @Description:TODO
 * @version:1.0
 */
@Document("role")
public class Role {
    @Id
    private Integer role_id;
    private String role_name;
    private String getRole_name_Zh;

    public Role(Integer role_id, String role_name, String getRole_name_Zh) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.getRole_name_Zh = getRole_name_Zh;
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

    public String getGetRole_name_Zh() {
        return getRole_name_Zh;
    }

    public void setGetRole_name_Zh(String getRole_name_Zh) {
        this.getRole_name_Zh = getRole_name_Zh;
    }
}