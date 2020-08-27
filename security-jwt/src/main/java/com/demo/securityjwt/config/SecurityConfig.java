package com.demo.securityjwt.config;

import com.demo.securityjwt.filter.JWTFilter;
import com.demo.securityjwt.filter.JWTLoginFilter;
import com.demo.securityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Auther:Lian
 * @Date:2020/8/27 13:36
 * @Description:TODO
 * @version:1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .antMatchers("/hello").hasAnyRole("admin", "user")
                .anyRequest().authenticated()
                .and()
                //把过滤器加入到过滤器链中
                //登陆地址/doLogin
                .addFilterBefore(new JWTLoginFilter("/doLogin", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginProcessingUrl("/doLogin")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
        ;
    }
}
