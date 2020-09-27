package com.demo.securitydcp.config;

import com.demo.securitydcp.model.Menu;
import com.demo.securitydcp.model.Role;
import com.demo.securitydcp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/8/21 2:07
 * @Description:TODO
 * @version:1.0
 */
@Component
public class MyFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;

    //路径匹配
    AntPathMatcher pathMatcher = new AntPathMatcher();

    //根据地址获取该地址需要哪些角色才能访问
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //o包含请求的信息
        //请求的地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        //可以对findMenuAll()做缓存，减少数据库的访问
        List<Menu> menus = menuService.findMenuAll();
        for (Menu menu : menus) {
            if (pathMatcher.match(menu.getPattern(), requestUrl)) {
                //访问的路径与数据库中的路径匹配
                //查询访问该路径所需的角色
                List<Role> roles = menuService.findMenuRolesById(menu.getMenu_id());
                //返回一个Collection<ConfigAttribute>包含角色的数据
                String[] rolesStr = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    rolesStr[i] = "ROLE_" + roles.get(i).getRole_name();
                }
                return SecurityConfig.createList(rolesStr);
            }
        }
        //没有匹配的路径，返回一个标识；可以理解为该路径登陆后即可访问
        return SecurityConfig.createList("ROLE_login");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    //是否支持这种方式
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}
