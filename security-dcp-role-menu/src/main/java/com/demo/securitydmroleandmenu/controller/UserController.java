package com.demo.securitydmroleandmenu.controller;

import com.demo.securitydmroleandmenu.model.User;
import com.demo.securitydmroleandmenu.response.HttpCode;
import com.demo.securitydmroleandmenu.response.HttpResponse;
import com.demo.securitydmroleandmenu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:Lian
 * @Date:2020/10/4 18:37
 * @Description:TODO
 * @version:1.0
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/user/save")
    public HttpResponse userSave(@RequestBody User user) {
        Object data = userService.userSave(user);
        if (data instanceof User) {
            return new HttpResponse(HttpCode.OK, data);
        }
        return new HttpResponse(HttpCode.BadRequest, data);
    }

    @PostMapping(value = "/user/update")
    public HttpResponse userUpdate(@RequestBody User user) {
        Object data = userService.userUpdate(user);
        if (data instanceof User) {
            return new HttpResponse(HttpCode.OK, data);
        }
        return new HttpResponse(HttpCode.BadRequest, data);
    }

    @PostMapping(value = "/user/delete")
    public HttpResponse userDelete(@RequestBody User user) {
        Object data = userService.userDelete(user);
        if (data instanceof Boolean) {
            return new HttpResponse(HttpCode.OK, data);
        }
        return new HttpResponse(HttpCode.BadRequest, data);
    }

    @PostMapping(value = "/user/findById")
    public HttpResponse userFindById(@RequestBody() User user) {
        Object data = userService.userFindById(user);
        if (data instanceof User) {
            return new HttpResponse(HttpCode.OK, data);
        }
        return new HttpResponse(HttpCode.BadRequest, data);
    }
}
