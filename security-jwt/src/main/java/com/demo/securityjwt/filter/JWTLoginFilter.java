package com.demo.securityjwt.filter;

import com.demo.securityjwt.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther:Lian
 * @Date:2020/8/27 14:29
 * @Description: 用户登录成功返回token；用户登录失败返回信息
 * @version:1.0
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    //authenticationManager用于校验
    public JWTLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        //AuthenticationManager为AbstractAuthenticationProcessingFilter的一个属性，之后要用到这个属性可以直接get
        setAuthenticationManager(authenticationManager);
    }

    //提取用户名密码进行登录
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse resp) throws AuthenticationException, IOException, ServletException {
        //取出JSON格式数据转换成User对象
        User user = new ObjectMapper().readValue(req.getInputStream(), User.class);
        //在这里get，进行登录
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    }

    /**
     *
     * @param req
     * @param resp
     * @param chain
     * @param authResult 登录成功的用户信息
     * @return void
     * @descreption 登录成功的回调
     * @author Lian
     * @date 2020/8/28 1:41
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse resp, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //获取登录成功的用户的角色
        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        //把角色生成一个字符串
        StringBuffer sb = new StringBuffer();
        for (GrantedAuthority authority : authorities) {
            //默认格式是 , 隔开
            sb.append(authority.getAuthority()).append(",");
        }
        //生成token
        String jwt = Jwts.builder()
                //配置用户角色
                .claim("authorities", sb)
                //主题一般用用户名
                .setSubject(authResult.getName())
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                //签名使用的算法和key
                .signWith(SignatureAlgorithm.HS512, "L1anyX")
                .compact();
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "登陆成功");
        map.put("data", jwt);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(new ObjectMapper().writeValueAsString(map));
        out.flush();
        out.close();
    }

    //登录失败的回调
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse resp, AuthenticationException failed) throws IOException, ServletException {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 401);
        map.put("msg", "登陆失败");
        map.put("data", "");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(new ObjectMapper().writeValueAsString(map));
        out.flush();
        out.close();
    }
}
