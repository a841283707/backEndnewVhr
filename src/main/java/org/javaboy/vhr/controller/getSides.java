package org.javaboy.vhr.controller;


import org.javaboy.vhr.bean.Hr;
import org.javaboy.vhr.bean.Menu;
import org.javaboy.vhr.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class getSides {

    @Autowired
    private MenuService menuService;

    @GetMapping("/getSides")
    public List<Menu> getSides(){
        Integer id= ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        List<Menu> menus=menuService.getMenuById(id);
        return menus;
    }

}
