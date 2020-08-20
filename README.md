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

## securitydb : spring boot + spring security + mongodb

数据采用连接数据库的方式获取

1. 创建spring boot项目，加入web/spring security/mongodb依赖
2. application.yml中配置端口号，配置mongodb地址以及数据库
3. 创建model：User、Role、User_Role，分别是用户、角色、用户和角色的关联表，**其中User需要继承security中的UserDetails来实现security的标准**
4. 创建dao：UserDao、RoleDao、User_RoleDao以及对应接口实现类
5. 编写测试类插入数据
6. **创建service：UserService实现UserDeatailsService接口，重写``UserDetails loadUserByUsername(String username)``，该方法用来通过登录的用户名获取用户的全部信息**
7. 创建controller：UserController中包含多个接口
8. **创建config：SecurityConfig配置；权限配置部分**

``
.antMatchers("/admin/**").hasRole("admin")  
.antMatchers("/dba/**").hasRole("dba")  
.antMatchers("/user/**").hasRole("user")  
.antMatchers("/hello").hasAnyRole("admin","dba","user")
.anyRequest().authenticated();  
``

9. 启动项目
10. 使用数据库中的用户登录
11. 登录成功后可以访问对应权限内的接口

需要注意：security中的角色需要前缀``ROLE_``，如果没有这个前缀，security就认为没有权限，因此，可以在数据库中添加前缀，也可以在``loadUserByUsername``内设置用户的roles属性时添加。
