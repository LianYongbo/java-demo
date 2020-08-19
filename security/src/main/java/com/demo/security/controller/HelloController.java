package com.demo.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther:Lian
 * @Date:2020/8/19 16:08
 * @Description:TODO
 * @version:1.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "请求成功！");
        map.put("data", "Hello!");
        return map;
    }

    @GetMapping("/login")
    public Map<String, Object> login() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 401);
        map.put("msg", "请求失败！");
        map.put("data", "请登录后访问！");
        return map;
    }
}
