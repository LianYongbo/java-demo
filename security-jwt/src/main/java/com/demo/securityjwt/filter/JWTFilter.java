package com.demo.securityjwt.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @Auther:Lian
 * @Date:2020/8/27 14:48
 * @Description: 每次访问验证token
 * @version:1.0
 */
public class JWTFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //这里假设发送请求时token被放在了请求头里
        String jwtToken = req.getHeader("authorization");
        //利用key对token进行解析；自动在token前加Bearer，需要去掉
        Jws<Claims> jws = Jwts.parser().setSigningKey("L1anyX")
                .parseClaimsJws(jwtToken.replace("Bearer", ""));
        //从解析得到的jws中获取信息
        Claims claims = jws.getBody();
        //获取用户名
        String username = claims.getSubject();
        //利用在登陆成功生成token用到的配置用户角色的name取出用户角色
        //AuthorityUtils用默认的格式把角色字符串隔开获取
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
        //校验，username，盐，用户角色
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,null,authorities);
        //把token设置到上下文
        SecurityContextHolder.getContext().setAuthentication(token);
        //过滤器继续往下走
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
