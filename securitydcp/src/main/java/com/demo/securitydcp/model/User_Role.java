package com.demo.securitydcp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther:Lian
 * @Date:2020/8/20 16:19
 * @Description:TODO
 * @version:1.0
 */
@Document(collection = "user_role")
public class User_Role {
    @Id
    private Integer ur_id;
    private Integer user_id;
    private Integer role_id;

    public User_Role(Integer ur_id, Integer user_id, Integer role_id) {
        this.ur_id = ur_id;
        this.user_id = user_id;
        this.role_id = role_id;
    }

    public Integer getUr_id() {
        return ur_id;
    }

    public void setUr_id(Integer ur_id) {
        this.ur_id = ur_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
