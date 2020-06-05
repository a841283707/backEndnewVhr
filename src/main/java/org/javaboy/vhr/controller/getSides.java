package org.javaboy.vhr.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.javaboy.vhr.bean.Hr;
import org.javaboy.vhr.bean.Menu;
import org.javaboy.vhr.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "获取菜单控制器")
@RestController
public class getSides {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "根据登录的id获取用户的菜单方法")
    @GetMapping("/getSides")
    public List<Menu> getSides(){
        Integer id= ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        List<Menu> menus=menuService.getMenuById(id);
        return menus;
    }

}
