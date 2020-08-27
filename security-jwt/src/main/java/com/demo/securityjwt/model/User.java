package com.demo.securityjwt.model;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/8/27 13:37
 * @Description:TODO
 * @version:1.0
 */
@Repository("user")
public class User implements UserDetails {
    @Id
    private Integer user_id;
    private String user_name;
    private String user_password;
    private List<Role> roles;

    public User() {
    }

    public User(Integer user_id, String user_name, String user_password, List<Role> roles) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.roles = roles;
    }

    public String getUser_name() {
        return user_name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user_password;
    }

    @Override
    public String getUsername() {
        return String.valueOf(user_id);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
