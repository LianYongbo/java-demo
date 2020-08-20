# spring boot 相关框架demo
## security : spring boot + spring security

初始spring security

1. 创建spring boot项目,加入web和spring security依赖
2. application.yml中配置端口号
3. HelloController用来测试
4. 启动项目
5. 访问/hello，框架重定向到/login进行登录
6. 使用username = user，password = 控制台框架提供的密码
7. 成功访问/hello

添加内存用户
1. 在SecurityConfig中重写``void configure(AuthenticationManagerBuilder auth)``。

``
auth.inMemoryAuthentication()
                .withUser("lian").password("123").roles("admin");
``

2. 添加的用户密码未加密，在SecurityConfig中添加方法``PasswordEncoder passwordEncoder()``，允许使用未加密的密码进行校验。

``
@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
``

配置表单登录、登录成功/失败、登出成功
1. 在SecurityConfig中重写``void configure(HttpSecurity http)``。其中，``.loginProcessingUrl("/doLogin")``表示登录的路径，框架默认是``/login``；``.loginPage("/login")``表示登录的页面，在前后端分离的项目中可以认为是接口。
