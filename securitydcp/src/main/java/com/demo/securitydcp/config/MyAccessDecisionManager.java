package com.demo.securitydcp.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @Auther:Lian
 * @Date:2020/8/21 2:44
 * @Description:TODO
 * @version:1.0
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    /**
     *
     * @param authentication 访问用户的信息
     * @param o
     * @param collection MyFilter中getAttributes(Object o)返回的所需角色信息
     * @return void
     * @descreption
     * @author Lian
     * @date 2020/8/21 3:29
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute attribute : collection) {
            //检验是否是标识，即登录即可访问
            if ("ROLE_login".equals(attribute.getAttribute())) {
                //匿名用户
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("非法请求！");
                } else {
                    //用户已登录，可以访问该路径
                    //结束
                    return;
                }
            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(attribute.getAttribute())) {
                    //用户角色满足，可以访问该路径
                    //结束
                    return;
                }
            }
        }
        //不能访问
        throw new AccessDeniedException("非法请求！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
