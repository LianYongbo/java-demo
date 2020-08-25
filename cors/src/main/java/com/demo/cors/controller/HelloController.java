package com.demo.cors.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:Lian
 * @Date:2020/8/25 15:32
 * @Description:TODO
 * @version:1.0
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "CORS - Hello !";
    }
}
