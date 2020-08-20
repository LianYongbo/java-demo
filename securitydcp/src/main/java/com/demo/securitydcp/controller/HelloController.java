package com.demo.securitydcp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther:Lian
 * @Date:2020/8/20 17:20
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
        map.put("data", "Hello !");
        return map;
    }

    @GetMapping("/admin/hello")
    public Map<String, Object> helloAdmin() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "请求成功！");
        map.put("data", "Hello admin !");
        return map;
    }

    @GetMapping("/dba/hello")
    public Map<String, Object> helloDba() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "请求成功！");
        map.put("data", "Hello dba !");
        return map;
    }

    @GetMapping("/user/hello")
    public Map<String, Object> helloUser() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "请求成功！");
        map.put("data", "Hello user !");
        return map;
    }
}
