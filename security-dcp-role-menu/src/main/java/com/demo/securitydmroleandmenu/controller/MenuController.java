package com.demo.securitydmroleandmenu.controller;

import com.demo.securitydmroleandmenu.model.Menu;
import com.demo.securitydmroleandmenu.response.HttpCode;
import com.demo.securitydmroleandmenu.response.HttpResponse;
import com.demo.securitydmroleandmenu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:Lian
 * @Date:2020/10/7 11:05
 * @Description:TODO
 * @version:1.0
 */
@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    @PostMapping(value = "/menu/create")
    public HttpResponse menuCreate(@RequestBody Menu menu) {
        Object data = menuService.menuCreate(menu);
        if (data instanceof Menu) {
            return new HttpResponse(HttpCode.OK, data);
        }
        return new HttpResponse(HttpCode.BadRequest, data);
    }

    @GetMapping(value = "/menu/findAll")
    public HttpResponse menuFindAll() {
        Object data = menuService.menuFindAll();
        return new HttpResponse(HttpCode.OK, data);
    }
}
