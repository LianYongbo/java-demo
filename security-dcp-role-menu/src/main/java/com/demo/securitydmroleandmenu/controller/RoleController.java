package com.demo.securitydmroleandmenu.controller;

import com.demo.securitydmroleandmenu.model.Role;
import com.demo.securitydmroleandmenu.response.HttpCode;
import com.demo.securitydmroleandmenu.response.HttpResponse;
import com.demo.securitydmroleandmenu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:Lian
 * @Date:2020/10/7 9:55
 * @Description:TODO
 * @version:1.0
 */
@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping(value = "/role/create")
    public HttpResponse roleCreate(@RequestBody Role role) {
        Object data = roleService.roleCreate(role);
        if (data instanceof Role) {
            return new HttpResponse(HttpCode.OK, data);
        }
        return new HttpResponse(HttpCode.BadRequest, data);
    }

    @PostMapping(value = "/role/update")
    public HttpResponse roleUpdate(@RequestBody Role role) {
        Object data = roleService.roleUpdate(role);
        if (data instanceof Role) {
            return new HttpResponse(HttpCode.OK, data);
        }
        return new HttpResponse(HttpCode.BadRequest, data);
    }

    @PostMapping(value = "/role/delete")
    public HttpResponse roleDelete(@RequestBody Role role) {
        Object data = roleService.roleDelete(role);
        if (data instanceof Boolean) {
            return new HttpResponse(HttpCode.OK, data);
        }
        return new HttpResponse(HttpCode.BadRequest, data);
    }

    @PostMapping(value = "/role/findByName")
    public HttpResponse roleFindByName(@RequestBody Role role) {
        Object data = roleService.roleFindByName(role);
        if (data instanceof String) {
            return new HttpResponse(HttpCode.BadRequest, data);
        }
        return new HttpResponse(HttpCode.OK, data);
    }
}
