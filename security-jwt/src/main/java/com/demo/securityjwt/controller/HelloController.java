package com.demo.securityjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:Lian
 * @Date:2020/8/27 14:17
 * @Description:TODO
 * @version:1.0
 */
@RestController
public class HelloController {

    @GetMapping("/admin/hello")
    public String helloAdmin() {
        return "Hello admin !";
    }

    @GetMapping("/user/hello")
    public String helloUser() {
        return "Hello user !";
    }

    @GetMapping("/hello")
    public String helloAll() {
        return "Hello !";
    }
}
