package com.demo.securitydb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/8/19 17:41
 * @Description: 继承的方法相当于get方法，需要删除对应属性的get方法
 * @version:1.0
 */
@Document("user")
public class User implements UserDetails {
    @Id
    private Integer user_id;
    private String user_name;
    private String user_password;
    private List<Role> roles;

    public User(Integer user_id, String user_name, String user_password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", roles=" + roles +
                '}';
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * 获得用户的角色集合
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            //这里的role_name需要有“ROLE_”的前缀，如果在数据库中添加了，这里就不需要添加了
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole_name()));
            //authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
        }
        return authorities;
    }

    /**
     * 获得用户的密码
     */
    @Override
    public String getPassword() {
        return user_password;
    }

    /**
     * 获得用户的用户名，即user_id
     */
    @Override
    public String getUsername() {
        return String.valueOf(user_id);
    }

    /**
     * 获得用户是否没有过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 获得用户是否没有被锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 获得密码是否没有过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 获得用户是否可用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
